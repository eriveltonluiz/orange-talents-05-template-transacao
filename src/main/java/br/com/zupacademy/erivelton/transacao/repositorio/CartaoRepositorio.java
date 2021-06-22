package br.com.zupacademy.erivelton.transacao.repositorio;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.erivelton.transacao.entidade.Cartao;

@Repository
public interface CartaoRepositorio extends JpaRepository<Cartao, UUID>{

	boolean existsByNumero(String numero);

	Cartao getByNumero(String numero);
}
