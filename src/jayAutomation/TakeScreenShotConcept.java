package jayAutomation;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShotConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();   
		driver.manage().deleteAllCookies();
	
		
		//Dynamic wait aka GLOBAL wait. Dynamic because it only waits for relevant loading time, and move onto action after. Where is STATIC WAIT like Thread.sleep(); hard coded and does not save time when page fully loaded
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Wait 30 seconds to load all elements then perform actions based on the script of that certain element. Some elements may not be loaded within 40 seconds explicit wait
		
		driver.get("https://www.google.com/"); 
		
		//Take screenshot & store as a file format   
		/*File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//NOW COPY THE SCREENSHOT TO DESIRED LOCATION USING COPYFILE//METHOD
		FileUtils.copyFile(src, new File("/Users/jewellmehedi/eclipse-workspace/JayNavAutomation/src/jayAutomation.png"));*/
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
		// now copy the screenshot to desired location using copyFile //method   | Just copy paste this two lines of code, no need to memorize
		//FileUtils.copyFile(src, new File("/Users/shams/eclipse-workspace/FreeCRMPSelenium/src/main/java/seleniumPractice/amazon.png"));
		 
		//@ 13 MINUTE REVIST AFTER JAVA 1.8
		 
		//*IQ: Can we take screen shot in selenium, if so how? Ans - Yes we can by using getScreenShotAs method 

		
		

	}

}
