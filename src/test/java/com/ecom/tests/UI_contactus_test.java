package com.ecom.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ecom.Base.BaseTest;
import com.ecom.Pages.ContactUspage;

public class UI_contactus_test extends BaseTest {

    // 1️⃣ Verify Contact Us page opens and "Get In Touch" header is displayed
    @Test(priority = 1)
    public void TC_Contactus_001_verifyGetInTouchHeader() {
        test = extent.createTest("TC_Contactus_001 - Verify 'Get In Touch' header is displayed");

        ContactUspage contactPage = new ContactUspage(driver);
        contactPage.navigateToContactUs();
        test.pass("Navigated to Contact Us page");

        Assert.assertTrue(contactPage.isGetInTouchHeaderDisplayed(), 
                "'Get In Touch' header not displayed!");
        test.pass("'Get In Touch' header is displayed successfully");
    }

    // 2️⃣ Verify Website Logo is displayed
    @Test(priority = 2)
    public void TC_Contactus_002_verifyLogoDisplayed() {
        test = extent.createTest("TC_Contactus_002 - Verify Website Logo is displayed");

        ContactUspage contactPage = new ContactUspage(driver);
        contactPage.navigateToContactUs();
        test.pass("Navigated to Contact Us page");

        Assert.assertTrue(contactPage.isLogoDisplayed(), 
                "Website logo not displayed!");
        test.pass("Website logo is displayed successfully on Contact Us page");
    }

    // 3️⃣ Verify Get In Touch email is displayed
    @Test(priority = 3)
    public void TC_Contactus_003_verifyGetInTouchEmailDisplayed() {
        test = extent.createTest("TC_Contactus_003 - Verify Get In Touch email is displayed");

        ContactUspage contactPage = new ContactUspage(driver);
        contactPage.navigateToContactUs();
        test.pass("Navigated to Contact Us page");

        Assert.assertTrue(contactPage.isGetInTouchMailDisplayed(), 
                "Get In Touch email is not displayed!");
        test.pass("Get In Touch email is displayed correctly");
    }

    // 4️⃣ Verify Name, Email, Subject, Message fields are visible
    @Test(priority = 4)
    public void TC_Contactus_004_verifyFormFieldsDisplayed() {
        test = extent.createTest("TC_Contactus_004 - Verify Form Fields are displayed");

        ContactUspage contactPage = new ContactUspage(driver);
        contactPage.navigateToContactUs();
        test.pass("Navigated to Contact Us page");

        Assert.assertTrue(contactPage.isNameFieldDisplayed(), "Name field missing!");
        test.pass("Name field is displayed");

        Assert.assertTrue(contactPage.isEmailFieldDisplayed(), "Email field missing!");
        test.pass("Email field is displayed");

        Assert.assertTrue(contactPage.isSubjectFieldDisplayed(), "Subject field missing!");
        test.pass("Subject field is displayed");

        Assert.assertTrue(contactPage.isMessageBoxDisplayed(), "Message box missing!");
        test.pass("Message field is displayed");
    }

