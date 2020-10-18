package com.deveficiente.desafiocreditas;

public class PossibilidadeEmprestimoResponse {

	private TipoEmprestimo tipo;
	private int taxa;

	public PossibilidadeEmprestimoResponse(TipoEmprestimo tipo, int taxa) {
		this.tipo = tipo;
		this.taxa = taxa;
	}
	
	public TipoEmprestimo getTipo() {
		return tipo;
	}
	
	public int getTaxa() {
		return taxa;
	}

}
