package com.deveficiente.desafiocreditas;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
//3
public class ModalidadsController {
	
	@Autowired
	//1
	private AnalisadorDeEmprestimos analisador;

	@PostMapping(value = "/api/modalidades")
	// 1
	// 1
	public ModalidadesEmprestimoResponse pesquisa(
			@RequestBody @Valid NovoClienteRequest request) {

		Set<PossibilidadeEmprestimoResponse> possibilidades = analisador.buscaPorCombinacao(request);
		return new ModalidadesEmprestimoResponse(request, possibilidades);
	}

}
