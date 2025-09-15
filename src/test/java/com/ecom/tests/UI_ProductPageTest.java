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
import com.ecom.Pages.ProductPage;
import com.ecom.Utilities.Excelutilities;
import com.ecom.Utilities.Screenshotutilities;

public class UI_ProductPageTest extends BaseTest{
	
	static String projectpath = System.getProperty("user.dir");
    ProductPage productPage;
    ExtentTest test;
    
    @BeforeMethod
    public void setUpPage() {
    	productPage = new ProductPage(driver);
    }
    
    @Test(priority = 1)
    public void verifyLogoDisplayed() throws IOException {
        productPage.clickProductsLink();  
        test = extent.createTest("Verify Logo 'Automation Engineer'");
        Assert.assertTrue(productPage.isLogoDisplayed());
        test.pass("Logo element located successfully");
        test.pass("Logo visibility verified on the page");
        test.pass("Logo display assertion passed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "LogoDisplayed"));
    }
  
    @Test(priority = 2)
    public void verifyCartIconDisplayed() throws IOException {
        test = extent.createTest("Verify Products Icon");
        Assert.assertTrue(productPage.isCartIconDisplayed());
        test.pass("Products Icon element found");
        test.pass("Products Icon is visible on UI");
        test.pass("Products Icon verified successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ProductsIcon"));
    }

    @Test(priority = 3)
    public void verifyTestCasesDisplayed() throws IOException {
        test = extent.createTest("Verify Cart Icon");
        Assert.assertTrue(productPage.isTestCasesIconDisplayed());
        test.pass("Cart Icon element located");
        test.pass("Cart Icon visibility confirmed");
        test.pass("Cart Icon display verified successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "TestCasesIcon"));
    }

    @Test(priority = 4)
    public void verifySignupLoginIconDisplayed() throws IOException {
        test = extent.createTest("Verify Signup/Login Icon");
        Assert.assertTrue(productPage.isSignupLoginIconDisplayed());
        test.pass("Signup/Login Icon element found");
        test.pass("Signup/Login Icon is displayed properly");
        test.pass("Signup/Login Icon validation passed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SignupLoginIcon"));
    }

