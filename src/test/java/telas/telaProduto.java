package telas;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class telaProduto {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "option-label-size-143-item-169")
    private WebElement escolheTamanho;

    @FindBy(id = "option-label-color-93-item-52")
    private WebElement escolheCor;

    @FindBy(id = "product-addtocart-button")
    private WebElement carrinho;

    @FindBy(xpath = "//span[@class=\"counter qty\"]//span[@class=\"counter-number\"]")
    private WebElement validaProdutoCarrinho;

    @FindBy(id = "top-cart-btn-checkout")
    private WebElement checkout;

    public telaProduto(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selcTamanho() {
        escolheTamanho.click();
    }

    public void selecCor() {
        escolheCor.click();
    }

    public void adicionaCarrinho() {
        carrinho.click();
    }

    public void produtoCarrinho() {
        waitUntilElementIsVisible(validaProdutoCarrinho);
        int val = Integer.parseInt(validaProdutoCarrinho.getText());
        boolean pc = (val >= 1);

        if (pc) {
            System.out.println("Produtos adicionados no carrinho");
        }
        Assert.assertTrue(pc);
    }

    public void realizaCheckout() throws InterruptedException {
        produtoCarrinho();
        validaProdutoCarrinho.click();
        Thread.sleep(2000);
        checkout.click();
    }

    private WebElement waitUntilElementIsVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
