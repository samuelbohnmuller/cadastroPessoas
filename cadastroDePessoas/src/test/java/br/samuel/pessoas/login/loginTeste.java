package br.samuel.pessoas.login;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.samuel.pessoas.cadastro.empregados.ModalCadastroEmpregadosPage;

public class loginTeste { //destinada a teste de login
	
	private LoginPage login;
	
	@BeforeEach
	public void BeforeEach() { //antes de tudo inicializar� loginPage
		login = new LoginPage();
	}
	
	@AfterEach
	public void AfterEach() {
		login.fechar();
	}
	
	@Test
	public void efetuarLoginComDadosValidos() {
		login.preencheFormularioDeLogin("dsfsf3@teste.br", "dsfsd");
		login.efetuarLogin();
		
		Assert.assertFalse(login.seEstaNaPaginaDeLogin()); 
		Assert.assertEquals("Testedsf", login.pegarNomeDoUsuarioLogado());
	}
	
	@Test
	public void naoDeveLogarComDadosInvalidos() {
		login.preencheFormularioDeLogin("invalido", "123456");
		login.efetuarLogin();
		
		Assert.assertTrue(login.seEstaNaPaginaDeLogin());  //verdadeiro estar nessa URL
		Assert.assertNotEquals("exemplo", login.verificaNotificacaoPush(".toast-message"));
		Assert.assertTrue(login.contemTextoNaPagina("senha inv�lido")); 
	}
	
}
