import PAGE_OBJECTS.PG_Obj_Aliexpr;
import SQL_HELPER.DB_Manager;
import org.junit.*;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AliexpressBuy {
    WebDriver driver;
    private String baseUrl;
    private String login = "";
    private String passwd = "";



    @Before
    public void setUp() throws SQLException {
        driver = new FirefoxDriver();
        baseUrl = "https://www.aliexpress.com";

        DB_Manager db_manager = new DB_Manager();
        db_manager.getPostgreData();

        login = rs.getString(2);
        passwd = rs.getString(3);

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
    }

    public void stepOne() throws InterruptedException {
        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();

        if(PG_Obj_Aliexpr.zgodaDane.isEnabled()) PG_Obj_Aliexpr.zgodaDane.click();
        Alert alert = driver.switchTo().alert(); //
        alert.accept(); // Popup window (Handing alert)


        Thread.sleep(2000);
        try{
           PG_Obj_Aliexpr.ubikName.sendKeys(login);
           PG_Obj_Aliexpr.ubikPassw.sendKeys(passwd);
           PG_Obj_Aliexpr.logToUBIK.click();
        }catch (Exception e){
            assertFalse("Logs didn't pass",false);
        }

        Thread.sleep(1000);

        PG_Obj_Aliexpr.diplomaObj.click();
        if(driver.findElement(By.xpath("//div[@id='karty_list_box']")).isEnabled()){
            assertTrue("Diploma is in progress",true);
        }


        try{
            PG_Obj_Aliexpr.postObj.click();

        }catch (Exception e){ }
        driver.navigate().to("https://poczta.wsisiz.edu.pl/src/login.php");
        boolean elemPr = isElementPresent(By.xpath("//input[@id='smsubmit']"),driver);

        for(int i = 1; i < 2; i++){
            if (elemPr == true){
                try {
                    PG_Obj_Aliexpr.postLog.sendKeys(login);
                    PG_Obj_Aliexpr.postPassw.sendKeys(passwd);
                    driver.findElement(By.xpath("//input[@id='smsubmit']")).click();
                    //PG_Obj_UBIK.logInToPost.click();
                } catch (Exception e) {
                    assertFalse("Logs didn't pass in UBIK Post ", false);
                }
            } else driver.navigate().to("https://poczta.wsisiz.edu.pl/src/login.php");
        }

    }

    public void stepTwo() throws InterruptedException {




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
