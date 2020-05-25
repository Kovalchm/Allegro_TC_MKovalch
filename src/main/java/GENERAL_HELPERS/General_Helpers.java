package GENERAL_HELPERS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class General_Helpers {

    public static boolean isElementPresent(By by, WebDriver driver) throws NoSuchElementException {
        boolean present;
        try {
            driver.findElement(by);
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
        return present;
    }

    public static void popUpWindow(WebDriver driver) {
        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // switch to popup window
        //driver.switchTo().window(parentWindowHandler);
    }

    public static WebDriver BrowserSetUp(WebDriver driver, String nameOfbrowser, boolean headles) {

        if ((nameOfbrowser.equals("Chrome")) && (headles == true)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);

        } else if ((nameOfbrowser.equals("Chrome")) && (headles == false)) {
            driver = new ChromeDriver();

        } else if ((nameOfbrowser.equals("Firefox")) && (headles == true)) {
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("-headless");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);
            driver = new FirefoxDriver(firefoxOptions);

        } else {
            driver = new FirefoxDriver();

        }
        return driver;
    }
}






