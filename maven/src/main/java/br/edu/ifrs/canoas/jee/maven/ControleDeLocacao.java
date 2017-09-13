package br.edu.ifrs.canoas.jee.maven;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ControleDeLocacao {

	private Map<Associado, List<Acervo>> emprestimos = new HashMap <Associado, List<Acervo>>();
	
	public Map<Associado,List <Acervo>> getEmprestimos(){
		
		return emprestimos;
	}
	
	public Acervo getObjElement(Associado a1, int i){
		
		return emprestimos.get(a1).get(i);
		//método para verificar os itens dentro da lista
		// a1 é o key list e i é indice dos itens(posição)
	}
	
	public boolean adicionaEmprestimo(Associado associado, Acervo acervo){
		
		if(associado == null || acervo == null){
			throw new NullPointerException("Você passou valores nulos");
		}
		
		else if(acervo.isLocado()){
			
			return false;
		}	
		else if(emprestimos.get(associado) == null){
			List<Acervo> l1 = new ArrayList<Acervo>();
			l1.add(acervo);
			emprestimos.put(associado, l1);
			// se o associado nunca locou nada a gente cria um novo acervo.
		}
		else{
			emprestimos.get(associado).add(acervo);
			//se já existir a lista so pega o associado e adiciona o acervo a ele.
		}
		acervo.setLocado(true);
		return true;	
	}
	
	public boolean devolveEmprestimo (Associado associado, Acervo acervo){
		
		if(associado == null || acervo == null){
			throw new NullPointerException("Você passou valores nulos");
		}
		
		else if(!acervo.isLocado()){
			// se não estiver locado retorna falso pois não tem como devolver o filme.
			return false;
		}	
		else if(!emprestimos.containsKey(associado)){
			// se não econtrar o associado no mapa retorna falso.
			return false;
		}
		else if(!emprestimos.get(associado).contains(acervo)){
			// se o acervo não estiver na lista, não tem como devolver
			return false;
		}
		
		else{
			
			acervo.setLocado(false);
			emprestimos.get(associado).remove(acervo);
			//remove o item da lista do associado.
		}
			return true;
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
