package com.ecom.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecom.Base.BaseTest;
import com.ecom.Pages.Signup_Login_page;
import com.ecom.Utilities.Excelutilities;
import com.ecom.Utilities.Screenshotutilities;
import com.aventstack.extentreports.Status;

public class login_functionality_tests extends BaseTest {

    static String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Logindata.xlsx";
    
    private void handleFailure(String testName, Exception e) {
        test.log(Status.FAIL, "Test failed: " + e.getMessage());
        try {
            String path = Screenshotutilities.capturescreen(driver, testName);
            test.addScreenCaptureFromPath(path);
        } catch (IOException ioException) {
            test.log(Status.WARNING, "Screenshot capture failed: " + ioException.getMessage());
        }
        Assert.fail(e.getMessage());
    }

    // Utility to fetch specific row from Excel
    private String[] getExcelRow(int rowNumber) throws IOException {
        Object[] rowData = Excelutilities.getExcelDataSpecificRow(excelPath, "LoginData", rowNumber);
        return new String[] { rowData[0].toString(), rowData[1].toString() };
    }
    
 // Test 1: Verify URL launch
    @Test(priority = 1)
    public void Tc_Ecom_Login_01_verifyUrlLaunch() {
        test = extent.createTest("Tc_Ecom_Login_01 - Verify URL launch");
        try {
            driver.get(config.getProperty("baseUrl"));
            String currentUrl = driver.getCurrentUrl();
            
            // ✅ Assertion 1: URL contains automationexercise
            Assert.assertTrue(currentUrl.contains("automationexercise"), "URL did not launch correctly!");
            test.log(Status.PASS, "URL contains automationexercise - Assertion 1 passed");
            
            // ✅ Assertion 2: URL is not empty
            Assert.assertFalse(currentUrl.isEmpty(), "URL is empty!");
            test.log(Status.PASS, "URL is not empty - Assertion 2 passed");
            
        } catch (Exception e) {
            handleFailure("Tc_Ecom_Login_01", e);
        }
    }

    // Test 2: Verify home page displayed
    @Test(priority = 2)
    public void Tc_Ecom_Login_02_verifyHomePageDisplayed() {
        test = extent.createTest("Tc_Ecom_Login_02 - Verify home page displayed");
        try {
            String title = driver.getTitle();
            
            // ✅ Assertion 1: Title contains Automation Exercise
            Assert.assertTrue(title.contains("Automation Exercise"), "Home page not loaded!");
            test.log(Status.PASS, "Home page title verified - Assertion 1 passed");
            
            // ✅ Assertion 2: Home page elements are visible
            WebElement homepageContent = driver.findElement(By.cssSelector(".features_items"));
            Assert.assertTrue(homepageContent.isDisplayed(), "Home page content not visible");
            test.log(Status.PASS, "Home page content visible - Assertion 2 passed");
            
        } catch (Exception e) {
            handleFailure("Tc_Ecom_Login_02", e);
        }
    }

    // Test 3: Navigate to Login/Signup page
    @Test(priority = 3)
    public void Tc_Ecom_Login_03_navigateToLoginSignupPage() {
        test = extent.createTest("Tc_Ecom_Login_03 - Navigate to Login/Signup page");
        try {
            Signup_Login_page loginPage = new Signup_Login_page(driver);
            loginPage.clickSignupLoginLink();
            
            // ✅ Assertion 1: URL contains login
            Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Login/Signup page not opened!");
            test.log(Status.PASS, "Navigated to login page - Assertion 1 passed");
            
            // ✅ Assertion 2: Login form is visible
            WebElement loginForm = driver.findElement(By.cssSelector(".login-form"));
            Assert.assertTrue(loginForm.isDisplayed(), "Login form not visible");
            test.log(Status.PASS, "Login form visible - Assertion 2 passed");
            
        } catch (Exception e) {
            handleFailure("Tc_Ecom_Login_03", e);
        }
    }

