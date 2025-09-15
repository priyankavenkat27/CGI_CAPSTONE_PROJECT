package com.ecom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Signup_Login_page {
    WebDriver driver;
    WebDriverWait wait;

    // 🔹 Locators for Login
    private By loginEmailField = By.xpath("//input[@data-qa='login-email']");
    private By loginPasswordField = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[text()='Login']");
    private By loginErrorMsg = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
    private By logoutLink = By.linkText("Logout");
    // 🔹 Locators for Signup
    private By signupNameField = By.name("name");
    private By signupEmailField = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By signupErrorMsg = By.xpath("//p[contains(text(),'Email Address already exist')]");


    private By enterAccountInfoHeader = By.xpath("//h2[b[text()='Enter Account Information']]");

    // 🔹 Common
    private By signupLoginLink = By.linkText("Signup / Login");
    private By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
    private By newUserSignupLabel = By.xpath("//h2[text()='New User Signup!']");
    private By loginToAccountLabel = By.xpath("//h2[text()='Login to your account']");
    private By orLabel = By.xpath("//h2[@class='or' and text()='OR']");

    // 🔹 Subscription Section

    private By subscriptionEmailField = By.id("subscribe_email"); // ✅ Corrected ID
    private By subscriptionButton = By.id("subscribe"); // ✅ Only if this ID is correct

    private By subscriptionSuccessMsg = By.xpath("//div[contains(text(),'You have been successfully subscribed!')]");
    private By subscriptionErrorMsg = By.xpath("//div[contains(text(),'Email Address already exist!')]");

    // 🔹 Scroll Elements
    private By scrollToTopArrow = By.id("scrollUp");

    // 🔹 Static Texts
    private By newUserSignupText = By.xpath("//h2[text()='New User Signup!']");
    private By loginToAccountText = By.xpath("//h2[text()='Login to your account']");
    private By orText = By.xpath("//div[@class='signup-form']//form//p[text()='OR']");

    // 🔹 Navigation Buttons
    private By productsIcon = By.xpath("//a[text()=' Products']");
    private By cartIcon = By.xpath("//a[text()=' Cart']");
    private By videoTutorialsIcon = By.xpath("//a[text()=' Video Tutorials']");
    private By contactUsIcon = By.xpath("//a[text()=' Contact us']");
    private By testCasesIcon = By.xpath("//a[text()=' Test Cases']");
    private By apiTestingIcon = By.xpath("//a[text()=' API Testing']");
    private By automationEngineerLogo = By.xpath("//img[contains(@src,'logo.png')]");
    
    private By logoutButton = By.xpath("//a[@href='/logout' and contains(@style,'color:brown')]");
    private By deleteAccountButton = By.xpath("//a[@href='/delete_account' and contains(@style,'color:brown')]");
    private By continueButton = By.xpath("//a[@data-qa='continue-button' and @href='/']");





    // 🔹 Constructor
    public Signup_Login_page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    


    // ================= LOGIN Methods =================
    public void clickSignupLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginLink)).click();
    }

    public void enterLoginEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmailField)).clear();
        driver.findElement(loginEmailField).sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPasswordField)).clear();
        driver.findElement(loginPasswordField).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isLoginSuccessful() {
        return driver.findElements(loggedInAs).size() > 0;
    }
    public void logoutIfLoggedIn() {
        try {
            if (driver.findElements(logoutLink).size() > 0) {
                driver.findElement(logoutLink).click();
                Thread.sleep(1000); // wait for logout to complete
            }
        } catch (Exception e) {
            
        }
    }

    public boolean isLoginErrorDisplayed() {
        return driver.findElements(loginErrorMsg).size() > 0;
    }

    public WebElement getSignupEmailField() {
        return driver.findElement(loginEmailField);
    }

    public WebElement getPasswordField() {
        return driver.findElement(loginPasswordField);
    }


    public boolean isLoginButtonVisible() {
    	try {
            return driver.findElement(loginButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    

    // ================= SIGNUP Methods =================
    public void waitForSignupForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@action='/signup']")));
    }
    public boolean isSignupFormVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@action='/signup']"))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void enterSignupName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupNameField)).clear();
        driver.findElement(signupNameField).sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupEmailField)).clear();
        driver.findElement(signupEmailField).sendKeys(email);
    }

    public void clickSignupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
    }

    public boolean isSignupButtonVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(signupButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSignupErrorDisplayed() {
        return driver.findElements(signupErrorMsg).size() > 0;
    }
    public boolean isEnterAccountInfoHeaderVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(enterAccountInfoHeader)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    // ================= SUBSCRIPTION Methods =================
    


    public WebElement getSubscriptionEmailField() {
        return driver.findElement(subscriptionEmailField);
    }

    public WebElement getSubscriptionButton() {
        return driver.findElement(subscriptionButton);
    }

    public void scrollToSubscriptionSection() {
        WebElement emailField = driver.findElement(subscriptionEmailField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailField);
    }

    public void enterSubscriptionEmail(String email) {
        WebElement emailField = getSubscriptionEmailField();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickSubscriptionButton() {
        getSubscriptionButton().click();
    }

    public boolean isSubscriptionSuccessDisplayed() {
        return driver.findElements(subscriptionSuccessMsg).size() > 0;
    }

    public boolean isSubscriptionErrorDisplayed() {
        return driver.findElements(subscriptionErrorMsg).size() > 0;
    }


    // ================= SCROLL Methods =================
    public void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollToTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }

    public boolean isScrollToTopArrowVisible() {
        return driver.findElements(By.xpath("//a[@id='scrollUp']")).size() > 0;
    }

    public boolean isScrollToTopArrowFunctional(WebDriver driver) {
        try {
            scrollToBottom(driver);
            Thread.sleep(1000); // wait for arrow to appear
            driver.findElement(By.xpath("//a[@id='scrollUp']")).click();
            Thread.sleep(1000); // wait for scroll
            Long scrollY = (Long) ((JavascriptExecutor) driver).executeScript("return window.pageYOffset;");
            return scrollY == 0;
        } catch (Exception e) {
            return false;
        }
    }


    // ================= STATIC TEXT Methods =================
    public boolean isNewUserSignupTextVisible() {
        return driver.findElements(newUserSignupText).size() > 0;
    }

    public boolean isLoginToAccountTextVisible() {
        return driver.findElements(loginToAccountText).size() > 0;
    }

    public boolean isOrTextVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(orText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isSubscriptionButtonVisible() {
        return driver.findElements(By.id("subscribe")).size() > 0;
    }


    // ================= NAVIGATION BUTTONS =================
    
 // 🔹 Getters for navigation icons/buttons
    public WebElement getProductsIcon(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productsIcon));
    }

    public WebElement getCartIcon(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon));
    }

    public WebElement getVideoTutorialsIcon(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(videoTutorialsIcon));
    }

    public WebElement getContactUsIcon(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsIcon));
    }

    public WebElement getTestCasesIcon(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesIcon));
    }

    public WebElement getApiTestingIcon(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(apiTestingIcon));
    }


    public boolean isLogoImageVisible() {
        return driver.findElements(By.xpath("//img[contains(@src,'logo.png')]")).size() > 0;
    }
    public void ensureSignupLoginLinkIsClickable(WebDriver driver, WebDriverWait wait) {
        logoutIfLoggedIn();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Signup / Login"))).click();
    }
    public void clickLoginButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']"))).click();
    }
    public WebElement getNewUserSignupLabel(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(newUserSignupLabel));
    }

    public WebElement getLoginToAccountLabel(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginToAccountLabel));
    }

    public WebElement getOrLabel(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orLabel));
    }
    
    public String getLoginEmail() {
        return driver.findElement(loginEmailField).getAttribute("value");
    }

    public String getLoginPassword() {
        return driver.findElement(loginPasswordField).getAttribute("value");
    }
    
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
    
    public String getLoginErrorMessage() {
        try {
            WebElement errorElement = driver.findElement(loginErrorMsg);
            return errorElement.getText();
        } catch (Exception e) {
            return "No error message found";
        }
    }

    public void clickDeleteAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteAccountButton)).click();
    }
    
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
    
    public void ensureLoggedOut() {
        try {
            // Try to logout if already logged in
            if (isLoginSuccessful()) {
                clickLogout();
            }
            
            // Navigate to home page to reset state
            driver.get("https://automationexercise.com/");
            
            // Wait for page to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".features_items")));
                
        } catch (Exception e) {
            System.out.println("Ensure logout completed: " + e.getMessage());
        }
    }
    
    public boolean isInvalidEmailMessageDisplayed() {
        try {
            WebElement emailField = driver.findElement(loginEmailField);
            String validationMessage = emailField.getAttribute("validationMessage");
            
            // Return true if browser shows any validation message for email field
            return validationMessage != null && !validationMessage.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
}

   

