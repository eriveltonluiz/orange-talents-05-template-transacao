package br.com.zupacademy.erivelton.transacao.entidade;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Transacao {

	@NotBlank
	@Id
	private String id;

	@NotNull
	private BigDecimal valor;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	private Estabelecimento estabelecimento;

	@ManyToOne
	private Cartao cartao;
	
	@NotNull
	private LocalDateTime efetivadaEm;
	
	@Deprecated
	public Transacao() {
	}

	public Transacao(@NotBlank String id, @NotNull BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
			@NotNull LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

}
