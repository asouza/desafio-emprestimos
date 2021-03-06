package com.deveficiente.desafiocreditas;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

@Service
public class RegraDeEmprestimo4 implements AnalisaCombinacao {

	@Override
	public Set<PossibilidadeEmprestimoResponse> possibilidades(
			NovoClienteRequest request) {
		return Set.of(new PossibilidadeEmprestimoResponse(
				TipoEmprestimo.pessoal, 4)) ;
	}

	@Override
	public boolean aceita(@Valid NovoClienteRequest request) {
		return (request.salarioMaiorQue(3000)
				&& request.salarioMenorIgual(5000))
				&& !request.ehDeSaoPaulo();
	}

}
