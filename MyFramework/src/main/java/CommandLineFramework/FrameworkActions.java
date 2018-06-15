package CommandLineFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FrameworkActions 
{
	MyInstances mi =new MyInstances();

	public WebElement getloactor(String locator)
	{
		String[] lctr = locator.split("=");
		if(lctr[0].contains("id"))
		{
			mi.mv.ele= mi.mv.driver.findElement(By.id(lctr[1]));			
		}
		else if(lctr[0].contains("xpath"))
		{
			mi.mv.ele= mi.mv.driver.findElement(By.xpath(lctr[1]));
		}
		else if(lctr[0].contains("class"))
		{
			mi.mv.ele= mi.mv.driver.findElement(By.className(lctr[1]));
		}
		else if(lctr[0].contains("css"))
		{
			mi.mv.ele= mi.mv.driver.findElement(By.cssSelector(lctr[1]));
		}
		else
		{
			System.out.println("locator Not matched");
			mi.mv.ele=null;
		}
		return mi.mv.ele;
		
	}
}
