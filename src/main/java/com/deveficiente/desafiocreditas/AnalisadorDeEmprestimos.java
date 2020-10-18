package com.deveficiente.desafiocreditas;

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
		

		Set<AnalisaCombinacao> aceites = analisadoresCombinacao
				.stream()
				//1
				.filter(analisador -> analisador.aceita(request))
				.collect(Collectors.toSet());
		
		//1
		if(aceites.isEmpty()) {
			return Set.of();
		}
		
		Assert.state(aceites.size() == 1,"Achou mais de uma combinacao possível");
		
		return aceites.iterator().next().possibilidades(request);
		
		
	}

	
}
