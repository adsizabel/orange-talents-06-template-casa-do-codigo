package br.com.zup.ot6.izabel.casadocodigo.excecoes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.ot6.izabel.casadocodigo.dto.CategoriaRequestDTO;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Categoria;
import br.com.zup.ot6.izabel.casadocodigo.repositorios.CategoriaRepositorio;

@Component
public class CategoriaDuplicadaValidador implements Validator{
	
	@Autowired
	CategoriaRepositorio categoriaRepositorio;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaRequestDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		CategoriaRequestDTO request = (CategoriaRequestDTO) target;
		
		Optional<Categoria> categoriaPesquisada = categoriaRepositorio.findByNome(request.getNome());
		
		if(categoriaPesquisada.isPresent()) {
			errors.rejectValue("nome", null, "Categoria já existe: " + request.getNome());
		}
	}

}
