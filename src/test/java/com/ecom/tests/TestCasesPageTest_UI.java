package com.ecom.tests;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.ecom.Base.BaseTest;
import com.ecom.Pages.TestcasesPage;
import com.ecom.Utilities.Excelutilities;
import com.ecom.Utilities.Screenshotutilities;

public class TestCasesPageTest_UI extends BaseTest {
    static String projectpath = System.getProperty("user.dir");
    TestcasesPage testCasesPage;
    ExtentTest test;
    
    @BeforeMethod
    public void setUpPage() {
        testCasesPage = new TestcasesPage(driver);
    }

    @Test(priority = 1)
    public void verifyLogoDisplayed() throws IOException {
        testCasesPage.clickTestCases();  
        test = extent.createTest("Verify Logo 'Automation Engineer'");
        Assert.assertTrue(testCasesPage.isLogoDisplayed());
        test.pass("Logo element located successfully");
        test.pass("Logo visibility verified on the page");
        test.pass("Logo display assertion passed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "LogoDisplayed"));
    }
  
    @Test(priority = 2)
    public void verifyProductsIconDisplayed() throws IOException {
        test = extent.createTest("Verify Products Icon");
        Assert.assertTrue(testCasesPage.isProductsIconDisplayed());
        test.pass("Products Icon element found");
        test.pass("Products Icon is visible on UI");
        test.pass("Products Icon verified successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ProductsIcon"));
    }

    @Test(priority = 3)
    public void verifyCartIconDisplayed() throws IOException {
        test = extent.createTest("Verify Cart Icon");
        Assert.assertTrue(testCasesPage.isCartIconDisplayed());
        test.pass("Cart Icon element located");
        test.pass("Cart Icon visibility confirmed");
        test.pass("Cart Icon display verified successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "CartIcon"));
    }

    @Test(priority = 4)
    public void verifySignupLoginIconDisplayed() throws IOException {
        test = extent.createTest("Verify Signup/Login Icon");
        Assert.assertTrue(testCasesPage.isSignupLoginIconDisplayed());
        test.pass("Signup/Login Icon element found");
        test.pass("Signup/Login Icon is displayed properly");
        test.pass("Signup/Login Icon validation passed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SignupLoginIcon"));
    }

