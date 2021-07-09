package br.com.zup.ot6.izabel.casadocodigo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.ot6.izabel.casadocodigo.dto.ClienteRequestDTO;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Cliente;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.EstadoPaisValidador;

@RestController
public class ClienteControlador {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	public EstadoPaisValidador estadoPaisValidador;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(estadoPaisValidador);
	}
	
	@PostMapping(value = "/cliente")
	@Transactional
	public String cadastrarCliente(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO) {
		Cliente cliente = clienteRequestDTO.coverterParaEntidade(entityManager);
		entityManager.persist(cliente);
		return cliente.toString();
	}


}
