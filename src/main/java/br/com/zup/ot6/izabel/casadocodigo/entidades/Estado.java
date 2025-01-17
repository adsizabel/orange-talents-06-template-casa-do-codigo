package br.com.zup.ot6.izabel.casadocodigo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotNull
	@ManyToOne
	private Pais pais;
	
	public Estado() {}
	
	public Estado(@NotBlank String nome, @NotNull Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
	}

	
}
