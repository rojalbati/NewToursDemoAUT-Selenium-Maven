package testPackages;

import org.apache.commons.mail.EmailException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import frameworkPackages.CaptureScreenShot;
import frameworkPackages.ZipFiles;
import uiPackages.BookFlightPageClass;
import uiPackages.CreateAccountSuccessPageClass;
import uiPackages.FlightConfirmationPageClass;
import uiPackages.FlightFinderPageClass;
import uiPackages.HomePageClass;
import uiPackages.MenuContactPageClass;
import uiPackages.MenuRegisterPageClass;
import uiPackages.MenuSignOnPageClass;
import uiPackages.MenuSupportPageClass;
import uiPackages.SelectFlightPageClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

public class TestClass extends BaseTestClass {
	
	// Creating object of PageClass
	
	static HomePageClass objHomePage;
	static MenuContactPageClass objMenuContactPage;
	static MenuSignOnPageClass objMenuSignOnPage;
	static MenuSupportPageClass objMenuSupportPage;
	static FlightFinderPageClass objFlightFinderPage;
	static SelectFlightPageClass objSelectFlightPage;
	static BookFlightPageClass objBookFlightPage;
	static FlightConfirmationPageClass objFlightConfirmationPage;
	static MenuRegisterPageClass objMenuRegisterPage;
	static CreateAccountSuccessPageClass objCreateAccountSuccessPage;
	static ZipFiles objzip;

