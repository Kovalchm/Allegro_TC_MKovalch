import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PG_Obj_WIT {

    @FindBy(xpath = "//span[contains(text(),'Przejdź dalej')]")
    static WebElement rodoOk;
    @FindBy(xpath = "//a[@href=\"/oferta-edukacyjna\"]")
    static WebElement studiaDropdown;
    @FindBy(xpath = "//a[@href=\"/studia-inzynierskie/informatyka\"]")
    static WebElement informaticsDirection;
    @FindBy(xpath = "//a[@href=\"/studia-inzynierskie/informatyka/bazy-danych\"]/span")
    static WebElement bdSpeciality;
    @FindBy(xpath = "//a[@href=\"/studia-inzynierskie/informatyka/inzynieria-oprogramowania\"]/span")
    static WebElement engSpeciality;
    @FindBy(xpath = "//a[@href=\"/studia-inzynierskie/informatyka/technologia-chmury-obliczeniowej\"]/span")
    static WebElement cloudSpeciality;
    @FindBy(xpath = "(//span[text() = 'Pobierz program'])[1]")
    static WebElement getdailyProgram;
}
