package custom;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;

/**
 * Configure your custom driver here
 * */
public class MyCustomDriver implements DriverSource{

	public static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	String browser = variables.getProperty("webdriver.provided.type");
	String chromeDir = variables.getProperty("webdriver.chrome.driver");
	
	@Override
	public WebDriver newDriver() {
		
		switch (browser.toLowerCase()) {
		case "firefox":
			File pathToBinary = null;
			try {
				pathToBinary = new File(getDefaultInstallationPathForFFBinary());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			FirefoxBinary binary = new FirefoxBinary(pathToBinary);
			DesiredCapabilities capabilities = new DesiredCapabilities();
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setPreference("app.update.enabled", false);
	        firefoxProfile.setPreference("app.update.auto", false);
	        firefoxProfile.setPreference("app.update.mode", 0);
	        firefoxProfile.setPreference("app.update.service.enabled", false);
	        firefoxProfile.setPreference("signon.autologin.proxy", true);
	        firefoxProfile.setPreference("plugins.update.notifyUser", false);
	        capabilities.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
	        capabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
	        capabilities.setCapability("firefox_binary", binary);
	        capabilities.setCapability("applicationCacheEnabled", false);
	        capabilities.setCapability("platform", Platform.ANY);
	        @SuppressWarnings("deprecation")
			FirefoxDriver driver = new FirefoxDriver(capabilities);
	        return driver;

		case "chrome":
		default:
			System.out.println("Its chrome");
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			String driverDirChrome = System.getProperty("user.dir") + chromeDir;
            System.setProperty("webdriver.chrome.driver", driverDirChrome);
            ChromeDriver driver2 = new ChromeDriver(caps);
			return driver2;
		}
		
		
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}
	
	/**
	 * Gecko driver version is compatible with FF version 52.5.0. In order to avoid serenity from failing 
	 * to lookup firefox binary in default directory (in case it is installed in some custom directory, the setup is configured
	 * to always provide the base installation directory. Use the property firefoxBinary.installationDir in serenity.properties file
	 * to configure the base dir
	 * */
	
	public static String getDefaultInstallationPathForFFBinary() throws FileNotFoundException {
		String ffInstallationDir = variables.getProperty("firefoxBinary.installationDir"); 
		File orig = new File(ffInstallationDir);
		    File[] directories = orig.listFiles(new FileFilter() {
		      public boolean accept(File pathname) {
		        return pathname.isDirectory();
		      }
		    });
		    for (File directory : directories) {
		        File file = new File(directory, "firefox.exe");
		        if (file.exists())
		        	return file.toString();
		    }
		    throw new FileNotFoundException("firefox binary missing in "+ffInstallationDir);
	}
	
}
