import PAGE_OBJECTS.PG_Obj_WIT;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WIT_Test {
    public WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp(){
        //System.setProperty("webdriver.firefox.marionette", "./geckodriver.exe");
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("-headless");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);

        driver = new FirefoxDriver(firefoxOptions);
        baseUrl = "https://www.wit.edu.pl/";
        PageFactory.initElements(driver, PG_Obj_WIT.class);


        /*FirefoxProfile profile = new FirefoxProfile();
        //Set Location to store files after downloading.
        profile.setPreference("browser.download.dir", "/home/misha/Downloads\n");
        profile.setPreference("browser.download.folderList", 2);

        //Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;");

        profile.setPreference( "browser.download.manager.showWhenStarting", false );
        profile.setPreference( "pdfjs.disabled", false );

        //Pass FProfile parameter In webdriver to use preferences to download file.
        */
    }

    @After
    public void teardown(){
        driver.close();
        //driver.quit();
    }

    @Test
    public void execute(){
        stepOne();
    }

    public void stepOne(){

        driver.get(baseUrl);//navigate().to(baseUrl);
        waitForPageLoaded();

        if (PG_Obj_WIT.rodoOk.isDisplayed()){
         PG_Obj_WIT.rodoOk.click();
        }

        try {
            assertTrue(PG_Obj_WIT.studiaDropdown.isEnabled());
        }catch (Error error){
            System.out.print("Error !!! Searchline element not detected");
        }

        Actions builder = new Actions(driver);
        Action studyChoose = builder.moveToElement(PG_Obj_WIT.studiaDropdown).clickAndHold(PG_Obj_WIT.studiaDropdown).build();
        studyChoose.perform();
        PG_Obj_WIT.informaticsDirection.click();

        if(driver.findElement(By.xpath("//a[@href=\"/studia-inzynierskie/informatyka/bazy-danych\"]/span"))!=null &&
                driver.findElement(By.xpath("//a[@href=\"/studia-inzynierskie/informatyka/inzynieria-oprogramowania\"]/span"))!= null &&
                    driver.findElement(By.xpath("//a[@href=\"/studia-inzynierskie/informatyka/technologia-chmury-obliczeniowej\"]/span"))!=null){
            PG_Obj_WIT.bdSpeciality.click();
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        if(driver.findElement(By.xpath("//h1[text() = 'Bazy danych']"))!=null) js.executeScript("window.history.go(-1)");

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfAllElements(PG_Obj_WIT.engSpeciality));
        PG_Obj_WIT.engSpeciality.click();
        if(driver.findElement(By.xpath("//h1[text() = 'Inżynieria oprogramowania']"))!=null) js.executeScript("window.history.go(-1)");

        WebDriverWait wait1 = new WebDriverWait(driver,5);
        wait1.until(ExpectedConditions.visibilityOfAllElements(PG_Obj_WIT.cloudSpeciality));
        PG_Obj_WIT.cloudSpeciality.click();
        if(driver.findElement(By.xpath("//h1[text() = 'Technologia chmury obliczeniowej']"))!=null) js.executeScript("window.history.go(-1)");

        WebDriverWait wait2 = new WebDriverWait(driver,5);
        wait2.until(ExpectedConditions.visibilityOfAllElements(PG_Obj_WIT.getdailyProgram));
        if (PG_Obj_WIT.getdailyProgram.isDisplayed() && PG_Obj_WIT.getdailyProgram.isEnabled()) PG_Obj_WIT.getdailyProgram.click();

        driver.switchTo().defaultContent();
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
