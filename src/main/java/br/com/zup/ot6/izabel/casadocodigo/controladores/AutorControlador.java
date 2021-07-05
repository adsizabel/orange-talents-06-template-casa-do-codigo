package br.com.zup.ot6.izabel.casadocodigo.controladores;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.ot6.izabel.casadocodigo.dto.AutorRequestDTO;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Autor;
import br.com.zup.ot6.izabel.casadocodigo.excecoes.ComponenteValidador;

@RestController
@RequestMapping(path = "/autor")
public class AutorControlador {
	
	ComponenteValidador componenteValidador;
	
	@Autowired		
	public AutorControlador(ComponenteValidador componenteValidador) {
		this.componenteValidador = componenteValidador;
	}

	@PostMapping
	public ResponseEntity<Autor> cadastrarAluno(@RequestBody @Valid AutorRequestDTO autorRequestDTO){
		 Autor autor = componenteValidador.salvar(autorRequestDTO.converterParaEntidade(autorRequestDTO));
		 return ResponseEntity.status(HttpStatus.OK).body(autor);
		
	}

}
