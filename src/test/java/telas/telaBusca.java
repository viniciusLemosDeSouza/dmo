package telas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class telaBusca {
    WebDriver driver;


    public telaBusca(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//span[@class =\"product-image-wrapper\"]//img[@alt=\"Balboa Persistence Tee\"]")
    protected WebElement produtoCamisaPreta;



    public void clicaProduto(){
        produtoCamisaPreta.click();
    }

}
