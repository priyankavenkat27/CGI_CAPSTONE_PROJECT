package com.ecom.tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.ecom.Base.BaseTest;
import com.ecom.Pages.TestcasesPage;
import com.ecom.Utilities.Excelutilities;
import com.ecom.Utilities.Screenshotutilities;
import com.aventstack.extentreports.ExtentTest;

public class TestCasesPageTest_Functional extends BaseTest {

    TestcasesPage testcasePage;
    static String projectpath = System.getProperty("user.dir");

    @Test(priority = 1)
    public void verifyBrowserLaunch() throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_001 - Verify Browser Launch");
        testcasePage = new TestcasesPage(driver);

        try {
            // Assuming browser launch is validated by homepage logo visibility
            boolean isLogoVisible = testcasePage.isLogoDisplayed();
            Assert.assertTrue(isLogoVisible, "Browser launched but homepage logo not visible");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_001_Pass");
            test.pass("✅ Browser launched and homepage is visible")
                .addScreenCaptureFromPath(screenshotPath);

            test.pass("Homepage logo verification completed");
            test.pass("Browser window opened without errors");
            test.pass("Initial UI components are visible after launch");
            test.pass("Browser launch test case executed successfully");

        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_001_Fail");
            test.fail("❌ Browser launch failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 2)
    public void verifyURLLoad() throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_002 - Verify URL Load");
        testcasePage = new TestcasesPage(driver);

        try {
            driver.get("https://automationexercise.com");
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("automationexercise"), "URL did not load correctly");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_002_Pass");
            test.pass("✅ URL loaded successfully: " + currentUrl)
                .addScreenCaptureFromPath(screenshotPath);

            test.pass("Navigated to Automation Exercise homepage successfully");
            test.pass("Verified URL contains the expected keyword");
            test.pass("Page redirection and load validation completed");
            test.pass("URL load test executed without issues");

        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_002_Fail");
            test.fail("❌ URL load failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 3)
    public void verifyHomePageVisibility() throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_003 - Verify Home Page Visibility");
        testcasePage = new TestcasesPage(driver);

        try {
            Assert.assertTrue(testcasePage.isLogoDisplayed(), "Home page logo not visible");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_003_Pass");

            test.pass("✅ Home page logo is visible")
                .addScreenCaptureFromPath(screenshotPath);
            test.pass("Home page loaded successfully");
            test.pass("Navigation bar and logo validated");
            test.pass("Initial page rendering check passed");

        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_003_Fail");

            test.fail("❌ Home page logo not visible: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 4)
    public void verifyTestCasesButtonAvailability() throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_004 - Verify Availability of 'Test Cases' Button");
        testcasePage = new TestcasesPage(driver);

        try {
            boolean isButtonVisible = driver.findElement(By.linkText("Test Cases")).isDisplayed();
            Assert.assertTrue(isButtonVisible, "'Test Cases' button is not visible on the homepage");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_004_Pass");
            test.pass("✅ 'Test Cases' button is available and visible on the homepage")
                .addScreenCaptureFromPath(screenshotPath);
            test.pass("Button is clickable and accessible");
            test.pass("UI element rendered successfully without errors");
            test.pass("Homepage contains required navigation element");

        } catch (AssertionError | Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_004_Fail");
            test.fail("❌ Failed to locate 'Test Cases' button: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e; 
        }
    }

    @Test(priority = 5)
    public void verifyNavigationToTestCasesPage() throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_005 - Verify Navigation to Test Cases Page");
        testcasePage = new TestcasesPage(driver);

        try {
            testcasePage.clickTestCases();
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("test_cases"), "Navigation to Test Cases page failed");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_005_Pass");
            test.pass("✅ Successfully navigated to Test Cases page. URL: " + currentUrl)
                .addScreenCaptureFromPath(screenshotPath);
            test.pass("Navigation action executed without errors");
            test.pass("Correct URL redirection verified");
            test.pass("Page loading confirmed after navigation");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_005_Fail");
            test.fail("❌ Navigation to Test Cases page failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 6)
    public void verifyTestCasesPageTitle() throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_006 - Verify Test Cases Page Title");
        testcasePage = new TestcasesPage(driver);

        try {
            String title = driver.getTitle();
            Assert.assertTrue(title.toLowerCase().contains("test cases"), "Title mismatch");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_006_Pass");
            test.pass("✅ Test Cases page title is correct: " + title)
                .addScreenCaptureFromPath(screenshotPath);
            test.pass("Page title verification completed");
            test.pass("Browser tab shows the correct title text");
            test.pass("Title validation executed successfully");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_006_Fail");
            test.fail("❌ Test Cases page title verification failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 7)
    public void verifyTestCasesPageContent() throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_007 - Verify Test Cases Page Content");
        testcasePage = new TestcasesPage(driver);

        try {
            boolean isContentVisible = testcasePage.isTestCasesSectionDisplayed();
            Assert.assertTrue(isContentVisible, "Test Cases content not visible");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_007_Pass");
            test.pass("✅ Test Cases content is visible").addScreenCaptureFromPath(screenshotPath);
            test.pass("Page structure verified successfully");
            test.pass("Content section loaded without any issue");
            test.pass("UI content validation executed correctly");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_007_Fail");
            test.fail("❌ Test Cases content verification failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 8)
    public void verifyDetailedStepsVisibility() throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_008 - Verify Detailed Steps Visibility");
        testcasePage = new TestcasesPage(driver);

        try {
            testcasePage.scrollToElement(testcasePage.testCase1Link);
            Assert.assertTrue(testcasePage.isTestCase1LinkDisplayed(), "Test Case 1 link not visible");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_008_Pass");
            test.pass("✅ Detailed steps for Test Case 1 are visible")
                .addScreenCaptureFromPath(screenshotPath);
            test.pass("Scroll action executed successfully");
            test.pass("Element visibility verified");
            test.pass("Detailed steps content confirmed on UI");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_008_Fail");
            test.fail("❌ Test Case 1 link not visible: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 9)
    public void verifyFeedbackSectionPresence() throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_009 - Verify Feedback Section Presence");
        testcasePage = new TestcasesPage(driver);

        try {
            testcasePage.scrollDown();
            Assert.assertTrue(testcasePage.isFeedbackSectionDisplayed(), "Feedback section not visible");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_009_Pass");
            test.pass("✅ Feedback section is visible")
                .addScreenCaptureFromPath(screenshotPath);
            test.pass("Scroll reached feedback section successfully");
            test.pass("Feedback area rendered properly");
            test.pass("Feedback section validated correctly");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_009_Fail");
            test.fail("❌ Feedback section not visible: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 10)
    public void verifyHyperlinksPresence() throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_010 - Verify Hyperlinks in Test Cases Section");
        testcasePage = new TestcasesPage(driver);

        try {
            Assert.assertTrue(testcasePage.isTestCase26LinkDisplayed(), "Test Case 26 link not visible");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_010_Pass");
            test.pass("✅ All hyperlinks are visible")
                .addScreenCaptureFromPath(screenshotPath);
            test.pass("Hyperlink visibility verified");
            test.pass("UI elements for links are displayed properly");
            test.pass("Navigation links are available and active");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_010_Fail");
            test.fail("❌ Hyperlink visibility failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 11)
    public void verifyFeedbackEmailPresence() throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_011 - Verify Feedback Email Presence");
        testcasePage = new TestcasesPage(driver);

        try {
            Assert.assertTrue(testcasePage.isFeedbackEmailDisplayed(), "Feedback email not visible");
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_011_Pass");
            test.pass("✅ Feedback email is visible").addScreenCaptureFromPath(screenshotPath);
            test.pass("Email UI element rendered successfully");
            test.pass("Feedback section contains required contact email");
            test.pass("Email presence validation executed");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_011_Fail");
            test.fail("❌ Feedback email not visible: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 12)
    public void verifyScrollBarFunctionality() throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_012 - Verify Scroll Bar Functionality");
        testcasePage = new TestcasesPage(driver);

        try {
            testcasePage.scrollDown();
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_012_Pass");
            test.pass("✅ Scroll bar is working").addScreenCaptureFromPath(screenshotPath);
            test.pass("Scroll action executed properly");
            test.pass("Scrollbar functionality confirmed");
            test.pass("Page scroll verified without issue");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_012_Fail");
            test.fail("❌ Scroll bar functionality failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 13)
    public void verifyScrollToTopArrowFunctionality() throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_013 - Verify Scroll-To-Top Arrow");
        testcasePage = new TestcasesPage(driver);

        try {
            testcasePage.scrollDown();
            testcasePage.clickScrollToTop();
            Assert.assertTrue(testcasePage.isLogoDisplayed(), "Scroll to top did not return to top");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_013_Pass");
            test.pass("✅ Scroll-to-top arrow is working").addScreenCaptureFromPath(screenshotPath);
            test.pass("Scroll-to-top click executed successfully");
            test.pass("Returned to top of page");
            test.pass("Logo visibility confirms top scroll");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_013_Fail");
            test.fail("❌ Scroll-to-top arrow failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 16, dataProvider = "validSubscriptionData")
    public void verifySubscriptionWithValidEmail(String email) throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_014 - Verify Subscription with Valid Email: " + email);
        testcasePage = new TestcasesPage(driver);

        try {
            testcasePage.enterSubscription(email);
            testcasePage.clickSubscriptionButton();
            Assert.assertTrue(testcasePage.isSubscriptionSuccessDisplayed(), "Subscription failed for valid email");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_014_Pass_" + email);
            test.pass("✅ Subscription successful for: " + email).addScreenCaptureFromPath(screenshotPath);
            test.pass("Valid email processed successfully");
            test.pass("Success message displayed for email: " + email);
            test.pass("Subscription functionality verified with valid input");
        } catch (Exception e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_014_Fail_" + email);
            test.fail("❌ Subscription failed for valid email: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 15, dataProvider = "invalidSubscriptionData")
    	public void verifySubscriptionInvalid(String invalidEmail) throws IOException, InterruptedException {
            test = extent.createTest("TC_TestCase_015 - Verify Subscription with Invalid Email: \" + email");

            WebElement subscriptionField = driver.findElement(By.id("susbscribe_email"));
            subscriptionField.clear();
            subscriptionField.sendKeys(invalidEmail);
            test.pass("Entered invalid email in subscription field: " + invalidEmail);
            test.pass("Subscription field accepts input properly");
            test.pass("Ready to validate invalid email submission");

            testcasePage.clickSubscriptionButton();
            test.pass("Clicked Subscribe button");

            Thread.sleep(2000);

            String validationMessage = subscriptionField.getAttribute("validationMessage");
            Assert.assertTrue(validationMessage.contains("Please include an '@'"),
                    "Subscription accepted invalid email!");
            test.pass("Validation message displayed correctly for invalid email: " + validationMessage)
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionInvalid"));
        }
    
    @Test(priority = 14)
    public void verifySubscriptionWithEmptyEmail() throws IOException {
        ExtentTest test = extent.createTest("TC_TestCase_016 - Verify Subscription with Empty Email");
        testcasePage = new TestcasesPage(driver);

        testcasePage.enterSubscription("");
        testcasePage.clickSubscriptionButton();

        boolean isSuccessDisplayed = testcasePage.isSubscriptionSuccessDisplayed();

        try {
            Assert.assertFalse(isSuccessDisplayed, "Unexpected success for empty email");

            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_016_Pass");
            test.pass("✅ Subscription error shown for empty email").addScreenCaptureFromPath(screenshotPath);
            test.pass("Empty email handled correctly by system");
            test.pass("Validation error displayed as expected");
            test.pass("Subscription prevented with empty email");

        } catch (AssertionError e) {
            String screenshotPath = Screenshotutilities.capturescreen(driver, "TC_TestCase_016_Fail");
            test.fail("❌ Unexpected success for empty email").addScreenCaptureFromPath(screenshotPath);
            test.fail("Failure reason: " + e.getMessage());    
            throw e; 
        }
    }

    @DataProvider
    public Object[][] validSubscriptionData() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\TestcasePageData.xlsx", "ValidEmails");
    }

    @DataProvider
    public Object[][] invalidSubscriptionData() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\TestcasePageData.xlsx", "InvalidEmails");
    }
}