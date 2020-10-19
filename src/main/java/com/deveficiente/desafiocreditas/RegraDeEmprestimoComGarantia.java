package com.deveficiente.desafiocreditas;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

@Service
//6
//11
public class RegraDeEmprestimoComGarantia implements AnalisaCombinacao {

	@Override
	//1
	//1
	public Optional<PossibilidadeEmprestimoResponse> aceita(@Valid NovoClienteRequest request) {
		//4
		//4 combinações
		boolean salarioMenorIgual3000 = request.salarioMenorIgual(3000);
		boolean ehDeSaoPaulo = request.ehDeSaoPaulo();
		boolean idadeMenorDoQue30 = request.idadeMenorDoQue(30);
		//4
		//3
		if(salarioMenorIgual3000
				&& ehDeSaoPaulo
				&& idadeMenorDoQue30) {			
			return Optional.of(new PossibilidadeEmprestimoResponse(TipoEmprestimo.com_garantia,
						3));
		}
		
		// 4 combinacoes
		boolean salarioMaiorQue3000 = request.salarioMaiorQue(3000);
		boolean salarioMenorIgual5000 = request.salarioMenorIgual(5000);
		//1
		//3
		if((salarioMaiorQue3000
				&& salarioMenorIgual5000)
				&& ehDeSaoPaulo) {
			return Optional.of(new PossibilidadeEmprestimoResponse(TipoEmprestimo.com_garantia,
					3));			
		}
		//3 combinacoes
		//1
		boolean salarioMaiorQue5000 = request.salarioMaiorQue(5000);
		//2
		if(salarioMaiorQue5000 && idadeMenorDoQue30) {
			return Optional.of(new PossibilidadeEmprestimoResponse(TipoEmprestimo.com_garantia,
					3));			
		}
		
		return Optional.empty();
	}

}
