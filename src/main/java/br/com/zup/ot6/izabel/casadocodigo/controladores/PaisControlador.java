package br.com.zup.ot6.izabel.casadocodigo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.ot6.izabel.casadocodigo.dto.PaisRequestDTO;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Pais;

@RestController
@RequestMapping(path = "/pais")
public class PaisControlador {

	@PersistenceContext
	private EntityManager entityManager;

	@PostMapping
	@Transactional
	public String cadastrarPais(@RequestBody @Valid PaisRequestDTO paisRequestDTO) {
		Pais pais = paisRequestDTO.converterParaEntidade(paisRequestDTO);
		entityManager.persist(pais);
		return pais.toString();

	}

}
