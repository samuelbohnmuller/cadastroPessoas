package br.samuel.pessoas.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import br.samuel.pessoas.cadastro.empregados.ListagemEmpregadoPage;
import br.samuel.pessoas.pageObject.PageObject;

public class LoginPage extends PageObject{ //destinada aos c�digos da API selenium 

	
	private static final String URL_LOGIN = "http://localhost:8080/samuel/login.com";

	public LoginPage() { //ao ser instanciado em outra classe, ter� acesso ao c�digo abaixo
		super(null); //busca o construtor de PageObject, de onde essa classe � extendida e passa () nulo, abrindo a primeira janela do navegador, pois estou come�ando na tela de login
		browser.navigate().to("URL_LOGIN");
	}

	public void preencheFormularioDeLogin(String email, String senha) {
		browser.findElement(By.id("j_username")).sendKeys(email);
		browser.findElement(By.id("j_password")).sendKeys(senha);		
	}
	
	public ListagemEmpregadoPage efetuarLogin() {
		browser.findElement(By.id("login-form")).submit();
		return new ListagemEmpregadoPage(browser); //para retornar o login para outra classe, j� com o navegador aberto
	}

	public boolean seEstaNaPaginaDeLogin() {
		return browser.getCurrentUrl().equals("URL_LOGIN");
	}

	public Object pegarNomeDoUsuarioLogado() {
		return browser.findElement(By.id("panelGroupAcoesDireita")).getText(); //se � igual o texto do id	
	}

	public WebElement verificaNotificacaoPush(String css) {
		return browser.findElement(By.cssSelector(css)); //se n�o cont�m no css da notifica��o push
	}

	public boolean contemTextoNaPagina(String texto) {
		return browser.getPageSource().contains(texto);	//se cont�m o texto na p�gina	
	}
	
	
}
