import org.junit.*;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UBIK {
    WebDriver driver;
    private String baseUrl;
    private String login = "kovalchm";
    private String passwd = "-Al-mako12";



    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        baseUrl = "https://ubi2.wit.edu.pl/?table=1";
        PageFactory.initElements(driver,PG_Obj_UBIK.class);
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void execute() throws InterruptedException {
        stepOne();
        stepTwo();
    }

    public void stepOne() throws InterruptedException {
        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();

        if(PG_Obj_UBIK.zgodaDane.isEnabled())PG_Obj_UBIK.zgodaDane.click();
        Alert alert = driver.switchTo().alert(); //
        alert.accept(); // Popup window (Handing alert)


        Thread.sleep(2000);
        try{
           PG_Obj_UBIK.ubikName.sendKeys(login);
           PG_Obj_UBIK.ubikPassw.sendKeys(passwd);
           PG_Obj_UBIK.logToUBIK.click();
        }catch (Exception e){
            assertFalse("Logs didn't pass",false);
        }

        Thread.sleep(1000);

        PG_Obj_UBIK.diplomaObj.click();
        if(driver.findElement(By.xpath("//div[@id='karty_list_box']")).isEnabled()){
            assertTrue("Diploma is in progress",true);
        }

        PG_Obj_UBIK.postObj.click();
        Thread.sleep(2000);

        if(driver.findElement(By.xpath("//*[contains(text(),'Logowanie do Wyższa Szkoła Informatyki Stosowanej i Zarządzania')]")).isDisplayed()){
            assertTrue("Loged in UBIK post",true);
        }
    }

    public void stepTwo() throws InterruptedException {
        String msg = "Тестовое сообщение лягушке :P";
        try{
            PG_Obj_UBIK.postLog.sendKeys(login);
            PG_Obj_UBIK.postPassw.sendKeys(passwd);
            PG_Obj_UBIK.logInToPost.click();
        }catch (Exception e){
            assertFalse("Logs didn't pass in UBIK Post ",false);
        }

        Thread.sleep(2000);
        PG_Obj_UBIK.newMsg.click();
        PG_Obj_UBIK.postTo.sendKeys("kmmmmk770@gmail.com");
        PG_Obj_UBIK.subjectLetter.sendKeys("Test msg");
        PG_Obj_UBIK.letterBox.sendKeys(msg);
        PG_Obj_UBIK.sendLetter.click();
        PG_Obj_UBIK.sigNOut.click();

    }



}
