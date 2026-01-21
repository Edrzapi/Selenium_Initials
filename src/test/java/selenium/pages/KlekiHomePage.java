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
        // Wait for *a* canvas-like element to exist
        wait.until(d -> !d.findElements(canvasLocator()).isEmpty());
    }

    public WebElement canvas() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(canvasLocator()));
    }

    /**
     * Tries to click a brush/pencil-ish tool.
     * If this fails, inspect Kleki toolbar and update the selector(s).
     */
    public void selectBrushOrPencil() {
        // Example strategies (swap these to match the real DOM):
        // - a button with title="Brush" or aria-label="Brush"
        // - a tool icon with data-tool="brush"
        By[] candidates = new By[] {
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
            } catch (NoSuchElementException ignored) { }
        }

        // If nothing matched, don't hard-fail; drawing may still work with default tool.
        // If you *want* to hard fail:
        // throw new AssertionError("Could not find Brush/Pencil tool - update selectors in selectBrushOrPencil()");
    }

    private By canvasLocator() {
        // Common canvas locators (update to match Kleki)
        // If you inspect Kleki and find a stable id/class, use it here.
        return By.cssSelector("canvas");
    }
}
