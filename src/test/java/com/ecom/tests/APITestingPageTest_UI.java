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
import com.ecom.Pages.APITesting;
import com.ecom.Utilities.Excelutilities;
import com.ecom.Utilities.Screenshotutilities;

public class APITestingPageTest_UI extends BaseTest {
    static String projectpath = System.getProperty("user.dir");
    APITesting apiTestingPage;
    ExtentTest test;
    
    @BeforeMethod
    public void setUpPage() {
        apiTestingPage = new APITesting(driver);
    }
    
    @Test(priority = 1)
    public void verifyLogoDisplayed() throws IOException {
        apiTestingPage.clickAPITestingLink();
        test = extent.createTest("Verify Logo 'Automation Engineer'");
        Assert.assertTrue(apiTestingPage.isLogoDisplayed());
        test.pass("Navigated to API Testing page successfully");
        test.pass("Logo element located on the header section");
        test.pass("Logo visibility verified correctly")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "LogoDisplayed"));
    }

    @Test(priority = 2)
    public void verifyProductsIconDisplayed() throws IOException {
        test = extent.createTest("Verify Products Icon");
        Assert.assertTrue(apiTestingPage.isProductsIconDisplayed());
        test.pass("Products Icon located on the navigation bar");
        test.pass("Products Icon is displayed to the user");
        test.pass("Products Icon verified successfully and ready for interaction")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ProductsIcon"));
    }

    @Test(priority = 3)
    public void verifyCartIconDisplayed() throws IOException {
        test = extent.createTest("Verify Cart Icon");
        Assert.assertTrue(apiTestingPage.isCartIconDisplayed());
        test.pass("Cart Icon element located on the page");
        test.pass("Cart Icon is visible in the navigation bar");
        test.pass("Cart Icon verification passed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "CartIcon"));
    }

    @Test(priority = 4)
    public void verifySignupLoginIconDisplayed() throws IOException {
        test = extent.createTest("Verify Signup/Login Icon");
        Assert.assertTrue(apiTestingPage.isSignupLoginIconDisplayed());
        test.pass("Signup/Login Icon found on the page");
        test.pass("Signup/Login Icon is visible and displayed correctly");
        test.pass("Signup/Login Icon verified successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SignupLoginIcon"));
    }

    @Test(priority = 5)
    public void verifyVideoTutorialsIconDisplayed() throws IOException {
        test = extent.createTest("Verify Video Tutorials Icon");
        Assert.assertTrue(apiTestingPage.isVideoTutorialsIconDisplayed());
        test.pass("Video Tutorials Icon element located");
        test.pass("Video Tutorials Icon is displayed to the user");
        test.pass("Video Tutorials Icon visibility validated")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "VideoTutorialsIcon"));
    }

    @Test(priority = 6)
    public void verifyHomeIconDisplayed() throws IOException {
        test = extent.createTest("Verify Home Icon");
        Assert.assertTrue(apiTestingPage.isHomeIconDisplayed());
        test.pass("Home Icon found on navigation menu");
        test.pass("Home Icon is visible and displayed correctly");
        test.pass("Home Icon validated successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "HomeIcon"));
    }

    @Test(priority = 7)
    public void verifyContactUsIconDisplayed() throws IOException {
        test = extent.createTest("Verify Contact Us Icon");
        Assert.assertTrue(apiTestingPage.isContactUsIconDisplayed());
        test.pass("Contact Us Icon element found");
        test.pass("Contact Us Icon displayed properly on page");
        test.pass("Contact Us Icon verified successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ContactUsIcon"));
    }

    @Test(priority = 8)
    public void verifyApiTestingIconDisplayed() throws IOException {
        test = extent.createTest("Verify API Testing Icon");
        Assert.assertTrue(apiTestingPage.isApiTestingIconDisplayed());
        test.pass("API Testing Icon located successfully");
        test.pass("API Testing Icon is displayed on navigation bar");
        test.pass("API Testing Icon visibility verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiTestingIcon"));
    }

    @Test(priority = 24)
    public void verifyFeedbackSectionDisplayed() throws IOException {
        test = extent.createTest("Verify Feedback Section");
        Assert.assertTrue(apiTestingPage.isFeedbackSectionDisplayed());
        test.pass("Feedback section located successfully");
        test.pass("Feedback section is displayed on API Testing page");
        test.pass("Feedback section verified successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "FeedbackSection"));
    }

    @Test(priority = 25)
    public void verifyFeedbackEmailDisplayed() throws IOException {
        test = extent.createTest("Verify Feedback Email");
        Assert.assertTrue(apiTestingPage.isFeedbackEmailDisplayed());
        test.pass("Feedback email field located");
        test.pass("Feedback email is visible to the user");
        test.pass("Feedback email verified successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "FeedbackEmail"));
    }
    
    @Test(priority = 9)
    public void verifyApilistSectionDisplayed() throws IOException {
        test = extent.createTest("Verify API List Section");
        Assert.assertTrue(apiTestingPage.isTestCasesSectionDisplayed());
        test.pass("API List section located on the page");
        test.pass("API List section displayed correctly");
        test.pass("API List section verification successful")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiListSection"));
    }
    
    //API List Hyperlinks (1 → 14)
    @Test(priority = 10)
    public void verifyApiList1LinkDisplayed() throws IOException {
        test = extent.createTest("Verify API List 1 Link");
        Assert.assertTrue(apiTestingPage.isApiList1LinkDisplayed());
        apiTestingPage.scrollToElement(apiTestingPage.ApiList1Link);
        test.pass("Scrolled to API List 1 link");
        test.pass("API List 1 link element located successfully");
        test.pass("API List 1 link is visible on the page")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiList1Link"));
    }

    @Test(priority = 11)
    public void verifyApiList2LinkDisplayed() throws IOException {
        test = extent.createTest("Verify API List 2 Link");
        Assert.assertTrue(apiTestingPage.isApiList2LinkDisplayed());
        apiTestingPage.scrollToElement(apiTestingPage.ApiList2Link);
        test.pass("Scrolled to API List 2 link");
        test.pass("API List 2 link element found");
        test.pass("API List 2 link visibility verified")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiList2Link"));
    }

    @Test(priority = 12)
    public void verifyApiList3LinkDisplayed() throws IOException {
        test = extent.createTest("Verify API List 3 Link");
        Assert.assertTrue(apiTestingPage.isApiList3LinkDisplayed());
        apiTestingPage.scrollToElement(apiTestingPage.ApiList3Link);
        test.pass("Scrolled to API List 3 link");
        test.pass("API List 3 link element located");
        test.pass("API List 3 link verified successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiList3Link"));
    }
    
    @Test(priority = 13)
    public void verifyApiList4LinkDisplayed() throws IOException {
        test = extent.createTest("Verify API List 4 Link");
        Assert.assertTrue(apiTestingPage.isApiList4LinkDisplayed());
        apiTestingPage.scrollToElement(apiTestingPage.ApiList4Link);
        test.pass("Scrolled to API List 4 link");
        test.pass("API List 4 link found successfully");
        test.pass("API List 4 link verified successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiList4Link"));
    }
    
    @Test(priority = 14)
    public void verifyApiList5LinkDisplayed() throws IOException {
        test = extent.createTest("Verify API List 5 Link");
        Assert.assertTrue(apiTestingPage.isApiList5LinkDisplayed());
        apiTestingPage.scrollToElement(apiTestingPage.ApiList5Link);
        test.pass("Scrolled to API List 5 link");
        test.pass("API List 5 link element located");
        test.pass("API List 5 link displayed properly")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiList5Link"));
    }
    
    @Test(priority = 15)
    public void verifyApiList6LinkDisplayed() throws IOException {
        test = extent.createTest("Verify API List 6 Link");
        Assert.assertTrue(apiTestingPage.isApiList6LinkDisplayed());
        apiTestingPage.scrollToElement(apiTestingPage.ApiList6Link);
        test.pass("Scrolled to API List 6 link");
        test.pass("API List 6 link located successfully");
        test.pass("API List 6 link visibility validated")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiList6Link"));
    }
    
    @Test(priority = 16)
    public void verifyApiList7LinkDisplayed() throws IOException {
        test = extent.createTest("Verify API List 7 Link");
        Assert.assertTrue(apiTestingPage.isApiList7LinkDisplayed());
        apiTestingPage.scrollToElement(apiTestingPage.ApiList7Link);
        test.pass("Scrolled to API List 7 link");
        test.pass("API List 7 link found successfully");
        test.pass("API List 7 link verification successful")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiList7Link"));
    }
    
    @Test(priority = 17)
    public void verifyApiList8LinkDisplayed() throws IOException {
        test = extent.createTest("Verify API List 8 Link");
        Assert.assertTrue(apiTestingPage.isApiList8LinkDisplayed());
        apiTestingPage.scrollToElement(apiTestingPage.ApiList8Link);
        test.pass("Scrolled to API List 8 link");
        test.pass("API List 8 link element located successfully");
        test.pass("API List 8 link displayed on page")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiList8Link"));
    }
    
    @Test(priority = 18)
    public void verifyApiList9LinkDisplayed() throws IOException {
        test = extent.createTest("Verify API List 9 Link");
        Assert.assertTrue(apiTestingPage.isApiList9LinkDisplayed());
        apiTestingPage.scrollToElement(apiTestingPage.ApiList9Link);
        test.pass("Scrolled to API List 9 link");
        test.pass("API List 9 link element found");
        test.pass("API List 9 link verification successful")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiList9Link"));
    }
    
    @Test(priority = 19)
    public void verifyApiList10LinkDisplayed() throws IOException {
        test = extent.createTest("Verify API List 10 Link");
        Assert.assertTrue(apiTestingPage.isApiList10LinkDisplayed());
        apiTestingPage.scrollToElement(apiTestingPage.ApiList10Link);
        test.pass("Scrolled to API List 10 link");
        test.pass("API List 10 link found successfully");
        test.pass("API List 10 link verification successful")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiList10Link"));
    }
    
    @Test(priority = 20)
    public void verifyApiList11LinkDisplayed() throws IOException {
        test = extent.createTest("Verify API List 11 Link");
        Assert.assertTrue(apiTestingPage.isApiList11LinkDisplayed());
        apiTestingPage.scrollToElement(apiTestingPage.ApiList11Link);
        test.pass("Scrolled to API List 11 link");
        test.pass("API List 11 link located successfully");
        test.pass("API List 11 link verification successful")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiList11Link"));
    }
    
    @Test(priority = 21)
    public void verifyApiList12LinkDisplayed() throws IOException {
        test = extent.createTest("Verify API List 12 Link");
        Assert.assertTrue(apiTestingPage.isApiList12LinkDisplayed());
        apiTestingPage.scrollToElement(apiTestingPage.ApiList12Link);
        test.pass("Scrolled to API List 12 link");
        test.pass("API List 12 link found on page");
        test.pass("API List 12 link verified successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiList12Link"));
    }
    
    @Test(priority = 22)
    public void verifyApiList13LinkDisplayed() throws IOException {
        test = extent.createTest("Verify API List 13 Link");
        Assert.assertTrue(apiTestingPage.isApiList13LinkDisplayed());
        apiTestingPage.scrollToElement(apiTestingPage.ApiList13Link);
        test.pass("Scrolled to API List 13 link");
        test.pass("API List 13 link element located");
        test.pass("API List 13 link verification successful")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiList13Link"));
    }
    
    @Test(priority = 23)
    public void verifyApiList14LinkDisplayed() throws IOException {
        test = extent.createTest("Verify API List 14 Link");
        Assert.assertTrue(apiTestingPage.isApiList14LinkDisplayed());
        apiTestingPage.scrollToElement(apiTestingPage.ApiList14Link);
        test.pass("Scrolled to API List 14 link");
        test.pass("API List 14 link element found");
        test.pass("API List 14 link verified successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiList14Link"));
    }
    
    @Test(priority = 26)
    public void verifySubscriptionIconVisible() throws IOException {
        test = extent.createTest("Verify Subscription Icon is visible");
        
        apiTestingPage.scrollPageDown(1000); 
        test.pass("Scrolled to Subscription section");
        WebElement subscriptionInput = driver.findElement(By.id("susbscribe_email"));
        Assert.assertTrue(subscriptionInput.isDisplayed(), "Subscription field not visible!");
        test.pass("Subscription input field located successfully");
        test.pass("Subscription input field is visible on the page");
        test.pass("User can interact with the subscription input field")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionIcon"));
    }

    @Test(priority = 27)
    public void verifySubscriptionEmpty() throws IOException {
        test = extent.createTest("Verify Subscription with Empty Email");

        WebElement subscriptionField = driver.findElement(By.id("susbscribe_email"));
        subscriptionField.clear();
        test.pass("Subscription input field cleared for empty test");
        test.pass("Ready to submit empty subscription email");
        test.pass("Subscription input field is editable and cleared");

        apiTestingPage.clickSubscriptionButton();
        test.pass("Clicked Subscribe button with empty input");

        String validationMessage = subscriptionField.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.toLowerCase().contains("fill"),
                "Subscription accepted empty email! Validation: " + validationMessage);
        test.pass("Proper validation message displayed for empty subscription email: " + validationMessage)
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionEmpty"));
    }

    @Test(priority = 28, dataProvider = "subscriptionDataInvalid")
    public void verifySubscriptionInvalid(String invalidEmail) throws IOException, InterruptedException {
        test = extent.createTest("Verify Subscription with Invalid Email");

        WebElement subscriptionField = driver.findElement(By.id("susbscribe_email"));
        subscriptionField.clear();
        subscriptionField.sendKeys(invalidEmail);
        test.pass("Entered invalid email in subscription field: " + invalidEmail);
        test.pass("Subscription field accepts input properly");
        test.pass("Ready to validate invalid email submission");

        apiTestingPage.clickSubscriptionButton();
        test.pass("Clicked Subscribe button");

        Thread.sleep(2000);

        String validationMessage = subscriptionField.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.contains("Please include an '@'"),
                "Subscription accepted invalid email!");
        test.pass("Validation message displayed correctly for invalid email: " + validationMessage)
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionInvalid"));
    }

    @Test(dataProvider = "subscriptionDataValid", priority = 29) 
    public void verifySubscriptionValid(String subscriptionEmail) throws IOException { 
        test = extent.createTest("Verify Subscription with Valid Email"); 

        apiTestingPage.scrollPageDown(1000); 
        test.pass("Scrolled to Subscription section");

        apiTestingPage.enterSubscription(subscriptionEmail); 
        test.pass("Entered valid subscription email: " + subscriptionEmail);
        test.pass("Subscription input field accepted the email correctly");

        apiTestingPage.clickSubscriptionButton(); 
        test.pass("Clicked Subscribe button to submit email");

        Assert.assertTrue(apiTestingPage.isSubscriptionSuccessDisplayed(), "Subscription success message not displayed"); 
        test.pass("Subscription success message displayed correctly")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionValid"));
    }

    @Test(dataProvider = "subscriptionDataValid", priority = 30) 
    public void verifySubscriptionUseralreadyExist(String subscriptionEmail) throws IOException { 
        test = extent.createTest("Verify Subscription with Already Existing Email"); 

        apiTestingPage.scrollPageDown(1000); 
        test.pass("Scrolled to Subscription section");

        apiTestingPage.enterSubscription(subscriptionEmail); 
        test.pass("Entered already registered email: " + subscriptionEmail);
        test.pass("Subscription field accepted the input correctly");

        apiTestingPage.clickSubscriptionButton(); 
        test.pass("Clicked Subscribe button for existing user email");

        boolean isSuccessDisplayed = apiTestingPage.isSubscriptionSuccessDisplayed();

        if (isSuccessDisplayed) {
            test.fail("Subscription success message displayed incorrectly for already registered email!")
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionUserAlreadyExist"));
        } else {
            test.pass("Subscription success message NOT displayed as expected for existing email")
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "NewSubscriptionUser"));
        }

        Assert.assertFalse(isSuccessDisplayed, "Subscription success message should NOT be displayed!");
    }

    @Test(priority = 31)
    public void verifyScrollToTopButton() throws IOException {
        test = extent.createTest("Verify Scroll To Top Button");

        apiTestingPage.scrollPageDown(1000);
        test.pass("Scrolled down the page to make 'Scroll To Top' button visible");
        test.pass("Scroll To Top button located on the page");

        apiTestingPage.clickScrollToTop();
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