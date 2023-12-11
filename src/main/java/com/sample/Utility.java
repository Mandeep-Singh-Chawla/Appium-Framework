package com.sample;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Collections;


public class Utility {
    private final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    AppiumDriver driver;

    public Utility(AppiumDriver driver) {
        this.driver = driver;
    }



    public void scrollPageDown() {
        try {
            Dimension dimensions = this.driver.manage().window().getSize();
            double screenHeightStart = (double) dimensions.getHeight() * 0.85D;
            int scrollStart = (int) screenHeightStart;
            double screenHeightEnd = (double) dimensions.getHeight() * 0.15D;
            int scrollEnd = (int) screenHeightEnd;
            Point start = new Point(200, scrollStart);
            Point end = new Point(200, scrollEnd);
            doSwipe(driver, start, end, 500);
            Thread.sleep(1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollPageUp() {
        try {
            Dimension dimensions = driver.manage().window().getSize();
            double screenHeightStart = (double) dimensions.getHeight() * 0.85D;
            int scrollStart = (int) screenHeightStart;
            double screenHeightEnd = (double) dimensions.getHeight() * 0.15D;
            int scrollEnd = (int) screenHeightEnd;
            Point start = new Point(200, scrollEnd);
            Point end = new Point(200, scrollStart);
            doSwipe((AppiumDriver) driver, start, end, 500);
            Thread.sleep(1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void slideElementRightToLeft(By by) {
        int screenWidth = driver.manage().window().getSize().width;
        int screenWidth90 = (int) (0.9D * (double) screenWidth);
        int screenWidth65 = (int) (0.4D * (double) screenWidth);
        int elementYAxis = getCentre(by).y;
        Point start = new Point(screenWidth90, elementYAxis);
        Point end = new Point(screenWidth65, elementYAxis);
        doSwipe((AppiumDriver) driver, start, end, 2000);
        String var10000 = by.getClass().getSimpleName();
    }

    public void slideElementLeftToRight(By by) {
        int screenWidth = driver.manage().window().getSize().width;
        int screenWidth90 = (int) (0.9D * (double) screenWidth);
        int screenWidth65 = (int) (0.4D * (double) screenWidth);
        int elementYAxis = getCentre(by).y;
        Point start = new Point(screenWidth65, elementYAxis);
        Point end = new Point(screenWidth90, elementYAxis);
        doSwipe((AppiumDriver) driver, start, end, 2000);
        String var10000 = by.getClass().getSimpleName();
    }

    public void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
        Sequence swipe = (new Sequence(FINGER, 1)).addAction(FINGER.createPointerMove(Duration.ofMillis(0L), PointerInput.Origin.viewport(), start.getX(), start.getY())).addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).addAction(FINGER.createPointerMove(Duration.ofMillis((long) duration), PointerInput.Origin.viewport(), end.getX(), end.getY())).addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));
    }

    public Point getCentre(By by) {
        WebElement me = findElement(by);
        Point point = new Point(me.getRect().x + me.getSize().getWidth() / 2, me.getRect().y + me.getSize().getHeight() / 2);
        return point;
    }

    public WebElement findElement(By by) {
        waitUntilElementVisible(by);
        return driver.findElement(by);
    }

    public void waitUntilElementVisible(By by) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception var6) {
            String customErrorMessage = "Timed out waiting for visibility of element located = ( " + by.toString() + ")";
            throw new NoSuchElementException(customErrorMessage, var6.getCause());
        }
    }

    public void scrollTillElement(By by, int numberOfScrolls) {
        for (int i = 0; i < numberOfScrolls; i++) {
            if (! isElementVisible(by)) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                scrollPageDown();
            } else {
                break;
            }
        }

    }
    public boolean isElementVisible(By by){
        try {
            driver.findElement(by);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void slideElementRightToLeftTillElement(By shortWidget, By shortElement, int numberOfSwipes) {
        for (int i = 0; i < numberOfSwipes; i++) {
            if (! isElementVisible(shortElement)) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                slideElementRightToLeft(shortWidget);
            } else {
                break;
            }
        }
    }
}
