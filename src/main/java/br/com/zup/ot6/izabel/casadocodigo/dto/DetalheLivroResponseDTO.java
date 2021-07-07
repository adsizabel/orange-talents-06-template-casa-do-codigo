package br.com.zup.ot6.izabel.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zup.ot6.izabel.casadocodigo.entidades.Livro;

public class DetalheLivroResponseDTO {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private int numeroPaginas;
	private String dataPublicacao;
	private String isbn;
	private DetalheAutorResponseDTO autor;

	public DetalheLivroResponseDTO(Livro livro) {
			titulo = livro.getTitulo();
			autor = new DetalheAutorResponseDTO(livro.getAutorLivro());
			isbn = livro.getIsbn();
			numeroPaginas = livro.getNumeroPaginas();
			preco = livro.getPreco();
			resumo = livro.getResumo();
			sumario = livro.getSumario();		
			dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter
					.ofPattern("dd/MM/yyyy"));
	}

	public DetalheAutorResponseDTO getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}	

	
}


