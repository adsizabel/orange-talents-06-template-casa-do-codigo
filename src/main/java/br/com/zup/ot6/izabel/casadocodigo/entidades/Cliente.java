package br.com.zup.ot6.izabel.casadocodigo.entidades;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.CpfCnpj;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@CpfCnpj
	private String cpfCnpj;
	@NotNull
	@Embedded
	private Endereco endereco;
	@NotNull
	@ManyToOne
	private Pais pais;
	@ManyToOne
	private Estado estado;
	@NotBlank
	private String telefone;
	
	public Cliente() {}

	public Cliente(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank @Email String email,
			@NotBlank String cpfCnpj, @NotNull Endereco endereco, @NotNull Pais pais, Estado estado,
			@NotBlank String telefone) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.endereco = endereco;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
	}



	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", cpfCnpj="
				+ cpfCnpj + ", endereco=" + endereco + ", pais=" + pais + ", estado=" + estado + ", telefone="
				+ telefone + "]";
	}
	
	
}
