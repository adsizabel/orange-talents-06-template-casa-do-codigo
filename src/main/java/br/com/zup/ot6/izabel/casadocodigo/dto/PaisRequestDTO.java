package br.com.zup.ot6.izabel.casadocodigo.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.ot6.izabel.casadocodigo.entidades.Pais;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.UniqueValue;

public class PaisRequestDTO {
	
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	@JsonProperty("nome")
	private String nome;

	@JsonCreator
	public PaisRequestDTO(@NotBlank String nome) {
		super();
		this.nome = nome;
	}
	
	public Pais converterParaEntidade(PaisRequestDTO paisRequestDTO) {
		return new Pais(nome);
	}
	
	

}
