package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomeDemoPO {

    @FindBy(xpath = "//h5[text()='Forms']")
    protected WebElement menuPracticeForm;

    @FindBy(xpath = "/html/body/div[4]/div/div")
    protected WebElement formClose;

    //
    @FindBy(className = "card-body")
    public List<WebElement> cards;

}
