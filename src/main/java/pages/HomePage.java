package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By makeAppointment = By.xpath("//*[@id=\"btn-make-appointment\"]");
    private By curaHealthCareBtn = By.id("menu-toggle");
    private By logoutBtn = By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[5]/a");

    //Constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage clickMakeAppointmentButton() {
        driver.findElement(makeAppointment).click();
        return new LoginPage(driver);
    }

        public void clickCuraHealthCareBtn() {
            driver.findElement(curaHealthCareBtn).click();

        }

    public void clickLogoutBtn() {
        driver.findElement(logoutBtn).click();

    }
    }

