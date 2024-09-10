package metodos_Genericos;

import constantes.Global;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class MetodosGenericos {
private WebDriver driver;
private Select selectElement;

    public MetodosGenericos(WebDriver d){
        driver = d;

    }

    int cont = 0;

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

    public void screenshot() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String filePath =  "screenshot/screenshot"+cont+".png";
        File destFile = new File(filePath);
        Files.copy(scrFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        cont++;
    }





}
