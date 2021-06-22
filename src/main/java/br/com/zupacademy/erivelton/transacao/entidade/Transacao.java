package br.com.zupacademy.erivelton.transacao.entidade;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.erivelton.transacao.dto.resposta.CartaoRespostaDTO;
import br.com.zupacademy.erivelton.transacao.dto.resposta.EstabelecimentoRespostaDTO;

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

	public String dataEmString() {
		return efetivadaEm.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm.ss"));
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public CartaoRespostaDTO getDTOCartao() {
		return new CartaoRespostaDTO(cartao.getNumero(), cartao.getEmail());
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public EstabelecimentoRespostaDTO getDTOEstabelecimento() {
		return new EstabelecimentoRespostaDTO(estabelecimento.getNome(), estabelecimento.getCidade(),
				estabelecimento.getEndereco());
	}
}
