package com.deveficiente.desafiocreditas;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RegraEmprestimoPessoalTest {

	private RegraEmprestimoPessoal regra = new RegraEmprestimoPessoal();
	//salario <= 3000 && nao de sp
	//salario > 3000 && não de sp 
	//salario <= 3000 && de sp
	
	@DisplayName("salario <= 3000 e nao de sp ")
	@ParameterizedTest
	@CsvSource({
		"3000,ba,true",
		"2999,ba,true",
		"2000,ba,true",
		"3001,ba,false",
		"4000,ba,false",
		"3000,sp,false"		
	})
	void teste1(BigDecimal salario,String estado,boolean resultado) throws Exception {
		NovoClienteRequest request = new NovoClienteRequest("", "", 30, estado, salario);
		Assertions.assertEquals(resultado, regra.aceita(request));
	}
}
