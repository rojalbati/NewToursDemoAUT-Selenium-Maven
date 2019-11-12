package frameworkPackages;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


public class CaptureScreenShot {

	public CaptureScreenShot() {

	}

	public static void getScreenShot(WebDriver driver, String filepath) {
		try {
			System.out.println("In getScreenShot method");
			TakesScreenshot ts = (TakesScreenshot) driver;
			System.out.println("before getScreenshotAs");
			File source = ts.getScreenshotAs(OutputType.FILE);
			System.out.println("After getScreenshotAs");
			FileUtils.copyFile(source, new File(filepath));
		} catch (WebDriverException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getDateTimeStamp() {
		Date oDate;
		String[] sDatePart;
		String sDateStamp;
		oDate = new Date();
		System.out.println(oDate.toString());
		sDatePart = oDate.toString().split(" ");
		sDateStamp = sDatePart[5] + "_" + sDatePart[1] + "_" + sDatePart[2] + "_" + sDatePart[3];
		sDateStamp = sDateStamp.replace(":", "_");
		System.out.println(sDateStamp);
		return sDateStamp;
	}



	
	private static String Email = "your_________________________email@gmail.com";
	private static String Password = "your______________________password";

	public static void sendemail() throws EmailException {
		// Create the attachment
		System.out.println("----------------Sending EMAIL----------------");
		EmailAttachment attachment = new EmailAttachment();
		//Path of the Zip File to be sent in Mail
		attachment.setPath("./test-output/Report/New-Tours-Demo-AUT-Smoke-Test.zip");
		
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Report from Selenium");
		attachment.setName("New-Tours-Demo-AUT-Smoke-Test.zip");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(Email, Password));
		email.setSSLOnConnect(true);
		email.setFrom(Email);
		email.setSubject("Report from Selenium");
		email.setMsg("This is a test report from Selenium");
		email.addTo("recipent@gmail.com");

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();
		System.out.println("----------------EMAIL SENT----------------");
	}

}