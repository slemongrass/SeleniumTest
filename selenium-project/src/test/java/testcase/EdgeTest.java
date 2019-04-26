package testcase;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import common.CommonUtil;

public class EdgeTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.edge.driver", "src/test/resources/driver/MicrosoftWebDriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(CommonUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        driver.get(CommonUtil.TEST_SERVER);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test1() {
        CommonUtil.testBaidu(driver);
    }
}
