package br.com.zupacademy.erivelton.transacao.dto.resposta;

import java.math.BigDecimal;

import br.com.zupacademy.erivelton.transacao.entidade.Transacao;

public class UltimasTransacoesDTO {

	private String id;

	private BigDecimal valor;
	
	private EstabelecimentoRespostaDTO estabelecimento;

	private CartaoRespostaDTO cartao;
	
	private String efetivadaEm;

	public UltimasTransacoesDTO(Transacao transacao) {
		this.id = transacao.getId();
		this.valor = transacao.getValor();
		this.estabelecimento = transacao.getDTOEstabelecimento();
		this.cartao = transacao.getDTOCartao();
		this.efetivadaEm = transacao.dataEmString();
	}
	
	public String getId() {
		return id;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public CartaoRespostaDTO getCartao() {
		return cartao;
	}
	
	public EstabelecimentoRespostaDTO getEstabelecimento() {
		return estabelecimento;
	}
	
	public String getEfetivadaEm() {
		return efetivadaEm;
	}
}
