package br.com.zupacademy.erivelton.transacao.dto.requisicao;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.erivelton.transacao.entidade.Estabelecimento;

public class NovoEstabelecimentoRequisicao {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String endereco;

	@Deprecated
	public NovoEstabelecimentoRequisicao() {
	}
	
	public NovoEstabelecimentoRequisicao(@NotBlank String nome, @NotBlank String cidade, @NotBlank String endereco) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return "Estabelecimento [nome=" + nome + ", cidade=" + cidade + ", endereco=" + endereco + "]";
	}

	public Estabelecimento paraEntidade() {
		return new Estabelecimento(nome, cidade, endereco);
	}

}
