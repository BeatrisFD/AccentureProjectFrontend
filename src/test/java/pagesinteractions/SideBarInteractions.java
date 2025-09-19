package pagesinteractions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.SideBarPO;

import java.util.List;

public class SideBarInteractions extends SideBarPO {
    WebDriver driver;
    CommonInteractions com;
    public SideBarInteractions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SideBarInteractions sideBarPicker(String menu){
        com.clickOnItem(menu);
        return new SideBarInteractions(driver);
    }

}
