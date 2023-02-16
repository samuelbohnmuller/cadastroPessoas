package br.samuel.pessoas.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

	protected WebDriver browser; //protected � liberado para as classes que s�o extendidas por essa classe 

	public PageObject(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		if(browser == null) { //se o construtor no par�metro do construtor vier null, ser� criado nova janela do chrome
			this.browser = new ChromeDriver();
		} else { //reaproveita a janela aberta
			this.browser = browser;
		}
		this.browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) //esperar� 5 segundos se n�o encontrar um elemento
		.pageLoadTimeout(5, TimeUnit.SECONDS); //espera ao carregar a p�gina
	}
	
	public void clicarPelaClasse(String elemento) {
		browser.findElement(By.className(elemento)).click();
	}
	
	public void clicarPeloId(String elemento) {
		browser.findElement(By.id(elemento)).click();
	}
	
	public void submetePeloId(String elemento) {
		browser.findElement(By.id(elemento)).submit();
	}
	
	public void digitaPeloId(String elemento, String elemento2) {
		browser.findElement(By.id(elemento)).sendKeys(elemento2);	
	}
	
	public void fechar() {
		browser.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	// browser.findElement(By.id("panelGroupAcoesDireita")).getAttribute("value"); //pega o texto do elemento
	// Assert.assertTrue(driver.findElement(By.id("elemento")).isSelected()); //se est� selecionado
	
	/* WebElement element driver.findElement(By.id("elemento"));
	 * Select combo = new Select(element); //para selecionar op��es
	 * combo.selectByIndex(3); //selecionar� o 4 elemento(come�a com 0) // ou ByValue, selecionando pelo value do elemento no HTML
	 * Assert.assertEquals("nome do elemento", combo.getFirstSelectedOption().getText()); pega o valor do primeiro texto selecionado desse elemento e ve se � igual
	 * 
	 * 
	 * List<WebElement> options = combo.getOptions();
	 * Assert.assertEquals(8, options.size()); //se a quantidade do elemento � essa
	 * 
	 * boolean encontrou = false
	 * for(WebElement option: options){ //se encontra o elemento pelo texto nas op��es
	 * 		if(option.getText().equals("mestrado")){
	 * 		encontrou = true;
	 * 		break;
	 *  	}
	 *  }
	 *  Assert.assertTrue(encontrou);
	 *  
	 *  WebElement botao = driver.findElement(By.id("botao"));
	 *  botao.click();
	 *  Assert.assertEquals("obrigado", botao.getAtribute("value")); //se � igual o valor do botao(que no caso foi mudado ao ser clicado)
	 * 
	 *  By.linkText("voltar").click(); clicar em link
	 */
	
}
