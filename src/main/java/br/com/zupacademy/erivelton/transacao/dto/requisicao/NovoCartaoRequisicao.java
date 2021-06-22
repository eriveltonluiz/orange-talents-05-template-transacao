package br.com.zupacademy.erivelton.transacao.dto.requisicao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.erivelton.transacao.entidade.Cartao;

public class NovoCartaoRequisicao {

	@NotBlank
	private String id;

	@Email
	@NotBlank
	private String email;

	@Deprecated
	public NovoCartaoRequisicao() {
	}

	public NovoCartaoRequisicao(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public Cartao paraEntidade() {
		return new Cartao(id, email);
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Cartao [id=" + id + ", email=" + email + "]";
	}

}
