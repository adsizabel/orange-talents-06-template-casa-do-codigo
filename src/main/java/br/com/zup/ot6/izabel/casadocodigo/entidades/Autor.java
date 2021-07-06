package br.com.zup.ot6.izabel.casadocodigo.entidades;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="autores")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	@Size(max = 400)
	private String descricao;
	@NotBlank
	@Email
	private String email;
	@CreationTimestamp
	private LocalDateTime dataCriacao;
	
	public Autor() {}

	public Autor(@NotBlank String nome, @NotBlank @Size(max = 400) String descricao, @NotBlank @Email String email) {
		this.nome = nome;
		this.descricao = descricao;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", email=" + email + ", dataCriacao="
				+ dataCriacao + "]";
	}

	
	
	
}
