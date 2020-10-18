package com.deveficiente.desafiocreditas;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

@Service
public class RegraDeEmprestimo6 implements AnalisaCombinacao {

	@Override
	public Set<PossibilidadeEmprestimoResponse> possibilidades(
			NovoClienteRequest request) {
		return Set.of(
				new PossibilidadeEmprestimoResponse(TipoEmprestimo.pessoal, 4),
				new PossibilidadeEmprestimoResponse(TipoEmprestimo.com_garantia,
						3),
				new PossibilidadeEmprestimoResponse(TipoEmprestimo.consignado,
						2));
	}

	@Override
	public boolean aceita(@Valid NovoClienteRequest request) {
		return request.salarioMaiorQue(5000) && request.idadeMenorDoQue(30);
	}

}
