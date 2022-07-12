package Services;

import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;



public class BrowsersService{
    private WebDriver driver= null;

            public BrowsersService() {
                switch (ReadProperties.browserName().toLowerCase()) {
                    case "chrome":
                        DriverManagerType driverManagerType = DriverManagerType.CHROME;
                        WebDriverManager.getInstance(driverManagerType).setup();

                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setHeadless(ReadProperties.isHeadless());
                        chromeOptions.addArguments("--disable-gpu"); //chromeOptions.addArguments("--window-size=1920,1200");
                        chromeOptions.addArguments("--ignore-certificate-errors");
                        chromeOptions.addArguments("--silent");
                        chromeOptions.addArguments("--start-maximized");

                        driver = new ChromeDriver(chromeOptions);

                        break;
                }
            }

            public WebDriver getDriver() {
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().deleteAllCookies();
                return driver;
            }
        }