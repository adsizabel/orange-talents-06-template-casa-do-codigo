package br.com.zup.ot6.izabel.casadocodigo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.ot6.izabel.casadocodigo.dto.AutorRequestDTO;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Autor;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.EmailDuplicadoAutorValidator;

@RestController
@RequestMapping(path = "/autor")
public class AutorControlador {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EmailDuplicadoAutorValidator emailDuplicadoAutorValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(emailDuplicadoAutorValidator);
	}
	
	@PostMapping
	@Transactional
	public String cadastrarAluno(@RequestBody @Valid AutorRequestDTO autorRequestDTO){
		 Autor autor = autorRequestDTO.converterParaEntidade(autorRequestDTO);
		 
		 entityManager.persist(autor);
		 return autor.toString();
		
	}

}
