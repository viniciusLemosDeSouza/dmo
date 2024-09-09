package telas;

import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class telaPagamento {
    WebDriver driver;
    private WebDriverWait wait;

    public telaPagamento(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//button[@title='Place Order' and .//span[text()='Place Order']]")
    private WebElement botaoFinaliza;

    @FindBy(xpath = "//span[@class=\"base\" and text()= \"Thank you for your purchase!\"]")
            private WebElement compraFinalizada;
    String msgFinalizada = "Thank you for your purchase!";


    public void confirmaPagamento() {
        try {
            WebElement elemento = waitUntilElementIsClickable(botaoFinaliza);
            elemento.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Elemento click interceptado. Tentando com JavaScript...");
            clickUsingJavaScript(botaoFinaliza);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public void validaCompraFinalizada(){
    boolean finaliza = false;

    waitUntilElementIsVisible(compraFinalizada);

    if(compraFinalizada.getText().equalsIgnoreCase(msgFinalizada)){
        finaliza = true;
        System.out.println("Compra finalizada com sucesso");
    }

    Assert.assertTrue(finaliza);
}

    private WebElement waitUntilElementIsClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    private WebElement waitUntilElementIsVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void clickUsingJavaScript(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
