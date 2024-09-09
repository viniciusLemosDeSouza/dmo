package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class telaInicial {
    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class=\"control\"]//input[@id=\"search\"]")
    protected WebElement barraBuscar;

    @FindBy(xpath = "//div[@class=\"actions\"]//button[@type=\"submit\"]")
    protected WebElement lupaBuscar;

    @FindBy(xpath = "//div[@class=\"ea-stickybox-hide\"]")
    protected WebElement popUp;

    public telaInicial(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

public void busca(){
   barraBuscar.sendKeys("Shirt");
}
public void clicaLupa(){
        lupaBuscar.click();
}
    public void fechaPopUp() {
        try {
            // Espera até que o popup seja visível ou até que o tempo de espera expire
            WebElement popupElement = waitUntilElementIsVisible(popUp);
            if (popupElement != null && popupElement.isDisplayed()) {
                popupElement.click();
                System.out.println("Popup clicado com sucesso.");
            } else {
                System.out.println("Popup não está disponível para clique.");
            }
        } catch (Exception e) {
            // Captura qualquer exceção que ocorra e imprime o stack trace
            System.err.println("Ocorreu um erro ao tentar clicar no popup.");
            e.printStackTrace();
        }
    }

    private WebElement waitUntilElementIsVisible(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            // Se o elemento não estiver visível após o tempo de espera, retorna null
            return null;
        }
    }

}

