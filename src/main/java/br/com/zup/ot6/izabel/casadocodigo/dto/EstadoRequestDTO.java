package br.com.zup.ot6.izabel.casadocodigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.ot6.izabel.casadocodigo.entidades.Estado;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Pais;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.ExistsId;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.UniqueValue;

public class EstadoRequestDTO {
	
	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	@JsonProperty("nome")
	private String nome;
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	@JsonProperty("idPais")
	private Long idPais;

	public EstadoRequestDTO(@NotBlank String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado converterParaEntidade(EntityManager entityManager) {
		Pais paisPesquisado = entityManager.find(Pais.class, idPais);
		return new Estado(nome, paisPesquisado);
	}
	
	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	@Override
	public String toString() {
		return "EstadoRequestDTO [nome=" + nome + ", pais_Id=" + idPais + "]";
	}
}
