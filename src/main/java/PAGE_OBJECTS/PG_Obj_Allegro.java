package PAGE_OBJECTS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PG_Obj_Allegro {
    @FindBy(xpath = "//input[@placeholder='czego szukasz?']")
    public static WebElement searchline;
    @FindBy(xpath = "//button[contains(text(),'szukaj')]")
    public static WebElement searchButton;
    @FindBy(xpath = "//a[@href='/smartfony-i-telefony-komorkowe-apple-48978?string=Iphone%2011&kolor=czarny']/span")
    public static WebElement colorblack;
    @FindBy(xpath = "//div[@data-analytics-interaction-label='sortTypeList']/select")
    public static WebElement sortingFrame;
}
