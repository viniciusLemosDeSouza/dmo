package telas;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import metodos_Genericos.geradorUsuario;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class dadosEntrega {
    // Variáveis para armazenar os dados do usuário
    private String gFirstName;
    private String gLastName;
    private String gEmail;
    private String gStreetAddress;
    private String gCity;
    private String gState;
    private String gPostalCode;
    private String gCountry;
    private String gPhone;

    // Elementos da página
    @FindBy(xpath = "//div[@class=\"control _with-tooltip\"] //input[@type=\"email\"]")
    private WebElement email;

    @FindBy(xpath = "//div[@class=\"control\"]//input[@name=\"firstname\"]")
    private WebElement firstName;

    @FindBy(xpath = "//div[@class=\"control\"]//input[@name=\"lastname\"]")
    private WebElement lastName;

    @FindBy(xpath = "//div[@class=\"control\"]//input[@name=\"street[0]\"]")
    private WebElement streetAddress;

    @FindBy(xpath = "//div[@class=\"control\"]//input[@name=\"city\"]")
    private WebElement city;

    @FindBy(xpath = "//div[@class=\"control\"]//select[@name=\"region_id\"]")
    private WebElement estado;

    @FindBy(xpath = "//div[@class=\"control\"]//input[@name=\"postcode\"]")
    private WebElement postalCode;

    @FindBy(xpath = "//div[@class=\"control\"]//select[@name=\"country_id\"]")
    private WebElement pais;

    @FindBy(xpath = "//div[@id='checkout-shipping-method-load']//table[@class='table-checkout-shipping-method']/tbody//tr[td/span/span[text()='$5.00']]")
    private WebElement shipping;

    @FindBy(xpath = "//div[@class=\"control _with-tooltip\"]//input[@name=\"telephone\"]")
    private WebElement phone;

    @FindBy(xpath = "//div[@class=\"primary\"]//button[@class=\"button action continue primary\"]")
    private WebElement buttonNext;



    private WebDriver driver;
    private WebDriverWait wait;

    public dadosEntrega(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        initializeUserData();
    }

    private void initializeUserData() throws IOException {
        try {
            // Obtém o JsonObject contendo a resposta
            JsonObject userData = geradorUsuario.fetchRandomUser();

            // Acessa o array "results" do JsonObject
            JsonElement resultsElement = userData.get("results");

            // Verifica se o "results" é um array
            if (resultsElement.isJsonArray()) {
                JsonArray resultsArray = resultsElement.getAsJsonArray();

                // Verifica se o array "results" contém pelo menos um item
                if (resultsArray.size() > 0) {
                    JsonObject user = resultsArray.get(0).getAsJsonObject();

                    // Acessa os sub-objetos "name" e "location"
                    JsonObject name = user.getAsJsonObject("name");
                    JsonObject location = user.getAsJsonObject("location");

                    // Obtém os valores dos campos do JSON
                    gFirstName = name.get("first").getAsString();
                    gLastName = name.get("last").getAsString();
                    gEmail = user.get("email").getAsString();

                    // Atualize para lidar com "street" como um objeto
                    JsonObject street = location.getAsJsonObject("street");
                    String streetNumber = street.get("number").getAsString();
                    String streetName = street.get("name").getAsString();
                    gStreetAddress = streetNumber + " " + streetName;

                    gCity = location.get("city").getAsString();
                    gState = location.get("state").getAsString();
                    gPostalCode = location.get("postcode").getAsString();
                    gCountry = location.get("country").getAsString();
                    gPhone = user.get("phone").getAsString();
                } else {
                    throw new IllegalStateException("O array 'results' está vazio.");
                }
            } else {
                throw new IllegalStateException("'results' não é um array JSON.");
            }
        } catch (ClassCastException | NullPointerException | IllegalStateException e) {
            // Trata exceções
            e.printStackTrace();
        }
    }

    public void informaDadosEntrega() {
        try {
            waitUntilElementIsVisible(email).sendKeys(gEmail);
            waitUntilElementIsVisible(firstName).sendKeys(gFirstName);
            waitUntilElementIsVisible(lastName).sendKeys(gLastName);
            waitUntilElementIsVisible(streetAddress).sendKeys(gStreetAddress);
            waitUntilElementIsVisible(city).sendKeys(gCity);
            selecionarEstado(gState);
            waitUntilElementIsVisible(postalCode).sendKeys(gPostalCode);
            selecionarPais(gCountry);
            waitUntilElementIsVisible(phone).sendKeys(gPhone);
            waitUntilElementIsVisible(shipping).click();
            waitUntilElementIsVisible(buttonNext).click();
        } catch (StaleElementReferenceException e) {

            System.out.println("Elemento stale encontrado. Re-tentando...");
            informaDadosEntrega();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selecionarEstado(String estadoSelecionado) {
        WebElement estadoElement = waitUntilElementIsVisible(estado);
        Select select = new Select(estadoElement);
        select.selectByVisibleText(estadoSelecionado);
    }

    private void selecionarPais(String paisSelecionado) {
        WebElement paisElement = waitUntilElementIsVisible(pais);
        Select select = new Select(paisElement);
        select.selectByVisibleText(paisSelecionado);
    }

    private WebElement waitUntilElementIsVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


}
