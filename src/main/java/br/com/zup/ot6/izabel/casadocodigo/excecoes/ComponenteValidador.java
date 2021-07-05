package br.com.zup.ot6.izabel.casadocodigo.excecoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.zup.ot6.izabel.casadocodigo.entidades.Autor;
import br.com.zup.ot6.izabel.casadocodigo.repositorios.AutorRepositorio;

@Component
public class ComponenteValidador {

	public AutorRepositorio autorRepositorio;

	@Autowired
	public ComponenteValidador(AutorRepositorio autorRepositorio) {
		this.autorRepositorio = autorRepositorio;
	}
	
	public Autor salvar(Autor autor) {
        if(autorRepositorio.findByEmail(autor.getEmail()) != null) {
            throw new ValidaEmailDuplicado("E-mail já está sendo utilizado.");
        }
        
        if(!validaQuantidadeCaracteres(autor.getDescricao())) {
			throw new ValidaQuantidadeCaracteres("Quantidade de caracteres acima do permitido");
		}

		if(!validaCamposVazios(autor.getNome()) || !validaCamposVazios(autor.getEmail())) {
			throw new ValidaCampoVazio("Campo obrigatório");
		}
        
        Autor autorSalvo = autorRepositorio.save(autor);
        return autorSalvo;
    }
	
	public boolean validaQuantidadeCaracteres(String caracteres) {
		if(caracteres.length()>400) {
			return false;
		}		
		return true;
	}
	
	public boolean validaCamposVazios(String campo) {
		if(campo.isBlank()) {
			return false;
		}		
		return true;
	}
}
