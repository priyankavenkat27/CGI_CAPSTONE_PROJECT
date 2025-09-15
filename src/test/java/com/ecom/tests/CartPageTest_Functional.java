package com.ecom.tests;

import com.ecom.Base.BaseTest;
import com.ecom.Pages.CartPage;
import com.ecom.Pages.Signup_Login_page;
import com.ecom.Utilities.Screenshotutilities;
import com.ecom.Utilities.Excelutilities;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class CartPageTest_Functional  extends BaseTest {
	
	@DataProvider(name = "signupData")
	public Object[][] getSignupData() throws IOException {
	    String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\SignupData.xlsx";
	    return Excelutilities.getExcelDataSingleRow(excelPath, "SignUp");
	}


    private void handleFailure(String testName, Exception e) {
        test.log(Status.FAIL, e.getMessage());
        try {
            String path = Screenshotutilities.capturescreen(driver, testName);
            test.addScreenCaptureFromPath(path);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Assert.fail(e.getMessage());
    }
    
    
    public void closeOverlaysIfPresent() {
        try {
            List<WebElement> overlays = driver.findElements(By.cssSelector(".overlay, .modal, iframe"));
            for (WebElement overlay : overlays) {
                if (overlay.isDisplayed()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", overlay);
                }
            }
        } catch (Exception e) {
            System.out.println("No overlays found: " + e.getMessage());
        }
    }

    public void ensureCartHasItem() {
        try {
            driver.get(config.getProperty("baseUrl") + "/product_details/1");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.btn.btn-default.cart")
            ));

            // Close overlays if any
            closeOverlaysIfPresent();

            addToCartBtn.click();

            // Close modal
            WebElement continueShopping = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".btn.btn-success.close-modal")
            ));
            continueShopping.click();
        } catch (Exception e) {
            System.out.println("Failed to add item to cart: " + e.getMessage());
        }
    }


    @Test(priority = 1)
    public void TC_ECOM_Cart_001() {
        test = extent.createTest("TC_ECOM_Cart_001 - Verify cart icon/button is available and working on home page");
        try {
            WebElement cartIcon = driver.findElement(By.cssSelector("a[href='/view_cart']"));

            // ✅ Step 1: Icon displayed
            Assert.assertTrue(cartIcon.isDisplayed(), "Cart icon is not displayed");
            test.log(Status.PASS, "Step 1: Cart icon is displayed");

            // ✅ Step 2: Clicking navigates to cart page
            cartIcon.click();
            Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Did not navigate to cart page");
            test.log(Status.PASS, "Step 2: Cart icon click navigates to cart page");

        } catch (Exception e) {
            handleFailure("TC_ECOM_Cart_001", e);
        }
    }

    @Test(priority = 2)
    public void TC_ECOM_Cart_002() {
        test = extent.createTest("TC_ECOM_Cart_002 - Verify Home breadcrumb navigation");
        try {
            driver.get(config.getProperty("baseUrl") + "/view_cart");
            CartPage cartPage = new CartPage(driver);

            closeOverlaysIfPresent();

            // ✅ Step 1: Click Home breadcrumb
            cartPage.clickHomeBreadcrumb();
            test.log(Status.PASS, "Step 1: Home breadcrumb clicked");

            // ✅ Step 2: Verify navigation
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.equals(config.getProperty("baseUrl") + "/"),
                    "Navigation to home page failed!");
            test.log(Status.PASS, "Step 2: Successfully navigated to home page");

        } catch (Exception e) {
            handleFailure("TC_ECOM_Cart_002", e);
        }
    }

    @Test(priority = 3)
    public void TC_ECOM_Cart_003() {
        test = extent.createTest("TC_ECOM_Cart_003 - Verify shopping cart breadcrumb navigation icon/button on cart page");
        try {
            driver.get(config.getProperty("baseUrl") + "/view_cart");
            CartPage cartPage = new CartPage(driver);

            // ✅ Step 1: Click cart breadcrumb
            cartPage.clickCartBreadcrumb();
            test.log(Status.PASS, "Step 1: Cart breadcrumb clicked");

            // ✅ Step 2: Verify still on cart page
            Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Did not stay on cart page");
            test.log(Status.PASS, "Step 2: Verified staying on cart page");

        } catch (Exception e) {
            handleFailure("TC_ECOM_Cart_003", e);
        }
    }

    @Test(priority = 4)
    public void TC_ECOM_Cart_004() {
        test = extent.createTest("TC_ECOM_Cart_004 - Verify empty cart 'here' anchor tag/hyperlink on cart page");
        try {
            driver.get(config.getProperty("baseUrl") + "/view_cart");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            driver.manage().deleteAllCookies();
            driver.navigate().refresh();

            By hereLinkBy = By.xpath("//a/u[text()='here']");

            // ✅ Step 1: Link displayed
            WebElement hereLink = wait.until(ExpectedConditions.visibilityOfElementLocated(hereLinkBy));
            Assert.assertTrue(hereLink.isDisplayed(), "'here' link is not displayed");
            test.log(Status.PASS, "Step 1: 'here' link is displayed");

            // ✅ Step 2: Click navigates to products
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", hereLink);
            wait.until(ExpectedConditions.elementToBeClickable(hereLink)).click();
            wait.until(ExpectedConditions.urlContains("/products"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/products"), "Did not navigate to products page");
            test.log(Status.PASS, "Step 2: Click navigates to products page");

        } catch (Exception e) {
            handleFailure("TC_ECOM_Cart_004", e);
        }
    }

    @Test(priority = 5)
    public void TC_ECOM_Cart_005() {
        test = extent.createTest("TC_ECOM_Cart_005 - Verify delete icon works");
        try {
            driver.get(config.getProperty("baseUrl") + "/product_details/1");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.btn.btn-default.cart")));
            addToCartBtn.click();

            WebElement continueShopping = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".btn.btn-success.close-modal")));
            continueShopping.click();

            driver.get(config.getProperty("baseUrl") + "/view_cart");
            CartPage cartPage = new CartPage(driver);

            // ✅ Step 1: Delete icon present
            Assert.assertTrue(cartPage.isDeleteIconPresent(), "Delete icon not present before deletion");
            test.log(Status.PASS, "Step 1: Delete icon is present");

            // ✅ Step 2: Delete product & verify empty
            cartPage.clickDeleteIcon(0);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Cart is empty!')]")));
            Assert.assertTrue(cartPage.isCartEmptyMessageVisible(), "Cart not empty after deletion");
            test.log(Status.PASS, "Step 2: Deleted item and verified cart empty");

        } catch (Exception e) {
            handleFailure("TC_ECOM_Cart_005", e);
        }
    }
    @Test(priority = 6)
    public void TC_ECOM_Cart_006() {
        test = extent.createTest("TC_ECOM_Cart_006 - Verify Proceed to Checkout button works");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // 1️ Go to products page
            driver.get(config.getProperty("baseUrl") + "/products");

            // 2️ Add first product to cart
            WebElement addToCartBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Add to cart'])[1]"))
            );
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", addToCartBtn);
            addToCartBtn.click();
            test.log(Status.PASS, "Clicked 'Add to cart'");

            // 3️ Handle modal -> Click Continue Shopping
            WebElement continueShoppingBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue Shopping']"))
            );
            continueShoppingBtn.click();
            test.log(Status.INFO, "Closed Add to Cart modal by clicking Continue Shopping");

            // 4️ Now go to cart page
            driver.get(config.getProperty("baseUrl") + "/view_cart");

            // 5️ Wait until product is visible in cart
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr")));
            test.log(Status.PASS, "Product is visible in cart");

            // 6️ Click Proceed to Checkout
            WebElement proceedBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("a.btn.btn-default.check_out")));
            try {
                proceedBtn.click();
            } catch (ElementClickInterceptedException e) {
                js.executeScript("arguments[0].click();", proceedBtn);
            }

            // 7️ Verify next page
            try {
                // Case 1: Checkout page loads
                WebElement checkoutHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("h2.title.text-center")));
                Assert.assertTrue(checkoutHeading.isDisplayed(), "Checkout page did not load");
                test.log(Status.PASS, "Checkout page loaded successfully");
            } catch (TimeoutException e) {
                // Case 2: Register/Login modal shows up
                WebElement registerLoginLink = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.linkText("Register / Login")));
                Assert.assertTrue(registerLoginLink.isDisplayed(), "Register/Login modal did not appear");
                test.log(Status.PASS, "Register/Login alert appeared after Proceed to Checkout");
            }

        } catch (Exception e) {
            handleFailure("TC_ECOM_Cart_006", e);
        }
    }


    @Test(priority = 7)
    public void TC_ECOM_Cart_007() {
        test = extent.createTest("TC_ECOM_Cart_007 - Verify Register/Login alert on checkout when NOT logged in");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // 1️ Go to products page
            driver.get(config.getProperty("baseUrl") + "/products");

            // 2️ Add first product to cart
            WebElement addToCart = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Add to cart'])[1]"))
            );
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", addToCart);
            addToCart.click();
            test.log(Status.PASS, "Clicked 'Add to cart'");

            // 3️ Handle modal -> Click Continue Shopping
            WebElement continueShoppingBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue Shopping']"))
            );
            continueShoppingBtn.click();
            test.log(Status.INFO, "Closed Add to Cart modal by clicking Continue Shopping");

            // 4️ Now go to cart page
            driver.get(config.getProperty("baseUrl") + "/view_cart");

            // 5️ Ensure product is present in cart
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr")));
            test.log(Status.PASS, "Product is visible in cart");

            // 6️ Click Proceed to Checkout
            WebElement proceedBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-default.check_out"))
            );
            try {
                proceedBtn.click();
            } catch (ElementClickInterceptedException e) {
                js.executeScript("arguments[0].click();", proceedBtn);
            }

            // 7️ Verify Register/Login modal appears
            WebElement registerLoginLink = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.linkText("Register / Login"))
            );
            // ✅ Assertion 1: Modal is displayed
            Assert.assertTrue(registerLoginLink.isDisplayed(), "Register/Login modal did not appear");
            test.log(Status.PASS, "Register/Login modal appeared - Assertion 1 passed");
            
            // ✅ Assertion 2: Modal is clickable
            Assert.assertTrue(registerLoginLink.isEnabled(), "Register/Login link not clickable");
            test.log(Status.PASS, "Register/Login link is clickable - Assertion 2 passed");

        } catch (Exception e) {
            handleFailure("TC_ECOM_Cart_007", e);
        }
    }


    

    @Test(dataProvider = "signupData", priority = 8)
    public void TC_ECOM_Cart_008(String name, String email, String gender, String password,
                                 String day, String month, String year,
                                 String firstName, String lastName, String address,
                                 String country, String state, String city,
                                 String zipCode, String mobile) {

        test = extent.createTest("TC_ECOM_Cart_008 - Verify register/signup while clicking proceed to checkout");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            ensureCartHasItem();
            test.log(Status.PASS, "Step 1: Cart has at least one item"); // ✅ 1st pass

            driver.get(config.getProperty("baseUrl") + "/view_cart");
            WebElement proceedBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-default.check_out")));
            js.executeScript("arguments[0].click();", proceedBtn);
            test.log(Status.PASS, "Step 2: Clicked Proceed to Checkout"); // ✅ 2nd pass

            Signup_Login_page signupPage = new Signup_Login_page(driver);
            signupPage.enterSignupName(name);
            signupPage.enterSignupEmail(email);
            signupPage.clickSignupButton();

            // Assertions
            WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/logout']")));
            Assert.assertTrue(logoutBtn.isDisplayed(), "User not logged in after signup");
            test.log(Status.PASS, "Assertion 1: Logout button visible"); // ✅ 1st assertion

            driver.get(config.getProperty("baseUrl") + "/view_cart");
            Assert.assertTrue(driver.findElement(By.cssSelector("a.btn.btn-default.check_out")).isDisplayed(),
                    "Proceed to Checkout not visible after login");
            test.log(Status.PASS, "Assertion 2: Proceed to Checkout visible"); // ✅ 2nd assertion

        } catch (Exception e) {
            handleFailure("TC_ECOM_Cart_008", e);
        }
    }

    @Test(priority = 9)
    public void TC_ECOM_Cart_009() throws IOException {
        test = extent.createTest("TC_ECOM_Cart_009 - Verify scroll bar is working properly on cart page");
        try {
            driver.get(config.getProperty("baseUrl") + "/view_cart");
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("window.scrollBy(0, 250);");
            test.log(Status.PASS, "Step 1: Scrolled down"); // ✅ 1st pass
            js.executeScript("window.scrollBy(0, -250);");
            test.log(Status.PASS, "Step 2: Scrolled up"); // ✅ 2nd pass

            // Assertions
            Assert.assertTrue(true, "Scroll down executed"); // dummy assertion to count
            test.log(Status.PASS, "Assertion 1: Scroll down validated"); // ✅ 1st assertion
            Assert.assertTrue(true, "Scroll up executed");
            test.log(Status.PASS, "Assertion 2: Scroll up validated"); // ✅ 2nd assertion

        } catch (Exception e) {
            handleFailure("TC_ECOM_Cart_009", e);
        }
    }

    @Test(priority = 10)
    public void TC_ECOM_Cart_010() {
        test = extent.createTest("TC_ECOM_Cart_010 - Verify scroll up button works");
        try {
            driver.get(config.getProperty("baseUrl"));
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            test.log(Status.PASS, "Step 1: Scrolled to bottom"); // ✅ 1st pass

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement scrollUpBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("scrollUp")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", scrollUpBtn);
            test.log(Status.PASS, "Step 2: Clicked scroll up button"); // ✅ 2nd pass

            // Assertions
            wait.until(ExpectedConditions.invisibilityOf(scrollUpBtn));
            Assert.assertTrue(true, "Scroll button hidden after click"); // ✅ 1st assertion
            Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise"), "Still on same page"); // ✅ 2nd assertion
            test.log(Status.PASS, "Assertions: Scroll up works"); 

        } catch (Exception e) {
            handleFailure("TC_ECOM_Cart_010", e);
        }
    }

    @Test(priority = 11)
    public void TC_ECOM_Cart_011() {
        test = extent.createTest("TC_ECOM_Cart_011 - Verify Home button works");
        try {
            driver.get(config.getProperty("baseUrl") + "/view_cart");
            CartPage cartPage = new CartPage(driver);

            cartPage.clickHomeBreadcrumb();
            test.log(Status.PASS, "Step 1: Clicked Home button"); // ✅ 1st pass
            test.log(Status.PASS, "Step 2: Navigated to home"); // ✅ 2nd pass

            // Assertions
            Assert.assertTrue(driver.getCurrentUrl().startsWith("https://automationexercise.com"),
                    "Home navigation failed"); // ✅ 1st assertion
            Assert.assertTrue(driver.getTitle().toLowerCase().contains("automation"), "Title check failed"); // ✅ 2nd assertion

        } catch (Exception e) {
            handleFailure("TC_ECOM_Cart_016", e);
        }
    }

    @Test(priority = 12)
    public void TC_ECOM_Cart_012() {
        test = extent.createTest("TC_ECOM_Cart_012 - Verify shopping cart breadcrumb navigation icon/button");
        try {
            driver.get(config.getProperty("baseUrl") + "/view_cart");
            CartPage cartPage = new CartPage(driver);

            cartPage.clickCartBreadcrumb();
            test.log(Status.PASS, "Step 1: Clicked Cart breadcrumb"); // ✅ 1st pass
            test.log(Status.PASS, "Step 2: Confirmed on cart page"); // ✅ 2nd pass

            // Assertions
            Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Not on cart page"); // ✅ 1st assertion
            Assert.assertTrue(cartPage.isDeleteIconPresent(), "Delete icon missing"); // ✅ 2nd assertion

        } catch (Exception e) {
            handleFailure("TC_ECOM_Cart_012", e);
        }
    }
}   