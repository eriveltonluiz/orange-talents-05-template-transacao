package br.com.zupacademy.erivelton.transacao.dto.resposta;

public class CartaoRespostaDTO {

	private String numero;

	private String email;

	public CartaoRespostaDTO(String numero, String email) {
		this.numero = numero;
		this.email = email;
	}

	public String getNumero() {
		return numero;
	}

	public String getEmail() {
		return email;
	}

}
