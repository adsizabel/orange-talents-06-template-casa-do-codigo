package br.com.zup.ot6.izabel.casadocodigo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.ot6.izabel.casadocodigo.dto.AutorRequestDTO;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Autor;

@RestController
@RequestMapping(path = "/autor")
public class AutorControlador {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Autor> cadastrarAluno(@RequestBody @Valid AutorRequestDTO autorRequestDTO){
		 Autor autor = autorRequestDTO.converterParaEntidade(autorRequestDTO);
		 entityManager.persist(autor);
		 return ResponseEntity.status(HttpStatus.OK).body(autor);
		
	}

}
