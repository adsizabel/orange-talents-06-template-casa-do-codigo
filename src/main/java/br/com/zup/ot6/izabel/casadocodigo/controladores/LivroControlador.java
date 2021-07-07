package br.com.zup.ot6.izabel.casadocodigo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.ot6.izabel.casadocodigo.dto.LivroRequestDTO;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Livro;

@RestController
@RequestMapping(path = "/livro")
public class LivroControlador {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public String cadastrarAluno(@RequestBody @Valid LivroRequestDTO livroRequestDTO){
		 Livro livro = livroRequestDTO.converterParaEntidade(entityManager);
		 
		 entityManager.persist(livro);
		 return livro.toString();
		
	}

}
