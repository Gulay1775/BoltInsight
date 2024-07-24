package utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    // Thread-safe driver pool
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    // Get WebDriver instance based on the browser specified in the configuration
    public static WebDriver getDriver() {

        // If driver is not initialized, create a new one based on the specified browser
        if (driverPool.get() == null) {

            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    break;
                case "edge":
                    driverPool.set(new EdgeDriver());
                    break;
                case "safari":
                    driverPool.set(new SafariDriver());
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    // If no browser specified or invalid, default to Chrome
                    driverPool.set(new ChromeDriver());
            }
            // Maximize window and set implicit wait time
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driverPool.get();
    }

    // Private constructor to prevent instantiation of Driver class
    private Driver() {

    }

    // Close WebDriver instance
    public static void closeDriver() {
        // If driver instance exists, quit and remove it from the pool
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }

    }



    }
