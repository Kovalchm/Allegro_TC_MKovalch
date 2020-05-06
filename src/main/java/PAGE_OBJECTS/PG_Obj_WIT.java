package PAGE_OBJECTS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PG_Obj_WIT {

    @FindBy(xpath = "//span[contains(text(),'Przejdź dalej')]")
    public static WebElement rodoOk;
    @FindBy(xpath = "//a[@href=\"/oferta-edukacyjna\"]")
    public static WebElement studiaDropdown;
    @FindBy(xpath = "//a[@href=\"/studia-inzynierskie/informatyka\"]")
    public static WebElement informaticsDirection;
    @FindBy(xpath = "//a[@href=\"/studia-inzynierskie/informatyka/bazy-danych\"]/span")
    public static WebElement bdSpeciality;
    @FindBy(xpath = "//a[@href=\"/studia-inzynierskie/informatyka/inzynieria-oprogramowania\"]/span")
    public static WebElement engSpeciality;
    @FindBy(xpath = "//a[@href=\"/studia-inzynierskie/informatyka/technologia-chmury-obliczeniowej\"]/span")
    public static WebElement cloudSpeciality;
    @FindBy(xpath = "(//span[text() = 'Pobierz program'])[1]")
    public static WebElement getdailyProgram;
}
