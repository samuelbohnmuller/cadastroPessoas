package br.samuel.pessoas.cadastro.empregados;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.samuel.pessoas.pageObject.PageObject;

public class ModalCadastroEmpregadosPage extends PageObject{
	
	public ModalCadastroEmpregadosPage(WebDriver browser) {
		super(browser); //recebe o estado atual que o navegador est� 
	}
	
	public boolean seEmpregadoApareceNaListagem(String nome, String admissao) {
		WebElement linhaDaTabela = browser.findElement(By.cssSelector(".ui-state-hover > .campo115")); //pega o �ltimo elemento na tabela(indo dentro da tag, tabela > tr > �ltimo elemento)
		WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:ntd-child(1)")); //pega a primeira linha horizontal da tabela(nome)
		WebElement colunaAdmissao = linhaDaTabela.findElement(By.cssSelector("td:ntd-child(4)"));
		
		return colunaNome.getText().equals(nome) && colunaAdmissao.getText().equals(admissao); //retorna os textos dos elementos
	}

}
