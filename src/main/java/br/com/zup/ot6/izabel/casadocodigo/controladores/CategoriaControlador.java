package br.com.zup.ot6.izabel.casadocodigo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.ot6.izabel.casadocodigo.dto.CategoriaRequestDTO;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Categoria;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaControlador {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public String postMethodName(@RequestBody @Valid CategoriaRequestDTO categoriaRequestDTO) {
		Categoria categoria = categoriaRequestDTO.converterParaEntidade(categoriaRequestDTO);
		entityManager.persist(categoria);
		return categoria.toString();
	}

}