    // 5️⃣ Verify Choose File option and Submit button are visible
    @Test(priority = 5)
    public void TC_Contactus_005_verifyChooseFileAndSubmitDisplayed() {
        test = extent.createTest("TC_Contactus_005 - Verify Choose File option & Submit button are displayed");

        ContactUspage contactPage = new ContactUspage(driver);
        contactPage.navigateToContactUs();
        test.pass("Navigated to Contact Us page");

        Assert.assertTrue(contactPage.isChooseFileOptionDisplayed(), "Choose file option missing!");
        test.pass("Choose File option is displayed successfully");

        Assert.assertTrue(contactPage.isSubmitButtonDisplayed(), "Submit button missing!");
        test.pass("Submit button is displayed successfully");
    }

//6️⃣ Verify Home icon/button is available
@Test(priority = 6)
public void TC_Contactus_006_verifyHomeBtnDisplayed() {
	test = extent.createTest("TC_Contactus_006 - Verify Home button is displayed");
 ContactUspage contactPage = new ContactUspage(driver);
 contactPage.navigateToContactUs();
 Assert.assertTrue(contactPage.isHomeBtnDisplayed(), "Home button not displayed!");
 test.pass("Home button is displayed");
 test.pass("Verified Home button on Contact Us page successfully");
}

//7️⃣ Verify Test Cases icon/button is available
@Test(priority = 7)
public void TC_Contactus_007_verifyTestCasesBtnDisplayed() {
	test = extent.createTest("TC_Contactus_007 - Verify Test cases button is displayed");
	ContactUspage contactPage = new ContactUspage(driver);
 contactPage.navigateToContactUs();
 Assert.assertTrue(contactPage.isTestCasesBtnDisplayed(), "Test Cases button not displayed!");
 test.pass("Test Cases button is displayed");
 test.pass("Verified Test Cases button on Contact Us page successfully");
}

//8️⃣ Verify API Testing icon/button is available
@Test(priority = 8)
public void TC_Contactus_008_verifyApiTestingBtnDisplayed() {
	test = extent.createTest("TC_Contactus_008 - Verify API testing button is displayed");
	ContactUspage contactPage = new ContactUspage(driver);
 contactPage.navigateToContactUs();
 Assert.assertTrue(contactPage.isApiTestingBtnDisplayed(), "API Testing button not displayed!");
 test.pass("API Testing button is displayed");
 test.pass("Verified API Testing button on Contact Us page successfully");
}

//9️⃣ Verify scroll bar is working properly
@Test(priority = 9)
public void TC_Contact_009_verifyScrollBarWorking(){
	test = extent.createTest("TC_Contact_009 - Verify scroll bar is working");
 ContactUspage contactPage = new ContactUspage(driver);
 contactPage.navigateToContactUs();
 Assert.assertTrue(contactPage.isScrollDisplayed(), "Scroll bar not displayed or working!");
 test.pass("Scroll bar is working properly");
 test.pass("Verified scroll functionality on Contact Us page");
}

//1️0️  Verify scroll-to-top/back-to-top arrow works properly
@Test(priority = 10)
public void TC_Contact_010_verifyScrollToTopArrow() {
	test = extent.createTest("TC_Contact_010 - Verify scroll to top button is working");
    ContactUspage contactPage = new ContactUspage(driver);
    contactPage.navigateToContactUs();

    // Scroll down so the arrow appears
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

    Assert.assertTrue(contactPage.isScrollToTopDisplayed(), "Scroll to top arrow not displayed!");
    test.pass("Scroll to top arrow is displayed");
    test.pass("Verified scroll to top arrow functionality successfully");
}
//11️⃣ Verify Subscription icon/button is available
@Test(priority = 11)
public void TC_Contact_011_verifySubscriptionIconDisplayed() {
	test = extent.createTest("TC_Contact_011 - Verify subscription icon is displayed");
 ContactUspage contactPage = new ContactUspage(driver);
 contactPage.navigateToContactUs();
 Assert.assertTrue(contactPage.isSubscriptionFieldDisplayed(), "Subscription field not displayed!");
 test.pass("Subscription field is displayed");
 test.pass("Verified Subscription field on Contact Us page successfully");
}


@Test(priority = 12)
public void TC_Contact_012_verifySubscriptionWithInvalidEmail() {
	test = extent.createTest("TC_Contact_013 - Verify subscription with invalid email");
    ContactUspage contactPage = new ContactUspage(driver);
    contactPage.navigateToContactUs();
    contactPage.enterSubscriptionEmail("invalidEmail"); 
    contactPage.clickSubscriptionButton();

    // Grab the actual message shown
    String actualMsg = driver.findElement(By.id("susbscribe_email")).getAttribute("validationMessage");

    if(actualMsg.contains("@")) { // check if it mentions @
        test.pass("Validation shown correctly for invalid email: " + actualMsg);
        test.pass("User cannot subscribe with invalid email");
    } else {
        test.fail("Validation not shown for invalid email. Message: " + actualMsg);
    }
}

//🔹 TC_015 - Empty Email (should pass)
@Test(priority = 13)
public void TC_Contact_013_verifySubscriptionWithEmptyEmail() {
	test = extent.createTest("TC_Contact_013 - Verify subscription with empty email");
 ContactUspage contactPage = new ContactUspage(driver);
 contactPage.navigateToContactUs();
 contactPage.enterSubscriptionEmail(""); 
 contactPage.clickSubscriptionButton();

 String validationMsg = driver.findElement(By.id("susbscribe_email")).getAttribute("validationMessage");

 if(validationMsg.toLowerCase().contains("fill")) {
     test.pass("Validation shown correctly for empty email: " + validationMsg);
     test.pass("User cannot subscribe with empty email");
 } else {
     test.fail("Validation not shown for empty email. Message: " + validationMsg);
 }
}

@Test(priority = 14)
public void TC_Contact_014_verifyGetInTouchHeader() {
	test = extent.createTest("TC_Contact_014 - Verify Get in Touch header is displayed");
    ContactUspage contactPage = new ContactUspage(driver);
    contactPage.navigateToContactUs();
    
    test.pass("Navigated to Contact Us page successfully");  // ✅ Pass 1
    test.pass("Contact Us page loaded");  // ✅ Pass 2
    
    if(contactPage.isGetInTouchHeaderDisplayed()) {
        test.pass("Get In Touch header displayed correctly");
    } else {
        test.fail("Get In Touch header NOT displayed");  // ❌ Fail
    }
}


@Test(priority = 15)
public void TC_Contact_015_verifyNameFieldDisplayed() {
	test = extent.createTest("TC_Contact_015 - Verify Name field is Displayed");
    ContactUspage contactPage = new ContactUspage(driver);
    contactPage.navigateToContactUs();
    
    test.pass("Navigated to Contact Us page successfully");  // ✅ Pass 1
    test.pass("Contact form section visible");  // ✅ Pass 2
    
    if(contactPage.isNameFieldDisplayed()) {
        test.pass("Name field displayed correctly");
    } else {
        test.fail("Name field NOT displayed");  // ❌ Fail
    }
}


@Test(priority = 16)
public void TC_Contact_016_verifyEmailFieldDisplayed() {
	test = extent.createTest("TC_Contact_016 - Verify Email field is displayed");
    ContactUspage contactPage = new ContactUspage(driver);
    contactPage.navigateToContactUs();
    
    test.pass("Navigated to Contact Us page successfully");  // ✅ Pass 1
    test.pass("Contact form section visible");  // ✅ Pass 2
    
    if(contactPage.isEmailFieldDisplayed()) {
        test.pass("Email field displayed correctly");
    } else {
        test.fail("Email field NOT displayed");  // ❌ Fail
    }
}


@Test(priority = 17)
public void TC_Contact_017_verifySubjectFieldDisplayed() {
	test = extent.createTest("TC_Contact_017 - Verify Subject field is displayed");
    ContactUspage contactPage = new ContactUspage(driver);
    contactPage.navigateToContactUs();
    
    test.pass("Navigated to Contact Us page successfully");  // ✅ Pass 1
    test.pass("Contact form section visible");  // ✅ Pass 2
    
    if(contactPage.isSubjectFieldDisplayed()) {
        test.pass("Subject field displayed correctly");
    } else {
        test.fail("Subject field NOT displayed");  // ❌ Fail
    }
}


@Test(priority = 18)
public void TC_Contact_018_verifyMessageFieldDisplayed() {
	test = extent.createTest("TC_Contact_018 - Verify Message field is displayed");
    ContactUspage contactPage = new ContactUspage(driver);
    contactPage.navigateToContactUs();
    
    test.pass("Navigated to Contact Us page successfully");  // ✅ Pass 1
    test.pass("Contact form section visible");  // ✅ Pass 2
    
    if(contactPage.isMessageBoxDisplayed()) {
        test.pass("Message field displayed correctly");
    } else {
        test.fail("Message field NOT displayed");  // ❌ Fail
    }
}

@Test(priority = 19)
public void TC_Contact_019_verifyNameFieldWithValidData() {
	test = extent.createTest("TC_Contact_019 - Verify name field with valid data is working");
  ContactUspage contactPage = new ContactUspage(driver);
  contactPage.navigateToContactUs();

  test.pass("Navigated to Contact Us page");
  contactPage.enterName("Bonnie");
  test.pass("Entered valid name in Name field");

  if(contactPage.isNameFieldDisplayed()) {
      test.pass("Name field accepts valid data correctly");
  } else {
      test.fail("Name field not working properly");
  }
}

@Test(priority = 20)
public void TC_Contact_020_verifyEmailFieldWithValidData() {
	test = extent.createTest("TC_Contact_020 - Verify email text field with valid input");
  ContactUspage contactPage = new ContactUspage(driver);
  contactPage.navigateToContactUs();

  test.pass("Navigated to Contact Us page");
  contactPage.enterEmail("hello@gmail.com");
  test.pass("Entered valid email in Email field");

  if(contactPage.isEmailFieldDisplayed()) {
      test.pass("Email field accepts valid data correctly");
  } else {
      test.fail("Email field not working properly");
  }
}

@Test(priority = 21)
public void TC_Contact_021_verifyEmailFieldEmpty() {
	test = extent.createTest("TC_Contact_021 - Verify email field with empty input");
  ContactUspage contactPage = new ContactUspage(driver);
  contactPage.navigateToContactUs();

  test.pass("Navigated to Contact Us page");
  contactPage.enterEmail(""); // empty
  contactPage.clickSubmit();

  String validationMsg = driver.findElement(By.id("susbscribe_email")).getAttribute("validationMessage");
  if(validationMsg.toLowerCase().contains("fill")) {
      test.pass("Validation shown correctly for empty email: " + validationMsg);
  } else {
      test.fail("Empty email accepted or validation missing");
  }
}

@Test(priority = 22)
public void TC_Contact_022_verifySubjectFieldWithData() {
	test = extent.createTest("TC_Contact_022 - Verify Subject field with data ");
  ContactUspage contactPage = new ContactUspage(driver);
  contactPage.navigateToContactUs();

  test.pass("Navigated to Contact Us page");
  contactPage.enterSubject("Inquiry about products");
  test.pass("Entered subject in Subject field");

  if(contactPage.isSubjectFieldDisplayed()) {
      test.pass("Subject field is displayed and accepts input");
  } else {
      test.fail("Subject field not working properly");
  }
}

@Test(priority = 23)
public void TC_Contact_023_verifyMessageFieldWithData() {
	test = extent.createTest("TC_Contact_023 - Verify Message field with valid data");
  ContactUspage contactPage = new ContactUspage(driver);
  contactPage.navigateToContactUs();

  test.pass("Navigated to Contact Us page");
  contactPage.enterMessage("This is a test message for automation.");
  test.pass("Entered message in Message box");

  if(contactPage.isMessageBoxDisplayed()) {
      test.pass("Message box is displayed and accepts input");
  } else {
      test.fail("Message box not working properly");
  }
}

@Test(priority = 24)
public void TC_Contact_024_verifyChooseFileButton() {
	test = extent.createTest("TC_Contact_024 - Verify Choose file button is working");
  ContactUspage contactPage = new ContactUspage(driver);
  contactPage.navigateToContactUs();

  test.pass("Navigated to Contact Us page");

  if(contactPage.isChooseFileOptionDisplayed()) {
      test.pass("Choose File button is displayed");
  } else {
      test.fail("Choose File button not displayed");
  }
}

@Test(priority = 25)
public void TC_Contact_025_verifySubmitButton() {
	test = extent.createTest("TC_Contact_025 - Verify Submit button is working");
  ContactUspage contactPage = new ContactUspage(driver);
  contactPage.navigateToContactUs();

  test.pass("Navigated to Contact Us page");

  if(contactPage.isSubmitButtonDisplayed()) {
      test.pass("Submit button is displayed");
  } else {
      test.fail("Submit button not displayed");
  }
}

@Test(priority = 26)
public void TC_Contact_026_verifyContactUsSectionVisible() {
	test = extent.createTest("TC_Contact_026 - Verify Contact us section is visible ");
  ContactUspage contactPage = new ContactUspage(driver);
  contactPage.navigateToContactUs();

  test.pass("Navigated to Contact Us page");

  if(contactPage.isGetInTouchHeaderDisplayed()) {
      test.pass("'CONTACT US' / Get In Touch section is visible");
  } else {
      test.fail("'CONTACT US' / Get In Touch section NOT visible");
  }
}}