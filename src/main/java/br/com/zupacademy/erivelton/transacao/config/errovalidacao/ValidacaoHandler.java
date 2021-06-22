package br.com.zupacademy.erivelton.transacao.config.errovalidacao;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.zupacademy.erivelton.transacao.config.excecao.RecursoNaoEncontradoException;

@RestControllerAdvice
public class ValidacaoHandler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public RespostaErroDTO handleRecursoNaoEncontrado(RecursoNaoEncontradoException ex) {
		return new RespostaErroDTO(ex.getMessage(), OffsetDateTime.now());
	}
}
