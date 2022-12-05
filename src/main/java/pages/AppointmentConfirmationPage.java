package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AppointmentConfirmationPage {
    private WebDriver driver;
    private By visitDateConfirmation = By.id("visit_date");
    private By goHomeBtn = By.cssSelector("#summary > div > div > div:nth-child(7) > p > a");
    public AppointmentConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getVisitDateConfirmation() {
        return driver.findElement(visitDateConfirmation).getText();
    }
    public HomePage clickGoHomeBtn() {
        driver.findElement(goHomeBtn).click();
        return new HomePage(driver);
    }
}
