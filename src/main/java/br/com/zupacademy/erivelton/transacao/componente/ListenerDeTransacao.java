package br.com.zupacademy.erivelton.transacao.componente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.zupacademy.erivelton.transacao.dto.requisicao.NovaTransacaoRequisicao;
import br.com.zupacademy.erivelton.transacao.entidade.Cartao;
import br.com.zupacademy.erivelton.transacao.entidade.Transacao;
import br.com.zupacademy.erivelton.transacao.repositorio.CartaoRepositorio;
import br.com.zupacademy.erivelton.transacao.repositorio.TransacaoRepositorio;

@Component
public class ListenerDeTransacao {

	@Autowired
	private CartaoRepositorio cartaoRepositorio;

	@Autowired
	private TransacaoRepositorio transacaoRepositorio;

	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	@Transactional
	public void ouvir(NovaTransacaoRequisicao requisicao) {
		Cartao cartao = requisicao.getEntidadeCartao();

		if (!cartaoRepositorio.existsByNumero(cartao.getNumero())) {
			cartaoRepositorio.save(cartao);
		} else {
			cartao = cartaoRepositorio.getByNumero(cartao.getNumero());
		}

		Transacao transacao = requisicao.paraEntidade(cartao);
		transacaoRepositorio.save(transacao);
	}
}
