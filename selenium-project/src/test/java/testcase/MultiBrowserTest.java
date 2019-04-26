package testcase;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import common.CommonUtil;

public class MultiBrowserTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testFirefox() {
        try {
            String browserType = "firefox";
            driver = CommonUtil.getWebDriver(browserType);
            driver.manage().timeouts().implicitlyWait(CommonUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
            driver.get(CommonUtil.TEST_SERVER);
            driver.manage().window().maximize();

            CommonUtil.testBaidu(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testChrome() {
        try {
            String browserType = "chrome";
            driver = CommonUtil.getWebDriver(browserType);
            driver.manage().timeouts().implicitlyWait(CommonUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
            driver.get(CommonUtil.TEST_SERVER);
            driver.manage().window().maximize();

            CommonUtil.testBaidu(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIE() {
        try {
            String browserType = "ie";
            driver = CommonUtil.getWebDriver(browserType);
            driver.manage().timeouts().implicitlyWait(CommonUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
            driver.get(CommonUtil.TEST_SERVER);
            driver.manage().window().maximize();

            CommonUtil.testBaidu(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEdge() {
        try {
            String browserType = "edge";
            driver = CommonUtil.getWebDriver(browserType);
            driver.manage().timeouts().implicitlyWait(CommonUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
            driver.get(CommonUtil.TEST_SERVER);
            driver.manage().window().maximize();

            CommonUtil.testBaidu(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
