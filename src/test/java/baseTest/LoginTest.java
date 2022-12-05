package baseTest;

import com.sun.net.httpserver.Authenticator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AppointmentConfirmationPage;
import pages.BookingPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTests {
@Test (priority = 1,dataProvider =  "loginData")

    public void successfulLogin(String Username,String Password,boolean Success,String facility,String healthCareOption,String inputComment)
    {

    LoginPage loginPage = homePage.clickMakeAppointmentButton();
    loginPage.setUserName(Username);
    loginPage.setPassWord(Password);
    BookingPage bookingPage = loginPage.setLoginButton();
    Assert.assertTrue(Success,bookingPage.getSuccessfulLoginMessage());
    bookingPage.setApplyCheckBox();
    bookingPage.setHealthCareOption1(healthCareOption);
    bookingPage.setFacilityDropDown(facility);
    bookingPage.setOpenCalendar();
    bookingPage.setSelectDate();
    bookingPage.setComment(inputComment);
    AppointmentConfirmationPage appointmentConfirmationPage = bookingPage.clickBookAppointmentBtn();
    Assert.assertEquals(appointmentConfirmationPage.getVisitDateConfirmation(),"21/12/2022");
    appointmentConfirmationPage.clickGoHomeBtn();
    homePage.clickCuraHealthCareBtn();
    homePage.clickLogoutBtn();
    }
    @DataProvider()
    public Object[][] loginData(){
    Object[][] data = new Object[3][6];
    data[0][0] = "John Doe"; data[0][1] = "ThisIsNotAPassword"; data[0][2] = true; data[0][3] = "Seoul CURA Healthcare Center"; data[0][4] = "Medicare"; data[0][5] = "Wheelchair required";
    data[1][0] = "John Doe"; data[1][1] = "ThisIsNotAPassword";  data[1][2] = true; data[1][3] = "Tokyo CURA Healthcare Center";  data[1][4] = "Medicaid"; data[1][5] = "Doesn't eat milk";
    data[2][0] = "John Doe"; data[2][1] = "ThisIsNotAPassword";data[2][2] = true; data[2][3] = "Hongkong CURA Healthcare Center"; data[2][4] = "None"; data[2][5] = "only sleep on cotton";
    return data;
    }

}
