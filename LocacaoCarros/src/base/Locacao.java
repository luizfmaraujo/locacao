package base;

public class Locacao {

	public Locadora locadora;
	public Carro carro;
	public int totalLocacao;

	public Locadora getLocadora() {
		return locadora;
	}

	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public int getTotalLocacao() {
		return totalLocacao;
	}

	public void setTotalLocacao(int totalLocacao) {
		this.totalLocacao = totalLocacao;
	}
}
