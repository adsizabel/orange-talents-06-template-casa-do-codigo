package br.com.zup.ot6.izabel.casadocodigo.entidades;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Endereco {
	@NotBlank
	private String rua;
	@NotBlank
	private String numero;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String cep;
	
	public Endereco() {}
	
	public Endereco(@NotBlank String rua, @NotBlank String numero, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String cep) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", cep=" + cep + "]";
	}
	
	
}
