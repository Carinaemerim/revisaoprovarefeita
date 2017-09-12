package br.edu.ifrs.canoas.jee.maven;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ControleDeLocacao {

	private Map<Associado, List<Acervo>> emprestimos = new HashMap <Associado, List<Acervo>>();
	
	public Map<Associado,List <Acervo>> getEmprestimos(){
		
		return emprestimos;
	}
	
	public boolean adicionaEmprestimo(Associado associado, Acervo acervo){
		
		return true;	
	}
	
	public boolean devolveEmprestimo (Associado associado, Acervo acervo){
		
		return false;
	}
	
	public int getTotalLocados(){
		int total = 0;
		
		for(Entry <Associado,List <Acervo>> tot : emprestimos.entrySet()){
			//tipo do mapa que sera pega a entrada : nome do mapa entryset
			//tot é o nome de variavel
			
			total += tot.getValue().size();
		}
		return total;
	}

}
