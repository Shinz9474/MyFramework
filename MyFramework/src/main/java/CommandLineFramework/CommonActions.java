package CommandLineFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class CommonActions 
{
		
	//Launch the desired browser
	public void launchBrowser(String Browsername, String msg) throws InterruptedException 
	{		
		if(Browsername.contains("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\Drivers\\chromedriver.exe");
		MyInstances.mv.driver = new ChromeDriver();
		//ChromeOptions.CAPABILITY.
		MyInstances.mv.driver.manage().window().maximize();		
		}
		else if(Browsername.toUpperCase()=="IE")
		{
		System.setProperty("webdriver.ie.driver", "G:\\Selenium\\Drivers\\IE\\IEDriverServer.exe");
		MyInstances.mv.driver = new InternetExplorerDriver();
		
		MyInstances.mv.driver.manage().window().maximize();	
		Thread.sleep(3000);
		}
	}
	
	//Navigate the mentioned url
	public void goToURL(String url, String msg)
	{
		MyInstances.mv.driver.get(url);
		waitInSeconds("10",null);
	}
	
	//wait
	public void waitInSeconds(String secs, String msg)
	{
		MyInstances.mv.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//wait for javascript to load
	public void waitForpageLoad()
	{
		String[] arr ={"This","is","my","house"};
		
		JavascriptExecutor JSdriver = (JavascriptExecutor)MyInstances.mv.driver;
		while(true)
		{
			try 
			{
				//((boolean)JSdriver.executeScript("return jquery.active==0"))
				if(JSdriver.executeScript("return jquery.active==0").toString()=="true")
				{
					break;
				}
			}
			catch (Exception e) 
			{
				// TODO: handle exception
				break;
			}
			
		}
		
	}
	
	//Type 
	public void type(String locator, String txt)
	{
		MyInstances.fa.getloactor(locator);
		MyInstances.mv.ele.sendKeys(txt);		
	}
	
	//Click
	public void click(String locator, String txt)
	{
		MyInstances.fa.getloactor(locator);
		MyInstances.mv.ele.click();
		waitForpageLoad();
	}
	
	//Closebrowser
	public void closeBrowser(String txt1, String txt2)
	{
		MyInstances.mv.driver.close();
	}
}
