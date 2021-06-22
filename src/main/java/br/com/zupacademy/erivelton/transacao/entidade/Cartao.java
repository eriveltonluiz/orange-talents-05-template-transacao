package br.com.zupacademy.erivelton.transacao.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String numero;
	
	@Email
	@NotBlank
	private String email;

	@Deprecated
	public Cartao() {
	}

	public Cartao(String numero, String email) {
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
