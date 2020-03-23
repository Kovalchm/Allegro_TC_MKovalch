import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

public class PG_Obj_Allegro {
    @FindBy(xpath = "//input[@placeholder='czego szukasz?']")
    static WebElement searchline;
    @FindBy(xpath = "//button[contains(text(),'szukaj')]")
    static WebElement searchButton;
    @FindBy(xpath = "//a[@href='/smartfony-i-telefony-komorkowe-apple-48978?string=Iphone%2011&kolor=czarny']")
    static WebElement colorblack;
    @FindBy(xpath = "//div[@data-analytics-interaction-label='sortTypeList']/select")
    static WebElement sortingFrame;

}
