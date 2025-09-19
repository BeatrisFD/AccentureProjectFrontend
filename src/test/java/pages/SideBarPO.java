package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SideBarPO{

    @FindBy(className = "text")
    public List<WebElement> cardItems;

}
