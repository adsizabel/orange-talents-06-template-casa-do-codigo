package br.com.zup.ot6.izabel.casadocodigo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.ot6.izabel.casadocodigo.dto.DetalheLivroResponseDTO;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Livro;

@RestController
@RequestMapping(path = "/produtos")
public class DetalheDoLivroControlador {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping(value = "/livro/{id}")	
	public ResponseEntity<?> detalheLivro(@PathVariable("id") Long id) {
		
		Livro livroPesquisado = entityManager.find(Livro.class, id);
		
		if(livroPesquisado == null) {
			return ResponseEntity.notFound().build();
		}
		
		DetalheLivroResponseDTO detalheLivroResponseDTO = new DetalheLivroResponseDTO(livroPesquisado);
		return ResponseEntity.ok(detalheLivroResponseDTO);
	}


}
