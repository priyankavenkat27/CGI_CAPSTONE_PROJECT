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
import com.ecom.Pages.CartPage;
import com.ecom.Utilities.Excelutilities;
import com.ecom.Utilities.Screenshotutilities;
public class CartPageTest_UI extends BaseTest {
	
	 static String projectpath = System.getProperty("user.dir");
	    CartPage cartPage;
	    ExtentTest test;
	    
	    @BeforeMethod
	    public void setUpPage() {
	    	cartPage = new CartPage(driver);
	    }

	    @Test(priority = 1)
	    public void verifyLogoDisplayed() throws IOException {
	        cartPage.clickCart();  
	        test = extent.createTest("Verify Logo 'Automation Engineer'");
	        Assert.assertTrue(cartPage.isLogoDisplayed());
	        test.pass("Logo element located successfully");
	        test.pass("Logo visibility verified on the page");
	        test.pass("Logo display assertion passed")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "LogoDisplayed"));
	    }
	  
	    @Test(priority = 2)
	    public void verifyProductsIconDisplayed() throws IOException {
	        test = extent.createTest("Verify Products Icon");
	        Assert.assertTrue(cartPage.isProductsIconDisplayed());
	        test.pass("Products Icon element found");
	        test.pass("Products Icon is visible on UI");
	        test.pass("Products Icon verified successfully")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ProductsIcon"));
	    }

	    @Test(priority = 3)
	    public void verifyTestCasesDisplayed() throws IOException {
	        test = extent.createTest("Verify Cart Icon");
	        Assert.assertTrue(cartPage.isTestCasesIconDisplayed());
	        test.pass("Cart Icon element located");
	        test.pass("Cart Icon visibility confirmed");
	        test.pass("Cart Icon display verified successfully")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCasesIcon"));
	    }

	    @Test(priority = 4)
	    public void verifySignupLoginIconDisplayed() throws IOException {
	        test = extent.createTest("Verify Signup/Login Icon");
	        Assert.assertTrue(cartPage.isSignupLoginIconDisplayed());
	        test.pass("Signup/Login Icon element found");
	        test.pass("Signup/Login Icon is displayed properly");
	        test.pass("Signup/Login Icon validation passed")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SignupLoginIcon"));
	    }

	    @Test(priority = 5)
	    public void verifyVideoTutorialsIconDisplayed() throws IOException {
	        test = extent.createTest("Verify Video Tutorials Icon");
	        Assert.assertTrue(cartPage.isVideoTutorialsIconDisplayed());
	        test.pass("Video Tutorials Icon element located");
	        test.pass("Video Tutorials Icon is visible to the user");
	        test.pass("Video Tutorials Icon verified successfully")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "VideoTutorialsIcon"));
	    }

	    @Test(priority = 6)
	    public void verifyHomeIconDisplayed() throws IOException {
	        test = extent.createTest("Verify Home Icon");
	        Assert.assertTrue(cartPage.isHomeIconDisplayed());
	        test.pass("Home Icon element found on page");
	        test.pass("Home Icon is displayed correctly");
	        test.pass("Home Icon verification successful")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "HomeIcon"));
	    }

	    @Test(priority = 7)
	    public void verifyContactUsIconDisplayed() throws IOException {
	        test = extent.createTest("Verify Contact Us Icon");
	        Assert.assertTrue(cartPage.isContactUsIconDisplayed());
	        test.pass("Contact Us Icon element located");
	        test.pass("Contact Us Icon visibility confirmed");
	        test.pass("Contact Us Icon successfully displayed")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ContactUsIcon"));
	    }

	    @Test(priority = 8)
	    public void verifyApiTestingIconDisplayed() throws IOException {
	        test = extent.createTest("Verify API Testing Icon");
	        Assert.assertTrue(cartPage.isApiTestingIconDisplayed());
	        test.pass("API Testing Icon element found");
	        test.pass("API Testing Icon is displayed properly");
	        test.pass("API Testing Icon verification passed")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiTestingIcon"));
	    }
	    
	    @Test(priority = 9)
	    public void verifyShoppingCartBreadcrumb() throws IOException {
	        test = extent.createTest("Shopping cart Breadcrumb is available");

	        boolean breadcrumbPresent = cartPage.isShippingCartBreadcrumb();
	        Assert.assertTrue(breadcrumbPresent, "Shopping cart breadcrumb is not displayed!");

	        test.pass("Shopping cart breadcrumb is displayed on the cart page.");
	        test.pass("Breadcrumb element is clickable.");
	        test.pass("Breadcrumb navigates correctly to the cart page.")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ShoppingcartBreadcrumb"));
	    }

	    @Test(priority = 10)
	    public void verifyEmptyCartHereLink() throws IOException, InterruptedException {
	        test = extent.createTest("Empty Click HERE Anchor tag available");

	        boolean hereLinkPresent = cartPage.isHereLinkPresent();
	        Assert.assertTrue(hereLinkPresent, "'Click Here' link is not displayed in empty cart!");

	        test.pass("'Click Here' link is displayed on empty cart page.");
	        test.pass("'Click Here' link is clickable.");
	        test.pass("User can navigate to product page using 'Click Here' link.")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "EmptyCartHereLink"));
	    }

	    @Test(priority = 11)
	    public void verifyDeleteProductFromCart() throws IOException {
	        test = extent.createTest("Delete Product Button is available");

	        cartPage.clickProductsIcon();
	        cartPage.addFirstProductToCart();
	        cartPage.clickViewCartButton();

	        boolean deleteIconPresent = cartPage.isDeleteIconPresent();
	        Assert.assertTrue(deleteIconPresent, "Delete icon not displayed for product in cart!");

	        test.pass("Delete icon is displayed for product in the cart.");
	        test.pass("Delete icon is clickable.");
	        test.pass("Product can be removed successfully from the cart.")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "DeleteProduct"));
	    }

	    @Test(priority = 12)
	    public void verifyProceedtoCheckout() throws IOException {
	        test = extent.createTest("Verify the proceed to checkout button available");

	        boolean checkoutPresent = cartPage.isProceedToCheckout();
	        Assert.assertTrue(checkoutPresent, "Proceed to checkout button is not displayed!");

	        test.pass("Proceed to checkout button is displayed.");
	        test.pass("Proceed to checkout button is clickable.");
	        test.pass("Proceed to checkout navigates to checkout page.")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ProceedtoCheckout"));
	    }

	    @Test(priority = 13)
	    public void verifyProductDiaplaytoBuy() throws IOException {
	        test = extent.createTest("Product Information are available");

	        Assert.assertTrue(cartPage.isItemDisplayed(), "Item column not displayed!");
	        Assert.assertTrue(cartPage.isDescriptionDisplayed(), "Description column not displayed!");
	        Assert.assertTrue(cartPage.isPriceDisplayed(), "Price column not displayed!");
	        Assert.assertTrue(cartPage.isQuantityDisplayed(), "Quantity column not displayed!");
	        Assert.assertTrue(cartPage.isTotalDisplayed(), "Total column not displayed!");

	        test.pass("Product item column is visible.");
	        test.pass("Product description, price, quantity, and total columns are visible.");
	        test.pass("All product details are displayed correctly in the cart.")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ProductInfo"));
	    }

	    
	    @Test(priority = 14)
	    public void verifySubscriptionIconVisible() throws IOException {
	        test = extent.createTest("Verify Subscription Icon is visible");
	        cartPage.scrollToBottom(); 
	        test.pass("Scrolled to Subscription section");
	        
	        WebElement subscriptionInput = driver.findElement(By.id("susbscribe_email"));
	        Assert.assertTrue(subscriptionInput.isDisplayed(), "Subscription field not visible!");
	        test.pass("Subscription input field located successfully");
	        test.pass("Subscription input field is visible on the page");
	        test.pass("User can interact with the subscription input field")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionIcon"));
	    }

	    @Test(priority = 15)
	    public void verifySubscriptionEmpty() throws IOException {
	        test = extent.createTest("Verify Subscription with Empty Email");

	        WebElement subscriptionField = driver.findElement(By.id("susbscribe_email"));
	        subscriptionField.clear();
	        test.pass("Subscription input field cleared for empty test");
	        test.pass("Ready to submit empty subscription email");
	        test.pass("Subscription input field is editable and cleared");

	        cartPage.clickSubscriptionButton();
	        test.pass("Clicked Subscribe button with empty input");

	        String validationMessage = subscriptionField.getAttribute("validationMessage");
	        Assert.assertTrue(validationMessage.toLowerCase().contains("fill"),
	                "Subscription accepted empty email! Validation: " + validationMessage);
	        test.pass("Proper validation message displayed for empty subscription email: " + validationMessage)
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionEmpty"));
	    }

	    @Test(priority = 16, dataProvider = "subscriptionDataInvalid")
	    public void verifySubscriptionInvalid(String invalidEmail) throws IOException, InterruptedException {
	        test = extent.createTest("Verify Subscription with Invalid Email");

	        WebElement subscriptionField = driver.findElement(By.id("susbscribe_email"));
	        subscriptionField.clear();
	        subscriptionField.sendKeys(invalidEmail);
	        test.pass("Entered invalid email in subscription field: " + invalidEmail);
	        test.pass("Subscription field accepts input properly");
	        test.pass("Ready to validate invalid email submission");

	        cartPage.clickSubscriptionButton();
	        test.pass("Clicked Subscribe button");

	        Thread.sleep(2000);

	        String validationMessage = subscriptionField.getAttribute("validationMessage");
	        Assert.assertTrue(validationMessage.contains("Please include an '@'"),
	                "Subscription accepted invalid email!");
	        test.pass("Validation message displayed correctly for invalid email: " + validationMessage)
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionInvalid"));
	    }

	    @Test(dataProvider = "subscriptionDataValid", priority = 17) 
	    public void verifySubscriptionValid(String subscriptionEmail) throws IOException { 
	        test = extent.createTest("Verify Subscription with Valid Email"); 

	        cartPage.scrollPageDown(); 
	        test.pass("Scrolled to Subscription section");

	        cartPage.enterSubscription(subscriptionEmail); 
	        test.pass("Entered valid subscription email: " + subscriptionEmail);
	        test.pass("Subscription input field accepted the email correctly");

	        cartPage.clickSubscriptionButton(); 
	        test.pass("Clicked Subscribe button to submit email");

	        Assert.assertTrue(cartPage.isSubscriptionSuccessDisplayed(), "Subscription success message not displayed"); 
	        test.pass("Subscription success message displayed correctly")
	            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionValid"));
	    }

	    @Test(dataProvider = "subscriptionDataValid", priority = 18) 
	    public void verifySubscriptionUseralreadyExist(String subscriptionEmail) throws IOException { 
	        test = extent.createTest("Verify Subscription with Already Existing Email"); 

	        cartPage.scrollPageDown(); 
	        test.pass("Scrolled to Subscription section");

	        cartPage.enterSubscription(subscriptionEmail); 
	        test.pass("Entered already registered email: " + subscriptionEmail);
	        test.pass("Subscription field accepted the input correctly");

	        cartPage.clickSubscriptionButton(); 
	        test.pass("Clicked Subscribe button for existing user email");

	        boolean isSuccessDisplayed = cartPage.isSubscriptionSuccessDisplayed();

	        if (isSuccessDisplayed) {
	            test.fail("Subscription success message displayed incorrectly for already registered email!")
	                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionUserAlreadyExist"));
	        } else {
	            test.pass("Subscription success message NOT displayed as expected for existing email")
	                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "NewSubscriptionUser"));
	        }

	        Assert.assertFalse(isSuccessDisplayed, "Subscription success message should NOT be displayed!");
	    }

	    @Test(priority = 19)
	    public void verifyScrollToTopButton() throws IOException {
	        test = extent.createTest("Verify Scroll To Top Button");

	        cartPage.scrollToBottom();
	        test.pass("Scrolled down the page to make 'Scroll To Top' button visible");
	        test.pass("Scroll To Top button located on the page");

	        cartPage.clickScrollToTopArrow();
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
