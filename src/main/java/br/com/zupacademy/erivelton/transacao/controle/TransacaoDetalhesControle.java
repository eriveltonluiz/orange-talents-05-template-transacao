package br.com.zupacademy.erivelton.transacao.controle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.erivelton.transacao.config.excecao.RecursoNaoEncontradoException;
import br.com.zupacademy.erivelton.transacao.dto.resposta.UltimasTransacoesDTO;
import br.com.zupacademy.erivelton.transacao.entidade.Transacao;
import br.com.zupacademy.erivelton.transacao.repositorio.CartaoRepositorio;
import br.com.zupacademy.erivelton.transacao.repositorio.TransacaoRepositorio;

@RestController
public class TransacaoDetalhesControle {

	@Autowired
	private TransacaoRepositorio transacaoRepositorio;

	@Autowired
	private CartaoRepositorio cartaoRepositorio;

	@GetMapping(value = "/transacoes/{idCartao}")
	public ResponseEntity<List<UltimasTransacoesDTO>> listarTransacoes(@PathVariable Long idCartao) {
		if (!cartaoRepositorio.existsById(idCartao))
			throw new RecursoNaoEncontradoException();

		List<Transacao> resultadoConsulta = transacaoRepositorio
				.findTop10ByCartaoIdOrderByEfetivadaEmDesc(idCartao);

		List<UltimasTransacoesDTO> listaDTO = resultadoConsulta.stream().map(UltimasTransacoesDTO::new)
				.collect(Collectors.toList());

		return ResponseEntity.ok(listaDTO);
	}
}
