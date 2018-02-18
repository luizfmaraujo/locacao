package testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import base.Locacao;
import base.Utilitario;
import junit.framework.TestCase;

class UtilitarioTest extends TestCase{

	@Test
	void testcalculaNumerodeDias() throws ParseException {
		int retornoEsperado = 4;
		SimpleDateFormat formato = new SimpleDateFormat( "dd/MM/yyyy" ); 
		Date dataInicial = formato.parse( "17/02/2018" );
		Date dataFinal = formato.parse( "21/02/2018" );
		int retornoEncontrado = Utilitario.calculaNumerodeDias(dataInicial, dataFinal);
		assertEquals(retornoEsperado, retornoEncontrado);
	}
	
	@Test
	void testcalculaQuantidadeDiasDaSemana() throws ParseException {
		int retornoEsperado = 5;
		SimpleDateFormat formato = new SimpleDateFormat( "dd/MM/yyyy" ); 
		Date dataInicial = formato.parse( "19/02/2018" );
		Date dataFinal = formato.parse( "23/02/2018" );
		int retornoEncontrado = Utilitario.calculaQuantidadeDiasDaSemana(dataInicial, dataFinal);
		assertEquals(retornoEsperado, retornoEncontrado);
	}
	
	@Test
	void testcalculaQuantidadeDiasFimDeSemana() throws ParseException {
		int retornoEsperado = 2;
		SimpleDateFormat formato = new SimpleDateFormat( "dd/MM/yyyy" ); 
		Date dataInicial = formato.parse( "16/02/2018" );
		Date dataFinal = formato.parse( "19/02/2018" );
		int retornoEncontrado = Utilitario.calculaQuantidadeDiasFimDeSemana(dataInicial, dataFinal);
		assertEquals(retornoEsperado, retornoEncontrado);
	}
	
	@Test
	void testcalculaMelhorLocadora() throws Exception {
		int retornoTotalEsperado = 930;
		String retornoLocadoraEsperado = "SouthCar";
		int  diasFimdeSemana = 2;
		int diasdeSemana = 5; 
		int numeroPessoas = 4;
		boolean cartaoFidelidade = true;
		Locacao locacao=Utilitario.calculaMelhorLocadora(diasFimdeSemana, diasdeSemana, numeroPessoas, cartaoFidelidade);
		int retornoTotalEncontrado = locacao.getTotalLocacao();
		String retornoLocadoraEncontrado = locacao.getLocadora().getNome();
		assertEquals(retornoTotalEsperado, retornoTotalEncontrado);
		assertEquals(retornoLocadoraEsperado, retornoLocadoraEncontrado);
	}

}
