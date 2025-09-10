package com.ecom.Pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VideoTutorialspage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By videoTutorialsLink = By.partialLinkText("Video Tutorials");
    By pageHeading = By.xpath("//h2[contains(text(),'Video Tutorials')]");
    By youtubeIframe = By.cssSelector("iframe[src*='youtube.com']");
    By homeBreadcrumb = By.cssSelector("a[href='/']");

    public VideoTutorialspage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= Actions =================

    public void clickVideoTutorialsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(videoTutorialsLink)).click();
    }

    public String getPageHeadingText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading)).getText();
    }

    public boolean isYouTubeVideoVisible() {
        try {
            return driver.findElement(youtubeIframe).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickHomeBreadcrumb() {
        wait.until(ExpectedConditions.elementToBeClickable(homeBreadcrumb)).click();
    }

    public boolean isPageVisible() {
        try {
            return driver.findElement(pageHeading).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Scroll methods
    public void scrollPageDown(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ")");
    }

    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
    }
}