	@Test(priority = 0, description = "Smoke Testing: Register, Login, Book and Logout")
	public void SmokeTesting() {
//In cmd Prompt: java -jar selenium-server-standalone-3.141.59.jar -role hub
		/*EXTENT REPORT*/
		
		/* Create Object of ExtentHtmlReporter and provide the path where you want to Generate the report*/
		String ReportPath = "./test-output/ExtentReports/Report.html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(ReportPath);
		/* Create object of ExtentReports class- This is main class which will create report*/
		ExtentReports extent = new ExtentReports();
		/* attach the reporter which we created*/
		extent.attachReporter(reporter);
		
		/* call createTest method and pass the name of TestCase- Based on your requirement*/
		ExtentTest logger = extent.createTest("Registration");
		//Title of the Test
		logger.log(Status.INFO, "Navigate to HomePage");
		objHomePage = new HomePageClass(driver, wait);
		objHomePage.waitForPageLoad(60);
		String HomePageVerificationFailedTime = CaptureScreenShot.getDateTimeStamp();
		String HomePageVerificationFailedFilePath = "./test-output/Screenshots/HomePageVerificationFailedScreenShot - "
				+ HomePageVerificationFailedTime + ".png";
		/* "If condition" is failed intentionally inorder to observe Fail Status in Report*/
		if (objHomePage.getPageTitle() != "Welcome: Mercury Tours") {
			// Saves the Screenshot in the given Path
			CaptureScreenShot.getScreenShot(driver, HomePageVerificationFailedFilePath);
			try {
				logger.fail("Home Page Title Could not be Verified",
						MediaEntityBuilder.createScreenCaptureFromPath(
								"./HomePageVerificationFailedScreenShot - " + HomePageVerificationFailedTime + ".png")
								.build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			logger.log(Status.PASS, "Home Page Title Verified");
		// assertEquals(objHomePage.getPageTitle(), "Welcome: Mercury Tours");
		// logger.log(Status.PASS, "Home Page Title Verified");
		extent.flush();

		logger.log(Status.INFO, "Navigate to Register Page");
		objMenuRegisterPage = objHomePage.navigateToRegisterPage();
		objMenuRegisterPage.waitForPageLoad(60);
		assertEquals("Register: Mercury Tours", objMenuRegisterPage.getPageTitle());
		logger.log(Status.PASS, "Register Page Title Verified");
		extent.flush();

		logger.log(Status.INFO, "Enter the Registration Details and Navigate to Create Account Success Page");
		objCreateAccountSuccessPage = objMenuRegisterPage.Register("Prayash", "Prayash", "9843453154",
				"Prayash@gmail.com", "Dudhpati", "Prayash", "Prayash", "Prayash", "44800", "NEPAL", "Prayash",
				"Prayash", "Prayash");
		objCreateAccountSuccessPage.waitForPageLoad(60);
		assertEquals("Register: Mercury Tours", objCreateAccountSuccessPage.getPageTitle());
		logger.log(Status.PASS, "Registered and Create Account SuccessPage Title Verified");
		extent.flush();

		/*TEST LOGIN*/
		ExtentTest logger1 = extent.createTest("Login");
		
		logger1.log(Status.INFO, "Navigate to the Sign On Page");
		objMenuSignOnPage = objCreateAccountSuccessPage.SignIn();
		assertEquals("Sign-on: Mercury Tours", objMenuSignOnPage.getPageTitle());
		logger1.log(Status.PASS, "Sign On Page Title Verified");
		extent.flush();
		
		logger1.log(Status.INFO, "Enter Invalid Login Details and Navigate to Sign On Page");
		objMenuSignOnPage.InvalidLogin("Invalid", "Invalid");
		assertEquals("Sign-on: Mercury Tours", objMenuSignOnPage.getPageTitle());
		logger1.log(Status.PASS, "Sign On Page Title Verified");
		extent.flush();
		
		logger1.log(Status.INFO, "Enter Valid Login Details and Navigate to Flight Finder Page");
		objFlightFinderPage = objMenuSignOnPage.validLogin("Prayash", "Prayash");
		assertEquals("Find a Flight: Mercury Tours:", objFlightFinderPage.getPageTitle());
		logger1.log(Status.PASS, "Flight Finder Page Title Verified");
		extent.flush();
		
		/*TEST FLIGHT BOOKING*/
		ExtentTest logger2 = extent.createTest("Flight Booking");
		
		logger2.log(Status.INFO, "Enter the Find Flight Details and Navigate to Select Flight Page");
		objSelectFlightPage = objFlightFinderPage.FlightFind("RoundTrip", "1", "Zurich", "Denver", "July", "21",
				"August", "21", "Unified Airlines");
		assertEquals("Select a Flight: Mercury Tours", objSelectFlightPage.getPageTitle());
		logger2.log(Status.PASS, "Select Flight Page Title Verified");
		extent.flush();

		logger2.log(Status.INFO, "Enter the Select Flights Detail and Navigate to Book Flight Page");
		objBookFlightPage = objSelectFlightPage.selectFlights("PangaeaAirlines362_D", "BlueSkiesAirlines631_T");
		assertEquals("Book a Flight: Mercury Tours", objBookFlightPage.getPageTitle());
		logger2.log(Status.PASS, "Book Flight Page Title Verified");
		extent.flush();

		logger2.log(Status.INFO, "Enter the Book Flight Details and Navigate to Flight Confirmation Page");
		objFlightConfirmationPage = objBookFlightPage.bookflight("Prayash", "Prayash", "Muslim", "Visa", "45631", "12",
				"2005", "Prayash", "Prayash", "Prayash");
		assertEquals("Flight Confirmation: Mercury Tours", objBookFlightPage.getPageTitle());

		logger2.log(Status.PASS, "Flight Confirnmation Page TItle Verified");
		String FlightConfirmationDetailsScreenShotTime = CaptureScreenShot.getDateTimeStamp();
		String FlightConfirmationDetailsScreenShotFilePath = "./test-output/Screenshots/FlightConfirmationDetailsScreenShot - "
				+ FlightConfirmationDetailsScreenShotTime + ".png";
		// Saves the Screenshot in the given Path
		CaptureScreenShot.getScreenShot(driver, FlightConfirmationDetailsScreenShotFilePath);
		try {
			logger2.pass("Flight Confirmation Details ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(
					"./FlightConfirmationDetailsScreenShot - " + FlightConfirmationDetailsScreenShotTime + ".png")
					.build());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		extent.flush();

		/*TEST LOGOUT*/
		ExtentTest logger3 = extent.createTest("Logout");
		
		logger3.log(Status.INFO, "Log Out and Navigate to Sign On Page");
		objMenuSignOnPage = objFlightConfirmationPage.Logout();
		assertEquals("Sign-on: Mercury Tours", objMenuSignOnPage.getPageTitle());
		logger3.log(Status.PASS, "Sign On Page Title Verified");
		extent.flush();

		// Pass all the FILES TO BE ZIPPED
		ZipFiles.zipFiles(ReportPath, FlightConfirmationDetailsScreenShotFilePath, HomePageVerificationFailedFilePath);

		try {
			CaptureScreenShot.sendemail();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}