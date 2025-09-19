package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPO{

    @FindBy(id = "firstname")
    public WebElement firstnameField;

    @FindBy(id = "lastname")
    public WebElement lastnameField;

    @FindBy(id = "userNumber")
    public WebElement usernumField;

    @FindBy(id = "submit")
    public WebElement registerButton;

}
