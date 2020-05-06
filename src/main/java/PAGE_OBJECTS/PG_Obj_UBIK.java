package PAGE_OBJECTS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PG_Obj_UBIK {
    @FindBy(xpath = "//button[@id='OK']")
    public static WebElement zgodaDane;
    @FindBy(xpath = "//input[@aria-label='Nazwa użytkownika']")
    public static WebElement ubikName;
    @FindBy(xpath = "//input[@aria-label='Hasło']")
    public static WebElement ubikPassw;
    @FindBy(xpath = "//a[@title='Dyplomy']/span")
    public static WebElement diplomaObj;
    @FindBy(xpath = "//button[@value='Zaloguj się']")
    public static WebElement logToUBIK;
    @FindBy(xpath = "//a[@href='https://poczta.wit.edu.pl/']")
    public static WebElement postObj;

    @FindBy(xpath = "//input[@id='login_username']")
    public static WebElement postLog;
    @FindBy(xpath = "//input[@id='secretkey']")
    public static WebElement postPassw;
    //@FindBy(xpath = "//input[@id='smsubmit']")
    //static WebElement logInToPost;

    @FindBy(css = "html > body > table:nth-of-type(1) > tbody > tr:nth-of-type(2) > td:nth-of-type(1) > a:nth-of-type(1)")
    public static WebElement newMsg;
    @FindBy(xpath = "#send_to")
    public static WebElement postTo;
    @FindBy(xpath = "//input[@id='subject']")
    public static WebElement subjectLetter;
    @FindBy(xpath = "//textarea[@id='body']")
    public static WebElement letterBox;
    @FindBy(xpath = "//input[@id='send']")
    public static WebElement sendLetter;
    @FindBy(xpath = "//a[@href='/src/signout.php']")
    public static WebElement sigNOut;



}
