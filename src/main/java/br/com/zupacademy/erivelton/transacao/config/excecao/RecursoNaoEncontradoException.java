package br.com.zupacademy.erivelton.transacao.config.excecao;

public class RecursoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RecursoNaoEncontradoException() {
		super("Recurso inserido não foi encontrado!!");
	}
}
