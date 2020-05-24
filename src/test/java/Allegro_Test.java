import PAGE_OBJECTS.PG_Obj_Allegro;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;


public class Allegro_Test {
    public WebDriver driver;
    private String baseUrl;
    List<WebElement> phoneList;
    List<WebElement> allPhonePrice;
    List<Float> numericprice = new ArrayList<>();

    @Before
    public void setUp(){
        //System.setProperty("webdriver.firefox.marionette", "./geckodriver.exe");

        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("-headless");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);

        driver = new FirefoxDriver(firefoxOptions);
        baseUrl = "https://allegro.pl/";
        PageFactory.initElements(driver, PG_Obj_Allegro.class);

    }

    @After
    public void teardown(){
        driver.close();
        //driver.quit();
    }

    @Test
    public void execute() throws InterruptedException {
        stepOne();
        stepTwo();
        stepThree();
    }

    public void stepOne() throws InterruptedException {

        driver.get(baseUrl);//navigate().to(baseUrl);
        driver.manage().window().maximize();
        try {
            if(driver.findElement(By.xpath("//button[contains(text(),'przejdź dalej')]")).isDisplayed()){
                driver.findElement(By.xpath("//button[contains(text(),'przejdź dalej')]")).click();
            }
        }catch (NoSuchElementException ex){

        }


        try {
            assertTrue(PG_Obj_Allegro.searchline.isEnabled());
        }catch (Error error){
            System.out.print("Error !!! Searchline element not detected");
        }

        PG_Obj_Allegro.searchline.sendKeys("Iphone 11");
        PG_Obj_Allegro.searchButton.click();
        Thread.sleep(2000);
        if(PG_Obj_Allegro.searchInPopUpWindow.isDisplayed() == true){
            PG_Obj_Allegro.searchInPopUpWindow.click();
        }

    }

    public void stepTwo() throws InterruptedException {
        Thread.sleep(10000);
        try{
            if (PG_Obj_Allegro.colorblack.isDisplayed()){
                PG_Obj_Allegro.colorblack.click();
            }
                 }catch (ElementNotVisibleException e){
                     System.out.print("Error !!! Color is not displayed on the page ");
                 }
                     phoneList = driver.findElements(By.xpath("//div[@id='opbox-listing--base']/div/section/section/article"));
                         System.out.print("There are "+phoneList.size()+" Iphones on the page. ");

    }

    public void stepThree(){
        //There are two possible methods for that task:
        allPhonePrice = driver.findElements(By.xpath("//div[@id='opbox-listing--base']/div/section[2]/section/article/div/div/div[2]/div[2]/div/div/span"));
        for (WebElement s : allPhonePrice){
            String substring = s.getText().replaceAll("(\\d+)\\,(\\d+)", "$1.$2").replaceAll("[^0-9?!\\.]",""); //s.getText().replaceAll("(\\d+)\\,(\\d+)", "$1.$2");
            numericprice.add(Float.parseFloat(substring));
        }

        Collections.sort(numericprice);
        Float pricewithVAT = numericprice.get(numericprice.size()-1);
        System.out.println("The bigest price with VAT is "+ Math.round(pricewithVAT*1.23));

    }
}
