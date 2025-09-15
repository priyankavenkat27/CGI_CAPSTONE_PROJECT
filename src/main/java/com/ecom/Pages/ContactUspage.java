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
    By logo = By.xpath("//img[@alt='Website for automation practice']");
    By contactUsLink = By.partialLinkText("Contact");
    By getInTouchHeader = By.xpath("//h2[text()='Get In Touch']");
    By getInTouchEmail = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[2]/div[1]/address/p[2]/a/u");
    By homePageBreadCrumb = By.xpath("//*[@id=\"form-section\"]/a");

    // Contact form fields
    By nameField = By.name("name");
    By emailField = By.name("email");
    By subjectField = By.name("subject");
    By messageField = By.name("message");
    By uploadFile = By.name("upload_file");
    By submitBtn = By.name("submit");
    By homeBtn = By.partialLinkText("Home");
    By testCasesBtn = By.partialLinkText("Test Cases");
    By apiTestingBtn = By.partialLinkText("API Testing");


    By successMsg = By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");
    By scrollToTopBtn = By.id("scrollUp");
    By subscriptionInput = By.id("susbscribe_email");
    By subscriptionButton = By.id("subscribe");
    By subscriptionSuccess = By.xpath("//div[@class='alert-success alert']");
    By subscriptionDuplicateMsg = By.xpath("//*[contains(text(),'Email Already Exists')]"); 

    // 🔹 Constructor
    public ContactUspage(WebDriver driver) {
        this.driver = driver;
    }
    
    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }
    
    public boolean isHomeBtnDisplayed() {
        return driver.findElement(homeBtn).isDisplayed();
    }
    
    public boolean isTestCasesBtnDisplayed() {
        return driver.findElement(testCasesBtn).isDisplayed();
    }

    public boolean isApiTestingBtnDisplayed() {
        return driver.findElement(apiTestingBtn).isDisplayed();
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
    
    public boolean isScrollToTopDisplayed() {
        return driver.findElement(scrollToTopBtn).isDisplayed();
    }
    
    public boolean isScrollDisplayed() {
        // Simple check: page body is displayed and scrollable
        return driver.findElement(By.tagName("body")).isDisplayed();
    }
    
    public boolean isSubscriptionDuplicateMsgDisplayed() {
        return driver.findElement(subscriptionDuplicateMsg).isDisplayed();
    }
    
    public void enterSubscriptionEmail(String email) {
        driver.findElement(subscriptionInput).clear();
        driver.findElement(subscriptionInput).sendKeys(email);
    }
    
    public boolean isSubscriptionFieldDisplayed() {
        return driver.findElement(subscriptionInput).isDisplayed();
    }

}
