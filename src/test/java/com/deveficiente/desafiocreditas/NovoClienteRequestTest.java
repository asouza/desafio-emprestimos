package com.deveficiente.desafiocreditas;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NovoClienteRequestTest {
	
	// salarioMenorIgual => valor exato, 1 para cima
	
	@DisplayName("verifica salario menor igual")
	@ParameterizedTest
	@CsvSource({
		"3000,3000,true",
		"2000,3000,true",
		"3001,3000,false",
		"5000,3000,false"
	})
	void teste1(BigDecimal salario,int teste,boolean resultado) throws Exception {
		NovoClienteRequest request = new NovoClienteRequest("", "", 30, "ba",
				salario);
		
		Assertions.assertEquals(resultado,request.salarioMenorIgual(teste));
	}
	
	@DisplayName("verifica se eh da cidade")
	@ParameterizedTest
	@CsvSource({
		"sp,true",
		"ba,false"
	})
	void teste2(String cidade,boolean resultado) throws Exception {
		NovoClienteRequest request = new NovoClienteRequest("", "", 30, cidade,
				BigDecimal.TEN);
		
		Assertions.assertEquals(resultado,request.ehDeSaoPaulo());
	}
	
	@DisplayName("idade menor do que")
	@ParameterizedTest
	@CsvSource({
		"29,30,true",
		"30,30,false",
		"20,30,true",
		"40,30,false"
	})
	void teste3(int idade,int limite,boolean resultado) throws Exception {
		NovoClienteRequest request = new NovoClienteRequest("", "", idade, "sp",
				BigDecimal.TEN);
		
		Assertions.assertEquals(resultado,request.idadeMenorDoQue(limite));
	}
	
	@DisplayName("idade maior do que")
	@ParameterizedTest
	@CsvSource({
		"31,30,true",
		"30,30,false",
		"40,30,true",
		"20,30,false"
	})
	void teste4(int idade,int limite,boolean resultado) throws Exception {
		NovoClienteRequest request = new NovoClienteRequest("", "", idade, "sp",
				BigDecimal.TEN);
		
		Assertions.assertEquals(resultado,request.idadeMaiorQue(limite));
	}
	
	@DisplayName("salario maior que")
	@ParameterizedTest
	@CsvSource({
		"3001,3000,true",
		"3000,3000,false",
		"4000,3000,true",
		"2000,3000,false"
	})
	void teste5(BigDecimal salario,int teste,boolean resultado) throws Exception {
		NovoClienteRequest request = new NovoClienteRequest("", "", 30, "ba",
				salario);
		
		Assertions.assertEquals(resultado,request.salarioMaiorQue(teste));
	}	
}
