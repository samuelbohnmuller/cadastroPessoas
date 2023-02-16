package br.samuel.pessoas.cadastro.empregados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import br.samuel.pessoas.login.LoginPage;
import br.samuel.pessoas.pageObject.PageObject;

public class CadastroTest extends LoginPage{

	private static final String URL_LISTAGEM_EMPREGADOS = "http://localhost:8080/samuel/empregados/empregados-lista.jsf";
	private ListagemEmpregadoPage cadastroPage;
	private ModalCadastroEmpregadosPage modalCadastroEmpregados;
	private LoginPage loginPage;
	private PageObject pageObject;

	@BeforeEach
	private void beforeEach() {
		LoginPage login = new LoginPage();
		login.preencheFormularioDeLogin("testsadsasds@teste.com", "sadsaasds");
		cadastroPage = login.efetuarLogin(); //passar login para cadastroPage com browser aberto e logado
	}

	@Test
	public void cadastrarEmpregado() {
		String nomeEmpregado = "SsadsasdO";
		String empresa = "CARMELITO E BETO";
		String admissao = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		ModalCadastroEmpregadosPage modalCadastroEmpregados = cadastroPage.CadastraEmpregado(empresa, nomeEmpregado); //navega pra p�gina de formul�rio e passa para objeto
	
		Assert.assertTrue(modalCadastroEmpregados.seEmpregadoApareceNaListagem(nomeEmpregado, admissao));
	}
	
	@Test
	public void validarCadastroDeEmpregados() {
		browser.get(URL_LISTAGEM_EMPREGADOS);
		modalCadastroEmpregados = cadastroPage.CadastraEmpregado("", ""); //enviar string vazia e n�o null
		
		pageObject.clicarPelaClasse("ui-button-text ui-c"); 
		Assert.assertNotEquals("n�o cont�m", loginPage.verificaNotificacaoPush("p:nth-child(2)"));
		Assert.assertTrue(loginPage.contemTextoNaPagina("Selecione a Pessoa F�sica!"));
		}
	
}
