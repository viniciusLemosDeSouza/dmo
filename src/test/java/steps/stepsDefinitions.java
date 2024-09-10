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
    public void usuarioAcessaAplicacao() throws InterruptedException, IOException {
        mG.abreAplicacao();
        mG.validaTelaInicial();
        mG.screenshot();
    }

    @When("Usuario realiza pesquisa")
    public void usuarioRealizaPesquisa() throws IOException {
        ti.busca();
        mG.screenshot();
    }

    @And("Usuario confirma pesquisa")
    public void usuarioConfirmaPesquisa() throws InterruptedException, IOException {
        ti.clicaLupa();
        mG.ValidaTelaBusca();
        mG.screenshot();
    }

    @And("Usuario seleciona o produto")
    public void usuarioSelecionaProduto() throws IOException {
        tb.clicaProduto();
        mG.screenshot();
    }

    @And("Usuario seleciona cor e tamanho L")
    public void usuarioSelecionaCorTamanho() throws IOException {
       ti.fechaPopUp();
        tp.selcTamanho();
        tp.selecCor();
        mG.screenshot();
    }
    @And("Usuario adiciona produto ao carrinho")
    public void usuarioAdicionaProdutoCarrinho() throws IOException {
        tp.adicionaCarrinho();
        mG.screenshot();
    }

    @And("Usuario realiza checkout")
    public void usuarioRealizacheckout() throws InterruptedException, IOException {
        tp.realizaCheckout();
        mG.screenshot();
    }
    @And("Usuario informa dados")
    public void usuarioInformaDados() throws InterruptedException, IOException {
        de.informaDadosEntrega();
        mG.screenshot();
    }

    @Then("Usuario finaliza pagamento")
    public void usuarioFinalizaPagameto() throws IOException {
        pg.confirmaPagamento();
        pg.validaCompraFinalizada();
        mG.screenshot();
    }


@After
    public void closeBrowser(){
        quitDriver();
}
}
