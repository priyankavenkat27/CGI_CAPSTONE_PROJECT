package com.ecom.Pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By homeBreadcrumb = By.cssSelector("a[href='/']");
    By cartBreadcrumb = By.cssSelector("li.active");
    By hereLink = By.linkText("here");
    By deleteIcons = By.cssSelector("a.cart_quantity_delete"); // multiple delete icons
    By proceedToCheckoutBtn = By.cssSelector("a.btn.btn-default.check_out");
    By subscriptionEmailBox = By.id("susbscribe"); // correct id
    By subscriptionBtn = By.id("subscribe");
    By commentsTextBox = By.name("message");
    By scrollToTopArrow = By.id("scrollUp");

    // ================= Actions =================

    public void clickHomeBreadcrumb() {
        wait.until(ExpectedConditions.elementToBeClickable(homeBreadcrumb)).click();
    }

    public void clickCartBreadcrumb() {
        wait.until(ExpectedConditions.elementToBeClickable(cartBreadcrumb)).click();
    }

    public void clickHereLink() {
        wait.until(ExpectedConditions.elementToBeClickable(hereLink)).click();
    }

    public WebElement getProceedToCheckoutBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));
    }

    public void clickDeleteIcon(int index) { // delete specific product by index
        List<WebElement> icons = driver.findElements(deleteIcons);
        if (index < icons.size()) {
            wait.until(ExpectedConditions.elementToBeClickable(icons.get(index))).click();
        }
    }

    public void clickDeleteAllProducts() { // delete all products
        List<WebElement> icons = driver.findElements(deleteIcons);
        for (WebElement icon : icons) {
            wait.until(ExpectedConditions.elementToBeClickable(icon)).click();
            // small pause if needed for DOM update
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }

    public void clickProceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
    }

    public void enterSubscriptionEmail(String email) {
        WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionEmailBox));
        emailBox.clear();
        emailBox.sendKeys(email);
    }

    public void clickSubscribe() {
        wait.until(ExpectedConditions.elementToBeClickable(subscriptionBtn)).click();
    }

    public void enterComments(String comments) {
        WebElement commentsBox = wait.until(ExpectedConditions.visibilityOfElementLocated(commentsTextBox));
        commentsBox.clear();
        commentsBox.sendKeys(comments);
    }

    public String getEnteredComments() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(commentsTextBox)).getAttribute("value");
    }

    public void clickScrollToTopArrow() {
        wait.until(ExpectedConditions.elementToBeClickable(scrollToTopArrow)).click();
    }

    // ================= Verification Methods =================

    public boolean isDeleteIconPresent() {
        return driver.findElements(deleteIcons).size() > 0;
    }

    public boolean isHereLinkPresent() {
        return driver.findElements(hereLink).size() > 0;
    }

    public boolean isSubscriptionIconPresent() {
        return driver.findElements(subscriptionBtn).size() > 0;
    }

    // Extra scroll methods
    public void scrollPageDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}

