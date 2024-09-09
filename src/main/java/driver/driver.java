package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public final class driver {
    protected static String driverPath;
    private static WebDriver driver;


    public static WebDriver getDriver() {
        driverPath = "src/test/browser/chromedriver.exe";

        if (driver == null) {
            ChromeOptions cOptions = new ChromeOptions();
            cOptions.addArguments("--remote-allow-origins=*");
            cOptions.addArguments("enable-automation");
            cOptions.addArguments("start-maximized");
            System.setProperty("webdriver.chrome.driver", driverPath);
           driver = new ChromeDriver(cOptions);
        }
        return driver;
    }
    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}