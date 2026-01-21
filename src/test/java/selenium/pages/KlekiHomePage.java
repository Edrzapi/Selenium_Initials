package selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KlekiHomePage {

    public final String URL = "https://kleki.com/";

    private final WebDriver driver;
    private final WebDriverWait wait;

    public KlekiHomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get(URL);
    }

    public void waitForReady() {
        wait.until(d -> !d.findElements(canvasLocator()).isEmpty());
    }

    public WebElement canvas() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(canvasLocator()));
    }

    public void selectBrushOrPencil() {
        By[] candidates = new By[]{
                By.cssSelector("[title*='Brush' i]"),
                By.cssSelector("[aria-label*='Brush' i]"),
                By.cssSelector("[data-tool='brush']"),
                By.cssSelector("[title*='Pencil' i]"),
                By.cssSelector("[aria-label*='Pencil' i]"),
                By.cssSelector("[data-tool='pencil']")
        };

        for (By by : candidates) {
            try {
                WebElement el = driver.findElement(by);
                if (el.isDisplayed() && el.isEnabled()) {
                    el.click();
                    return;
                }
            } catch (NoSuchElementException ignored) {
            }
        }
    }

    private By canvasLocator() {
        return By.cssSelector("canvas");
    }
}
