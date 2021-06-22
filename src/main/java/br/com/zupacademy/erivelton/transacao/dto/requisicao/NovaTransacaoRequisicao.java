package br.com.zupacademy.erivelton.transacao.dto.requisicao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.erivelton.transacao.entidade.Cartao;
import br.com.zupacademy.erivelton.transacao.entidade.Transacao;

public class NovaTransacaoRequisicao {

	@NotBlank
	private String id;

	@NotNull
	private BigDecimal valor;

	private NovoEstabelecimentoRequisicao estabelecimento;

	private NovoCartaoRequisicao cartao;

	@NotBlank
	private String efetivadaEm;

	@Deprecated
	public NovaTransacaoRequisicao() {
	}

	public NovaTransacaoRequisicao(String id, BigDecimal valor, NovoEstabelecimentoRequisicao estabelecimento,
			NovoCartaoRequisicao cartao, String efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public Transacao paraEntidade(Cartao cartao) {
		return new Transacao(id, valor, estabelecimento.paraEntidade(), cartao,
				LocalDateTime.parse(efetivadaEm));
	}

	public Cartao getEntidadeCartao() {
		return cartao.paraEntidade();
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public NovoEstabelecimentoRequisicao getEstabelecimento() {
		return estabelecimento;
	}

	public NovoCartaoRequisicao getCartao() {
		return cartao;
	}

	public String getEfetivadaEm() {
		return efetivadaEm;
	}

	@Override
	public String toString() {
		return "EventoDeTransacao [id=" + id + ", valor=" + valor + ", estabelecimento=" + estabelecimento + ", cartao="
				+ cartao + ", efetivadaEm=" + efetivadaEm + "]";
	}

}
