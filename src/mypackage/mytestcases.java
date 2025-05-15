package mypackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.Date;

public class mytestcases extends parameters{
	

	
	
	
	
	@BeforeTest
	public void setup() throws SQLException {
		
		
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","haitham");
		driver.get(website);
		int randomindex = rand.nextInt(500,900);
		
	}
	
	@Test(priority = 1)
	
	public void updatecustomername() throws SQLException {
		
	String myquery = "update customers set customername='soso' where customernumber=103";
	stmt = con.createStatement();
	int effectedrow = stmt.executeUpdate(myquery);
	System.out.println(effectedrow);
	Assert.assertEquals(effectedrow, 1);
	
	
		
	}

	@Test(priority = 2)
	public void deletecustomer() throws SQLException {
		
		String myquery ="delete from customers where customernumber=6186";
		stmt = con.createStatement();
		int effectedrow = stmt.executeUpdate(myquery);
		System.out.println(effectedrow);

	}

	@Test(priority = 3)
	
	public void readdata() throws SQLException, IOException, InterruptedException {
		String myquery = "select * from customers where customernumber=103";
		stmt = con.createStatement();
		rs = stmt.executeQuery(myquery);
		while(rs.next()) {
			
			String customername = rs.getString("customername");
			Assert.assertEquals(customername.length()>0,true);
			System.out.println(customername);
			
			String lastname = rs.getString("contactLastName");
			Assert.assertEquals(lastname.length()>0,true);
			System.out.println(lastname);
			
			WebElement firstname = driver.findElement(By.id("customer[first_name]"));
			WebElement lastnamee = driver.findElement(By.id("customer[last_name]"));
			WebElement mail = driver.findElement(By.id("customer[email]"));
			
			firstname.sendKeys(customername);
			lastnamee.sendKeys(lastname);
			mail.sendKeys(customername+lastname+"@gmail.com");
			
			screenshot();
			
			
			

		}
		

		
	}
	

}
