package pagesinteractions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomeDemoPO;
import pages.SideBarPO;

import java.time.Duration;

public class CommonInteractions {
    WebDriver driver;
    HomeDemoPO home;
    SideBarPO side;

    public CommonInteractions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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

    public void clickOnCard(String str){
        for(int i =0; i<home.cards.size();i++){
            if(home.cards.get(i).getText().equals(str)){
                clickOnElement(home.cards.get(i));
                break;
            }
        }
    }
    public void clickOnItem(String str){
        for(int i =0; i<side.cardItems.size();i++){
            if(side.cardItems.get(i).getText().equals(str)){
                clickOnElement(side.cardItems.get(i));
                break;
            }
        }
    }
    public void clickOnElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

}