package br.com.zup.ot6.izabel.casadocodigo.dto;

import javax.persistence.Embedded;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.ot6.izabel.casadocodigo.entidades.Cliente;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Estado;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Pais;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.CpfCnpj;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.ExistsId;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.UniqueValue;

public class ClienteRequestDTO {
	@NotBlank
	@JsonProperty("nome")
	private String nome;
	@NotBlank
	@JsonProperty("sobrenome")
	private String sobrenome;
	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	@JsonProperty("email")
	private String email;
	@NotBlank
	@CpfCnpj
	@UniqueValue(domainClass = Cliente.class, fieldName = "cpfCnpj")
	@JsonProperty("cpfCnpj")
	private String cpfCnpj;
	@NotNull
	@Embedded
	@JsonProperty("endereco")
	private EnderecoRequestDTO endereco;
	@NotNull
	@ManyToOne
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	@JsonProperty("idPais")
	private Long idPais;
	@ManyToOne
	@JsonProperty("idEstado")
	private Long idEstado;
	@NotBlank
	@JsonProperty("telefone")
	private String telefone;
	
	public ClienteRequestDTO(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank @Email String email,
			@NotBlank String cpfCnpj, @NotNull EnderecoRequestDTO endereco, @NotNull Long idPais, Long idEstado,
			@NotBlank String telefone) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.endereco = endereco;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
	}

	public Cliente coverterParaEntidade(EntityManager entityManager) {
		Estado	estado = null;
		
		Pais pais = entityManager.find(Pais.class, idPais);
		if(idEstado != null) {
			estado = entityManager.find(Estado.class, idEstado);
		}
	
		return new Cliente(nome, sobrenome, email, cpfCnpj, endereco.coverterParaEntidadeEndereco(endereco),
				pais, estado, telefone);
	}

	public Long getIdPais() {
		return idPais;
	}

	
	
	
	

}
