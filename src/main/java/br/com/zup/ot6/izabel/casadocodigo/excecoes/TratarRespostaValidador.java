package br.com.zup.ot6.izabel.casadocodigo.excecoes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratarRespostaValidador {
	
	MessageSource messageSource;
	
	@Autowired
	public TratarRespostaValidador(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
    public ErrosDTO tratamentoGenerico(BindException e){
        
		List<FieldError> fieldErros =  e.getBindingResult().getFieldErrors();
		List<ObjectError> errosGlobais= e.getBindingResult().getGlobalErrors();
		
		return montaObjetoErrosDTO(fieldErros, errosGlobais);
		
	}
	
	private ErrosDTO montaObjetoErrosDTO(List<FieldError> fieldErros, List<ObjectError> errosGlobais) {
		return new ErrosDTO(getErrosCampos(fieldErros), getErrosGlobais(errosGlobais));		
	}
	
	private List<String> getErrosGlobais(List<ObjectError> errosGlobais){
		List<String> globais = new ArrayList<>();
		for(ObjectError obj: errosGlobais) {
			globais.add(obj.getDefaultMessage());
		}
		return globais;
	}

	private List<RespostaPadraoDTO> getErrosCampos(List<FieldError> errosCampos){
		List<RespostaPadraoDTO> dto = new ArrayList<>();
		for(FieldError c: errosCampos) {
			dto.add(new RespostaPadraoDTO(c.getField(), c.getDefaultMessage()));
		}
		return dto;
	}
	
	private String getMessagensErros(ObjectError erro) {
		return messageSource.getMessage(erro, LocaleContextHolder.getLocale());
	}
}
