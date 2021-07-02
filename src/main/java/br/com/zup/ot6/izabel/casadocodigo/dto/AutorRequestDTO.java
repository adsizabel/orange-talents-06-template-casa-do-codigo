package br.com.zup.ot6.izabel.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.ot6.izabel.casadocodigo.entidades.Autor;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.ValidaCampoVazio;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.ValidaQuantidadeCaracteres;


public class AutorRequestDTO {
	@NotBlank
    @JsonProperty("nome")
	private String nome;
	@NotBlank
	@Size(max = 400)
	@JsonProperty("descricao")
	private String descricao;
	@NotBlank
	@Email
	@JsonProperty("email")
	private String email;

	public AutorRequestDTO(@NotBlank String nome, @NotBlank @Size(max = 400) String descricao, @NotBlank @Email String email) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.email = email;
	}

	public Autor converterParaEntidade(AutorRequestDTO autorRequestDTO) {
		if(!validaQuantidadeCaracteres(descricao)) {
			throw new ValidaQuantidadeCaracteres("Quantidade de caracteres acima do permitido");
		}
		
		if(!validaCamposVazios(nome) || !validaCamposVazios(email)) {
			throw new ValidaCampoVazio("Campo obrigatório");
		}
		return new Autor(this.nome, this.email, this.descricao);
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
