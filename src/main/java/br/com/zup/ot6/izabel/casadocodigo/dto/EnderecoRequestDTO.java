package br.com.zup.ot6.izabel.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.ot6.izabel.casadocodigo.entidades.Endereco;

public class EnderecoRequestDTO {

	@NotBlank
	@JsonProperty("rua")
	private String rua;
	@NotBlank
	@JsonProperty("numero")
	private String numero;
	@NotBlank
	@JsonProperty("complemento")
	private String complemento;
	@NotBlank
	@JsonProperty("cidade")
	private String cidade;
	@NotBlank
	@JsonProperty("cep")
	private String cep;
	
	public EnderecoRequestDTO(@NotBlank String rua, @NotBlank String numero, @NotBlank String complemento,
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
		return "EnderecoRequestDTO [rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", cidade="
				+ cidade + ", cep=" + cep + "]";
	}
	
	public Endereco coverterParaEntidadeEndereco(EnderecoRequestDTO enderecoRequestDTO) {
		return new Endereco(rua, numero, complemento, cidade, cep);
	}
}
