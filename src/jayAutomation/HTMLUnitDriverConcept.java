package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HTMLUnitDriverConcept {

	public static void main(String[] args) throws InterruptedException {

System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver();
				
		//htmlunitdriver is not availabe in Slenium 3.x version. After download selenium JAR file, it is NOT included in it
		//htmlunitdriver -- So to use this concept, we have to download htmlunitdriver JAR file 

		//Advantages: 
		//1. Testing happens behind the scene -- no browser is launched 
		//2. Execution of test cases is very fast -- performance of the script 
		
		//AKA: Ghost Driver hence Headless Browser, there are are two types of GH or HB: 
			//1. --HtmlUnitDriver -- Java 
			//2. --PhantomJS -- JavaScript
		
		//It is used to get result  fast, for SANITY or SMOKE testing, just want to do to high level testing without launching the
		//browser with full navigatioanl button option than we use HtmlUnitDriver 

		//**IQ: What are the changes in Selenium 3?
		//Selenium 2.5, all the drivers were included, however, after update in Selenium 3 now the responsibility falls on each browser organization  
		//to have their own browser driver such as FF Gecko driver, or Chrome driver, Safari extention so it is the same for Html therefore we have HtmlUnitDriver 

		//WebDriver driver = HtmlUnitDriver();   //CAN'T RUN HTMLUNITDRIVER, IT IS NOT PICKING UP AS CLASS, WILL HAVE TO DOWNGRADE TO JAVE 1.8 & TRY AGAIN
		
		driver.manage().window().maximize();   
		driver.manage().deleteAllCookies();
	
		
		//Dynamic wait aka GLOBAL wait. Dynamic because it only waits for relevant loading time, and move onto action after. Where is STATIC WAIT like Thread.sleep(); hard coded and does not save time when page fully loaded
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);//Wait for page to load fully, even if few elements are not loaded yet, that's why implicit wait comes in
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //Wait 30 seconds to load ALL ELEMENTS then perform actions based on the script of that certain element. Some elements may not be loaded within 40 seconds explicit wait
		
		
		driver.get("http://www.freecrm.com");
		
		System.out.println("Before login, titile is:====" + driver.getTitle());
		
		driver.findElement(By.name("username")).sendKeys("jmintegr1");
		Thread.sleep(2000);  //SEEMS LIKE IT NEEDS THREAD.SLEEP TIME FOR LOGIN BUTTON TO CLICK & WORK
		
		driver.findElement(By.name("password")).sendKeys("1zengogo");
		Thread.sleep(2000); 
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		System.out.println("After login, title is: ====" + driver.getTitle());
		

		
		Thread.sleep(3000);
		
		
		driver.quit();

		
	}

}
