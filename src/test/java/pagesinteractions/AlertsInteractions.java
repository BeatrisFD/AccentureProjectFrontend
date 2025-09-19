package pagesinteractions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AlertsPO;

public class AlertsInteractions extends AlertsPO {
    WebDriver driver;
    public AlertsInteractions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);}

    public AlertsInteractions clickOnNewWindow() {
        windowButton.click();
        return new AlertsInteractions(driver);
    }
}
