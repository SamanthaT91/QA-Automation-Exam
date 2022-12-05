package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingPage{
    private final WebDriver driver;
    String day = "21";
    private By SuccessfulLoginMessage = By.tagName("h2");
    private By facilityDropDown = By.name("facility");
    private By applyCheckBox = By.id("chk_hospotal_readmission");
    private By healthCareOption1 = By.xpath("//*[@name=\"programs\"][@type=\"radio\"]");
    private By comment = By.cssSelector("#txt_comment");
    private By bookAppointmentBtn = By.id("btn-book-appointment");
    private By openCalendar = By.name("visit_date");
    private By selectDate = By.xpath("//table/tbody/tr/td[contains(text(),"+day+")]");


    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getSuccessfulLoginMessage(){
        return  driver.findElement(SuccessfulLoginMessage).getText();
    }

    public void setFacilityDropDown(String facility){
     driver.findElement(facilityDropDown).sendKeys(facility);
    }

    public void setApplyCheckBox() {
        driver.findElement(applyCheckBox).click();
    }

    public void setHealthCareOption1(String healthCareOption){
        driver.findElement(healthCareOption1).sendKeys(healthCareOption);
    }
    public void setComment(String inputComment) {
        driver.findElement(comment).clear();
        driver.findElement(comment).sendKeys(inputComment);
    }

    public void setOpenCalendar()
    {
        driver.findElement(openCalendar).click();
    }

    public void setSelectDate()
    {
        driver.findElement(selectDate).click();
    }

    public AppointmentConfirmationPage clickBookAppointmentBtn(){
        driver.findElement(bookAppointmentBtn).click();
        return  new AppointmentConfirmationPage(driver);

    }
}
