package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userName = By.id("txt-username");
    private By passWord = By.name("password");
    private By loginButton = By.cssSelector("#btn-login");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setUserName(String inputName)
    {
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(inputName);
    }
    public void setPassWord(String inputPassword)
    {
        driver.findElement(passWord).clear();
        driver.findElement(passWord).sendKeys(inputPassword);
    }
    public BookingPage setLoginButton(){
        driver.findElement(loginButton).click();
        return new BookingPage(driver);
    }

}
