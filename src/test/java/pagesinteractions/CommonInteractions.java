package pagesinteractions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestRule;

import java.time.Duration;

public class CommonInteractions {

    protected WebDriver driver = TestRule.getDriver();

    public CommonInteractions(){}

    //actions example
    protected void moveToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    //explicit wait example
    protected void waitVisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}