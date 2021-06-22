package br.com.zupacademy.erivelton.transacao.config.errovalidacao;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RespostaErroDTO {

	private String mensagem;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm.ss")
	private OffsetDateTime momento;

	public RespostaErroDTO(String mensagem, OffsetDateTime momento) {
		super();
		this.mensagem = mensagem;
		this.momento = momento;
	}

	public String getMensagem() {
		return mensagem;
	}

	public OffsetDateTime getMomento() {
		return momento;
	}

}
