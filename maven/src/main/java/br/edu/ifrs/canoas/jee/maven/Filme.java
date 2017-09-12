package br.edu.ifrs.canoas.jee.maven;

public class Filme extends Acervo implements Alugavel {

	private String diretor;
	private String estilo;
	
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public void getTitulo(String getTitulo) {
		
	}
	@Override
	public int getTempoEmprestimos() {
		
		return 0;
	}
	
	
}
