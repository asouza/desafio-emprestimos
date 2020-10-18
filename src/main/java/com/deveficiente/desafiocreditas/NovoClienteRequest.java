package com.deveficiente.desafiocreditas;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.br.CPF;

//0
public class NovoClienteRequest {

	@NotBlank
	@CPF
	private String cpf;
	@NotBlank
	private String nome;
	@Positive
	private int idade;
	@NotBlank
	private String localizacao;
	@Positive
	@NotNull
	private BigDecimal salario;

	public NovoClienteRequest(@NotBlank @CPF String cpf, @NotBlank String nome,
			@Positive int idade, @NotBlank String localizacao,
			@Positive @NotNull BigDecimal salario) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.localizacao = localizacao;
		this.salario = salario;
	}

	public String getNome() {
		return this.nome;
	}

	public boolean salarioMenorIgual(int valor) {
		return this.salario.compareTo(new BigDecimal(valor)) <= 0;
	}

	public boolean ehDeSaoPaulo() {
		return this.localizacao.toLowerCase().equals("sp");		
	}

	public boolean idadeMenorDoQue(int limite) {
		return this.idade < limite;
	}

	public boolean salarioMaiorQue(int limite) {
		return this.salario.compareTo(new BigDecimal(limite)) > 0;
	}

	public boolean idadeMaiorQue(int limite) {
		return this.idade > limite;
	}

}
