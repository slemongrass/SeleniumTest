package common;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtil {
    public static String TEST_SERVER = XmlUtil.getConfAttribute("test.server.url");
    public static String HUB_SERVER = XmlUtil.getConfAttribute("test.seleniumhub.url");

    // implicit wait time
    public static final Integer IMPLICIT_WAIT_TIME = 30;

    // common wait time
    public static final Integer COMMON_WAIT_TIME = 30;

    public static WebDriver getWebDriver(String browserType) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        WebDriver driver = null;

        capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN10);

        switch (browserType) {
        case "firefox":
            capabilities = DesiredCapabilities.firefox();
            break;
        case "chrome":
            capabilities = DesiredCapabilities.chrome();
            break;
        case "edge":
            capabilities = DesiredCapabilities.edge();
            break;
        case "ie":
        default:
            capabilities = DesiredCapabilities.internetExplorer();
            break;
        }

        driver = new RemoteWebDriver(new URL(HUB_SERVER), capabilities);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);

        return driver;
    }

    public static void testBaidu(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, COMMON_WAIT_TIME);

        String title = driver.getTitle();
        System.out.println(title);

        By input = By.id("kw");
        wait.until(ExpectedConditions.elementToBeClickable(input));
        driver.findElement(input).clear();
        driver.findElement(input).click();
        driver.findElement(input).sendKeys("selenium test");

        By submit = By.id("su");
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        driver.findElement(submit).click();
    }
}
