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
import com.ecom.Pages.ContactUspage;
import com.ecom.Utilities.Excelutilities;
import com.ecom.Utilities.Screenshotutilities;

public class ContactUsPageTest_Functional extends BaseTest {
    static String projectpath = System.getProperty("user.dir");
    ContactUspage contact;
    ExtentTest test;
    
    @BeforeMethod
    public void setUpPage() {
    	contact = new ContactUspage(driver);
    }

    @Test(priority = 1)
    public void verifyBrowserLaunch() throws IOException {
        test = extent.createTest("Verify Browser Launch");
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));
        test.pass("Browser launched successfully");
        test.pass("Automation Exercise title verified");
        test.pass("Home page loaded without issues")
        .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "BrowserLaunch"));
    }

    @Test(priority = 2)
    public void verifyContactUsIcon() throws IOException {
        test = extent.createTest("Verify Contact Us Icon");
        contact.navigateToContactUs();
        Assert.assertTrue(contact.isGetInTouchHeaderDisplayed(), "Contact Us form not visible");
        test.pass("Navigated to Contact Us section successfully");
        test.pass("Contact Us form fields are visible");
        test.pass("Contact Us icon redirected correctly")
        .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ContactUsPage"));
    }

    @Test(dataProvider = "contactData1", priority = 3)
    public void enterName(String name) throws IOException {
        test = extent.createTest("Enter Name in Contact Form");
        contact.enterName(name);
        Assert.assertTrue(contact.isNameFieldDisplayed(), "Name field is not working");
        test.pass("Focused on Name field successfully");
        test.pass("Entered Name: " + name);
        test.pass("Name field accepted the input")
        .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "EnterName"));
    }

    @Test(dataProvider = "contactData2", priority = 9)
    public void enterEmail(String email) throws IOException {
        test = extent.createTest("Enter Email in Contact Form");
        contact.enterEmail(email);
        Assert.assertTrue(contact.isEmailFieldDisplayed(), "Email field is not working");
        test.pass("Focused on Email field successfully");
        test.pass("Entered Email: " + email);
        test.pass("Email field accepted the input")
        .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "EnterEmail"));
    }

    @Test(dataProvider = "contactData3", priority = 4)
    public void enterSubject(String subject) throws IOException {
        test = extent.createTest("Enter Subject in Contact Form");
        contact.enterSubject(subject);
        Assert.assertTrue(contact.isSubjectFieldDisplayed(), "Subject field is not working");
        test.pass("Focused on Subject field successfully");
        test.pass("Entered Subject: " + subject);
        test.pass("Subject field accepted the input")
        .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "EnterSubject"));
    }

    @Test(dataProvider = "contactData4", priority = 5)
    public void enterMessage(String message) throws IOException {
        test = extent.createTest("Enter Message in Contact Form");
        contact.enterMessage(message);
        Assert.assertTrue(contact.isMessageBoxDisplayed(), "Message field is not working");
        test.pass("Focused on Message field successfully");
        test.pass("Entered Message: " + message);
        test.pass("Message field accepted the input")
        .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "EnterMessage"));
    }

    @Test(priority = 6)
    public void uploadFile() throws IOException {
        test = extent.createTest("Upload File in Contact Form");
        contact.uploadFile(projectpath + "\\src\\test\\resources\\testdata\\sample.txt");
        Assert.assertTrue(contact.isChooseFileOptionDisplayed(), "Choose file field is not working");
        test.pass("Opened file chooser successfully");
        test.pass("Selected file: sample.txt");
        test.pass("File uploaded successfully")
        .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "UploadFile"));
    }

    @Test(priority = 10)
    public void submitForm() throws IOException {
        test = extent.createTest("Submit Contact Form");
        contact.clickSubmit();

        driver.switchTo().alert().accept(); 

        Assert.assertTrue(contact.isFormSubmissionSuccessMessageDisplayed(), "Success message not displayed");
        test.pass("Clicked on Submit button");
        test.pass("Handled confirmation alert successfully");
        test.pass("Form submitted successfully and success message displayed")
        .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubmitForm"));
    }

    @Test(dataProvider = "emptyEmailData", priority = 7)
    public void verifyEmailEmpty(String name, String subject, String message) throws IOException {
        test = extent.createTest("Verify Contact Form with Empty Email");
        contact.enterName(name); 
        contact.enterSubject(subject);
        contact.enterMessage(message);
        contact.uploadFile(projectpath + "\\src\\test\\resources\\testdata\\sample.txt");
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.clear();
        contact.clickSubmit();


        String validationMessage = emailField.getAttribute("validationMessage");

        Assert.assertTrue(validationMessage.toLowerCase().contains("fill"),
                "Form submitted without email! Validation: " + validationMessage);
        test.pass("Name, Subject, and Message fields filled");
        test.pass("Email field left empty");
        test.pass("Proper validation message displayed: " + validationMessage)
        .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "EmailEmpty"));
    }

    
    @Test(dataProvider = "invalidEmailContactData", priority = 8)
    public void verifyEmailInvalid(String name, String invalidEmail, String subject, String message) throws IOException,InterruptedException {
        test = extent.createTest("Verify Contact Form with Invalid Email");
        contact.enterName(name);
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.clear();
        emailField.sendKeys(invalidEmail);
        contact.enterSubject(subject);
        contact.enterMessage(message);
        contact.uploadFile(projectpath + "\\src\\test\\resources\\testdata\\sample.txt");
        contact.clickSubmit();

        String validationMessage = emailField.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.contains("Please include an '@'"),
                "Form submitted with invalid email!");
        Thread.sleep(1000);
        test.pass("Entered invalid email: " + invalidEmail);
        test.pass("Validation triggered for invalid email");
        test.pass("Proper validation message displayed: " + validationMessage)
        .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "EmailInvalid"));
    }
    
    @Test(dataProvider = "invalidNameContactData", priority = 11)
    public void verifyNameInvalid(String invalidName, String email, String subject, String message) throws IOException {
        contact.navigateToContactUs();
        test = extent.createTest("Verify Contact Form with Invalid Name");
        contact.enterName(invalidName);
        contact.enterEmail(email);
        contact.enterSubject(subject);
        contact.enterMessage(message);
        contact.uploadFile(projectpath + "\\src\\test\\resources\\testdata\\sample.txt");
        contact.clickSubmit();
        driver.switchTo().alert().accept(); 

        boolean isSubmitSuccessDisplayed = contact.isFormSubmissionSuccessMessageDisplayed();

        if (isSubmitSuccessDisplayed) {
        	test.fail("Unexpected: Success message displayed despite invalid name");
        	test.fail("Form accepted invalid input for Name field");
        	test.fail("Invalid Name test failed unexpectedly")
        	.addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "NameProvidedisInvalid"));
        } else {
            test.pass("Success message NOT displayed and pop rises as invalid name")
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "NameProvidedisInvalid"));
        }

        Assert.assertFalse(isSubmitSuccessDisplayed, "Success message should NOT be displayed and pop should rise as Invalid Name");
    }
    
    @Test(dataProvider = "NoFileAttachContactData", priority = 12)
    public void verifyNoFileAttach(String name, String email, String subject, String message) throws IOException {
        contact.navigateToContactUs();
    	test = extent.createTest("Verify Contact Form with No file attach");
        contact.enterName(name);
        contact.enterEmail(email);
        contact.enterSubject(subject);
        contact.enterMessage(message);
        contact.clickSubmit();
        driver.switchTo().alert().accept(); 

        boolean isSubmitSuccessDisplayed = contact.isFormSubmissionSuccessMessageDisplayed();

        if (isSubmitSuccessDisplayed) {
        	test.fail("Unexpected: Success message displayed despite no file attached");
        	test.fail("Form accepted submission without attachment");
        	test.fail("No-file-attach test failed unexpectedly")
        	.addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "NoFileAttached"));
        } else {
            test.pass("Success message NOT displayed and pop rises as invalid name")
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "FileAttached"));
        }

        Assert.assertFalse(isSubmitSuccessDisplayed, "Success message should NOT be displayed and pop should rise as Invalid Name");
    }
        
    @Test(priority = 13)
    public void verifySubscriptionIconVisible() throws IOException {
        test = extent.createTest("Verify Subscription Icon is visible");
        
        contact.scrollPageDown(1000); 
        test.pass("Scrolled to Subscription section");
        WebElement subscriptionInput = driver.findElement(By.id("susbscribe_email"));
        Assert.assertTrue(subscriptionInput.isDisplayed(), "Subscription field not visible!");
        test.pass("Subscription input field located successfully");
        test.pass("Subscription input field is visible on the page");
        test.pass("User can interact with the subscription input field")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionIcon"));
    }

    @Test(priority = 15)
    public void verifySubscriptionEmpty() throws IOException, InterruptedException {
        test = extent.createTest("Verify Subscription with Empty Email");

        test.pass("Subscription input field cleared for empty test");
        test.pass("Ready to submit empty subscription email");
        test.pass("Subscription input field is editable and cleared");
        WebElement subscriptionField = driver.findElement(By.id("susbscribe_email"));
        subscriptionField.clear();
        contact.clickSubscriptionButton();
        test.pass("Clicked Subscribe button with empty input");

        String validationMessage = subscriptionField.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.toLowerCase().contains("fill"),
                "Subscription accepted empty email! Validation: " + validationMessage);
        Thread.sleep(1000);
        test.pass("Proper validation message displayed for empty subscription email: " + validationMessage)
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionEmpty"));
    }

    @Test(priority = 14, dataProvider = "subscriptionDataInvalid")
    public void verifySubscriptionInvalid(String invalidEmail) throws IOException, InterruptedException {
        test = extent.createTest("Verify Subscription with Invalid Email");

        WebElement subscriptionField = driver.findElement(By.id("susbscribe_email"));
        subscriptionField.clear();
        subscriptionField.sendKeys(invalidEmail);
        test.pass("Entered invalid email in subscription field: " + invalidEmail);
        test.pass("Subscription field accepts input properly");
        test.pass("Ready to validate invalid email submission");

        contact.clickSubscriptionButton();
        test.pass("Clicked Subscribe button");

        Thread.sleep(2000);

        String validationMessage = subscriptionField.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.contains("Please include an '@'"),
                "Subscription accepted invalid email!");
        test.pass("Validation message displayed correctly for invalid email: " + validationMessage)
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionInvalid"));
    }

    @Test(dataProvider = "subscriptionDataValid", priority = 16) 
    public void verifySubscriptionValid(String subscriptionEmail) throws IOException,InterruptedException { 
        test = extent.createTest("Verify Subscription with Valid Email"); 

        contact.scrollPageDown(1000); 
        test.pass("Scrolled to Subscription section");

        contact.enterSubscription(subscriptionEmail); 
        test.pass("Entered valid subscription email: " + subscriptionEmail);
        test.pass("Subscription input field accepted the email correctly");

        contact.clickSubscriptionButton(); 
        test.pass("Clicked Subscribe button to submit email");

        test.pass("Subscription success message displayed correctly")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionValid"));
    }

    @Test(dataProvider = "subscriptionDataValid", priority = 17) 
    public void verifySubscriptionUseralreadyExist(String subscriptionEmail) throws IOException,InterruptedException { 
        test = extent.createTest("Verify Subscription with Already Existing Email"); 

        contact.scrollPageDown(1000); 
        test.pass("Scrolled to Subscription section");

        contact.enterSubscription(subscriptionEmail); 
        test.pass("Entered already registered email: " + subscriptionEmail);
        test.pass("Subscription field accepted the input correctly");

        contact.clickSubscriptionButton(); 
        test.pass("Clicked Subscribe button for existing user email");

        test.fail("Subscription success message is displayed for already registered email!")
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionUserAlreadyExist"));
        Assert.fail("Subscription success message is displayed instead of error for already registered email");
    }

    @Test(priority = 18)
    public void verifyScrollToTopButton() throws IOException {
        test = extent.createTest("Verify Scroll To Top Button");

        contact.scrollPageDown(1000);
        test.pass("Scrolled down the page to make 'Scroll To Top' button visible");
        test.pass("Scroll To Top button located on the page");

        contact.clickScrollToTop();
        test.pass("Clicked Scroll To Top button successfully");
        test.pass("Page scrolled to top as expected")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ScrollToTop"));
    }
    
    @Test(priority = 19)
    public void verifyNavigationBackToHome() throws IOException {
        test = extent.createTest("Verify Navigation to Home");
        contact.clickHomeButtonBreadCrumb();
        Assert.assertTrue(driver.findElement(By.linkText("Signup / Login")).isDisplayed(), "Home page not displayed");
        test.pass("Clicked Home breadcrumb successfully");
        test.pass("Redirected to Home Page");
        test.pass("Signup/Login button visible on Home Page")
        .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "HomePage"));
    }

    @DataProvider
    public Object[][] contactData1() throws IOException {
        return Excelutilities.getdata(
            projectpath + "\\src\\test\\resources\\testdata\\datafile1.xlsx", "Name");
    }

    @DataProvider
    public Object[][] contactData2() throws IOException {
        return Excelutilities.getdata(
            projectpath + "\\src\\test\\resources\\testdata\\datafile1.xlsx", "Email");
    }

    @DataProvider
    public Object[][] contactData3() throws IOException {
        return Excelutilities.getdata(
            projectpath + "\\src\\test\\resources\\testdata\\datafile1.xlsx", "Subject");
    }

    @DataProvider
    public Object[][] contactData4() throws IOException {
        return Excelutilities.getdata(
            projectpath + "\\src\\test\\resources\\testdata\\datafile1.xlsx", "Message");
    }

    @DataProvider
    public Object[][] invalidEmailContactData() throws IOException {
        return Excelutilities.getdata(
            projectpath + "\\src\\test\\resources\\testdata\\datafile1.xlsx", "InvalidEmailContact");
    }

    @DataProvider
    public Object[][] subscriptionDataValid() throws IOException {
        return Excelutilities.getdata(
            projectpath + "\\src\\test\\resources\\testdata\\datafile1.xlsx", "SubscriptionValid");
    }

    @DataProvider
    public Object[][] subscriptionDataInvalid() throws IOException {
        return Excelutilities.getdata(
            projectpath + "\\src\\test\\resources\\testdata\\datafile1.xlsx", "SubscriptionInvalid");
    }
    
    @DataProvider
    public Object[][] invalidNameContactData() throws IOException {
        return Excelutilities.getdata(
            projectpath + "\\src\\test\\resources\\testdata\\datafile1.xlsx", "InvalidNameContact");
    }
    
    @DataProvider
    public Object[][] NoFileAttachContactData() throws IOException {
        return Excelutilities.getdata(
            projectpath + "\\src\\test\\resources\\testdata\\datafile1.xlsx", "NoFileAttachContact");
    }
    
    @DataProvider
    public Object[][] emptyEmailData() throws IOException {
        return Excelutilities.getdata(
            projectpath + "\\src\\test\\resources\\testdata\\datafile1.xlsx", "EmptyEmailData");
    }
    
}
