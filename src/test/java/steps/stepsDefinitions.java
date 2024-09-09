package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metodos_Genericos.MetodosGenericos;
import org.openqa.selenium.WebDriver;
import telas.*;
import io.cucumber.java.en.Given;

import java.io.IOException;

import static driver.driver.getDriver;
import static driver.driver.quitDriver;

public class stepsDefinitions {
    WebDriver driver;
    private telaInicial ti;
    private MetodosGenericos mG;
    private telaBusca tb;
    private telaProduto tp;
    private dadosEntrega de;
    private telaPagamento pg;

    public stepsDefinitions() throws IOException {
        driver = getDriver();
        mG= new MetodosGenericos(driver);
        ti = new telaInicial(driver);
        tb = new telaBusca(driver);
        tp = new telaProduto(driver);
        de = new dadosEntrega(driver);
        pg = new telaPagamento(driver);
    }

    @Given("Usuario acessa aplicacao")
    public void usuarioAcessaAplicacao() throws InterruptedException {
        mG.abreAplicacao();
        mG.validaTelaInicial();
    }

    @When("Usuario realiza pesquisa")
    public void usuarioRealizaPesquisa()  {
        ti.busca();

    }
    @And("Usuario confirma pesquisa")
    public void usuarioConfirmaPesquisa() throws InterruptedException {
        ti.clicaLupa();
        mG.ValidaTelaBusca();
    }

    @And("Usuario seleciona o produto")
    public void usuarioSelecionaProduto(){
        tb.clicaProduto();
    }

    @And("Usuario seleciona cor e tamanho L")
    public void usuarioSelecionaCorTamanho(){
       ti.fechaPopUp();
        tp.selcTamanho();
        tp.selecCor();
    }
    @And("Usuario adiciona produto ao carrinho")
    public void usuarioAdicionaProdutoCarrinho(){
        tp.adicionaCarrinho();
    }

    @And("Usuario realiza checkout")
    public void usuarioRealizacheckout() throws InterruptedException {
        tp.realizaCheckout();
    }
    @And("Usuario informa dados")
    public void usuarioInformaDados() throws InterruptedException {
        de.informaDadosEntrega();
    }

    @Then("Usuario finaliza pagamento")
    public void usuarioFinalizaPagameto(){
        pg.confirmaPagamento();
        pg.validaCompraFinalizada();
    }



@After
    public void closeBrowser(){
        quitDriver();
}
}
