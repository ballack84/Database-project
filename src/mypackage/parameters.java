package mypackage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameters {
	
	WebDriver driver = new ChromeDriver();
	String website = "https://smartbuy-me.com/account/register";
	
	Connection con;
	
	Statement stmt;
	
	ResultSet rs;
	
	Random rand = new Random();
	//to take screen shot for the test and code to save the pic file with date
	public void screenshot() throws IOException {
		Date mynewdate = new Date();
		
		System.out.println(mynewdate.toString().replace(":", "-"));
		String filename = mynewdate.toString().replace(":", "-");
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File myscreenshot = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(myscreenshot,new File("./ScreenShotFolder/", filename+ ".jpg"));
		
	}
	

}
