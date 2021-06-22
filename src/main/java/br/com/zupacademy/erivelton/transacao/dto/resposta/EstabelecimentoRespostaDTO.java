package br.com.zupacademy.erivelton.transacao.dto.resposta;

public class EstabelecimentoRespostaDTO {

	private String nome;
	
	private String cidade;
	
	private String endereco;
	
	public EstabelecimentoRespostaDTO(String nome, String cidade, String endereco) {
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
}
