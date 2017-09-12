package br.edu.ifrs.canoas.jee.maven;

public class Jogo extends Acervo implements Alugavel{

	private String plataforma;

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public void getTitulo(String getTitulo) {
		
	}

	@Override
	public int getTempoEmprestimos() {
		
		return 0;
	}
	
	
}
