package br.com.zup.ot6.izabel.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.ot6.izabel.casadocodigo.entidades.Autor;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Categoria;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Livro;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.UniqueValue;


public class LivroRequestDTO {
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	@JsonProperty("titulo")
	private String titulo;
	@NotBlank
	@JsonProperty("resumo")
	private String resumo;
	@JsonProperty("sumario")
	private String sumario;
	@Min(20)
	@JsonProperty("preco")
	private BigDecimal preco;
	@Min(100)
	@JsonProperty("numeroPaginas")
	private Integer numeroPaginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	@JsonProperty("isbn")
	private String isbn;
	@Future
	@JsonProperty("dataPublicacao")
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	@JsonProperty("categoriaLivroId")
	private Long categoriaLivroId;
	@NotNull
	@JsonProperty("autorLivroId")
	private Long autorLivroId;

	public Livro converterParaEntidade(EntityManager entityManager) {
		
		Autor autor = entityManager.find(Autor.class, autorLivroId);
		Categoria categoria = entityManager.find(Categoria.class, categoriaLivroId);
		
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
	}

}
