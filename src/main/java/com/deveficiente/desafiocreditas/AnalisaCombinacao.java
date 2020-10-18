package com.deveficiente.desafiocreditas;

import java.util.Set;

import javax.validation.Valid;

public interface AnalisaCombinacao {

	public Set<PossibilidadeEmprestimoResponse> possibilidades(NovoClienteRequest request);

	public boolean aceita(@Valid NovoClienteRequest request);
}
