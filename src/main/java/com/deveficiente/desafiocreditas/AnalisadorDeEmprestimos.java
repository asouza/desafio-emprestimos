package com.deveficiente.desafiocreditas;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
//3
public class AnalisadorDeEmprestimos {
	
	@Autowired
	//1
	private Set<AnalisaCombinacao> analisadoresCombinacao;

	public Set<PossibilidadeEmprestimoResponse> buscaPorCombinacao(
			@Valid NovoClienteRequest request) {
		

		Set<PossibilidadeEmprestimoResponse> possibilidades = analisadoresCombinacao
				.stream()
				//1
				.map(analisador -> analisador.aceita(request))
				.filter(Optional :: isPresent)
				.map(Optional :: get)
				.collect(Collectors.toSet());
		
		if(possibilidades.isEmpty()) {
			return Set.of();
		}
		
		return possibilidades;
		
		
	}

	
}
