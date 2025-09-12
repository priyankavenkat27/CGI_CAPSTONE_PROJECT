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
import com.ecom.Pages.HomePage;
import com.ecom.Utilities.Excelutilities;
import com.ecom.Utilities.Screenshotutilities;

public class SubscriptionHomePageTest_Functional extends BaseTest {

    static String projectpath = System.getProperty("user.dir");
    HomePage subscriptionPage;
    ExtentTest test;
    
    @BeforeMethod
    public void setUpPage() {
    	subscriptionPage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void verifySubscriptionIconVisible() throws IOException,InterruptedException {
        test = extent.createTest("Verify Subscription Icon is visible");
        subscriptionPage.scrollPageDown(10000);
 
        Thread.sleep(2000);
        WebElement subscriptionInput = driver.findElement(By.id("susbscribe_email"));
        Assert.assertTrue(subscriptionInput.isDisplayed(), "Subscription field not visible!");
        test.pass("Subscription input field located successfully");
        test.pass("Subscription input field is visible on the page");
        test.pass("User can interact with the subscription input field")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionIcon"));
    }

    @Test(priority = 2)
    public void verifySubscriptionEmpty() throws IOException {
        test = extent.createTest("Verify Subscription with Empty Email");

        WebElement subscriptionField = driver.findElement(By.id("susbscribe_email"));
        subscriptionPage.clearsubscriptionEmail();
        test.pass("Subscription input field cleared for empty test");
        test.pass("Ready to submit empty subscription email");
        test.pass("Subscription input field is editable and cleared");

        subscriptionPage.clickSubscribe();
        test.pass("Clicked Subscribe button with empty input");

        String validationMessage = subscriptionField.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.toLowerCase().contains("fill"),
                "Subscription accepted empty email! Validation: " + validationMessage);
        test.pass("Proper validation message displayed for empty subscription email: " + validationMessage)
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionEmpty"));
    }

    @Test(priority = 3, dataProvider = "subscriptionDataInvalid")
    public void verifySubscriptionInvalid(String invalidEmail) throws IOException, InterruptedException {
        test = extent.createTest("Verify Subscription with Invalid Email");
        WebElement subscriptionField = driver.findElement(By.id("susbscribe_email"));

        subscriptionPage.clearsubscriptionEmail();
        subscriptionPage.enterSubscriptionEmail(invalidEmail);
        test.pass("Entered invalid email in subscription field: " + invalidEmail);
        test.pass("Subscription field accepts input properly");
        test.pass("Ready to validate invalid email submission");
        
        subscriptionPage.clickSubscribe();
        test.pass("Clicked Subscribe button");
        Thread.sleep(2000);

        String validationMessage = subscriptionField.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.contains("Please include an '@'"),
                "Subscription accepted invalid email!");
        test.pass("Validation message displayed correctly for invalid email: " + validationMessage)
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionInvalid"));
    }

    @Test(dataProvider = "subscriptionDataValid", priority = 4) 
    public void verifySubscriptionValid(String subscriptionEmail) throws IOException { 
        test = extent.createTest("Verify Subscription with Valid Email"); 

        test.pass("Scrolled to Subscription section");

        subscriptionPage.enterSubscriptionEmail(subscriptionEmail); 
        test.pass("Entered valid subscription email: " + subscriptionEmail);
        test.pass("Subscription input field accepted the email correctly");

        subscriptionPage.clickSubscribe(); 
        test.pass("Clicked Subscribe button to submit email");
       
        Assert.assertEquals(subscriptionPage.getSuccessMessage(), "You have been successfully subscribed!"); 
        test.pass("Subscription success message displayed correctly")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionValid"));
    }

    @Test(dataProvider = "subscriptionDataValid", priority = 5) 
    public void verifySubscriptionUseralreadyExist(String subscriptionEmail) throws IOException, InterruptedException { 
        test = extent.createTest("Verify Subscription with Already Existing Email"); 

        test.pass("Scrolled to Subscription section");

        subscriptionPage.enterSubscriptionEmail(subscriptionEmail); 
        test.pass("Entered already registered email: " + subscriptionEmail);
        test.pass("Subscription field accepted the input correctly");
        
        subscriptionPage.clickSubscribe(); 
        test.pass("Clicked Subscribe button for existing user email");
        
        String msg = subscriptionPage.getSuccessMessage();
        boolean isSuccessDisplayed = msg.equals("You have been successfully subscribed!");

        if (isSuccessDisplayed) {
            test.fail("Subscription success message displayed incorrectly for already registered email!")
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionUserAlreadyExist"));
        } else {
            test.pass("Subscription success message NOT displayed as expected for existing email")
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "NewSubscriptionUser"));
        }

        Assert.assertFalse(isSuccessDisplayed, "Subscription success message should NOT be displayed!");
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
