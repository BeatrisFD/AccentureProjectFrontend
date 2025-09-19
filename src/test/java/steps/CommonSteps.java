package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pagesinteractions.*;

import java.time.Duration;

public class CommonSteps {

    WebDriver driver;
    HomeDemoInteractions home;
    SideBarInteractions sideBar;
    RegisterInteractions reg;
    AlertsInteractions alerts;
    CommonInteractions com;

    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        //options.addArguments("headless");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("que estou no site {string}")
    public void queEstouNoSite(String url) {
        driver.get(url);
    }

    @When("escolho a opção Forms na página inicial")
    public void escolhoAOpçãoFormsNaPáginaInicial() {
        home = new HomeDemoInteractions(driver);
        home.cardPicker("Forms");
    }

    @And("preencho o formulário em Practice Form")
    public void preenchoOFormulárioEmPracticeForm() {
        sideBar = new SideBarInteractions(driver);
        reg = new RegisterInteractions(driver);

        sideBar.sideBarPicker("Practice Form");

        reg.inputFirstName("teste");
        reg.inputLastName("test");
        reg.inputUserNumber("1111111111");
    }

    @Then("submeto o formulário")
    public void submetoOFormulário() {
        reg = new RegisterInteractions(driver);
        reg.clickOnRegisterButton();
    }

    @And("fecho o pop-up")
    public void fechoOPopUp() {
        home = new HomeDemoInteractions(driver);
        home.FormClick();
    }
//----------------------------------------------------------
    @When("escolho a opção Alerts na página inicial")
    public void escolhoAOpçãoAlertsNaPáginaInicial() {
        home = new HomeDemoInteractions(driver);
        home.cardPicker("Alerts, Frame & Windows");
    }

    @And("escolho o submenu Browser Windows")
    public void escolhoOSubmenuBrowserWindows() {
        sideBar = new SideBarInteractions(driver);
        sideBar.sideBarPicker("Browser Windows");
    }

    @And("clico no botão new Windows")
    public void clicoNoBotãoNewWindows() {
        alerts = new AlertsInteractions(driver);
        alerts.clickOnNewWindow();
    }

    @Then("verifico na janela a mensagem This is a sample page")
    public void verificoNaJanelaAMensagemThisIsASamplePage() {
    }

    @After
    public void afterScenario(){
        if(driver != null){
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
