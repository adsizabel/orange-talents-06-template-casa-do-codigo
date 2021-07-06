package br.com.zup.ot6.izabel.casadocodigo.excecoes;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.ot6.izabel.casadocodigo.dto.AutorRequestDTO;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Autor;
import br.com.zup.ot6.izabel.casadocodigo.repositorios.AutorRepositorio;

@Component
public class EmailDuplicadoAutorValidator implements Validator{
	
	@Autowired
	AutorRepositorio autorRepositorio;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorRequestDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		AutorRequestDTO request = (AutorRequestDTO) target;
		
		Optional<Autor> autorPesquisado = autorRepositorio.findByEmail(request.getEmail());
		
		if(autorPesquisado.isPresent()) {
			errors.rejectValue("email", null, "E-mail já está sendo usado: " + request.getEmail());
		}
	}

}
