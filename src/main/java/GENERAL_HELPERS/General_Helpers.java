package GENERAL_HELPERS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class General_Helpers {

    public static boolean isElementPresent(By by, WebDriver driver) throws NoSuchElementException
    {
        boolean present;
        try
        {
            driver.findElement(by);
            present = true;
        }catch (NoSuchElementException e)
        {
            present = false;
        }
        return present;
    }

    public static void popUpWindow(WebDriver driver){
        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // switch to popup window
        //driver.switchTo().window(parentWindowHandler);
    }

}

