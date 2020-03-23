import org.junit.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TC {
    public WebDriver driver;
    private String baseUrl;
    List<WebElement> phoneList;
    List<WebElement> allPhonePrice;
    List<Integer> numericprice = new ArrayList<>();

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        baseUrl = "https://allegro.pl/";
        PageFactory.initElements(driver,PG_Obj_Allegro.class);
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void execute(){
        stepOne();
        stepTwo();
        stepThree();
    }

    public void stepOne(){
        System.setProperty("webdriver.firefox.marionette", "./geckodriver.exe");
        System.setProperty("webdriver.gecko.driver.driver", "./geckodriver.exe");

        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();

        if(driver.findElement(By.xpath("/html/body/div[3]/div[8]/div/div[2]/div/button/img\n")).isDisplayed()){
            driver.findElement(By.xpath("/html/body/div[3]/div[8]/div/div[2]/div/button/img\n")).click();
        }

        try {
            assertTrue(PG_Obj_Allegro.searchline.isEnabled());
        }catch (Error error){
            System.out.print("Error !!! Searchline element not detected");
        }
        PG_Obj_Allegro.searchline.sendKeys("Iphone 11");
        PG_Obj_Allegro.searchButton.click();
    }

    public void stepTwo(){
       if (PG_Obj_Allegro.colorblack.isDisplayed()){
           PG_Obj_Allegro.colorblack.click();
       }else {
           System.out.print("Error !!! Color is not displayed on the page ");
       }
         phoneList = driver.findElements(By.xpath("//div[@id='opbox-listing--base']/div/section/section/article"));
        System.out.print("There are "+phoneList.size()+" Iphones on the page. ");
    }

    public void stepThree(){
        //There are two possible methods for that task:
        allPhonePrice = driver.findElements(By.xpath("//div[@id='opbox-listing--base']/div/section[2]/section/article/div/div/div[2]/div[2]/div/div/span"));
        for (WebElement s : allPhonePrice){
            //s.getText().replaceAll("(\\d+)\\,(\\d+)", "$1.$2"); Dont want to work, unfortunately need to parse Int instead double
            String substring = s.getText().substring(0,5);
            String substring1 = substring.replaceAll("\\s+", "");
            numericprice.add(Integer.parseInt(substring1));
        }
        //numericprice.add(Integer.parseInt(arr[count]));
       /* for (int i=0; i < arr.length; i++){
            int x = Integer.parseInt(arr[0]);
            numericprice.add(x);
        }*/
        Collections.sort(numericprice);
        Integer pricewithVAT = numericprice.get(numericprice.size()-1);
        System.out.println("The bigest price with vat is "+pricewithVAT*1.23);

        //Second one is to sort all phones using allegro by price desc and get text element of the most expensive one
      /*  PG_Obj_Allegro.sortingFrame.click();
        driver.findElement(By.xpath("//option[@value='pd']")).click();
       WebElement mostExpensive = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/div/div/div[2]/div[1]/div[3]/div" +
                "/div/div/div[2]/div[1]/div/section[2]/section/article[1]/div/div/div[2]/div[2]/div/div/span"));
        String tmp = mostExpensive.getText();
        double price = Double.parseDouble(tmp) * 1.23;
       System.out.println("Max price with VAT is "+price);*/
    }
}