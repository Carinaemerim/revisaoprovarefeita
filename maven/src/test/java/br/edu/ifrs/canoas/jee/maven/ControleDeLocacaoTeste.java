package br.edu.ifrs.canoas.jee.maven;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ControleDeLocacaoTeste {

	ControleDeLocacao controle;
	// inicializa
	
	@Before
	public void InicializaObjeto(){
		
		controle = new ControleDeLocacao();
		//instancia
	}
	
	@Test
	public void TestaAdicionaEmprestimo(){
	
		Associado associado1;
		associado1 = new Associado();
			
		associado1.setCodigo("444");
		associado1.setNome("Lipe");
		
		Acervo filme1;
		filme1 = new Filme();
		
		filme1.setCodigo("55");
		
		controle.adicionaEmprestimo(associado1, filme1); 
		
		assertThat (filme1.isLocado()).isEqualTo (true);
   }
	
	@Test
	public void TestaExcecao(){
		
		Associado associado1 = null;
		Acervo filme1;
		filme1 = new Filme();
		filme1.setCodigo("555");
		
		try{
			controle.adicionaEmprestimo(associado1, filme1);
			
		} catch(NullPointerException e) {
			
			assertThat (e.getMessage()).isEqualTo("Você passou valores nulos");
		}
		
	}
	
	@Test
	public void TestaAcervoLocado(){
		
		Associado associado1 = new Associado();
		Associado associado2 = new Associado();
		associado1.setCodigo("554");
		associado2.setCodigo("553");
		Acervo filme1;
		filme1 = new Filme();
		filme1.setCodigo("555");
		
		controle.adicionaEmprestimo(associado1, filme1);
		assertThat(controle.adicionaEmprestimo(associado2, filme1)).isFalse();
		
	}
	
	@Test
	public void TestaDoisFilmes(){
		
		Associado associado1 = new Associado();
		associado1.setCodigo("41");
		
		Acervo filme1;
		filme1 = new Filme();
		filme1.setCodigo("555");
		
		Acervo filme2;
		filme2 = new Filme();
		filme2.setCodigo("777");
		
		controle.adicionaEmprestimo(associado1, filme1);
		controle.adicionaEmprestimo(associado1, filme2);	
		
		assertThat(controle.getObjElement(associado1, 0).getCodigo()).isEqualTo("555");
		assertThat(controle.getObjElement(associado1, 1).getCodigo()).isEqualTo("777");
		// pega os dois primeiros itens da lista do associado1 para verificar se os
		//filmes foram setados na mesma lista
	}
	
	@Test
	public void TestaDevolveEmprestimo(){
		
		Associado associado1 = null;
		Acervo filme1;
		filme1 = new Filme();
		filme1.setCodigo("41");
		
		try{
			controle.devolveEmprestimo(associado1, filme1);
			
		}  catch(NullPointerException e) {
			
			assertThat (e.getMessage()).isEqualTo("Você passou valores nulos");
		    } 
		
	    }
		
		@Test
		public void TestaFilme(){
			
			Associado associado1;
			associado1 = new Associado();
			
			Acervo filme1;
			filme1 = new Filme();
			filme1.setCodigo("41");
			Acervo filme2;
			filme2 = new Filme();
			filme2.setCodigo("42");
			
			controle.adicionaEmprestimo(associado1, filme1);
		
			assertThat(controle.devolveEmprestimo(associado1, filme2)).isFalse();
			
		}
		
		@Test
		public void devolveFilmeSemAssociado(){
			
			Associado associado1;
			associado1 = new Associado();
			associado1.setCodigo("444");
			Acervo filme1;
			filme1 = new Filme();
			filme1.setCodigo("41");
			filme1.setLocado(true);
			
			assertThat (controle.devolveEmprestimo(associado1, filme1)).isFalse();
			
		}
		
		@Test
		public void devolveAssociadoErrado(){
			
			Associado associado1;
			associado1 = new Associado();
			associado1.setCodigo("444");
			Acervo filme1;
			filme1 = new Filme();
			filme1.setCodigo("41");
			
			Acervo filme2;
			filme2 = new Filme();
			filme2.setCodigo("42");
			filme2.setLocado(true);
			
			controle.adicionaEmprestimo(associado1, filme1);
			
			assertThat (controle.devolveEmprestimo(associado1, filme2)).isFalse();
		}
		
		@Test
		public void devolucaopadrao(){
			
			Associado associado1;
			associado1 = new Associado();
			associado1.setCodigo("444");
			Acervo filme1;
			filme1 = new Filme();
			filme1.setCodigo("41");
			
			controle.adicionaEmprestimo(associado1, filme1);
			
			assertThat (controle.devolveEmprestimo(associado1, filme1)).isTrue();
			
		}
		
		@Test
		public void testaTotalLocadoMesmaPessoa(){
			//testar quantidade locada para a mesma pessoa
			Associado associado1;
			associado1 = new Associado();
			associado1.setCodigo("444");
			
			Acervo filme1;
			filme1 = new Filme();
			filme1.setCodigo("41");
			
			Acervo filme2;
			filme2 = new Filme();
			filme2.setCodigo("42");
			
			controle.adicionaEmprestimo(associado1, filme1);
			controle.adicionaEmprestimo(associado1, filme2);
			
			assertThat(controle.getTotalLocados()).isEqualTo(2);
			
			controle.devolveEmprestimo(associado1, filme2);
			
			assertThat(controle.getTotalLocados()).isEqualTo(1);
		}
		
		@Test
		public void testaTotalLocadoPessoasDiferentes(){
			//Testar quantidade ao locar para duas pessoas diferentes
			Associado associado1;
			associado1 = new Associado();
			associado1.setCodigo("444");
			
			Associado associado2;
			associado2 = new Associado();
			associado2.setCodigo("445");
			
			Acervo filme1;
			filme1 = new Filme();
			filme1.setCodigo("41");
			
			Acervo filme2;
			filme2 = new Filme();
			filme2.setCodigo("42");
			
			controle.adicionaEmprestimo(associado2, filme2);
			controle.adicionaEmprestimo(associado1, filme1);
			
			assertThat(controle.getTotalLocados()).isEqualTo(2);
			
			controle.devolveEmprestimo(associado2, filme2);
			
			assertThat (controle.getTotalLocados()).isEqualTo(1);
		}
		
		@Test
		public void testaRetornoEmprestimos(){
			
			Associado associado2;
			associado2 = new Associado();
			associado2.setCodigo("445");
			
			Acervo filme1;
			filme1 = new Filme();
			filme1.setCodigo("41");
			
			controle.adicionaEmprestimo(associado2, filme1);
			
		    Map<Associado, List<Acervo>> emprestimosTeste = new HashMap <Associado, List<Acervo>>();
			emprestimosTeste = controle.getEmprestimos();
			
			assertThat(emprestimosTeste.get(associado2).get(0)).isEqualTo(filme1);
			// pega o associado atraves da lista de emprestimos e verifica se o item da lista dele esta com o nome
			//do objeto locado
		}
		
		
	}


