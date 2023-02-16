package br.samuel.pessoas.cadastro.empregados;

import org.openqa.selenium.WebDriver;

import br.samuel.pessoas.pageObject.PageObject;

public class ListagemEmpregadoPage extends PageObject {

	private PageObject pageObject;
	private static final String URL_LISTAGEM_EMPREGADOS = "http://localhost:8080/samuel/empregados/empregados-lista.jsf";

	public ListagemEmpregadoPage(WebDriver browser) {
		super(null);
		this.browser = browser;
	}

	public ModalCadastroEmpregadosPage CadastraEmpregado(String empresa, String pessoaFisica) {
		browser.navigate().to(URL_LISTAGEM_EMPREGADOS);
		pageObject.digitaPeloId("form:autoCompleteEmpresa:autoCompleteEmpresa_input", empresa); // filtra Empresa
		pageObject.submetePeloId("form:autoCompleteEmpresa:autoCompleteEmpresa_input"); // submete a empresa no campo
		pageObject.clicarPeloId("form:j_idt381:j_idt382"); // clica para incluir Empregado
		pageObject.digitaPeloId("formCadastroEmpregado:autoCompletePessoa:j_idt321", pessoaFisica); // seleciona pessoa
																									// f�sica
		pageObject.submetePeloId("formCadastroEmpregado:autoCompletePessoa:j_idt321"); // submete pessoa f�sica ao
																						// Empregado
		pageObject.clicarPeloId("formCadastroEmpregado:admissao_input");
		pageObject.clicarPelaClasse("today"); // clica na data de hoje
		pageObject.clicarPelaClasse("ui-button-text ui-c"); // clica em gravar
		pageObject.clicarPelaClasse("ui-button-text ui-c"); // clica pra continuar pois ele est� presente em outra
															// Empresa

		return new ModalCadastroEmpregadosPage(browser); // devolve a essa instancia, o estado atual do
															// navegador(aberto)
	}
}
