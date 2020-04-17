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
import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UBIK {
    WebDriver driver;
    private String baseUrl;
    private String login = "";
    private String passwd = "";



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


        try{
            PG_Obj_UBIK.postObj.click();

        }catch (Exception e){ }
        driver.navigate().to("https://poczta.wsisiz.edu.pl/src/login.php");
        boolean elemPr = isElementPresent(By.xpath("//input[@id='smsubmit']"),driver);

        for(int i = 1; i < 2; i++){
            if (elemPr == true){
                try {
                    PG_Obj_UBIK.postLog.sendKeys(login);
                    PG_Obj_UBIK.postPassw.sendKeys(passwd);
                    driver.findElement(By.xpath("//input[@id='smsubmit']")).click();
                    //PG_Obj_UBIK.logInToPost.click();
                } catch (Exception e) {
                    assertFalse("Logs didn't pass in UBIK Post ", false);
                }
            } else driver.navigate().to("https://poczta.wsisiz.edu.pl/src/login.php");
        }

    }

    public void stepTwo() throws InterruptedException {


        String msg = "Тестовое сообщение лягушке :P";

        Thread.sleep(2000);
        PG_Obj_UBIK.newMsg.click();
        PG_Obj_UBIK.postTo.sendKeys("kmmmmk770@gmail.com");
        PG_Obj_UBIK.subjectLetter.sendKeys("Test msg");
        PG_Obj_UBIK.letterBox.sendKeys(msg);
        PG_Obj_UBIK.sendLetter.click();
        PG_Obj_UBIK.sigNOut.click();

    }

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

}