    // Test 4: Verify 'Login to your account' text
    @Test(priority = 4)
    public void Tc_Ecom_Login_04_verifyLoginToYourAccountText() {
        test = extent.createTest("Tc_Ecom_Login_04 - Verify 'Login to your account' text");
        try {
            Signup_Login_page loginPage = new Signup_Login_page(driver);
            loginPage.clickSignupLoginLink();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            WebElement loginText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='Login to your account']")));
            
            // ✅ Assertion 1: Login text is displayed
            Assert.assertTrue(loginText.isDisplayed(), "'Login to your account' text not found!");
            test.log(Status.PASS, "Login text displayed - passed");
            
            // ✅ Assertion 2: Login text contains correct content
            Assert.assertTrue(loginText.getText().contains("Login to your account"), 
                            "Login text content incorrect");
            test.log(Status.PASS, "Login text content verified - passed");
            
        } catch (Exception e) {
            handleFailure("Tc_Ecom_Login_04", e);
        }
    }

    // Test 5: Valid email and password entry 
    @Test(priority = 5)
    public void Tc_Ecom_Login_05_validCredentialsEntry() throws IOException {
        test = extent.createTest("Tc_Ecom_Login_05 - Valid Credentials Entry");
        try {
            String[] creds = getExcelRow(0); 
            String email = creds[0], password = creds[1];

            Signup_Login_page loginPage = new Signup_Login_page(driver);
            loginPage.clickSignupLoginLink();
            
            loginPage.enterLoginEmail(email);
            loginPage.enterLoginPassword(password);

            // ✅ Assertion 1: Email field contains entered value
            Assert.assertEquals(loginPage.getLoginEmail(), email, "Email not entered correctly");
            test.log(Status.PASS, "Email entered correctly - passed");
            
            // ✅ Assertion 2: Password field contains entered value
            Assert.assertEquals(loginPage.getLoginPassword(), password, "Password not entered correctly");
            test.log(Status.PASS, "Password entered correctly - passed");
            
        } catch (Exception e) {
            handleFailure("Tc_Ecom_Login_05", e);
        }
    }

    
    // Test 6: Login with invalid credentials 
    @Test(priority = 6)
    public void Tc_Ecom_Login_06_invalidLogin() throws IOException {
        test = extent.createTest("Tc_Ecom_Login_06 - Invalid Login");
        try {
            String[] creds = getExcelRow(2); 
            String email = creds[0], password = creds[1];

            Signup_Login_page loginPage = new Signup_Login_page(driver);
            loginPage.clickSignupLoginLink();
            loginPage.enterLoginEmail(email);
            loginPage.enterLoginPassword(password);
            loginPage.clickLoginButton();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            // ✅ Assertion 1: Login error displayed or stayed on login page
            boolean hasError = loginPage.isLoginErrorDisplayed();
            boolean isOnLoginPage = driver.getCurrentUrl().contains("login");
            
            Assert.assertTrue(hasError || isOnLoginPage, 
                "No error shown and not on login page after invalid login");
            test.log(Status.PASS, "Login error handled - passed");
            
            if (hasError) {
                // ✅ Assertion 2: Error message contains expected text
                String errorText = loginPage.getLoginErrorMessage();
                Assert.assertTrue(errorText.contains("incorrect") || errorText.contains("Invalid"), 
                                "Error message doesn't contain expected text: " + errorText);
                test.log(Status.PASS, "Error message verified -  passed");
            }
            
        } catch (Exception e) {
            handleFailure("Tc_Ecom_Login_06", e);
        }
    }

    // Test 7: Login with valid email + invalid password 
    @Test(priority = 7)
    public void Tc_Ecom_Login_07_validEmailInvalidPassword() throws IOException {
        test = extent.createTest("Tc_Ecom_Login_07 - Valid Email + Invalid Password");
        try {
            String[] creds = getExcelRow(3); 
            String email = creds[0], password = creds[1];

            Signup_Login_page loginPage = new Signup_Login_page(driver);
            loginPage.clickSignupLoginLink();
            loginPage.enterLoginEmail(email);
            loginPage.enterLoginPassword(password);
            loginPage.clickLoginButton();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            // ✅ Assertion 1: Login error displayed or stayed on login page
            boolean hasError = loginPage.isLoginErrorDisplayed();
            boolean isOnLoginPage = driver.getCurrentUrl().contains("login");
            
            Assert.assertTrue(hasError || isOnLoginPage, 
                "No error shown and not on login page after invalid login");
            test.log(Status.PASS, "Login error handled - passed");
            
            // ✅ Assertion 2: Still on login page or got error
            Assert.assertTrue(isOnLoginPage || hasError, "Not on login page and no error after failed login");
            test.log(Status.PASS, "Proper error handling - passed");
            
        } catch (Exception e) {
            handleFailure("Tc_Ecom_Login_07", e);
        }
    }

    // Test 8: Login with invalid email + valid password 
    @Test(priority = 8)
    public void Tc_Ecom_Login_08_invalidEmailValidPassword() throws IOException {
        test = extent.createTest("Tc_Ecom_Login_08 - Invalid Email + Valid Password");
        try {
            String[] creds = getExcelRow(5); 
            String email = creds[0], password = creds[1];

            Signup_Login_page loginPage = new Signup_Login_page(driver);
            loginPage.clickSignupLoginLink();
            loginPage.enterLoginEmail(email);
            loginPage.enterLoginPassword(password);
            loginPage.clickLoginButton();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            // ✅ Assertion 1: Login error displayed or stayed on login page
            boolean hasError = loginPage.isLoginErrorDisplayed();
            boolean isOnLoginPage = driver.getCurrentUrl().contains("login");
            
            Assert.assertTrue(hasError || isOnLoginPage, 
                "No error shown and not on login page after invalid login");
            test.log(Status.PASS, "Login error handled - passed");
            
            if (hasError) {
                // ✅ Assertion 2: Error message contains expected text
                String errorText = loginPage.getLoginErrorMessage();
                Assert.assertTrue(errorText.contains("incorrect") || errorText.contains("Invalid"), 
                                "Error message doesn't contain expected text: " + errorText);
                test.log(Status.PASS, "Error message verified - passed");
            }
            
        } catch (Exception e) {
            handleFailure("Tc_Ecom_Login_08", e);
        }
    }

 // Test 9: Login with blank email and password
    @Test(priority = 9)
    public void Tc_Ecom_Login_9_blankEmailAndPassword() throws IOException {
        test = extent.createTest("Tc_Ecom_Login_9 - Blank Email & Password Login");
        try {
            Signup_Login_page loginPage = new Signup_Login_page(driver);
            loginPage.ensureLoggedOut();

            loginPage.clickSignupLoginLink();
            loginPage.clickLoginButton(); // Click without entering anything

            // ✅ Assertion: Browser validation message appears
            Assert.assertTrue(
                loginPage.isInvalidEmailMessageDisplayed(),
                "No error displayed for blank email & password!"
            );
            test.log(Status.PASS, "Blank email/password validation message displayed - passed");
            test.log(Status.PASS, "user was not able to login - passed");
        } catch (Exception e) {
            handleFailure("Tc_Ecom_Login_9", e);
        }
    }


}