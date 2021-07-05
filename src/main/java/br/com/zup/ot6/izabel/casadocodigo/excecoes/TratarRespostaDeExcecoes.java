package br.com.zup.ot6.izabel.casadocodigo.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TratarRespostaDeExcecoes {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> tratamentoGenerico(Exception e, HttpServletRequest request){
        HttpStatus status = getHttpStatus(e);
        ErroRespostaPadrao erro = new ErroRespostaPadrao();
        erro.setMessagem(e.getMessage());
        erro.setTimestamp(System.currentTimeMillis());
        erro.setStatus(status.value());
        erro.setErro(status.getReasonPhrase());
        erro.setUri(request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }

    private HttpStatus getHttpStatus(Exception e){
        if(e instanceof ValidaQuantidadeCaracteres || e instanceof ValidaCampoVazio
        	|| e instanceof ValidaEmailDuplicado) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
