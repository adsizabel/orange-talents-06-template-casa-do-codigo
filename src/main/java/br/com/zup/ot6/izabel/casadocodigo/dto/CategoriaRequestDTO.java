package br.com.zup.ot6.izabel.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.ot6.izabel.casadocodigo.entidades.Categoria;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.UniqueValue;

public class CategoriaRequestDTO {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	@JsonProperty("nome")
	private String nome;

	@JsonCreator
	public CategoriaRequestDTO(@NotBlank @JsonProperty("nome") String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Categoria converterParaEntidade(CategoriaRequestDTO categoriaRequestDTO) {
		return new Categoria(this.nome);
	}
}
