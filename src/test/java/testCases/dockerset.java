package testCases;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.remote.RemoteWebDriver;

	import java.net.MalformedURLException;
	import java.net.URL;

	public class dockerset {
	    public static void main(String[] args) throws MalformedURLException, InterruptedException {
	        // Point to your Selenium Standalone server
	        @SuppressWarnings("deprecation")
			URL gridUrl = new URL("http://localhost:4444/wd/hub");

	        // Create Chrome options
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");

	        // Create a remote WebDriver instance
	        WebDriver driver = new RemoteWebDriver(gridUrl, options);

	        // Run a simple test
	        driver.get("https://www.example.com");
	        System.out.println("Title is: " + driver.getTitle());

	        // Wait for a bit so you can see the browser
	        Thread.sleep(5000);

	        // Quit
	        driver.quit();
	    }
	}



