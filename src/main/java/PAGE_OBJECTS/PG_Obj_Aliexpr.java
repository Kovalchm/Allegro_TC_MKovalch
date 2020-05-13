package PAGE_OBJECTS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PG_Obj_Aliexpr {
    @FindBy(xpath = "//a[@class='close-layer']")
    public static WebElement spamWindow;

    @FindBy(xpath = "//div[@id='nav-user-account']/span/a/span")
    public static WebElement mojProfil;

    @FindBy(xpath = "//div[@id='nav-user-account']/div/div/p[3]/a[2]")
    public static WebElement logINAli;

    @FindBy(xpath = "//iframe[@id='alibaba-login-box']")
    public static WebElement popUPWindowLogin;

    @FindBy(xpath = "//form[@id='login-form']/div[1]/div/input") //*[@id="fm-login-id"]
    public static WebElement fieldLogin;

    @FindBy(xpath = "//form[@id='login-form']/div[3]/div/input") //*[@id="fm-login-password"]
    public static WebElement fieldPassw;

    @FindBy(xpath = "//form[@id='login-form']/div[5]/button") //body/div[1]/div/div[2]/div/form/div[5]/button
    public static WebElement submitBtn;









}
