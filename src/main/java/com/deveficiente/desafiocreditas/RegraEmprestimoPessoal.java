package com.deveficiente.desafiocreditas;

import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

@Service
//1
public class RegraEmprestimoPessoal implements AnalisaCombinacao {

	// 1
	public Optional<PossibilidadeEmprestimoResponse> aceita(
			@Valid NovoClienteRequest request) {
		// 3
		if (request.salarioMenorIgual(3000) && !request.ehDeSaoPaulo()) {
			return Optional.of(new PossibilidadeEmprestimoResponse(
					TipoEmprestimo.pessoal, 4));
		}
		
		return Optional.of(new PossibilidadeEmprestimoResponse(
				TipoEmprestimo.pessoal, 4));		
	}

}