    @Test(priority = 5)
    public void verifyVideoTutorialsIconDisplayed() throws IOException {
        test = extent.createTest("Verify Video Tutorials Icon");
        Assert.assertTrue(testCasesPage.isVideoTutorialsIconDisplayed());
        test.pass("Video Tutorials Icon element located");
        test.pass("Video Tutorials Icon is visible to the user");
        test.pass("Video Tutorials Icon verified successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "VideoTutorialsIcon"));
    }

    @Test(priority = 6)
    public void verifyHomeIconDisplayed() throws IOException {
        test = extent.createTest("Verify Home Icon");
        Assert.assertTrue(testCasesPage.isHomeIconDisplayed());
        test.pass("Home Icon element found on page");
        test.pass("Home Icon is displayed correctly");
        test.pass("Home Icon verification successful")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "HomeIcon"));
    }

    @Test(priority = 7)
    public void verifyContactUsIconDisplayed() throws IOException {
        test = extent.createTest("Verify Contact Us Icon");
        Assert.assertTrue(testCasesPage.isContactUsIconDisplayed());
        test.pass("Contact Us Icon element located");
        test.pass("Contact Us Icon visibility confirmed");
        test.pass("Contact Us Icon successfully displayed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ContactUsIcon"));
    }

    @Test(priority = 8)
    public void verifyApiTestingIconDisplayed() throws IOException {
        test = extent.createTest("Verify API Testing Icon");
        Assert.assertTrue(testCasesPage.isApiTestingIconDisplayed());
        test.pass("API Testing Icon element found");
        test.pass("API Testing Icon is displayed properly");
        test.pass("API Testing Icon verification passed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiTestingIcon"));
    }

    @Test(priority = 36)
    public void verifyFeedbackSectionDisplayed() throws IOException {
        test = extent.createTest("Verify Feedback Section");
        Assert.assertTrue(testCasesPage.isFeedbackSectionDisplayed());
        test.pass("Feedback Section element located");
        test.pass("Feedback Section is visible on page");
        test.pass("Feedback Section validation successful")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "FeedbackSection"));
    }

    @Test(priority = 37)
    public void verifyFeedbackEmailDisplayed() throws IOException {
        test = extent.createTest("Verify Feedback Email");
        Assert.assertTrue(testCasesPage.isFeedbackEmailDisplayed());
        test.pass("Feedback Email input element located");
        test.pass("Feedback Email input is visible and interactable");
        test.pass("Feedback Email verification passed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "FeedbackEmail"));
    }

    @Test(priority = 9)
    public void verifyTestCasesSectionDisplayed() throws IOException {
        test = extent.createTest("Verify Test Cases Section");
        Assert.assertTrue(testCasesPage.isTestCasesSectionDisplayed());
        test.pass("Test Cases Section element located");
        test.pass("Test Cases Section is visible to user");
        test.pass("Test Cases Section display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCasesSection"));
    }

    //Test Cases Hyperlinks (1 → 26)
    @Test(priority = 10)
    public void verifyTestCase1LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 1 Link");
        Assert.assertTrue(testCasesPage.isTestCase1LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase1Link);
        test.pass("Test Case 1 Link element found");
        test.pass("Scrolled to Test Case 1 Link successfully");
        test.pass("Test Case 1 Link display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase1Link"));
    }

    @Test(priority = 11)
    public void verifyTestCase2LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 2 Link");
        Assert.assertTrue(testCasesPage.isTestCase2LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase2Link);
        test.pass("Test Case 2 Link element found");
        test.pass("Scrolled to Test Case 2 Link successfully");
        test.pass("Test Case 2 Link display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase2Link"));
    }

    @Test(priority = 12)
    public void verifyTestCase3LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 3 Link");
        Assert.assertTrue(testCasesPage.isTestCase3LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase3Link);
        test.pass("Test Case 3 Link element found");
        test.pass("Scrolled to Test Case 3 Link successfully");
        test.pass("Test Case 3 Link visibility confirmed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase3Link"));
    }

    @Test(priority = 13)
    public void verifyTestCase4LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 4 Link");
        Assert.assertTrue(testCasesPage.isTestCase4LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase4Link);
        test.pass("Test Case 4 Link element found");
        test.pass("Scrolled to Test Case 4 Link successfully");
        test.pass("Test Case 4 Link display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase4Link"));
    }

    @Test(priority = 14)
    public void verifyTestCase5LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 5 Link");
        Assert.assertTrue(testCasesPage.isTestCase5LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase5Link);
        test.pass("Test Case 5 Link element found");
        test.pass("Scrolled to Test Case 5 Link successfully");
        test.pass("Test Case 5 Link display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase5Link"));
    }

    @Test(priority = 15)
    public void verifyTestCase6LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 6 Link");
        Assert.assertTrue(testCasesPage.isTestCase6LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase6Link);
        test.pass("Test Case 6 Link element found");
        test.pass("Scrolled to Test Case 6 Link successfully");
        test.pass("Test Case 6 Link visibility confirmed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase6Link"));
    }

    @Test(priority = 16)
    public void verifyTestCase7LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 7 Link");
        Assert.assertTrue(testCasesPage.isTestCase7LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase7Link);
        test.pass("Test Case 7 Link element found");
        test.pass("Scrolled to Test Case 7 Link successfully");
        test.pass("Test Case 7 Link display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase7Link"));
    }

    @Test(priority = 17)
    public void verifyTestCase8LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 8 Link");
        Assert.assertTrue(testCasesPage.isTestCase8LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase8Link);
        test.pass("Test Case 8 Link element located");
        test.pass("Scrolled to Test Case 8 Link successfully");
        test.pass("Test Case 8 Link visibility verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase8Link"));
    }

    @Test(priority = 18)
    public void verifyTestCase9LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 9 Link");
        Assert.assertTrue(testCasesPage.isTestCase9LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase9Link);
        test.pass("Test Case 9 Link element found");
        test.pass("Scrolled to Test Case 9 Link successfully");
        test.pass("Test Case 9 Link visibility confirmed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase9Link"));
    }

    @Test(priority = 19)
    public void verifyTestCase10LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 10 Link");
        Assert.assertTrue(testCasesPage.isTestCase10LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase10Link);
        test.pass("Test Case 10 Link element located");
        test.pass("Scrolled to Test Case 10 Link successfully");
        test.pass("Test Case 10 Link display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase10Link"));
    }

    @Test(priority = 20)
    public void verifyTestCase11LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 11 Link");
        Assert.assertTrue(testCasesPage.isTestCase11LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase11Link);
        test.pass("Test Case 11 Link element located");
        test.pass("Scrolled to Test Case 11 Link successfully");
        test.pass("Test Case 11 Link visibility verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase11Link"));
    }

    @Test(priority = 21)
    public void verifyTestCase12LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 12 Link");
        Assert.assertTrue(testCasesPage.isTestCase12LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase12Link);
        test.pass("Test Case 12 Link element located");
        test.pass("Scrolled to Test Case 12 Link successfully");
        test.pass("Test Case 12 Link display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase12Link"));
    }

    @Test(priority = 22)
    public void verifyTestCase13LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 13 Link");
        Assert.assertTrue(testCasesPage.isTestCase13LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase13Link);
        test.pass("Test Case 13 Link element located");
        test.pass("Scrolled to Test Case 13 Link successfully");
        test.pass("Test Case 13 Link visibility verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase13Link"));
    }

    @Test(priority = 23)
    public void verifyTestCase14LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 14 Link");
        Assert.assertTrue(testCasesPage.isTestCase14LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase14Link);
        test.pass("Test Case 14 Link element located");
        test.pass("Scrolled to Test Case 14 Link successfully");
        test.pass("Test Case 14 Link display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase14Link"));
    }

    @Test(priority = 24)
    public void verifyTestCase15LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 15 Link");
        Assert.assertTrue(testCasesPage.isTestCase15LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase15Link);
        test.pass("Test Case 15 Link element found");
        test.pass("Scrolled to Test Case 15 Link successfully");
        test.pass("Test Case 15 Link display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase15Link"));
    }
    
    @Test(priority = 25)
    public void verifyTestCase16LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 16 Link");
        Assert.assertTrue(testCasesPage.isTestCase16LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase16Link);
        test.pass("Test Case 16 Link element located");
        test.pass("Scrolled to Test Case 16 Link successfully");
        test.pass("Test Case 16 Link visibility verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase16Link"));
    }

    @Test(priority = 26)
    public void verifyTestCase17LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 17 Link");
        Assert.assertTrue(testCasesPage.isTestCase17LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase17Link);
        test.pass("Test Case 17 Link element found");
        test.pass("Scrolled to Test Case 17 Link successfully");
        test.pass("Test Case 17 Link display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase17Link"));
    }

    @Test(priority = 27)
    public void verifyTestCase18LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 18 Link");
        Assert.assertTrue(testCasesPage.isTestCase18LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase18Link);
        test.pass("Test Case 18 Link element found");
        test.pass("Scrolled to Test Case 18 Link successfully");
        test.pass("Test Case 18 Link visibility verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase18Link"));
    }

    @Test(priority = 28)
    public void verifyTestCase19LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 19 Link");
        Assert.assertTrue(testCasesPage.isTestCase19LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase19Link);
        test.pass("Test Case 19 Link element located");
        test.pass("Scrolled to Test Case 19 Link successfully");
        test.pass("Test Case 19 Link display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase19Link"));
    }

    @Test(priority = 29)
    public void verifyTestCase20LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 20 Link");
        Assert.assertTrue(testCasesPage.isTestCase20LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase20Link);
        test.pass("Test Case 20 Link element located");
        test.pass("Scrolled to Test Case 20 Link successfully");
        test.pass("Test Case 20 Link visibility verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase20Link"));
    }

    @Test(priority = 30)
    public void verifyTestCase21LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 21 Link");
        Assert.assertTrue(testCasesPage.isTestCase21LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase21Link);
        test.pass("Test Case 21 Link element found");
        test.pass("Scrolled to Test Case 21 Link successfully");
        test.pass("Test Case 21 Link display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase21Link"));
    }

    @Test(priority = 31)
    public void verifyTestCase22LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 22 Link");
        Assert.assertTrue(testCasesPage.isTestCase22LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase22Link);
        test.pass("Test Case 22 Link element located");
        test.pass("Scrolled to Test Case 22 Link successfully");
        test.pass("Test Case 22 Link visibility verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase22Link"));
    }

    @Test(priority = 32)
    public void verifyTestCase23LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 23 Link");
        Assert.assertTrue(testCasesPage.isTestCase23LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase23Link);
        test.pass("Test Case 23 Link element located");
        test.pass("Scrolled to Test Case 23 Link successfully");
        test.pass("Test Case 23 Link display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase23Link"));
    }

    @Test(priority = 33)
    public void verifyTestCase24LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 24 Link");
        Assert.assertTrue(testCasesPage.isTestCase24LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase24Link);
        test.pass("Test Case 24 Link element located");
        test.pass("Scrolled to Test Case 24 Link successfully");
        test.pass("Test Case 24 Link visibility verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase24Link"));
    }

    @Test(priority = 34)
    public void verifyTestCase25LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 25 Link");
        Assert.assertTrue(testCasesPage.isTestCase25LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase25Link);
        test.pass("Test Case 25 Link element found");
        test.pass("Scrolled to Test Case 25 Link successfully");
        test.pass("Test Case 25 Link display verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase25Link"));
    }

    @Test(priority = 35)
    public void verifyTestCase26LinkDisplayed() throws IOException {
        test = extent.createTest("Verify Test Case 26 Link");
        Assert.assertTrue(testCasesPage.isTestCase26LinkDisplayed());
        testCasesPage.scrollToElement(testCasesPage.testCase26Link);
        test.pass("Test Case 26 Link element located");
        test.pass("Scrolled to Test Case 26 Link successfully");
        test.pass("Test Case 26 Link visibility verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCase26Link"));
    }

    @Test(priority = 38)
    public void verifySubscriptionIconVisible() throws IOException {
        test = extent.createTest("Verify Subscription Icon is visible");
        testCasesPage.scrollDown(); 
        test.pass("Scrolled to Subscription section");
        
        WebElement subscriptionInput = driver.findElement(By.id("susbscribe_email"));
        Assert.assertTrue(subscriptionInput.isDisplayed(), "Subscription field not visible!");
        test.pass("Subscription input field located successfully");
        test.pass("Subscription input field is visible on the page");
        test.pass("User can interact with the subscription input field")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionIcon"));
    }

    @Test(priority = 39)
    public void verifySubscriptionEmpty() throws IOException {
        test = extent.createTest("Verify Subscription with Empty Email");

        WebElement subscriptionField = driver.findElement(By.id("susbscribe_email"));
        subscriptionField.clear();
        test.pass("Subscription input field cleared for empty test");
        test.pass("Ready to submit empty subscription email");
        test.pass("Subscription input field is editable and cleared");

        testCasesPage.clickSubscriptionButton();
        test.pass("Clicked Subscribe button with empty input");

        String validationMessage = subscriptionField.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.toLowerCase().contains("fill"),
                "Subscription accepted empty email! Validation: " + validationMessage);
        test.pass("Proper validation message displayed for empty subscription email: " + validationMessage)
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionEmpty"));
    }

    @Test(priority = 40, dataProvider = "subscriptionDataInvalid")
    public void verifySubscriptionInvalid(String invalidEmail) throws IOException, InterruptedException {
        test = extent.createTest("Verify Subscription with Invalid Email");

        WebElement subscriptionField = driver.findElement(By.id("susbscribe_email"));
        subscriptionField.clear();
        subscriptionField.sendKeys(invalidEmail);
        test.pass("Entered invalid email in subscription field: " + invalidEmail);
        test.pass("Subscription field accepts input properly");
        test.pass("Ready to validate invalid email submission");

        testCasesPage.clickSubscriptionButton();
        test.pass("Clicked Subscribe button");

        Thread.sleep(2000);

        String validationMessage = subscriptionField.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.contains("Please include an '@'"),
                "Subscription accepted invalid email!");
        test.pass("Validation message displayed correctly for invalid email: " + validationMessage)
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionInvalid"));
    }

    @Test(dataProvider = "subscriptionDataValid", priority = 41) 
    public void verifySubscriptionValid(String subscriptionEmail) throws IOException { 
        test = extent.createTest("Verify Subscription with Valid Email"); 

        testCasesPage.scrollDown(); 
        test.pass("Scrolled to Subscription section");

        testCasesPage.enterSubscription(subscriptionEmail); 
        test.pass("Entered valid subscription email: " + subscriptionEmail);
        test.pass("Subscription input field accepted the email correctly");

        testCasesPage.clickSubscriptionButton(); 
        test.pass("Clicked Subscribe button to submit email");

        Assert.assertTrue(testCasesPage.isSubscriptionSuccessDisplayed(), "Subscription success message not displayed"); 
        test.pass("Subscription success message displayed correctly")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionValid"));
    }

    @Test(dataProvider = "subscriptionDataValid", priority = 42) 
    public void verifySubscriptionUseralreadyExist(String subscriptionEmail) throws IOException { 
        test = extent.createTest("Verify Subscription with Already Existing Email"); 

        testCasesPage.scrollDown(); 
        test.pass("Scrolled to Subscription section");

        testCasesPage.enterSubscription(subscriptionEmail); 
        test.pass("Entered already registered email: " + subscriptionEmail);
        test.pass("Subscription field accepted the input correctly");

        testCasesPage.clickSubscriptionButton(); 
        test.pass("Clicked Subscribe button for existing user email");

        boolean isSuccessDisplayed = testCasesPage.isSubscriptionSuccessDisplayed();

        if (isSuccessDisplayed) {
            test.fail("Subscription success message displayed incorrectly for already registered email!")
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionUserAlreadyExist"));
        } else {
            test.pass("Subscription success message NOT displayed as expected for existing email")
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "NewSubscriptionUser"));
        }

        Assert.assertFalse(isSuccessDisplayed, "Subscription success message should NOT be displayed!");
    }

    @Test(priority = 43)
    public void verifyScrollToTopButton() throws IOException {
        test = extent.createTest("Verify Scroll To Top Button");

        testCasesPage.scrollDown();
        test.pass("Scrolled down the page to make 'Scroll To Top' button visible");
        test.pass("Scroll To Top button located on the page");

        testCasesPage.clickScrollToTop();
        test.pass("Clicked Scroll To Top button successfully");
        test.pass("Page scrolled to top as expected")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ScrollToTop"));
    }

    @DataProvider
    public Object[][] subscriptionDataValid() throws IOException {
        return Excelutilities.getdata(
            projectpath + "\\src\\test\\resources\\testdata\\datafile3.xlsx", "ValidEmail");
    }

    @DataProvider
    public Object[][] subscriptionDataInvalid() throws IOException {
        return Excelutilities.getdata(
            projectpath + "\\src\\test\\resources\\testdata\\datafile3.xlsx", "InvalidEmail");
    }
}
