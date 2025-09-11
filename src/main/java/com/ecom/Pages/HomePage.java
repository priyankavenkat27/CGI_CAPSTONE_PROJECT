package com.ecom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // 🔹 Locators
    private By navHome = By.xpath("//a[contains(text(),' Home')]"); // home navigation link
    private By logo = By.xpath("//div[@class='logo pull-left']"); // site logo
    private By navSignupLogin = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By navCart = By.xpath("//a[contains(text(),'Cart')]");
    private By navContactUs = By.xpath("//a[contains(text(),'Contact us')]");
    private By navProducts = By.xpath("//a[contains(text(),'Products')]");
    private By navTestCases = By.xpath("//a[contains(text(),'Test Cases')]");
    private By navApiTesting = By.xpath("//a[contains(@href,'/api_list')]");
    private By navVideoTutorials = By.xpath("//a[contains(@href,'youtube.com')]");

    // 🔹 Subscription section
    private By subscriptionEmail = By.id("susbscribe_email");
    private By subscribeBtn = By.id("subscribe");
    private By successMsg = By.xpath("//div[contains(text(),'You have been successfully subscribed!')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Page actions
    public void clickHome() {
        driver.findElement(navHome).click();
    }
    
    
    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public void clickSignupLogin() {
        driver.findElement(navSignupLogin).click();
    }

    public void clickCart() {
        driver.findElement(navCart).click();
    }

    public void clickContactUs() {
        driver.findElement(navContactUs).click();
    }

    public void clickProducts() {
        driver.findElement(navProducts).click();
    }

    public void clickTestCases() {
        driver.findElement(navTestCases).click();
    }

    public void clickApiTesting() {
        driver.findElement(navApiTesting).click();
    }

    public void clickVideoTutorials() {
        driver.findElement(navVideoTutorials).click();
    }

    // ✅ Subscription
    public void enterSubscriptionEmail(String email) {
        driver.findElement(subscriptionEmail).clear();
        driver.findElement(subscriptionEmail).sendKeys(email);
    }

    public void clickSubscribe() {
        driver.findElement(subscribeBtn).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }

    public void scrollPageDown(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ")");
    }
}
