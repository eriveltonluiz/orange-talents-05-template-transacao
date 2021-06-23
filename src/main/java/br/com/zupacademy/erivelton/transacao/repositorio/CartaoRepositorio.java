package br.com.zupacademy.erivelton.transacao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.erivelton.transacao.entidade.Cartao;

@Repository
public interface CartaoRepositorio extends JpaRepository<Cartao, Long>{

	boolean existsByNumero(String numero);

	Cartao findByNumero(String numero);
}
