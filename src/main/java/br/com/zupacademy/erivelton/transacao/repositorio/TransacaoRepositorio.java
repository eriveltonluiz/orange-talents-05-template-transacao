package br.com.zupacademy.erivelton.transacao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.erivelton.transacao.entidade.Transacao;

@Repository
public interface TransacaoRepositorio extends JpaRepository<Transacao, String>{

}
