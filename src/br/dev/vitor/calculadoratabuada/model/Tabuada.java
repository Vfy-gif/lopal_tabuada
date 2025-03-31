package br.dev.vitor.calculadoratabuada.model;

public class Tabuada {

	private double multiplicando;
	private double menorMultiplicador;
	private double maiorMultiplicador;

	public double getMultiplicando() {
		return multiplicando;
	}

	public void setMultiplicando(double multiplicando) {
		this.multiplicando = multiplicando;
	}

	public double getMenorMultiplicador() {
		return menorMultiplicador;
	}

	public void setMenorMultiplicador(double menorMultiplicador) {
		this.menorMultiplicador = menorMultiplicador;
	}

	public double getMaiorMultiplicador() {
		return maiorMultiplicador;
	}

	public void setMaiorMultiplicador(double maiorMultiplicador) {
		this.maiorMultiplicador = maiorMultiplicador;
	}

	public void exibirTabuada() {
		
		if(menorMultiplicador > maiorMultiplicador ) {
			double temp = maiorMultiplicador;
			maiorMultiplicador = menorMultiplicador;
			menorMultiplicador = temp;
		}
		
		while(menorMultiplicador <= maiorMultiplicador) {
			double produto = multiplicando * menorMultiplicador;
			System.out.printf("%s x %s = %s\n", multiplicando, menorMultiplicador, produto);
			menorMultiplicador++;
		}
		
		
	}
	
}
