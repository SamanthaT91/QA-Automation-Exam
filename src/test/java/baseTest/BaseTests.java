package baseTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

@BeforeSuite
    public void setup(){

        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        homePage = new HomePage(driver);
    }
    @AfterMethod
    public void captureScreenShots(ITestResult testResult){

        if(ITestResult.FAILURE == testResult.getStatus())
        {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +  "/resources/screenshots/FailedTests/"+ testResult.getName()+"_" + testResult.getStartMillis()+ ".png");
            try {
                FileHandler.copy(source, destination);
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +  "/resources/screenshots/PassedTests/"+ testResult.getName()+"_" + testResult.getStartMillis()+ ".png");
            try {
                FileHandler.copy(source, destination);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
