package com.deveficiente.desafiocreditas;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

@Service
public class RegraDeEmprestimo2 implements AnalisaCombinacao {

	@Override
	public Set<PossibilidadeEmprestimoResponse> possibilidades(
			NovoClienteRequest request) {
		return Set.of(
				new PossibilidadeEmprestimoResponse(TipoEmprestimo.pessoal, 4),
				new PossibilidadeEmprestimoResponse(TipoEmprestimo.com_garantia,
						3));
	}

	@Override
	public boolean aceita(@Valid NovoClienteRequest request) {
		//4
		return request.salarioMenorIgual(3000)
				&& request.ehDeSaoPaulo()
				&& request.idadeMenorDoQue(30);
	}

}
