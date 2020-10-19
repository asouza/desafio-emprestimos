package com.deveficiente.desafiocreditas;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.util.Assert;

public class RegraDeEmprestimoComGarantiaTest {

	private RegraDeEmprestimoComGarantia regraEmprestimoPessoal = new RegraDeEmprestimoComGarantia();
	
	@ParameterizedTest
	@DisplayName("salario menor que 3000, de sao paulo e idade menor que 30")
	@MethodSource("geradorTeste1")
	void teste1(BigDecimal salario, String cidade, int idade,Optional<PossibilidadeEmprestimoResponse> resultado)
			throws Exception {
		NovoClienteRequest request = new NovoClienteRequest("324233", "alberto",
				idade, cidade, salario);
		
		Optional<PossibilidadeEmprestimoResponse> aceite = regraEmprestimoPessoal.aceita(request);
		
		Assertions.assertEquals(resultado.isPresent(), aceite.isPresent());
		aceite.ifPresent(emprestimoEncontrado -> {
			PossibilidadeEmprestimoResponse emprestimoEsperado = resultado.get();
			Assertions.assertEquals(emprestimoEsperado.getTipo(),emprestimoEncontrado.getTipo());
			Assertions.assertEquals(emprestimoEsperado.getTaxa(),emprestimoEncontrado.getTaxa());
		});
	}
	
	private static Stream<Arguments> geradorTeste1() {
		PossibilidadeEmprestimoResponse resultado = new PossibilidadeEmprestimoResponse(
				TipoEmprestimo.com_garantia, 3);
		return Stream.of(
				Arguments.of(new BigDecimal(3000),"sp",29,Optional.of(resultado)),
				//inverte o primeiro if1
				Arguments.of(new BigDecimal(3001),"rj",31,Optional.empty()),
				//inverte o segundo if1
				Arguments.of(new BigDecimal(3000),"rj",29,Optional.empty()),
				//inverte o terceiro if1
				Arguments.of(new BigDecimal(3000),"rj",30,Optional.empty()),
				//verdade para o if2
				Arguments.of(new BigDecimal(3001),"sp",29,Optional.of(resultado)),
				//verdade para o if2 outra borda
				Arguments.of(new BigDecimal(5000),"sp",29,Optional.of(resultado)),
				//inverte condicao 1 if2
				Arguments.of(new BigDecimal(3000),"sp",30,Optional.empty()),
				//inverte condicao 2 if2
				Arguments.of(new BigDecimal(5001),"sp",30,Optional.empty()),
				//verdade if 3
				Arguments.of(new BigDecimal(5001),"sp",29,Optional.of(resultado)),
				//inverte condicao 1 if 3
				Arguments.of(new BigDecimal(5000),"RJ",29,Optional.empty()),
				//inverte condicao 2 if 3
				Arguments.of(new BigDecimal(5001),"RJ",30,Optional.empty())
			);
	}
}
