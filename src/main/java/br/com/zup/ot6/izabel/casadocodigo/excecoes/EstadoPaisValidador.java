package br.com.zup.ot6.izabel.casadocodigo.excecoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import br.com.zup.ot6.izabel.casadocodigo.dto.ClienteRequestDTO;
import br.com.zup.ot6.izabel.casadocodigo.entidades.Estado;
import br.com.zup.ot6.izabel.casadocodigo.repositorios.EstadoRepositorio;

@Component
public class EstadoPaisValidador implements Validator{

	@Autowired
	EstadoRepositorio estadoRepositorio;

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteRequestDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		ClienteRequestDTO request = (ClienteRequestDTO) target;

		List<Estado> list = estadoRepositorio.pesquisaPaises(request.getIdPais());
		
		if(!list.isEmpty()) {
			errors.reject(null, "Pais possue estados, logo Estado é obrigatorio ");
		}

	}

}
