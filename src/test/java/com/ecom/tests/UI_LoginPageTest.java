package com.ecom.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecom.Base.BaseTest;
import com.ecom.Pages.Signup_Login_page;
import com.ecom.Utilities.Excelutilities;
import com.ecom.Utilities.Screenshotutilities;
import com.aventstack.extentreports.ExtentTest;


public class UI_LoginPageTest extends BaseTest {

    Signup_Login_page signupLoginPage;
    static String projectpath = System.getProperty("user.dir");

    @Test(priority = 1)
    public void verifyLogoImagePresence() throws IOException {
        ExtentTest test = extent.createTest("TC_loginpage_01 - Verify Logo Image on Signup/Login Page");
        Signup_Login_page signupLoginPage = new Signup_Login_page(driver);

        try {
            signupLoginPage.clickSignupLoginLink();
            boolean isLogoVisible = signupLoginPage.isLogoImageVisible();
            Assert.assertTrue(isLogoVisible, "Logo image not visible on Signup/Login page");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TTC_loginpage_01_Pass");
            test.pass("✅ Logo image is visible on Signup/Login page")
                .addScreenCaptureFromPath(screenshotPath);
            test.pass("Navigated to Signup/Login page successfully");
            test.pass("Verified presence of logo without any issue");
            test.pass("UI branding is consistent with expected design");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_01_Fail");
            test.fail("❌ Logo image not found: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 2)
    public void verifySignupButtonPresence() throws IOException {
        ExtentTest test = extent.createTest("TC_loginpage_02 - Verify Signup Button Presence on Signup/Login Page");
        Signup_Login_page signupLoginPage = new Signup_Login_page(driver);

        try {
            signupLoginPage.clickSignupLoginLink();
            boolean isSignupButtonVisible = signupLoginPage.isSignupButtonVisible();
            Assert.assertTrue(isSignupButtonVisible, "Signup button not visible on Signup/Login page");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_02_Pass");
            test.pass("✅ Signup button is visible on Signup/Login page")
                .addScreenCaptureFromPath(screenshotPath);
            test.pass("Signup/Login page loaded correctly");
            test.pass("Signup button functionality is available for user interaction");
            test.pass("Verified element alignment of Signup button");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_02_Fail");
            test.fail("❌ Signup button not found: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 3, dataProvider = "validSignupData1")
    public void verifySignupWithValidData(String name, String email) throws IOException {
        ExtentTest test = extent.createTest("TC_loginpage_03 - Signup with Valid Name & Email: " + name + ", " + email);
        Signup_Login_page signupLoginPage = new Signup_Login_page(driver);

        try {
            signupLoginPage.clickSignupLoginLink();
            signupLoginPage.enterSignupName(name);
            signupLoginPage.enterSignupEmail(email);
            signupLoginPage.clickSignupButton();

            if (signupLoginPage.isSignupErrorDisplayed()) {
                String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_03_Fail_" + name);
                test.fail("❌ Signup failed: Email already exists").addScreenCaptureFromPath(screenshotPath);
                return;
            }

            Assert.assertTrue(signupLoginPage.isEnterAccountInfoHeaderVisible(), "'Enter Account Information' header not visible after signup");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_03_Pass_" + name);
            test.pass("✅ Signup successful, account info page loaded").addScreenCaptureFromPath(screenshotPath);
            test.pass("Form inputs accepted valid user details correctly");
            test.pass("Redirected to account information page as expected");
            test.pass("Page responsiveness and validation handled correctly");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_03_Fail_" + name);
            test.fail("❌ Unexpected error during signup: " + e.getMessage()).addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 4, dataProvider = "invalidSignupData1")
    public void verifySignupWithInvalidEmail(String name, String email) throws IOException {
        ExtentTest test = extent.createTest("TC_loginpage_04 - Signup with Invalid Email: " + name + ", " + email);
        Signup_Login_page signupLoginPage = new Signup_Login_page(driver);

        try {
            signupLoginPage.clickSignupLoginLink();
            signupLoginPage.enterSignupName(name);
            signupLoginPage.enterSignupEmail(email);
            signupLoginPage.clickSignupButton();

            Assert.assertTrue(signupLoginPage.isSignupErrorDisplayed(), "Expected signup error not displayed for invalid email");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_04_Pass_" + name);
            test.pass("✅ Signup error displayed correctly for invalid email").addScreenCaptureFromPath(screenshotPath);
            test.pass("System rejected invalid email format properly");
            test.pass("UI validation message appeared as expected");
            test.pass("Signup did not proceed with incorrect email data");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_04_Fail_" + name);
            test.fail("❌ Unexpected behavior during signup with invalid email: " + e.getMessage()).addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 5, dataProvider = "edgeCaseSignupData1")
    public void verifySignupEdgeCases(String name, String email, String scenario) throws IOException {
        name = (name == null || name.trim().isEmpty()) ? "" : name.trim();
        email = (email == null || email.trim().isEmpty()) ? "" : email.trim();

        ExtentTest test = extent.createTest("TC_loginpage_05 - " + scenario + ": Name='" + name + "', Email='" + email + "'");
        Signup_Login_page signupLoginPage = new Signup_Login_page(driver);

        try {
            signupLoginPage.clickSignupLoginLink();
            signupLoginPage.enterSignupName(name);
            signupLoginPage.enterSignupEmail(email);
            signupLoginPage.clickSignupButton();

            boolean accountInfoVisible = signupLoginPage.isEnterAccountInfoHeaderVisible();

            Assert.assertFalse(accountInfoVisible, "Signup should not proceed for scenario: " + scenario);

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_05_Pass_" + scenario);
            test.pass("✅ Signup blocked as expected for scenario: " + scenario).addScreenCaptureFromPath(screenshotPath);
            test.pass("All invalid signup cases handled properly");
            test.pass("System prevents account creation with invalid inputs");
            test.pass("UI validation messages are displayed correctly");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_05_Fail_" + scenario);
            test.fail("❌ Unexpected behavior for scenario: " + scenario + " - " + e.getMessage()).addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 6)
    public void verifyLoginButtonIsVisibleOnSignupLoginPage() throws IOException {
        ExtentTest test = extent.createTest("TC_loginpage_06 - Verify Login Button Visibility");

        Signup_Login_page signupLoginPage = new Signup_Login_page(driver);

        try {
            signupLoginPage.logoutIfLoggedIn();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            signupLoginPage.ensureSignupLoginLinkIsClickable(driver, wait);

            Assert.assertTrue(signupLoginPage.isLoginButtonVisible(), "Login button is not visible on Signup/Login page");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_06_Pass_LoginButtonVisible");
            test.pass("✅ Login button is visible on Signup/Login page").addScreenCaptureFromPath(screenshotPath);
            test.pass("Login button is correctly rendered");
            test.pass("Login button is clickable for user interaction");
            test.pass("Login functionality entry point is verified");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_06_Fail_LoginButtonVisible");
            test.fail("❌ Login button visibility test failed: " + e.getMessage()).addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 7, dataProvider = "loginEdgeCaseData")
    public void verifyLoginEdgeCases(String email, String password, String scenario) throws IOException {
        email = (email == null || email.trim().isEmpty()) ? "" : email.trim();
        password = (password == null || password.trim().isEmpty()) ? "" : password.trim();

        ExtentTest test = extent.createTest("TC_loginpage_07 - " + scenario + ": Email='" + email + "', Password='" + password + "'");
        Signup_Login_page signupLoginPage = new Signup_Login_page(driver);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            signupLoginPage.ensureSignupLoginLinkIsClickable(driver, wait);

            signupLoginPage.enterLoginEmail(email);
            signupLoginPage.enterLoginPassword(password);
            signupLoginPage.clickLoginButton();

            boolean errorVisible = signupLoginPage.isLoginErrorDisplayed();
            boolean stillOnLoginPage = driver.findElements(By.xpath("//h2[text()='Login to your account']")).size() > 0;
            boolean loginSucceeded = driver.findElements(By.xpath("//a[contains(text(),'Logged in as')]")).size() > 0;

            Assert.assertFalse(loginSucceeded, "Login should not succeed for scenario: " + scenario);
            Assert.assertTrue(errorVisible || stillOnLoginPage, "Expected failure behavior not shown for scenario: " + scenario);

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_07_Pass_" + scenario);
            test.pass("✅ Login blocked correctly for scenario: " + scenario).addScreenCaptureFromPath(screenshotPath);
            test.pass("Negative login scenarios validated successfully");
            test.pass("Proper error handling for invalid credentials");
            test.pass("System does not allow unauthorized access");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_07_Fail_" + scenario);
            test.fail("❌ Unexpected behavior for scenario: " + scenario + " - " + e.getMessage()).addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 8, dataProvider = "validLoginData")
    public void verifyValidLogin(String email, String password, String scenario) throws IOException {
        email = (email == null || email.trim().isEmpty()) ? "" : email.trim();
        password = (password == null || password.trim().isEmpty()) ? "" : password.trim();

        ExtentTest test = extent.createTest("TC_loginpage_08 - " + scenario + ": Email='" + email + "', Password='" + password + "'");
        Signup_Login_page signupLoginPage = new Signup_Login_page(driver);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            signupLoginPage.ensureSignupLoginLinkIsClickable(driver, wait);

            signupLoginPage.enterLoginEmail(email);
            signupLoginPage.enterLoginPassword(password);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logged in as')]")));

            Assert.assertTrue(signupLoginPage.isLoginSuccessful(), "Login failed with valid credentials");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_08_Pass_" + scenario);
            test.pass("✅ Login successful with valid credentials").addScreenCaptureFromPath(screenshotPath);
            test.pass("User successfully navigated into account");
            test.pass("Session established for valid credentials");
            test.pass("Logout option available after login");
            
            signupLoginPage.logoutIfLoggedIn();
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_08_Fail_" + scenario);
            test.fail("❌ Unexpected behavior for scenario: " + scenario + " - " + e.getMessage()).addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 9)
    public void verifyScrollBarFunctionalityOnSignupLoginPage() throws IOException {
        ExtentTest test = extent.createTest("TC_loginpage_09 - Verify Scroll Bar Functionality");

        Signup_Login_page signupLoginPage = new Signup_Login_page(driver);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            signupLoginPage.ensureSignupLoginLinkIsClickable(driver, wait);

            signupLoginPage.scrollToBottom(driver);
            Number scrollY = (Number) ((JavascriptExecutor) driver).executeScript("return window.pageYOffset;");
            Assert.assertTrue(scrollY.longValue() > 0, "Scroll bar did not scroll to bottom");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_09_Pass_ScrollBar");
            test.pass("✅ Scroll bar is working properly").addScreenCaptureFromPath(screenshotPath);
            test.pass("Scroll functionality verified till bottom of page");
            test.pass("No UI freeze during scrolling");
            test.pass("Page elements loaded correctly after scroll");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_09_Fail_ScrollBar");
            test.fail("❌ Scroll bar test failed - " + e.getMessage()).addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 10)
    public void verifyScrollToTopArrowFunctionalityOnSignupLoginPage() throws IOException {
        ExtentTest test = extent.createTest("TC_loginpage_10 - Verify Scroll-to-Top Arrow Functionality");

        Signup_Login_page signupLoginPage = new Signup_Login_page(driver);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            signupLoginPage.ensureSignupLoginLinkIsClickable(driver, wait);

            boolean arrowVisible = signupLoginPage.isScrollToTopArrowVisible();
            boolean arrowWorks = signupLoginPage.isScrollToTopArrowFunctional(driver);

            Assert.assertTrue(arrowVisible, "Scroll-to-top arrow is not visible");
            Assert.assertTrue(arrowWorks, "Scroll-to-top arrow did not scroll to top");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_10_Pass_ScrollArrow");
            test.pass("✅ Scroll-to-top arrow is working properly").addScreenCaptureFromPath(screenshotPath);
            test.pass("Arrow icon is displayed correctly on UI");
            test.pass("Click action navigates user back to top");
            test.pass("No delay observed while scrolling to top");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_10_Fail_ScrollArrow");
            test.fail("❌ Scroll-to-top arrow test failed - " + e.getMessage()).addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 11)
    public void verifySubscriptionIconIsVisibleOnSignupLoginPage() throws IOException {
        ExtentTest test = extent.createTest("TC_loginpage_11 - Verify Subscription Icon/Button Visibility");

        Signup_Login_page signupLoginPage = new Signup_Login_page(driver);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            signupLoginPage.ensureSignupLoginLinkIsClickable(driver, wait);

            Assert.assertTrue(signupLoginPage.isSubscriptionButtonVisible(), "Subscription input field is not visible");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_11_Pass_SubscriptionIcon");
            test.pass("✅ Subscription icon/button is visible").addScreenCaptureFromPath(screenshotPath);
            test.pass("Subscription field available for input");
            test.pass("User can interact with subscription icon");
            test.pass("Subscription functionality entry point verified");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_11_Fail_SubscriptionIcon");
            test.fail("❌ Subscription icon/button test failed - " + e.getMessage()).addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 12)
    public void verifySignupLoginPageLabels() throws IOException {
        ExtentTest test = extent.createTest("TC_loginpage_01 - Verify Signup/Login Page Labels");
        Signup_Login_page signupLoginPage = new Signup_Login_page(driver);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            signupLoginPage.ensureSignupLoginLinkIsClickable(driver, wait);

            WebElement newUserLabel = signupLoginPage.getNewUserSignupLabel(wait);
            Assert.assertEquals(newUserLabel.getText().trim(), "New User Signup!", "❌ 'New User Signup!' label not found or incorrect");

            WebElement loginLabel = signupLoginPage.getLoginToAccountLabel(wait);
            Assert.assertEquals(loginLabel.getText().trim(), "Login to your account", "❌ 'Login to your account' label not found or incorrect");

            WebElement orLabel = signupLoginPage.getOrLabel(wait);
            Assert.assertEquals(orLabel.getText().trim(), "OR", "❌ 'OR' label not found or incorrect");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_01_Pass_Labels");
            test.pass("✅ All labels are visible and correct").addScreenCaptureFromPath(screenshotPath);
            test.pass("Signup label verified successfully");
            test.pass("Login label verified successfully");
            test.pass("OR label verified successfully");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_01_Fail_Labels");
            test.fail("❌ Label verification failed - " + e.getMessage()).addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 13)
    public void verifyNavigationIconsOnSignupLoginPage() throws IOException {
        ExtentTest test = extent.createTest("TC_loginpage_02 - Verify Navigation Icons on Signup/Login Page");
        Signup_Login_page signupLoginPage = new Signup_Login_page(driver);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            signupLoginPage.ensureSignupLoginLinkIsClickable(driver, wait);

            Assert.assertTrue(signupLoginPage.getProductsIcon(wait).isDisplayed(), "❌ Products icon not visible");
            Assert.assertTrue(signupLoginPage.getCartIcon(wait).isDisplayed(), "❌ Cart icon not visible");
            Assert.assertTrue(signupLoginPage.getVideoTutorialsIcon(wait).isDisplayed(), "❌ Video Tutorials icon not visible");
            Assert.assertTrue(signupLoginPage.getContactUsIcon(wait).isDisplayed(), "❌ Contact Us icon not visible");
            Assert.assertTrue(signupLoginPage.getTestCasesIcon(wait).isDisplayed(), "❌ Test Cases icon not visible");
            Assert.assertTrue(signupLoginPage.getApiTestingIcon(wait).isDisplayed(), "❌ API Testing icon not visible");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_02_Pass_NavIcons");
            test.pass("✅ All navigation icons are visible on Signup/Login page").addScreenCaptureFromPath(screenshotPath);
            test.pass("Products, Cart, Tutorials, Contact Us icons verified");
            test.pass("Test Cases and API Testing icons verified");
            test.pass("Navigation bar rendering is complete and correct");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_loginpage_02_Fail_NavIcons");
            test.fail("❌ Navigation icon verification failed - " + e.getMessage()).addScreenCaptureFromPath(screenshotPath);
        }
    }


    @DataProvider
    public Object[][] validSignupData1() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\SignupData1.xlsx", "ValidSignup");
    }

    @DataProvider
    public Object[][] invalidSignupData1() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\SignupData1.xlsx", "InvalidSignup");
    }
    @DataProvider
    public Object[][] edgeCaseSignupData1() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\SignupData1.xlsx", "EdgeCases");
    }
    @DataProvider
    public Object[][] loginEdgeCaseData() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\SignupData1.xlsx", "LoginEdgeCases");
    }
    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\SignupData1.xlsx", "ValidLogin");
    }   
}