package base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import util.FileUtil;

public class Utilitario {
	static FileUtil arquivo = new FileUtil();
	static List<Locadora> locadoras = new ArrayList<Locadora>();
	static List<Carro> carros = new ArrayList<Carro>();

	public static Locacao calculaMelhorLocadora(int diasFimdeSemana, int diasdeSemana, int numeroPessoas,
			boolean cartaoFidelidade) throws Exception {
		int menorLocacao = 99999999;
		int totalLocacaoAtual = 0;
		Utilitario.preencheDadosLocadoras();
		Utilitario.preencheDadosCarros();
		Locacao locacao = new Locacao();
		if (cartaoFidelidade) {
			for (Locadora locadora : locadoras) {
				for (Carro carro : carros) {
					if ((numeroPessoas <= carro.getLimite()) && (carro.getTipo().equals(locadora.getTipoCarro()))) {
						totalLocacaoAtual = locadora.getTaxaFimdeSemanaVip() * diasFimdeSemana
								+ locadora.getTaxaSemanalVip() * diasdeSemana;
						if (totalLocacaoAtual < menorLocacao) {
							locacao.setTotalLocacao(totalLocacaoAtual);
							locacao.setLocadora(locadora);
							locacao.setCarro(carro);
							menorLocacao = totalLocacaoAtual;
						}
					}
				}
			}
		} else {
			for (Locadora locadora : locadoras) {
				for (Carro carro : carros) {
					if ((numeroPessoas <= carro.getLimite()) && (carro.getTipo().equals(locadora.getTipoCarro()))) {
						totalLocacaoAtual = locadora.getTaxaFimdeSemanaNormal() * diasFimdeSemana
								+ locadora.getTaxaSemanalNormal() * diasdeSemana;
						if (totalLocacaoAtual < menorLocacao) {
							locacao.setTotalLocacao(totalLocacaoAtual);
							locacao.setLocadora(locadora);
							locacao.setCarro(carro);
							menorLocacao = totalLocacaoAtual;
						}
					}
				}
			}
		}
		return locacao;
	}

	public static void preencheDadosLocadoras() throws Exception {
		String dadosLocadoras = arquivo.read("Locadora");
		String locadorasSeparadas[] = dadosLocadoras.split(Pattern.quote("\n"));
		for (String ls : locadorasSeparadas) {
			Locadora locadoraAtual = new Locadora();
			String dados[] = ls.split(Pattern.quote(";"));
			locadoraAtual.setNome(dados[0].toString());
			locadoraAtual.setTaxaSemanalNormal(Integer.valueOf(dados[1].toString()));
			locadoraAtual.setTaxaSemanalVip(Integer.valueOf(dados[2].toString()));
			locadoraAtual.setTaxaFimdeSemanaNormal(Integer.valueOf(dados[3].toString()));
			locadoraAtual.setTaxaFimdeSemanaVip(Integer.valueOf(dados[4].toString()));
			locadoraAtual.setTipoCarro(dados[5].toString());
			locadoras.add(locadoraAtual);
		}

	}

	public static void preencheDadosCarros() throws Exception {
		String dadosCarros = arquivo.read("Carro");
		String carrosSeparados[] = dadosCarros.split(Pattern.quote("\n"));
		for (String cs : carrosSeparados) {
			String dados[] = cs.split(Pattern.quote(";"));
			Carro carroAtual = new Carro();
			carroAtual.setTipo(dados[0].toString());
			carroAtual.setNome(dados[1].toString());
			carroAtual.setLimite(Integer.valueOf(dados[2].toString()));
			carros.add(carroAtual);
		}

	}

	public static Date converteStringEmData(String stringData) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt_BR"));
			date = sdf.parse(stringData);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static int calculaNumerodeDias(Date dataInicial, Date dataFinal) {
		int dias;
		if (dataInicial == null || dataFinal == null) {
			return 0;
		}
		dias = (int) ((dataFinal.getTime() - dataInicial.getTime()) / (24 * 60 * 60 * 1000));
		return dias;
	}

	public static int calculaQuantidadeDiasDaSemana(Date dataInicial, Date dataFinal) {
		int diasSemana = 0;
		int totalDias = calculaNumerodeDias(dataInicial, dataFinal);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dataInicial);
		for (int i = 0; i <= totalDias; i++) {
			if (!(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
					&& !(calendar.get(calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
				diasSemana++;
			}
			calendar.add(calendar.DATE, 1);
		}
		return diasSemana;
	}

	public static int calculaQuantidadeDiasFimDeSemana(Date dataInicial, Date dataFinal) {
		int diasFimdeSemana = 0;
		int totalDias = calculaNumerodeDias(dataInicial, dataFinal);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dataInicial);
		for (int i = 0; i <= totalDias; i++) {
			if ((calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
					|| (calendar.get(calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
				diasFimdeSemana++;
			}
			calendar.add(calendar.DATE, 1);
		}
		return diasFimdeSemana;
	}

}
