package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class StepDefs {
    WebDriver driver;

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://b2c.zeiss.com/b2c.zeiss.com/oauth2/v2.0/authorize?p=b2c_1a_zeissidsocialv2signin&client_id=db167f2e-fbee-48fb-acb2-0c65daff36a0&redirect_uri=https%3A%2F%2Fid-ip.zeiss.com%2FOAuth%2FAuthorizeCallBack&response_type=id_token&scope=openid+profile+offline_access&response_mode=form_post&nonce=637822829564737359.NWZiYWE0N2EtMTY3My00N2FiLWE4MDQtYjE1OWIzYWM2YTQ5NTllOWZiMjctMGY4MC00ZGYxLTk0NTEtYzMxZGMwMDk3M2U4&ui_locales=en&state=CfDJ8Mfbt-svviFEncIY2VZm1xUlh8EOSj_O27r5lIhEiWusDerJeOSBRqFD6q9BE-AN_lOaO206WXMggwKiZ3efMOKxX_VqcGQa789xvESRYYy9f50Ge5cVqtdpBPJR_pEezI9KJ8HM2c4OB_7uYpVrrStf0mSagbFSBK8GKliJnMQTyLBdW6YaiUD_qbwjuwvTPm6jo88i0h9lfg8L9hla9w9F8SCDNLWTlk_wvjJ_sIIILfMsXlqzaPglI-AlorDQEskFsjpq8WsXI0OOYOOoREZSU1nhO3O1eblCnfCG3jBs&x-client-SKU=ID_NETSTANDARD2_0&x-client-ver=5.5.0.0");
    }


    @When("^I provide \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_provide_and(String arg1, String arg2) throws Throwable {
        //driver.wait(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12, 1));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("signInName"))));

        driver.findElement(By.id("signInName")).sendKeys(arg1);
        driver.findElement(By.id("password")).sendKeys(arg2);

    }
    @When("^I click on login button$")
    public void i_click_on_login_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@class='buttons']/button[@id='next']")).click();
    }
    @Then("^I should see the error alert$")
    public void i_should_see_the_Error_message() throws Throwable {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            if(driver.findElement(By.name("Password")).isDisplayed()){
                Assert.assertTrue(true);
            }else
                Assert.assertTrue(false);
        }catch(Exception NoSuchElementException){
            Assert.assertTrue(false);
        }finally{
            driver.quit();
        }
    }
}
