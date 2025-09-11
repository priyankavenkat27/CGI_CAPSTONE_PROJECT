package com.ecom.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUspage {
    WebDriver driver;
        WebDriverWait wait;

    // 🔹 Locators
    By contactUsLink = By.partialLinkText("Contact");
    By getInTouchHeader = By.xpath("//h2[text()='Get In Touch']");
    By getInTouchEmail = By.xpath("//div[@class='contact-info']//p[contains(text(),'info@automationexercise.com')]");
    By homePageBreadCrumb = By.xpath("//*[@id=\"form-section\"]/a");

    // Contact form fields
    By nameField = By.name("name");
    By emailField = By.name("email");
    By subjectField = By.name("subject");
    By messageField = By.name("message");
    By uploadFile = By.name("upload_file");
    By submitBtn = By.name("submit");

    By successMsg = By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");
    By scrollToTopBtn = By.id("scrollUp");
    By subscriptionInput = By.id("susbscribe_email");
    By subscriptionButton = By.id("subscribe");
    By subscriptionSuccess = By.xpath("//div[@class='alert-success alert']");

    // 🔹 Constructor
    public ContactUspage(WebDriver driver) {
        this.driver = driver;
    }

    // 🔹 Navigation
    public void navigateToContactUs() {
        driver.findElement(contactUsLink).click();
    }

    // 🔹 Validations
    public boolean isGetInTouchHeaderDisplayed() {
        return driver.findElement(getInTouchHeader).isDisplayed();
    }

    public boolean isGetInTouchMailDisplayed() {
        return driver.findElement(getInTouchEmail).isDisplayed();
    }

    // 🔹 Form field validations
    public boolean isNameFieldDisplayed() {
        return driver.findElement(nameField).isDisplayed();
    }

    public boolean isEmailFieldDisplayed() {
        return driver.findElement(emailField).isDisplayed();
    }

    public boolean isSubjectFieldDisplayed() {
        return driver.findElement(subjectField).isDisplayed();
    }

    public boolean isMessageBoxDisplayed() {
        return driver.findElement(messageField).isDisplayed();
    }

    public boolean isChooseFileOptionDisplayed() {
        return driver.findElement(uploadFile).isDisplayed();
    }

    public boolean isSubmitButtonDisplayed() {
        return driver.findElement(submitBtn).isDisplayed();
    }

    // 🔹 Actions
    public void enterName(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterSubject(String subject) {
        driver.findElement(subjectField).clear();
        driver.findElement(subjectField).sendKeys(subject);
    }

    public void enterMessage(String message) {
        driver.findElement(messageField).clear();
        driver.findElement(messageField).sendKeys(message);
    }

    public void uploadFile(String filePath) {
        driver.findElement(uploadFile).sendKeys(filePath);
    }

    public void clickSubmit() {
        driver.findElement(submitBtn).click();
    }

    // 🔹 Utility to fill form quickly
    public void fillContactForm(String name, String email, String subject, String message) {
        enterName(name);
        enterEmail(email);
        enterSubject(subject);
        enterMessage(message);
    }

    public void submitForm() {
        clickSubmit();
    }

    public boolean isFormSubmissionSuccessMessageDisplayed() {
        return driver.findElement(successMsg).isDisplayed();
    }

    public void enterSubscription(String email) {
        WebElement element = driver.findElement(subscriptionInput);
        element.clear();
        element.sendKeys(email);
    }

    public void clickSubscriptionButton() {
        driver.findElement(subscriptionButton).click();
    }
    
    public boolean isSubscriptionSuccessDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionSuccess)).isDisplayed();
    }
    
    public void scrollPageDown(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ")");
    }
    
    public void clickScrollToTop() {
        driver.findElement(scrollToTopBtn).click();
    }

    public void clickHomeButtonBreadCrumb() {
        driver.findElement(homePageBreadCrumb).click();
    }
}
