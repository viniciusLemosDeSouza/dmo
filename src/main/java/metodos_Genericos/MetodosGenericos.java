package metodos_Genericos;

import constantes.Global;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class MetodosGenericos {
private WebDriver driver;
private Select selectElement;

    public MetodosGenericos(WebDriver d){
        driver = d;

    }


    public void abreAplicacao(){
        driver.get(Global.APP.getS());
    }
    public void validaTelaInicial() throws InterruptedException {
        Boolean ok = false;
        Thread.sleep(2000);
        if(driver.getTitle().equals("Home Page")){
            ok = true;
            System.out.println("Tela inicial carregada com sucesso");
        }else{
            System.out.println("Tela inicial não carregada corretamente");
        }
    Assert.assertTrue(ok);

    }

    public void ValidaTelaBusca() throws InterruptedException {
        Thread.sleep(3000);
        Boolean tb = false;
        if(driver.getTitle().equals("Search results for: 'Shirt'")){
        tb = true;
        System.out.println("Tela de busca carregada com sucesso");
        }else{
            System.out.println("Tela de busca não carregada corretamente");
        }
        Assert.assertTrue(tb);
    }





}
