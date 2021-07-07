package br.com.zup.ot6.izabel.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.ot6.izabel.casadocodigo.entidades.Autor;

public class DetalheAutorResponseDTO {

	@NotBlank
	@JsonProperty("nome")
	private String nome;
	@NotBlank
	@JsonProperty("descricao")
	private String descricao;

	public DetalheAutorResponseDTO(Autor autorLivro) {
		nome = autorLivro.getNome();
		descricao = autorLivro.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
