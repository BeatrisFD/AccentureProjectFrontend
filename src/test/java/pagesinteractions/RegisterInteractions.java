package pagesinteractions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.RegisterPO;

public class RegisterInteractions extends RegisterPO {
    WebDriver driver;
    CommonInteractions com;
    public RegisterInteractions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);}

    public RegisterInteractions inputFirstName(String firstName){
        firstnameField.clear();
        firstnameField.sendKeys(firstName);
        return new RegisterInteractions(driver);
    }

    public RegisterInteractions inputLastName(String lastName){
        lastnameField.clear();
        lastnameField.sendKeys(lastName);
        return new RegisterInteractions(driver);
    }

    public RegisterInteractions inputUserNumber(String userNum){
        usernumField.clear();
        usernumField.sendKeys(userNum);
        return new RegisterInteractions(driver);
    }

    public void clickOnRegisterButton(){
        com.clickOnElement(registerButton);
    }

}
