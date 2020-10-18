package com.deveficiente.desafiocreditas;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

@Service
//1
public class RegraDeEmprestimo1 implements AnalisaCombinacao {

	@Override
	//1
	public Set<PossibilidadeEmprestimoResponse> possibilidades(
			NovoClienteRequest request) {
		return Set.of(
				new PossibilidadeEmprestimoResponse(TipoEmprestimo.pessoal, 4));
	}

	@Override
	//1
	public boolean aceita(@Valid NovoClienteRequest request) {
		//3
		return request.salarioMenorIgual(3000) && !request.ehDeSaoPaulo();
	}

}
