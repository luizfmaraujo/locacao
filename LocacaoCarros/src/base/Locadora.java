package base;

public class Locadora {

	public String nome;
	public int taxaSemanalNormal;
	public int taxaFimdeSemanaNormal;
	public int taxaSemanalVip;
	public int taxaFimdeSemanaVip;
	public String tipoCarro;

	public String getTipoCarro() {
		return tipoCarro;
	}

	public void setTipoCarro(String tipoCarro) {
		this.tipoCarro = tipoCarro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTaxaSemanalNormal() {
		return taxaSemanalNormal;
	}

	public void setTaxaSemanalNormal(int taxaSemanalNormal) {
		this.taxaSemanalNormal = taxaSemanalNormal;
	}

	public int getTaxaFimdeSemanaNormal() {
		return taxaFimdeSemanaNormal;
	}

	public void setTaxaFimdeSemanaNormal(int taxaFimdeSemanaNormal) {
		this.taxaFimdeSemanaNormal = taxaFimdeSemanaNormal;
	}

	public int getTaxaSemanalVip() {
		return taxaSemanalVip;
	}

	public void setTaxaSemanalVip(int taxaSemanalVip) {
		this.taxaSemanalVip = taxaSemanalVip;
	}

	public int getTaxaFimdeSemanaVip() {
		return taxaFimdeSemanaVip;
	}

	public void setTaxaFimdeSemanaVip(int taxaFimdeSemanaVip) {
		this.taxaFimdeSemanaVip = taxaFimdeSemanaVip;
	}

}
