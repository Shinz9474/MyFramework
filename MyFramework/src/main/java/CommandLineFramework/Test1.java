package CommandLineFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;

public class Test1 
{

public static void main(String[] args) throws InterruptedException
{
MyInstances mi = new MyInstances();
mi.ca.launchBrowser("IE", null);
mi.ca.goToURL("https://www.marykayintouch.ca/login/login.aspx", null);
mi.ca.type("id=txtConsultantID", "*00900");
mi.ca.type("id=txtPassword", "Industry1st!");
mi.ca.click("id=btnSubmit", null);
mi.ca.closeBrowser(null, null);
mi.mv.driver.quit();

}
}