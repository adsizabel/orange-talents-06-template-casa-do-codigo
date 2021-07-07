package br.com.zup.ot6.izabel.casadocodigo.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "livros")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	@Min(20)
	@NotNull
	private BigDecimal preco;
	@Min(100)
	private Integer numeroPaginas;
	@Future
	private LocalDate dataPublicacao;
	@NotBlank
	private String isbn;
	@NotNull
	@ManyToOne
	private Categoria categoriaLivro;
	@NotNull
	@ManyToOne
	private Autor autorLivro;
	
	public Livro() {}

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@Min(20) @NotNull BigDecimal preco, @Min(100) Integer numeroPaginas, @NotBlank String isbn, 
			@Future LocalDate dataPublicacao, @NotNull Categoria categoriaLivro, @NotNull Autor autorLivro) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoriaLivro = categoriaLivro;
		this.autorLivro = autorLivro;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", numeroPaginas=" + numeroPaginas + ", dataPublicacao=" + dataPublicacao + ", isbn=" + isbn
				+ ", categoriaLivro=" + categoriaLivro + ", autorLivro=" + autorLivro + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public String getIsbn() {
		return isbn;
	}

	public Autor getAutorLivro() {
		return autorLivro;
	}

	
	
}
