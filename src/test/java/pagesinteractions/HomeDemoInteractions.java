package pagesinteractions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomeDemoPO;
import util.Utils;

public class HomeDemoInteractions extends HomeDemoPO {
    WebDriver driver;
    CommonInteractions com;
    public HomeDemoInteractions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);}

    public HomeDemoInteractions cardPicker(String menu){
        com = new CommonInteractions(driver);
        com.clickOnCard(menu);
        return new HomeDemoInteractions(driver);
    }

    public HomeDemoInteractions practiceForm() {
        menuPracticeForm.click();
        return new HomeDemoInteractions(driver);
    }

    public HomeDemoInteractions FormClick() {
        formClose.click();
        return new HomeDemoInteractions(driver);
    }

}