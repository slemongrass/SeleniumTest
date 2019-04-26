package testcase;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import common.CommonUtil;

public class IETest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.ie.driver", "src/test/resources/driver/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(CommonUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

    @Before
    public void setUp() throws Exception {
        driver.get(CommonUtil.TEST_SERVER);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1() {
        CommonUtil.testBaidu(driver);
    }
}
