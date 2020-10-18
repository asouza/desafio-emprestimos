package com.deveficiente.desafiocreditas;

import java.util.Set;

public class ModalidadesEmprestimoResponse {

	private Set<PossibilidadeEmprestimoResponse> emprestimos;
	private String nome;

	public ModalidadesEmprestimoResponse(NovoClienteRequest novoClienteRequest,
			Set<PossibilidadeEmprestimoResponse> emprestimos ) {
				this.emprestimos = emprestimos;
			this.nome = novoClienteRequest.getNome();
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public Set<PossibilidadeEmprestimoResponse> getEmprestimos() {
		return emprestimos;
	}

}