    @Test(priority = 5)
    public void verifyVideoTutorialsIconDisplayed() throws IOException {
        test = extent.createTest("Verify Video Tutorials Icon");
        Assert.assertTrue(productPage.isVideoTutorialsIconDisplayed());
        test.pass("Video Tutorials Icon element located");
        test.pass("Video Tutorials Icon is visible to the user");
        test.pass("Video Tutorials Icon verified successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "VideoTutorialsIcon"));
    }

    @Test(priority = 6)
    public void verifyHomeIconDisplayed() throws IOException {
        test = extent.createTest("Verify Home Icon");
        Assert.assertTrue(productPage.isHomeIconDisplayed());
        test.pass("Home Icon element found on page");
        test.pass("Home Icon is displayed correctly");
        test.pass("Home Icon verification successful")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "HomeIcon"));
    }

    @Test(priority = 7)
    public void verifyContactUsIconDisplayed() throws IOException {
        test = extent.createTest("Verify Contact Us Icon");
        Assert.assertTrue(productPage.isContactUsIconDisplayed());
        test.pass("Contact Us Icon element located");
        test.pass("Contact Us Icon visibility confirmed");
        test.pass("Contact Us Icon successfully displayed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ContactUsIcon"));
    }

    @Test(priority = 8)
    public void verifyApiTestingIconDisplayed() throws IOException {
        test = extent.createTest("Verify API Testing Icon");
        Assert.assertTrue(productPage.isApiTestingIconDisplayed());
        test.pass("API Testing Icon element found");
        test.pass("API Testing Icon is displayed properly");
        test.pass("API Testing Icon verification passed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ApiTestingIcon"));
    }
    
    @Test(priority = 9)
    public void verifyPromotionalBannerDisplayed() throws IOException {
        test = extent.createTest("Verify Promotional Banner 'Special Offer Big Sale Upto 50% Off' ");
        Assert.assertTrue(productPage.ispromtionalBannerDisplayed());
        test.pass("Offer Banner element located successfully");
        test.pass("Offer Banner visibility verified on the page");
        test.pass("Offer Banner display assertion passed")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "PromotionalBannerDisplayed"));
    }
    
    @Test(priority = 11)
    public void verifyAddProductIcon() throws IOException {
        test = extent.createTest("Add to cart icon is available");
        productPage.scrollPageDown();

        boolean AddtoCartPresent = productPage.addFirstProductToCartVisible();
        Assert.assertTrue(AddtoCartPresent, "Add to cart icon is not displayed!");

        test.pass("Add to cart icon displayed on the product page.");
        test.pass("Add to cart icon is clickable.");
        test.pass("Add to cart icon correctly adds items to the cart page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "AddtoCartIcon"));
    }
    
    @Test(priority = 12)
    public void verifyViewProductIcon() throws IOException {
        test = extent.createTest("View product icon is available");

        boolean ViewProductIconPresent = productPage.ViewProduct();
        Assert.assertTrue(ViewProductIconPresent, "View product icon is not displayed!");

        test.pass("View product icon displayed on the product page.");
        test.pass("View product icon is clickable.");
        test.pass("View product icon correctly display item on the productt page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ViewProductIcon"));
    }
    
    @Test(priority = 13)
    public void verifyCategorySection() throws IOException {
        test = extent.createTest("Category Section is available");
        
        boolean CategorySectionPresent = productPage.isCategorySection();
        Assert.assertTrue(CategorySectionPresent, "Category Section is not displayed!");

        test.pass("Category Section displayed on the product page.");
        test.pass("Category Section navigation links are clickable.");
        test.pass("Category Section correctly display navigation links on the productt page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "CategorySection"));
    }
    
    @Test(priority = 14)
    public void verifyBrandsSection() throws IOException {
        test = extent.createTest("Brands Section is available");
        productPage.scrollPageDown();
        
        boolean BrandsSectionPresent = productPage.isBrandSection();
        Assert.assertTrue(BrandsSectionPresent, "Brands Section is not displayed!");

        test.pass("Brands Section displayed on the product page.");
        test.pass("Brands Section navigation links are clickable.");
        test.pass("Brands Section correctly display navigation links on the productt page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "BrandsSection"));
    }
    
    @Test(priority = 10)
    public void verifyAllProductSection() throws IOException {
        test = extent.createTest("All Products Section is available");
        productPage.scrollPageDown();

        boolean AllProductSectionPresent = productPage.isAllProductSection();
        Assert.assertTrue(AllProductSectionPresent, "All Products Section is not displayed!");

        test.pass("All Products Section displayed on the product page.");
        test.pass("All Products Section products are clickable.");
        test.pass("All Products Section correctly displays products on the productt page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "AllProductsSection"));
    }
    
    @Test(priority = 15, dataProvider = "searchData")
    public void verifyProductSearch(String productName) throws IOException {
        test = extent.createTest("Search Product: " + productName);
        
        productPage.searchProduct(productName);
        
        test.pass("Search Product Textbox displayed on the product page.");
        test.pass("Able to enter products to search");
        test.pass("Searched for product: " + productName)
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "Search_" + productName));
    }
    
    @Test(priority = 16)
    public void verifySearchProductsSection() throws IOException {
        test = extent.createTest("Search Products section is available");
        productPage.scrollPageDown();

        boolean SearchProductSectionPresent = productPage.isSearchedProductsHeaderVisible();
        Assert.assertTrue(SearchProductSectionPresent, "Search Products Section is not displayed!");

        test.pass("Search Products Section displayed on the product page.");
        test.pass("Search Products Section products are clickable.");
        test.pass("Search Products Section correctly displays products on the productt page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SearchProductsSection"));
    }

    @Test(priority = 17)
    public void verifyCategoryAndBrandNavigation() throws IOException {
        test = extent.createTest("Category Toggle Navigation");
        
        productPage.selectCategoryWomen();
        test.pass("Navigated to Women Category")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "WomenCategory"));

        productPage.selectCategoryMen();
        test.pass("Navigated to Men Category")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "MenCategory"));

        productPage.selectCategoryKids();
        test.pass("Navigated to Kids Category")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "KidsCategory"));
    }
    
    @Test(priority = 18)
    public void verifySubscriptionIconVisible() throws IOException {
        test = extent.createTest("Verify Subscription Icon is visible");
        productPage.scrollToBottom(); 
        test.pass("Scrolled to Subscription section");
        
        WebElement subscriptionInput = driver.findElement(By.id("susbscribe_email"));
        Assert.assertTrue(subscriptionInput.isDisplayed(), "Subscription field not visible!");
        test.pass("Subscription input field located successfully");
        test.pass("Subscription input field is visible on the page");
        test.pass("User can interact with the subscription input field")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionIcon"));
    }

    @Test(priority = 19)
    public void verifySubscriptionEmpty() throws IOException {
        test = extent.createTest("Verify Subscription with Empty Email");

        WebElement subscriptionField = driver.findElement(By.id("susbscribe_email"));
        subscriptionField.clear();
        test.pass("Subscription input field cleared for empty test");
        test.pass("Ready to submit empty subscription email");
        test.pass("Subscription input field is editable and cleared");

        productPage.clickSubscriptionButton();
        test.pass("Clicked Subscribe button with empty input");

        String validationMessage = subscriptionField.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.toLowerCase().contains("fill"),
                "Subscription accepted empty email! Validation: " + validationMessage);
        test.pass("Proper validation message displayed for empty subscription email: " + validationMessage)
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionEmpty"));
    }

    @Test(priority = 20, dataProvider = "subscriptionDataInvalid")
    public void verifySubscriptionInvalid(String invalidEmail) throws IOException, InterruptedException {
        test = extent.createTest("Verify Subscription with Invalid Email");

        WebElement subscriptionField = driver.findElement(By.id("susbscribe_email"));
        subscriptionField.clear();
        subscriptionField.sendKeys(invalidEmail);
        test.pass("Entered invalid email in subscription field: " + invalidEmail);
        test.pass("Subscription field accepts input properly");
        test.pass("Ready to validate invalid email submission");

        productPage.clickSubscriptionButton();
        test.pass("Clicked Subscribe button");

        Thread.sleep(2000);

        String validationMessage = subscriptionField.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.contains("Please include an '@'"),
                "Subscription accepted invalid email!");
        test.pass("Validation message displayed correctly for invalid email: " + validationMessage)
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionInvalid"));
    }

    @Test(dataProvider = "subscriptionDataValid", priority = 21) 
    public void verifySubscriptionValid(String subscriptionEmail) throws IOException { 
        test = extent.createTest("Verify Subscription with Valid Email"); 

        productPage.scrollToBottom(); 
        test.pass("Scrolled to Subscription section");

        productPage.enterSubscription(subscriptionEmail); 
        test.pass("Entered valid subscription email: " + subscriptionEmail);
        test.pass("Subscription input field accepted the email correctly");

        productPage.clickSubscriptionButton(); 
        test.pass("Clicked Subscribe button to submit email");

        Assert.assertTrue(productPage.isSubscriptionSuccessDisplayed(), "Subscription success message not displayed"); 
        test.pass("Subscription success message displayed correctly")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionValid"));
    }

    @Test(dataProvider = "subscriptionDataValid", priority = 22) 
    public void verifySubscriptionUseralreadyExist(String subscriptionEmail) throws IOException { 
        test = extent.createTest("Verify Subscription with Already Existing Email"); 

        productPage.scrollToBottom(); 
        test.pass("Scrolled to Subscription section");

        productPage.enterSubscription(subscriptionEmail); 
        test.pass("Entered already registered email: " + subscriptionEmail);
        test.pass("Subscription field accepted the input correctly");

        productPage.clickSubscriptionButton(); 
        test.pass("Clicked Subscribe button for existing user email");

        boolean isSuccessDisplayed = productPage.isSubscriptionSuccessDisplayed();

        if (isSuccessDisplayed) {
            test.fail("Subscription success message displayed incorrectly for already registered email!")
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "SubscriptionUserAlreadyExist"));
        } else {
            test.pass("Subscription success message NOT displayed as expected for existing email")
                .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "NewSubscriptionUser"));
        }

        Assert.assertFalse(isSuccessDisplayed, "Subscription success message should NOT be displayed!");
    }

    @Test(priority = 23)
    public void verifyScrollToTopButton() throws IOException {
        test = extent.createTest("Verify Scroll To Top Button");

        productPage.scrollToBottom();
        test.pass("Scrolled down the page to make 'Scroll To Top' button visible");
        test.pass("Scroll To Top button located on the page");

        productPage.clickScrollToTopArrow();
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
    
    @DataProvider
    public Object[][] searchData() throws IOException {
        return Excelutilities.getdata(
            projectpath + "\\src\\test\\resources\\testdata\\datafile3.xlsx", "SearchProduct");
    }
    
}
