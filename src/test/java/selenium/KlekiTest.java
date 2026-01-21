package selenium;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pages.KlekiHomePage;

import java.time.Duration;

public class KlekiTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private KlekiHomePage home;

    @BeforeClass
    public static void init() {
        // SafariDriver comes bundled with Safari on macOS (no geckodriver needed)
        SafariOptions options = new SafariOptions();
        driver = new SafariDriver(options);

        driver.manage().window().setSize(new Dimension(1366, 768));
        wait = new WebDriverWait(driver, 5);
    }

    @Before
    public void setup() {
        home = new KlekiHomePage(driver, wait);
        home.open();
        home.waitForReady();
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void drawQuickLine_onCanvas() {
        WebElement canvas = home.canvas();
        home.selectBrushOrPencil(); // optional
//        E
        new Actions(driver)
                .moveToElement(canvas).clickAndHold().moveByOffset(0, -200).moveByOffset(100, 0).click()
                .moveToElement(canvas, 0, 0).clickAndHold().moveByOffset(100, 0).click().moveToElement(canvas, 0, 0)
				.clickAndHold().moveByOffset(0, -100).moveByOffset(100, 0).click()
                .moveToElement(canvas, 60, 0).click()
                .build()
				.perform();

//        R
		new Actions(driver)
                .moveByOffset(25, 0).clickAndHold().moveByOffset(0, -100).moveByOffset(50, 0).moveByOffset(0, 50)
				.moveByOffset(-50, 0).moveByOffset(50, 50).build().perform();
        Assert.assertTrue(canvas.isDisplayed());
    }
}
