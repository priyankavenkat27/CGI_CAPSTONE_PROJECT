package com.ecom.Pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	    WebDriver driver;

	    public RegisterPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    By signup = By.linkText("Signup / Login");
	    By displaysignuppage = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
	    By SignupHeading = By.xpath("//h2[text()='New User Signup!']");
	    By nameField = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
	    By emailField = By.xpath("//input[@data-qa='signup-email']");
	    By signupButton = By.xpath("//button[@data-qa='signup-button']");
	    By createAccountPage = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b");
	    By titleMrRadio = By.xpath("//*[@id=\"id_gender1\"]");  
	    By titleMrsRadio = By.xpath("//*[@id=\"id_gender2\"]"); 
	    By passwordField = By.id("password");
	    By emailexist = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");
	    By dobDayDropdown = By.id("days");
	    By dobMonthDropdown = By.id("months");
	    By dobYearDropdown = By.id("years");

	    By newsletterCheckbox = By.xpath("//*[@id=\"newsletter\"]");
	    By specialOffersCheckbox = By.xpath("//*[@id=\"optin\"]");
	    By addressHeading = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/h2/b");
	    By firstName = By.id("first_name");
	    By lastName = By.id("last_name");
	    By company = By.id("company");
	    By address1 = By.id("address1");
	    By address2 = By.id("address2");
	    By countryDropdown = By.id("country");
	    By state = By.id("state");
	    By city = By.id("city");
	    By zipcode = By.id("zipcode");
	    By mobile = By.id("mobile_number");
	    By createAccountButton = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button");
	    
	    By accountCreatedMessage = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
	    By continueButtonAfterSignup = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
	    By loggedInAsUsername = By.xpath("//a[contains(text(),'Logged in as')]");
	    By deleteAccountButton = By.xpath("//a[contains(text(),'Delete Account')]");
	    By accountDeletedMessage = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
	    By continueButtonAfterDeletion = By.xpath("//a[contains(text(),'Continue')]");

	   
	    public void clicksignup() {
	        driver.findElement(signup).click();
	    }
	    
	    public boolean issignupDisplay() {
	        return driver.findElement(displaysignuppage).isDisplayed();
	    }
	    
	    public boolean newUserSignupHeading() {
	        return driver.findElement(SignupHeading).isDisplayed();
	    }
	    public boolean emailExist() {
	    	return driver.findElement(emailexist).isDisplayed();
	    }
	    
	    public boolean navigatetoCreateAccount() {
	        return driver.findElement(createAccountPage).isDisplayed();
	    }
	    
	    public void entersignup(String name, String email) {
	        driver.findElement(nameField).sendKeys(name);
	        driver.findElement(emailField).sendKeys(email);

	    }
	    
	    public WebElement getEmailField() {
	        return driver.findElement(emailField);
	    }
	    
	    public void clicksignupButton() {
	    	driver.findElement(signupButton).click();
	    }
	    
	    public void selectTitle(String title) {
	        if (title.equalsIgnoreCase("Mr")) {
	            driver.findElement(titleMrRadio).click();
	        } else if (title.equalsIgnoreCase("Mrs")) {
	            driver.findElement(titleMrsRadio).click();
	        }
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void selectDateOfBirth(String day, String month, String year) {
	        // Select day
	        WebElement dayDropdownElement = driver.findElement(dobDayDropdown);
	        Select daySelect = new Select(dayDropdownElement);
	        daySelect.selectByVisibleText(day);
	        
	        // Select month
	        WebElement monthDropdownElement = driver.findElement(dobMonthDropdown);
	        Select monthSelect = new Select(monthDropdownElement);
	        monthSelect.selectByVisibleText(month);
	        
	        // Select year
	        WebElement yearDropdownElement = driver.findElement(dobYearDropdown);
	        Select yearSelect = new Select(yearDropdownElement);
	        yearSelect.selectByVisibleText(year);
	    }
	    
	    public void selectNewsletter() {
	        WebElement checkbox = driver.findElement(newsletterCheckbox);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
	    }

	    public void selectSpecialOffers() {
	        WebElement checkbox = driver.findElement(specialOffersCheckbox);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
	    }

	    public boolean isAddressHeadingDisplayed() {
	        return driver.findElement(addressHeading).isDisplayed();
	    }

	    public void enterFirstName(String fname) {
	        driver.findElement(firstName).sendKeys(fname);
	    }

	    public void enterLastName(String lname) {
	        driver.findElement(lastName).sendKeys(lname);
	    }

	    public void enterCompany(String comp) {
	        driver.findElement(company).sendKeys(comp);
	    }

	    public void enterAddress1(String addr) {
	        driver.findElement(address1).sendKeys(addr);
	    }

	    public void enterAddress2(String addr) {
	        driver.findElement(address2).sendKeys(addr);
	    }

	    public void selectCountry(String country) {
	        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
	    }

	    public void enterState(String st) {
	        driver.findElement(state).sendKeys(st);
	    }

	    public void enterCity(String ct) {
	        driver.findElement(city).sendKeys(ct);
	    }

	    public void enterZipcode(String zip) {
	        driver.findElement(zipcode).sendKeys(zip);
	    }

	    public void enterMobile(String mob) {
	        driver.findElement(mobile).sendKeys(mob);
	    }
	    
	    public void clickCreateAccountButton() {
	        WebElement createAccountBtn = driver.findElement(createAccountButton);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountBtn);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();
	    }
	    
	    public boolean isAccountCreatedMessageDisplayed() {
	        return driver.findElement(accountCreatedMessage).isDisplayed();
	    }

	    public void clickContinueAfterAccountCreated() {
	        WebElement continuecreateAccountBtn = driver.findElement(continueButtonAfterSignup);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continuecreateAccountBtn);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(continuecreateAccountBtn)).click();
	    }

	    public boolean isLoggedInAsUsernameDisplayed() {
	        return driver.findElement(loggedInAsUsername).isDisplayed();
	    }

	    public void clickDeleteAccount() {
	        driver.findElement(deleteAccountButton).click();
	    }

	    public boolean isAccountDeletedMessageDisplayed() {
	        return driver.findElement(accountDeletedMessage).isDisplayed();
	    }

	    public void clickContinueAfterAccountDeleted() {
	        driver.findElement(continueButtonAfterDeletion).click();
	    }

	    public boolean isHomePageDisplayed() {
	        return driver.findElement(By.linkText("Signup / Login")).isDisplayed();
	    }

}
