
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PG_Obj_UBIK {
    @FindBy(xpath = "//button[@id='OK']")
    static WebElement zgodaDane;
    @FindBy(xpath = "//input[@aria-label='Nazwa użytkownika']")
    static WebElement ubikName;
    @FindBy(xpath = "//input[@aria-label='Hasło']")
    static WebElement ubikPassw;
    @FindBy(xpath = "//a[@title='Dyplomy']/span")
    static WebElement diplomaObj;
    @FindBy(xpath = "//button[@value='Zaloguj się']")
    static WebElement logToUBIK;
    @FindBy(xpath = "//a[@href='https://poczta.wit.edu.pl/']")
    static WebElement postObj;

    @FindBy(xpath = "//input[@id='login_username']")
    static WebElement postLog;
    @FindBy(xpath = "//input[@id='secretkey']")
    static WebElement postPassw;
    //@FindBy(xpath = "//input[@id='smsubmit']")
    //static WebElement logInToPost;

    @FindBy(css = "html > body > table:nth-of-type(1) > tbody > tr:nth-of-type(2) > td:nth-of-type(1) > a:nth-of-type(1)")
    static WebElement newMsg;
    @FindBy(xpath = "#send_to")
    static WebElement postTo;
    @FindBy(xpath = "//input[@id='subject']")
    static WebElement subjectLetter;
    @FindBy(xpath = "//textarea[@id='body']")
    static WebElement letterBox;
    @FindBy(xpath = "//input[@id='send']")
    static WebElement sendLetter;
    @FindBy(xpath = "//a[@href='/src/signout.php']")
    static WebElement sigNOut;



}
