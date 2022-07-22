package core;

import enums.BrowserEnum;
import enums.EnvironmentEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class WebDriverFactory {
    //from browserstack
    // https://automate.browserstack.com/dashboard/v2/getting-started
    public static final String USERNAME = "oksanaskovron1";
    public static final String AUTOMATE_KEY = "oYj3BC4mfM79ooD7zjoQ";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    private static WebDriver driver;
    private static DesiredCapabilities caps;


    private WebDriverFactory(){}

    //didn't do singletone. Try to do

    public static WebDriver getDriver(BrowserEnum browser,
                                      String browserVersion,
                                      EnvironmentEnum environment){
        setProperties(); //обовязково
        if (environment.equals(EnvironmentEnum.LOCAL)){
            return getLocalDriver(browser);
        }else if (environment.equals(EnvironmentEnum.REMOTE)){
            setCaps(browser, browserVersion);
            return getRemoteDriver();
        }else{
            throw new RuntimeException("Unsupported environment: " + environment); //RuntimeException шоб не try кечати
        }
    }

    private static WebDriver getLocalDriver(BrowserEnum browser){
        switch (browser){
            case CHROME: return new ChromeDriver();
            case FIREFOX: return new FirefoxDriver();
            default: throw new RuntimeException("browser not supported: " + browser);
        }
    }

    //посилаємо тест на browserstack
    private static WebDriver getRemoteDriver(){
        //WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        //# Write your test here
        //driver.quit();
        //copied from browserstack and edited:
        java.net.URL url = null;
        try {
            url = new URL(URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new RemoteWebDriver(url, caps); //шоб посилати драйвер на хаб
    }


//    private static void setPropertiesOksana() {
//        String driversFolderWin = "src\\test\\resources\\drivers\\";
//        String driversFolderUnix = "src/test/resources/drivers/";
//        //визначити на якій операційній системі ми є
//        String os = System.getProperty("os.name"); //поверне назву операційної системи windows, macOs
//        String arch = System.getProperty("os.arch"); // x86, x64 поверне архітектуру
//
//        if (os.toLowerCase().contains("win")) {
//            if (arch.contains("64")) {
//                System.setProperty("webdriver.chrome.driver", driversFolderWin + "win\\64\\chromedriver.exe");
//                System.setProperty("webdriver.gecko.driver", driversFolderWin + "win\\64\\geckodriver.exe");
//            } else {
//                System.setProperty("webdriver.chrome.driver", driversFolderWin + "win\\86\\chromedriver.exe");
//                System.setProperty("webdriver.gecko.driver", driversFolderWin + "win\\86\\geckodriver.exe");
//            }
//        } else if (os.toLowerCase().contains("nux") || os.toLowerCase().contains("nix")) {
//            if (arch.contains("64")) {
//                System.setProperty("webdriver.chrome.driver", driversFolderUnix + "linux/64/chromedriver.exe");
//                System.setProperty("webdriver.gecko.driver", driversFolderUnix + "linux/64/geckodriver.exe");
//            } else {
//                System.setProperty("webdriver.chrome.driver", driversFolderUnix + "linux/86/chromedriver.exe");
//                System.setProperty("webdriver.gecko.driver", driversFolderUnix + "linux/86/geckodriver.exe");
//            }
//        } else if (os.toLowerCase().contains("mac")) {
//                            System.setProperty("webdriver.chrome.driver", driversFolderUnix + "linux/64/chromedriver.exe");
//                System.setProperty("webdriver.gecko.driver", driversFolderUnix + "linux/64/geckodriver.exe");
//        }else{
//            throw new RuntimeException("Unsupported OS: " + os);
//        }
//
//    }

    private static void setProperties() {
        String driversFolderWin = "src\\test\\resources\\drivers\\";
        String driversFolderUnix = "src/test/resources/drivers/";
        String os = System.getProperty("os.name");
        String arch = System.getProperty("os.arch");
        if(os.toLowerCase().contains("win")) {
            if(arch.contains("64")) {
                System.setProperty("webdriver.chrome.driver", driversFolderWin + "win\\64\\chromedriver.exe");
                System.setProperty("webdriver.gecko.driver", driversFolderWin + "win\\64\\geckodriver.exe");
            } else {
                System.setProperty("webdriver.chrome.driver", driversFolderWin + "win\\86\\chromedriver.exe");
                System.setProperty("webdriver.gecko.driver", driversFolderWin + "win\\86\\geckodriver.exe");
            }
        } else if (os.toLowerCase().contains("nux") || os.toLowerCase().contains("nix")) {
            if(arch.contains("64")) {
                System.setProperty("webdriver.chrome.driver", driversFolderUnix + "linux/64/chromedriver");
                System.setProperty("webdriver.gecko.driver", driversFolderUnix + "linux/64/geckodriver");
            } else {
                System.setProperty("webdriver.chrome.driver", driversFolderUnix + "linux/86/chromedriver");
                System.setProperty("webdriver.gecko.driver", driversFolderUnix + "linux/86/geckodriver");
            }
        } else if (os.toLowerCase().contains("mac") ) {
            System.setProperty("webdriver.chrome.driver", driversFolderUnix + "macos/64/chromedriver");
            System.setProperty("webdriver.gecko.driver", driversFolderUnix + "macos/64/geckodriver");
        } else {
            throw new RuntimeException("Unsupported OS: " + os);
        }
    }

    //for browserstack on what to run. можемо запускати багато тестів, але на одному браузері
    //операційці за раз
    private static void setCaps(BrowserEnum browserEnum, String browserVersion){
        caps = new DesiredCapabilities(); //треба проініціалізувати, бо caps буде null зверху private static DesiredCapabilities caps;
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", browserEnum.name() ); //configure browser
        caps.setCapability("browser_version", browserVersion);
        caps.setCapability("name", "oksanaskovron1's First Test");
    }
}
