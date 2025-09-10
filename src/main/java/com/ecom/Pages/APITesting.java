package com.ecom.Pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class APITesting {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By apiTestingLink = By.partialLinkText("API Testing");
    By pageHeading = By.xpath("//h2[text()='API Testing']");
    By homeBreadcrumb = By.cssSelector("a[href='/']");

    public APITesting(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= Actions =================

    public void clickAPITestingLink() {
        wait.until(ExpectedConditions.elementToBeClickable(apiTestingLink)).click();
    }

    public String getPageHeadingText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading)).getText();
    }

    public void clickHomeBreadcrumb() {
        wait.until(ExpectedConditions.elementToBeClickable(homeBreadcrumb)).click();
    }

    public boolean isAPITestingPageVisible() {
        try {
            return driver.findElement(pageHeading).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isHomeBreadcrumbVisible() {
        try {
            return driver.findElement(homeBreadcrumb).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Scroll method (optional if content is long)
    public void scrollPageDown(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ")");
    }

    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
    }
}
