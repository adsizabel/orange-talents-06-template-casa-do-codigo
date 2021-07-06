package br.com.zup.ot6.izabel.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.ot6.izabel.casadocodigo.entidades.Autor;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.UniqueValue;


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
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	@JsonProperty("email")
	private String email;

	public AutorRequestDTO(@NotBlank String nome, @NotBlank @Size(max = 400) String descricao, @NotBlank @Email String email) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.email = email;
	}

	public Autor converterParaEntidade(AutorRequestDTO autorRequestDTO) {
		return new Autor(this.nome, this.descricao, this.email);
	}

	public String getEmail() {
		return email;
	}
	
}
