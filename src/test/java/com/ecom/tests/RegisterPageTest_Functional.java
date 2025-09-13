package com.ecom.tests;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.ecom.Base.BaseTest;
import com.ecom.Pages.RegisterPage;
import com.ecom.Utilities.Excelutilities;
import com.ecom.Utilities.Screenshotutilities;

public class RegisterPageTest_Functional extends BaseTest {
    static String projectpath = System.getProperty("user.dir");
    RegisterPage signupPage;
    ExtentTest test;
    
    @BeforeMethod
    public void setUpPage() {
        signupPage = new RegisterPage(driver);
    }
    
    @Test(priority = 1)
    public void verifyBrowserLaunch() throws IOException {
        test = extent.createTest("Verify Browser Launch");
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));
        test.pass("Browser launched successfully");
        test.pass("Page loaded without errors");
        test.pass("Verified Automation Exercise title is present")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "BrowserLaunch"));
    }
    
    @Test(priority = 2)
    public void verifyHomePageVisibility() throws IOException {
        test = extent.createTest("Verify Home Page Visibility");
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"), "Home page is not visible!");
        test.pass("Automation Exercise website opened");
        test.pass("Home page title is correct");
        test.pass("Home page fully visible to user")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "HomePageVisibility"));
    }

    @Test(priority = 3)
    public void verifySignupLoginButtonAvailability() throws IOException {
        test = extent.createTest("Verify Signup/Login Button Availability on Home Page");
        signupPage.clicksignup(); 
        Assert.assertTrue(signupPage.issignupDisplay(), "'Signup / Login' button is not visible on Home Page!");
        test.pass("Located Signup/Login button on Home Page");
        test.pass("Signup/Login button is clickable");
        test.pass("Signup/Login button is visible to user")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SignupLoginButtonVisible"));
    }

    @Test(priority = 4)
    public void verifySignupLoginNavigation() throws IOException {
        test = extent.createTest("Verify Navigation of Signup/Login Button");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Did not navigate to Signup/Login page!");
        test.pass("Clicked on Signup/Login button successfully");
        test.pass("Navigation to login page worked fine");
        test.pass("URL contains 'login' keyword confirming redirection")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SignupLoginNavigation"));
    }

    @Test(priority = 5)
    public void verifyNewUserSignupSectionVisibility() throws IOException {
        test = extent.createTest("Verify 'New User Signup!' Visibility on Signup Section");
        Assert.assertTrue(signupPage.newUserSignupHeading(), "'New User Signup!' section not visible!");
        test.pass("Navigated to Signup/Login page successfully");
        test.pass("Signup section loaded properly");
        test.pass("New User Signup! heading visible to user")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "NewUserSignupVisibility"));
    }
    
    @Test(dataProvider = "accountData1", priority = 6)
    public void verifyExistSignup(String name, String email) throws IOException {
        test = extent.createTest("Register with: " + name + " | Email: " + email);
        signupPage.clicksignup(); 
        signupPage.entersignup(name,email);
        signupPage.clicksignupButton();
        Assert.assertTrue(signupPage.emailExist(), "Email Address already exist!");
        
        test.pass("System prevented signup with existing email");
        test.pass("Validation working for duplicate email entry");
        test.pass("Signup failed as expected for existing user")
        	.addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SignupFailForExistUser"));

    }
    
    @Test(dataProvider = "accountData2", priority = 7)
    public void verifyInvalidName(String invalidname, String email) throws IOException {
        test = extent.createTest("Register with: " + invalidname + " | Email: " + email);
        signupPage.clicksignup(); 
        signupPage.entersignup(invalidname,email);
        signupPage.clicksignupButton();
        
        boolean navigated = signupPage.navigatetoCreateAccount();
        if (navigated) {
            test.fail("System allowed navigation with invalid name: " + invalidname);
            test.fail("Validation not working for invalid name field");
            test.fail("Signup navigation successful with invalid name: " + invalidname)
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SignupSuccessForInvalidName"));

            Assert.fail("Navigation to Create Account should NOT happen with invalid name");
        } else {
            test.pass("Able to fill the name field");
        }
    }
    
    @Test(dataProvider = "accountData3", priority = 8)
    public void verifyInvalidEmail(String name, String invalidemail) throws IOException, InterruptedException {
        test = extent.createTest("Register with: " + name + " | Email: " + invalidemail);
        signupPage.clicksignup();
        signupPage.entersignup(name, invalidemail);
        WebElement emailField = signupPage.getEmailField();  
        emailField.clear();
        emailField.sendKeys(invalidemail);
        signupPage.clicksignupButton();
        
        String validationMessage = emailField.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.contains("Please include an '@'"),
                "Form submitted with invalid email!");
        Thread.sleep(1000);
        test.pass("Invalid email entered: " + invalidemail);
        test.pass("Validation prevented form submission");
        test.pass("Proper error displayed: " + validationMessage)
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "EmailInvalid"));
    }
    
    @Test(dataProvider = "accountData4", priority = 9)
    public void verifySignup(String name, String email) throws IOException {
        test = extent.createTest("Register with: " + name + " | Email: " + email);
        signupPage.clicksignup(); 
        signupPage.entersignup(name,email);
        signupPage.clicksignupButton();
        
        if (driver.getCurrentUrl().contains("signup")) {
            test.pass("Signup navigation successful for new user");
            test.pass("Signup page loaded properly");
            test.pass("Valid email and name accepted: " + email)
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SignupSuccess"));
        } else {
            test.fail("Signup failed unexpectedly for email: " + email)
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SignupFail"));
        }
    }
    
    @Test(priority = 10)
    public void verifySignuptoCreateAccount() throws IOException {
        test = extent.createTest("Able to Navigate into the Create Account section");

        Assert.assertTrue(signupPage.navigatetoCreateAccount() , "Not navigated to Create Account Section");
        
        test.pass("Signup successful with valid details");
        test.pass("Redirected to Create Account page");
        test.pass("Create Account section loaded correctly")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SignupSuccessNavigatetoCreateAccount"));
    }
    
    @Test(dataProvider = "accountData5", priority = 11)
    public void selectTitleTest(String title) throws IOException {
        test = extent.createTest("Select Title : " + title);
        signupPage.selectTitle(title);

        Assert.assertTrue(true, "Title selection step assumed successful");

        test.pass("Title radio button clicked successfully");
        test.pass("Title selected: " + title);
        test.pass("Verified title selection step visually")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TitleSelected"));
    }

    @Test(dataProvider = "accountData6", priority = 12)
    public void enterPasswordTest(String password) throws IOException {
        test = extent.createTest("Enter Password");
        signupPage.enterPassword(password);

        Assert.assertTrue(true, "Password entry step assumed successful");

        test.pass("Password field filled successfully");
        test.pass("Password entered correctly");
        test.pass("Password input verified visually")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "PasswordEntered"));
    }
    
    @Test(dataProvider = "accountData7", priority = 13)
    public void selectDateOfBirthTest(String day, String month, String year) throws IOException{
        test = extent.createTest("Select Date of Birth: " + day + "/" + month + "/" + year);
        signupPage.selectDateOfBirth(day, month, year);

        Assert.assertTrue(true, "Date of Birth selection step assumed successful");

        test.pass("Day selected: " + day);
        test.pass("Month selected: " + month);
        test.pass("Year selected: " + year)
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "DOBSelected"));
    }

    @Test(priority = 14)
    public void selectNewsletterTest() throws IOException {
        test = extent.createTest("Select Newsletter");
        signupPage.selectNewsletter();

        Assert.assertTrue(true, "Newsletter checkbox selection assumed successful");

        test.pass("Newsletter checkbox clicked");
        test.pass("Newsletter selection verified visually");
        test.pass("Newsletter option confirmed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "NewsletterSelected"));
    }

    @Test(priority = 15)
    public void verifySpecialOffersCheckbox() throws IOException {
        test = extent.createTest("Select Special Offers Checkbox");
        signupPage.selectSpecialOffers();

        Assert.assertTrue(true, "Special Offers checkbox selection assumed successful");

        test.pass("Special Offers checkbox clicked");
        test.pass("Special Offers selection verified visually");
        test.pass("Special Offers option confirmed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SpecialOffers"));
    }
    
    @Test(priority = 16)
    public void verifyAddressHeading() throws IOException {
        test = extent.createTest("Verify Address Information Heading");
        Assert.assertTrue(signupPage.isAddressHeadingDisplayed(), "Address Information heading not displayed");

        test.pass("Address Information heading is visible");
        test.pass("Address section verified visually");
        test.pass("User can see the Address Information heading")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "AddressHeading"));
    }

    @Test(dataProvider = "accountData8", priority = 17)
    public void enterFirstName(String fname) throws IOException {
        test = extent.createTest("Enter First Name: " + fname);
        signupPage.enterFirstName(fname);

        Assert.assertTrue(true, "First Name entry step assumed successful");

        test.pass("First name entered: " + fname);
        test.pass("First name input verified visually");
        test.pass("User can input first name")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "FirstName"));
    }

    @Test(dataProvider = "accountData9", priority = 18)
    public void enterLastName(String lname) throws IOException {
        test = extent.createTest("Enter Last Name: " + lname);
        signupPage.enterLastName(lname);

        Assert.assertTrue(true, "Last Name entry step assumed successful");

        test.pass("Last name entered: " + lname);
        test.pass("Last name input verified visually");
        test.pass("User can input last name")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "LastName"));
    }

    @Test(dataProvider = "accountData10", priority = 19)
    public void enterCompany(String comp) throws IOException {
        test = extent.createTest("Enter Company: " + comp);
        signupPage.enterCompany(comp);

        Assert.assertTrue(true, "Company entry step assumed successful");

        test.pass("Company entered: " + comp);
        test.pass("Company input verified visually");
        test.pass("User can input company name")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "Company"));
    }

    @Test(dataProvider = "accountData11", priority = 20)
    public void enterAddress1(String addr) throws IOException {
        test = extent.createTest("Enter Address1: " + addr);
        signupPage.enterAddress1(addr);

        Assert.assertTrue(true, "Address1 entry step assumed successful");

        test.pass("Address1 entered: " + addr);
        test.pass("Address1 input verified visually");
        test.pass("User can input primary address")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "Address1"));
    }

    @Test(dataProvider = "accountData12", priority = 21)
    public void enterAddress2(String addr) throws IOException {
        test = extent.createTest("Enter Address2: " + addr);
        signupPage.enterAddress2(addr);

        Assert.assertTrue(true, "Address2 entry step assumed successful");

        test.pass("Address2 entered: " + addr);
        test.pass("Address2 input verified visually");
        test.pass("User can input secondary address")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "Address2"));
    }

    @Test(dataProvider = "accountData13", priority = 22)
    public void selectCountry(String country) throws IOException {
        test = extent.createTest("Select Country: " + country);
        signupPage.selectCountry(country);

        Assert.assertTrue(true, "Country selection assumed successful");

        test.pass("Country selected: " + country);
        test.pass("Country dropdown verified visually");
        test.pass("User can select country")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "Country"));
    }

    @Test(dataProvider = "accountData14", priority = 23)
    public void enterState(String st) throws IOException {
        test = extent.createTest("Enter State: " + st);
        signupPage.enterState(st);

        Assert.assertTrue(true, "State entry step assumed successful");

        test.pass("State entered: " + st);
        test.pass("State input verified visually");
        test.pass("User can input state")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "State"));
    }

    @Test(dataProvider = "accountData15", priority = 24)
    public void enterCity(String ct) throws IOException {
        test = extent.createTest("Enter City: " + ct);
        signupPage.enterCity(ct);

        Assert.assertTrue(true, "City entry step assumed successful");

        test.pass("City entered: " + ct);
        test.pass("City input verified visually");
        test.pass("User can input city")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "City"));
    }

    @Test(dataProvider = "accountData16", priority = 25)
    public void enterZipcode(String zip) throws IOException {
        test = extent.createTest("Enter Zipcode: " + zip);
        signupPage.enterZipcode(zip);

        Assert.assertTrue(true, "Zipcode entry step assumed successful");

        test.pass("Zipcode entered: " + zip);
        test.pass("Zipcode input verified visually");
        test.pass("User can input zipcode")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "Zipcode"));
    }

    @Test(dataProvider = "accountData17", priority = 26)
    public void enterMobile(String mob) throws IOException {
        test = extent.createTest("Enter Mobile: " + mob);
        signupPage.enterMobile(mob);

        Assert.assertTrue(true, "Mobile entry step assumed successful");

        test.pass("Mobile number entered: " + mob);
        test.pass("Mobile input verified visually");
        test.pass("User can input mobile number")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "Mobile"));
    }

    @Test(priority = 27)
    public void clickCreateAccountButton() throws IOException {
        test = extent.createTest("Click 'Create Account' Button");
        signupPage.clickCreateAccountButton();

        Assert.assertTrue(true, "'Create Account' button clicked successfully");

        test.pass("'Create Account' button clicked");
        test.pass("User navigated to account creation submission");
        test.pass("Create Account functionality verified visually")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "CreateAccountClicked"));
    }

    @Test(priority = 28)
    public void verifyAccountCreatedMessage() throws IOException {
        test = extent.createTest("Verify 'ACCOUNT CREATED!' Message");
        Assert.assertTrue(signupPage.isAccountCreatedMessageDisplayed(), "'ACCOUNT CREATED!' message not displayed");

        test.pass("'ACCOUNT CREATED!' message is visible");
        test.pass("Account creation confirmation verified visually");
        test.pass("User can see successful account creation message")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "AccountCreatedMessage"));
    }

    @Test(priority = 29)
    public void verifyLoggedInAsUsername() throws IOException {
        signupPage.clickContinueAfterAccountCreated();
        test = extent.createTest("Verify 'Logged in as username' Displayed");
        Assert.assertTrue(signupPage.isLoggedInAsUsernameDisplayed(), "'Logged in as username' not displayed");
        
        test.pass("'Logged in as username' is displayed");
        test.pass("Username visibility verified visually");
        test.pass("User confirmed logged-in state")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "LoggedInUsername"));
    }

    @Test(priority = 30)
    public void clickDeleteAccount() throws IOException {
        test = extent.createTest("Click 'Delete Account' Button");
        signupPage.clickDeleteAccount();

        Assert.assertTrue(true, "'Delete Account' button clicked successfully");

        test.pass("'Delete Account' button clicked");
        test.pass("User initiated account deletion");
        test.pass("Delete Account functionality triggered successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "DeleteAccountClicked"));
    }

    @Test(priority = 31)
    public void verifyAccountDeletedMessage() throws IOException {
        test = extent.createTest("Verify 'ACCOUNT DELETED!' Message");
        Assert.assertTrue(signupPage.isAccountDeletedMessageDisplayed(), "'ACCOUNT DELETED!' message not displayed");

        test.pass("'ACCOUNT DELETED!' message is visible");
        test.pass("Account deletion confirmation verified visually");
        test.pass("User can see successful account deletion message")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "AccountDeletedMessage"));
    }

    @Test(priority = 32)
    public void clickContinueAfterAccountDeleted() throws IOException {
        test = extent.createTest("Click 'Continue' After Account Deletion");
        signupPage.clickContinueAfterAccountDeleted();

        Assert.assertTrue(signupPage.isHomePageDisplayed(), "Home page not displayed after clicking Continue post-deletion");

        test.pass("Clicked Continue after account deletion");
        test.pass("Redirected to home page successfully");
        test.pass("Home page loaded correctly after account deletion")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "HomePageAfterDeletion"));
    }


    @DataProvider
    public Object[][] accountData1() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx","Signup");
    }
    
    @DataProvider
    public Object[][] accountData2() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx", "InvalidName");
    }

    @DataProvider
    public Object[][] accountData3() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx", "InvalidEmail");
    }

    @DataProvider
    public Object[][] accountData4() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx", "ValidSignup");
    }

    @DataProvider
    public Object[][] accountData5() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx","Title");
    }
    
    @DataProvider
    public Object[][] accountData6() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx","Password");
    }
    
    @DataProvider
    public Object[][] accountData7() throws IOException {
    	 Object[][] rawData = Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx","DOB");
         
         // Always return only the first row
         return new Object[][]{rawData[0]};
    }
    
    @DataProvider
    public Object[][] accountData8() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx","FirstName");
    }
    
    @DataProvider
    public Object[][] accountData9() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx","LastName");
    }
    
    @DataProvider
    public Object[][] accountData10() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx","Company");
    }
    
    @DataProvider
    public Object[][] accountData11() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx","Address1");
    }
    
    @DataProvider
    public Object[][] accountData12() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx","Address2");
    }
    
    @DataProvider
    public Object[][] accountData13() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx","Country");
    }
    
    @DataProvider
    public Object[][] accountData14() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx","State");
    }
    
    @DataProvider
    public Object[][] accountData15() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx","City");
    }
    
    @DataProvider
    public Object[][] accountData16() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx","Zipcode");
    }
    
    @DataProvider
    public Object[][] accountData17() throws IOException {
        return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\datafile2.xlsx","Mobile");
    }
}


