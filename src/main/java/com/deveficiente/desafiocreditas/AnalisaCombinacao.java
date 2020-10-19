package com.deveficiente.desafiocreditas;

import java.util.Optional;

import javax.validation.Valid;

public interface AnalisaCombinacao {

	public Optional<PossibilidadeEmprestimoResponse> aceita(
			@Valid NovoClienteRequest request);
}
