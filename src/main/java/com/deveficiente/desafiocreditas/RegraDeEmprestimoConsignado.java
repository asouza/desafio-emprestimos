package com.deveficiente.desafiocreditas;

import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

@Service
public class RegraDeEmprestimoConsignado implements AnalisaCombinacao {

	@Override
	public Optional<PossibilidadeEmprestimoResponse> aceita(@Valid NovoClienteRequest request) {
		if(request.salarioMaiorQue(5000)) {
			return Optional.of(new PossibilidadeEmprestimoResponse(TipoEmprestimo.consignado,2));
		}
		
		return Optional.empty();
	}

}
