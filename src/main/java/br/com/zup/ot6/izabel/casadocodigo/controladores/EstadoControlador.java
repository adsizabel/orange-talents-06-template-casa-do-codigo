package br.com.zup.ot6.izabel.casadocodigo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.ot6.izabel.casadocodigo.dto.EstadoRequestDTO;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Estado;

@RestController
@RequestMapping(path = "/estado")
public class EstadoControlador {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public String cadastrarEstado(@RequestBody @Valid EstadoRequestDTO estadoRequestDTO){
		 Estado estado = estadoRequestDTO.converterParaEntidade(entityManager);
		 entityManager.persist(estado);
		 return estado.toString();
		
	}

}
