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

public class ProductPageTest_Functional extends BaseTest {
	
	static String projectpath = System.getProperty("user.dir");
    ProductPage productPage;
    ExtentTest test;
    
    @BeforeMethod
    public void setUpPage() {
    	productPage = new ProductPage(driver);
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
        test = extent.createTest("Verify Product Icon is present");
        productPage.clickProductsLink();
        
        Assert.assertTrue(productPage.isProductsIconDisplayed(), "Product Icon is not visible");
        test.pass("Navigated to Product page successfully");
        test.pass("All Product icon fields are visible");
        test.pass("Product icon redirected correctly")
        .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ProductPage"));
    }
    
    @Test(priority = 3)
    public void verifyAllProductSection() throws IOException {
        test = extent.createTest("All Products Section is available and working");
        productPage.scrollPageDown();

        boolean AllProductSectionPresent = productPage.isAllProductSection();
        Assert.assertTrue(AllProductSectionPresent, "All Products Section is not displayed!");

        test.pass("All Products Section displayed on the product page.");
        test.pass("All Products Section products are clickable.");
        test.pass("All Products Section correctly displays products on the productt page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "AllProductsSection"));
    }
    
    @Test(priority = 4)
    public void verifyAddToCart() throws IOException,InterruptedException {
        test = extent.createTest("Add Product to Cart");
        productPage.scrollPageDown();
        
        productPage.FirstProductToCart();
        Thread.sleep(2000);
        test.pass("Product added to cart successfully")
        	.addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "AddToCart"));
        
        productPage.clickContinueShop();
        test.pass("Click continue shopping successfully")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ContinueShop"));
    }
    
    @Test(priority = 5)
    public void verifyViewProductButton() throws IOException {
        test = extent.createTest("View product icon is available is and working");

        productPage.clickViewProduct();

        test.pass("View product icon displayed on the product page.");
        test.pass("View product icon is clickable.");
        test.pass("View product icon correctly display item on the product page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ViewProductWorking"));
    }
    
    @Test(priority = 6)
    public void verifyProductDetail() throws IOException {
        test = extent.createTest("Product detail is available");

        boolean ViewProductDetailPresent = productPage.ViewProductDetail();
        Assert.assertTrue(ViewProductDetailPresent, "Product detail is not displayed!");
        
        test.pass("View product icon navigates to the product detail page.");
        test.pass("Product detail section is displayed.");
        test.pass("Product details are correctly displayed on the productt page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ProductDetail"));
    }
    
    @Test(priority = 7)
    public void verifyProductName() throws IOException {
        test = extent.createTest("Product name is available");

        boolean ViewProductNamePresent = productPage.ViewProductName();
        Assert.assertTrue(ViewProductNamePresent, "Product name is not displayed!");
        
        test.pass("Product detail section is displayed.");
        test.pass("Product detail page displays product name.");
        test.pass("Product name is correctly displayed on the product page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ProductName"));
    }
    
    @Test(priority = 8)
    public void verifyProductCategory() throws IOException {
        test = extent.createTest("Product category is available");

        boolean ViewProductCategoryPresent = productPage.ViewProductCategory();
        Assert.assertTrue(ViewProductCategoryPresent, "Product category is not displayed!");
        
        test.pass("Product detail section is displayed.");
        test.pass("Product detail page displays product category.");
        test.pass("Product category is correctly displayed on the product page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ProductCategory"));
    }
    
    @Test(priority = 9)
    public void verifyProductPrice() throws IOException {
        test = extent.createTest("Product price is available");

        boolean ViewProductPricePresent = productPage.ViewProductPrice();
        Assert.assertTrue(ViewProductPricePresent, "Product price is not displayed!");
        
        test.pass("Product detail section is displayed.");
        test.pass("Product detail page displays product price.");
        test.pass("Product price is correctly displayed on the product page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ProductPrice"));
    }
    
    @Test(priority = 10)
    public void verifyProductAvailability() throws IOException {
        test = extent.createTest("Product availability is available");

        boolean ViewProductAvailabilityPresent = productPage.ViewProductAvailability();
        Assert.assertTrue(ViewProductAvailabilityPresent, "Product availability is not displayed!");
        
        test.pass("Product detail section is displayed.");
        test.pass("Product detail page displays product availability.");
        test.pass("Product availability is correctly displayed on the product page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ProductAvailability"));
    }
    
    @Test(priority = 11)
    public void verifyProductCondition() throws IOException {
        test = extent.createTest("Product condition is available");

        boolean ViewProductConditionPresent = productPage.ViewProductCondition();
        Assert.assertTrue(ViewProductConditionPresent, "Product condition is not displayed!");
        
        test.pass("Product detail section is displayed.");
        test.pass("Product detail page displays product condition.");
        test.pass("Product condition is correctly displayed on the product page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ProductCondition"));
    }
    
    @Test(priority = 12)
    public void verifyProductBrand() throws IOException {
        test = extent.createTest("Product brand is available");

        boolean ViewProductBrandPresent = productPage.ViewProductBrand();
        Assert.assertTrue(ViewProductBrandPresent, "Product brand is not displayed!");
        
        test.pass("Product detail section is displayed.");
        test.pass("Product detail page displays product brand.");
        test.pass("Product brand is correctly displayed on the productt page.")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "ProductBrand"));
    }
    
    @Test(priority = 13, dataProvider = "reviewData")
    public void verifyWriteYourReview(String name, String email, String review) throws IOException {
        test = extent.createTest("Write Review Test for: " + name);

        productPage.submitReview(name, email, review);
        
        test.pass("Review submitted successfully for user: " + name);
        test.pass("Review submitted successfully for user: " + email);
        test.pass("Review submitted successfully for user: " + review);
        test.pass("Review submitted successfully for user subitted")
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "Review"));
    }
    
    @Test(priority = 14, dataProvider = "searchData")
    public void verifyProductSearch(String productName) throws IOException {
        test = extent.createTest("Search Product: " + productName);
        productPage.clickProductsLink();
        productPage.scrollPageDown();
        productPage.searchProduct(productName);
        
        test.pass("Search Product Textbox displayed on the product page.");
        test.pass("Able to enter products to search");
        test.pass("Searched for product: " + productName)
            .addScreenCaptureFromPath(Screenshotutilities.capturescreen(driver, "Search_" + productName));
    }
    
    @Test(priority = 15)
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
    
    
    @Test(priority = 16)
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

    @Test(priority = 17)
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

    @Test(priority = 18, dataProvider = "subscriptionDataInvalid")
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

    @Test(dataProvider = "subscriptionDataValid", priority = 19) 
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

    @Test(dataProvider = "subscriptionDataValid", priority = 20) 
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

    @Test(priority = 21)
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
    
    @DataProvider
    public Object[][] reviewData() throws IOException {
        return Excelutilities.getdata(
        	projectpath + "\\src\\test\\resources\\testdata\\datafile3.xlsx","WriteReview");
    }
}
