package com.deveficiente.desafiocreditas;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

@Service
public class RegraDeEmprestimoComGarantia implements AnalisaCombinacao {

	@Override
	public Optional<PossibilidadeEmprestimoResponse> aceita(@Valid NovoClienteRequest request) {
		//4
		if(request.salarioMenorIgual(3000)
				&& request.ehDeSaoPaulo()
				&& request.idadeMenorDoQue(30)) {
			return Optional.of(new PossibilidadeEmprestimoResponse(TipoEmprestimo.com_garantia,
						3));
		}
		
		if((request.salarioMaiorQue(3000)
				&& request.salarioMenorIgual(5000))
				&& request.ehDeSaoPaulo()) {
			return Optional.of(new PossibilidadeEmprestimoResponse(TipoEmprestimo.com_garantia,
					3));			
		}
		
		if(request.salarioMaiorQue(5000) && request.idadeMenorDoQue(30)) {
			return Optional.of(new PossibilidadeEmprestimoResponse(TipoEmprestimo.com_garantia,
					3));			
		}
		
		return Optional.empty();
	}

}
