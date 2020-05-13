
import PAGE_OBJECTS.PG_Obj_Aliexpr;
import SQL_HELPER.DB_Manager;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import java.sql.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AliexpressBuy {
    WebDriver driver;
    private String baseUrl;
    private List <String> dataSet;

    @Before
    public void setUp() throws SQLException {
        driver = new FirefoxDriver();
        baseUrl = "https://www.aliexpress.com";

        DB_Manager db_manager = new DB_Manager();
        dataSet = db_manager.getClient_params();

        PageFactory.initElements(driver, PG_Obj_Aliexpr.class);
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void execute() throws InterruptedException {
        stepOne();
        //stepTwo();
        //stepThree();
    }

    public void stepOne() throws InterruptedException {
        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if(PG_Obj_Aliexpr.spamWindow.isEnabled()) PG_Obj_Aliexpr.spamWindow.click();
        else Thread.sleep(2000);

        try{
           PG_Obj_Aliexpr.mojProfil.click();

           WebDriverWait wait = new WebDriverWait(driver,10);
           wait.until(ExpectedConditions.elementToBeClickable(PG_Obj_Aliexpr.logINAli));
           PG_Obj_Aliexpr.logINAli.click();

           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            if(driver.findElement(By.xpath("//div[@id='batman-tabbed']/ul/li")).isEnabled()){
                driver.findElement(By.xpath("//div[@id='batman-tabbed']/ul/li[2]")).click();
            }
            WebElement tmp = driver.findElement(By.xpath("//div[@id='batman-tabbed']/ul/li[2]"));

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            Actions action = new Actions(driver);
            action.moveToElement(tmp).doubleClick().moveByOffset(-180,60).doubleClick().sendKeys(dataSet.get(0)).perform();
            action.moveToElement(tmp).moveByOffset(-180,120).doubleClick().sendKeys(dataSet.get(1)).perform();
            action.moveToElement(tmp).moveByOffset(-180,220).doubleClick().perform();

        }catch (Exception e){
            assertFalse("Logs didn't pass",false);
        }

        Thread.sleep(1000);
    }

    public void stepTwo() throws InterruptedException {

    }

    public void stepThree() throws InterruptedException {

    }

}
