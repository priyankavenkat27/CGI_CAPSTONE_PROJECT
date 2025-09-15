package com.ecom.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.ecom.Pages.HomePage;
import com.ecom.Base.BaseTest;
import com.ecom.Utilities.Excelutilities;
import com.ecom.Utilities.Screenshotutilities;
import com.aventstack.extentreports.ExtentTest;

public class UI_HomePageTest extends BaseTest {
	static String projectpath = System.getProperty("user.dir");

	@Test(priority = 1)
    public void verifyAutomationEngineerLogoIsVisible() {
        HomePage HomePage = new HomePage(driver);

        test.info("🔍 Navigating to Home page");
        HomePage.clickHome();

        test.info("🔍 Validating 'Automation Engineer' logo visibility");
        boolean isLogoVisible = HomePage.isAutomationLogoVisible();

        String screenshotFile = "";
        try {
            screenshotFile = Screenshotutilities.capturescreen(driver, "AutomationEngineerLogo");
        } catch (Exception e) {
            test.warning("⚠️ Screenshot capture failed: " + e.getMessage());
        }

        if (isLogoVisible) {
            test.pass("✅ 'Automation Engineer' logo is visible on the HomePage.")
                .addScreenCaptureFromPath(screenshotFile);
        } else {
            test.fail("❌ 'Automation Engineer' logo is NOT visible on the HomePage.")
                .addScreenCaptureFromPath(screenshotFile);
        }

        Assert.assertTrue(isLogoVisible, "Logo image should be visible.");

    }
	@Test(priority = 2)
	
	public void verifyProductsButtonIsVisibleAndNavigates() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifyProductsButtonIsVisibleAndNavigates");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();

	    test.info("🔍 Checking visibility of 'Products' button");
	    boolean isVisible = HomePage.isProductsButtonVisible();
	    String screenshot = Screenshotutilities.capturescreen(driver, "ProductsButton");

	    if (isVisible) {
	        test.pass("✅ 'Products' button is visible").addScreenCaptureFromPath(screenshot);

	        test.info("🖱️ Clicking 'Products' button");
	        HomePage.clickProducts();
	        String currentUrl = driver.getCurrentUrl();
	        String navScreenshot = Screenshotutilities.capturescreen(driver, "ProductsNavigation");

	        if (currentUrl.contains("/products")) {
	            test.pass("✅ Navigation to Products page successful").addScreenCaptureFromPath(navScreenshot);
	        } else {
	            test.fail("❌ Navigation to Products page failed. URL: " + currentUrl)
	                .addScreenCaptureFromPath(navScreenshot);
	        }

	        Assert.assertTrue(currentUrl.contains("/products"), "Should navigate to Products page.");
	    } else {
	        test.fail("❌ 'Products' button is NOT visible").addScreenCaptureFromPath(screenshot);
	        Assert.fail("'Products' button should be visible.");
	    }
	}
	@Test(priority = 3)
	public void verifyCartButtonIsVisibleAndNavigates() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifyCartButtonIsVisibleAndNavigates");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();

	    test.info("🔍 Checking visibility of 'Cart' button");
	    boolean isVisible = HomePage.isCartButtonVisible();
	    String screenshot = Screenshotutilities.capturescreen(driver, "CartButton");

	    if (isVisible) {
	        test.pass("✅ 'Cart' button is visible").addScreenCaptureFromPath(screenshot);

	        test.info("🖱️ Clicking 'Cart' button");
	        HomePage.clickCart();
	        String currentUrl = driver.getCurrentUrl();
	        String navScreenshot = Screenshotutilities.capturescreen(driver, "CartNavigation");

	        if (currentUrl.contains("/view_cart")) {
	            test.pass("✅ Navigation to Cart page successful").addScreenCaptureFromPath(navScreenshot);
	        } else {
	            test.fail("❌ Navigation to Cart page failed. URL: " + currentUrl)
	                .addScreenCaptureFromPath(navScreenshot);
	        }

	        Assert.assertTrue(currentUrl.contains("/view_cart"), "Should navigate to Cart page.");
	    } else {
	        test.fail("❌ 'Cart' button is NOT visible").addScreenCaptureFromPath(screenshot);
	        Assert.fail("'Cart' button should be visible.");
	    }
	}
	@Test(priority = 4)
	public void verifySignupLoginButtonIsVisibleAndNavigates() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifySignupLoginButtonIsVisibleAndNavigates");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();

	    test.info("🔍 Checking visibility of 'Signup/Login' button");
	    boolean isVisible = HomePage.isSignupLoginButtonVisible();
	    String screenshot = Screenshotutilities.capturescreen(driver, "SignupLoginButton");

	    if (isVisible) {
	        test.pass("✅ 'Signup/Login' button is visible").addScreenCaptureFromPath(screenshot);

	        test.info("🖱️ Clicking 'Signup/Login' button");
	        HomePage.clickSignupLogin();
	        String currentUrl = driver.getCurrentUrl();
	        String navScreenshot = Screenshotutilities.capturescreen(driver, "SignupLoginNavigation");

	        if (currentUrl.contains("/login")) {
	            test.pass("✅ Navigation to Signup/Login page successful").addScreenCaptureFromPath(navScreenshot);
	        } else {
	            test.fail("❌ Navigation to Signup/Login page failed. URL: " + currentUrl)
	                .addScreenCaptureFromPath(navScreenshot);
	        }

	        Assert.assertTrue(currentUrl.contains("/login"), "Should navigate to Signup/Login page.");
	    } else {
	        test.fail("❌ 'Signup/Login' button is NOT visible").addScreenCaptureFromPath(screenshot);
	        Assert.fail("'Signup/Login' button should be visible.");
	    }
	}
	@Test(priority = 5)
	public void verifyContactUsButtonIsVisibleAndNavigates() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifyContactUsButtonIsVisibleAndNavigates");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();

	    test.info("🔍 Checking visibility of 'Contact Us' button");
	    boolean isVisible = HomePage.isContactUsButtonVisible();
	    String screenshot = Screenshotutilities.capturescreen(driver, "ContactUsButton");

	    if (isVisible) {
	        test.pass("✅ 'Contact Us' button is visible").addScreenCaptureFromPath(screenshot);

	        test.info("🖱️ Clicking 'Contact Us' button");
	        HomePage.clickContactUs();
	        String currentUrl = driver.getCurrentUrl();
	        String navScreenshot = Screenshotutilities.capturescreen(driver, "ContactUsNavigation");

	        if (currentUrl.contains("/contact_us")) {
	            test.pass("✅ Navigation to Contact Us page successful").addScreenCaptureFromPath(navScreenshot);
	        } else {
	            test.fail("❌ Navigation to Contact Us page failed. URL: " + currentUrl)
	                .addScreenCaptureFromPath(navScreenshot);
	        }

	        Assert.assertTrue(currentUrl.contains("/contact_us"), "Should navigate to Contact Us page.");
	    } else {
	        test.fail("❌ 'Contact Us' button is NOT visible").addScreenCaptureFromPath(screenshot);
	        Assert.fail("'Contact Us' button should be visible.");
	    }
	}
	@Test(priority = 6)
	public void verifyTestCasesButtonIsVisibleAndNavigates() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifyTestCasesButtonIsVisibleAndNavigates");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();

	    test.info("🔍 Checking visibility of 'Test Cases' button");
	    boolean isVisible = HomePage.isTestCasesButtonVisible();
	    String screenshot = Screenshotutilities.capturescreen(driver, "TestCasesButton");

	    if (isVisible) {
	        test.pass("✅ 'Test Cases' button is visible").addScreenCaptureFromPath(screenshot);

	        test.info("🖱️ Clicking 'Test Cases' button");
	        HomePage.clickTestCases();
	        String currentUrl = driver.getCurrentUrl();
	        String navScreenshot = Screenshotutilities.capturescreen(driver, "TestCasesNavigation");

	        if (currentUrl.contains("/test_cases")) {
	            test.pass("✅ Navigation to Test Cases page successful").addScreenCaptureFromPath(navScreenshot);
	        } else {
	            test.fail("❌ Navigation to Test Cases page failed. URL: " + currentUrl)
	                .addScreenCaptureFromPath(navScreenshot);
	        }

	        Assert.assertTrue(currentUrl.contains("/test_cases"), "Should navigate to Test Cases page.");
	    } else {
	        test.fail("❌ 'Test Cases' button is NOT visible").addScreenCaptureFromPath(screenshot);
	        Assert.fail("'Test Cases' button should be visible.");
	    }
	}
	@Test(priority = 7)
	public void verifyApiTestingButtonIsVisibleAndNavigates() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifyApiTestingButtonIsVisibleAndNavigates");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();

	    test.info("🔍 Checking visibility of 'API Testing' button");
	    boolean isVisible = HomePage.isApiTestingButtonVisible();
	    String screenshot = Screenshotutilities.capturescreen(driver, "ApiTestingButton");

	    if (isVisible) {
	        test.pass("✅ 'API Testing' button is visible").addScreenCaptureFromPath(screenshot);

	        test.info("🖱️ Clicking 'API Testing' button");
	        HomePage.clickApiTesting();
	        String currentUrl = driver.getCurrentUrl();
	        String navScreenshot = Screenshotutilities.capturescreen(driver, "ApiTestingNavigation");

	        if (currentUrl.contains("/api_list")) {
	            test.pass("✅ Navigation to API Testing page successful").addScreenCaptureFromPath(navScreenshot);
	        } else {
	            test.fail("❌ Navigation to API Testing page failed. URL: " + currentUrl)
	                .addScreenCaptureFromPath(navScreenshot);
	        }

	        Assert.assertTrue(currentUrl.contains("/api_list"), "Should navigate to API Testing page.");
	    } else {
	        test.fail("❌ 'API Testing' button is NOT visible").addScreenCaptureFromPath(screenshot);
	        Assert.fail("'API Testing' button should be visible.");
	    }
	}
	@Test(priority = 8)
	public void verifyVideoTutorialsButtonIsVisibleAndNavigatesAndReturns() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifyVideoTutorialsButtonIsVisibleAndNavigatesAndReturns");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();

	    test.info("🔍 Checking visibility of 'Video Tutorials' button");
	    boolean isVisible = HomePage.isVideoTutorialsButtonVisible();
	    String screenshot = Screenshotutilities.capturescreen(driver, "VideoTutorialsButton");

	    if (isVisible) {
	        test.pass("✅ 'Video Tutorials' button is visible").addScreenCaptureFromPath(screenshot);

	        test.info("🖱️ Clicking 'Video Tutorials' button");
	        HomePage.clickVideoTutorials();

	        // Wait for YouTube to load
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.urlContains("youtube.com"));

	        String youtubeUrl = driver.getCurrentUrl();
	        String youtubeScreenshot = Screenshotutilities.capturescreen(driver, "YouTubePage");

	        if (youtubeUrl.contains("youtube.com")) {
	            test.pass("✅ Navigated to YouTube successfully").addScreenCaptureFromPath(youtubeScreenshot);
	        } else {
	            test.fail("❌ Failed to navigate to YouTube. URL: " + youtubeUrl)
	                .addScreenCaptureFromPath(youtubeScreenshot);
	        }

	        Assert.assertTrue(youtubeUrl.contains("youtube.com"), "Should navigate to YouTube Video Tutorials.");

	        // ✅ Navigate back to HomePage
	        test.info("↩️ Navigating back to HomePage");
	        driver.navigate().back();

	        // Wait for HomePage to reload
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),' Home')]")));

	        String backScreenshot = Screenshotutilities.capturescreen(driver, "ReturnedToHomePage");
	        test.pass("✅ Returned to HomePage successfully").addScreenCaptureFromPath(backScreenshot);

	    } else {
	        test.fail("❌ 'Video Tutorials' button is NOT visible").addScreenCaptureFromPath(screenshot);
	        Assert.fail("'Video Tutorials' button should be visible.");
	    }
	}

	@Test(priority = 9)
	public void verifyScrollBarFunctionalityOnHomePage() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifyScrollBarFunctionalityOnHomePage");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();

	    test.info("🔍 Scrolling down the HomePage to verify scroll bar functionality");
	    HomePage.scrollPageDown(1000); // scroll down by 1000 pixels

	    String scrollScreenshot = Screenshotutilities.capturescreen(driver, "ScrollBarFunctionality");

	    // Validate scroll by checking visibility of footer or any lower element
	    boolean isScrolled = ((JavascriptExecutor) driver)
	        .executeScript("return window.pageYOffset > 500;").equals(true);

	    if (isScrolled) {
	        test.pass("✅ Scroll bar is working properly").addScreenCaptureFromPath(scrollScreenshot);
	    } else {
	        test.fail("❌ Scroll bar did not scroll the page as expected").addScreenCaptureFromPath(scrollScreenshot);
	    }

	    Assert.assertTrue(isScrolled, "Scroll bar should move the page vertically.");
	}
	@Test(priority = 10)
	public void verifyScrollToTopArrowFunctionality() throws IOException, InterruptedException {
	    ExtentTest test = extent.createTest("Test Execution: verifyScrollToTopArrowFunctionality");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();

	    test.info("🔍 Scrolling down to activate 'Back to Top' arrow");
	    HomePage.scrollPageDown(1500); // scroll deep enough to trigger arrow

	    Thread.sleep(2000); // wait for arrow to appear

	    test.info("🖱️ Clicking 'Back to Top' arrow using JavaScript");
	    ((JavascriptExecutor) driver).executeScript("document.querySelector('#scrollUp').click();");

	    Thread.sleep(2000); // wait for scroll to complete

	    String topScreenshot = Screenshotutilities.capturescreen(driver, "ScrollToTopArrow");

	    // Validate scroll to top by checking Y offset
	    boolean isAtTop = ((JavascriptExecutor) driver)
	        .executeScript("return window.pageYOffset == 0;").equals(true);

	    if (isAtTop) {
	        test.pass("✅ 'Back to Top' arrow scrolled the page to top").addScreenCaptureFromPath(topScreenshot);
	    } else {
	        test.fail("❌ 'Back to Top' arrow did not scroll to top").addScreenCaptureFromPath(topScreenshot);
	    }

	    Assert.assertTrue(isAtTop, "Page should scroll to top when 'Back to Top' arrow is clicked.");
	}
	@Test(priority = 11)
	public void verifySubscriptionIconIsVisibleOnHomePage() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifySubscriptionIconIsVisibleOnHomePage");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();

	    test.info("🔍 Scrolling to subscription section");
	    try {
	        WebElement subscriptionField = driver.findElement(By.id("susbscribe_email"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subscriptionField);
	        Thread.sleep(1000); // allow scroll to complete
	    } catch (Exception e) {
	        test.fail("❌ Unable to locate subscription field for scrolling");
	        Assert.fail("Subscription field not found.");
	    }

	    test.info("🔍 Checking visibility of subscription email field and button");

	    boolean emailFieldVisible = driver.findElements(By.id("susbscribe_email")).size() > 0 &&
	                                driver.findElement(By.id("susbscribe_email")).isDisplayed();

	    boolean subscribeBtnVisible = driver.findElements(By.id("subscribe")).size() > 0 &&
	                                  driver.findElement(By.id("subscribe")).isDisplayed();

	    String screenshot = Screenshotutilities.capturescreen(driver, "SubscriptionIconVisibility");

	    if (emailFieldVisible && subscribeBtnVisible) {
	        test.pass("✅ Subscription email field and button are visible").addScreenCaptureFromPath(screenshot);
	    } else {
	        test.fail("❌ Subscription section is not fully visible").addScreenCaptureFromPath(screenshot);
	        Assert.fail("Subscription email field or button is missing.");
	    }
	}


	@Test(priority = 12, dataProvider = "subscriptionData")
	public void verifySubscriptionScenarios(String email, String type) throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: Subscription - " + type);

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();
	    test.pass("✅ Navigated to Home Page");

	    HomePage.scrollPageDown(1000);
	    test.pass("✅ Page scrolled down successfully");

	    HomePage.clearsubscriptionEmail();
	    HomePage.enterSubscriptionEmail(email);
	    HomePage.clickSubscribe();
	    test.pass("✅ Subscription email entered and Subscribe clicked");

	    String screenshot = Screenshotutilities.capturescreen(driver, "Subscription_" + type);

	    String message = "";
	    try {
	        message = HomePage.getSuccessMessage().trim();
	    } catch (Exception e) {
	        message = ""; // No message shown
	    }

	    type = type != null ? type.trim().toLowerCase() : "";

	    switch (type) {
	        case "valid":
	        case "duplicate":
	            if (message.contains("successfully subscribed")) {
	                test.pass("✅ " + type + " email subscription successful").addScreenCaptureFromPath(screenshot);
	            } else {
	                test.fail("❌ " + type + " email subscription failed. Message: " + message)
	                    .addScreenCaptureFromPath(screenshot);
	                Assert.fail("Expected success message not found.");
	            }
	            break;

	        case "invalid":
	        case "blank":
	            if (message.isEmpty() || !message.contains("successfully subscribed")) {
	                test.pass("✅ " + type + " email was correctly rejected").addScreenCaptureFromPath(screenshot);
	            } else {
	                test.fail("❌ " + type + " email was incorrectly accepted. Message: " + message)
	                    .addScreenCaptureFromPath(screenshot);
	                Assert.fail(type + " email should not be accepted.");
	            }
	            break;

	        default:
	            test.fail("❌ Unknown email type: '" + type + "' — check Excel data").addScreenCaptureFromPath(screenshot);
	            Assert.fail("Unrecognized email type: " + type);
	    }
	}

	@Test(priority = 13)
	public void verifyViewProductButtonIsVisible() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifyViewProductButtonIsVisible");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();
	    test.pass("✅ Navigated to Home Page");

	    boolean isVisible = HomePage.isViewProductButtonVisible();
	    test.pass("✅ Checked visibility of 'View Product' button");

	    String screenshot = Screenshotutilities.capturescreen(driver, "ViewProductButton");
	    test.pass("✅ Captured screenshot for 'View Product' button");

	    if (isVisible) {
	        test.pass("✅ 'View Product' button is visible").addScreenCaptureFromPath(screenshot);
	    } else {
	        test.fail("❌ 'View Product' button is NOT visible").addScreenCaptureFromPath(screenshot);
	        Assert.fail("'View Product' button should be visible.");
	    }
	}

	@Test(priority = 14)
	public void verifyBrandsSectionIsVisible() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifyBrandsSectionIsVisible");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();
	    test.pass("✅ Navigated to Home Page");

	    HomePage.scrollPageDown(1500);
	    test.pass("✅ Scrolled down to Brands Section");

	    boolean isVisible = HomePage.isBrandsSectionVisible();
	    test.pass("✅ Checked visibility of Brands Section");

	    String screenshot = Screenshotutilities.capturescreen(driver, "BrandsSection");
	    test.pass("✅ Captured screenshot for Brands Section");

	    if (isVisible) {
	        test.pass("✅ Brands section is visible").addScreenCaptureFromPath(screenshot);
	    } else {
	        test.fail("❌ Brands section is NOT visible").addScreenCaptureFromPath(screenshot);
	        Assert.fail("Brands section should be visible.");
	    }
	}

	@Test(priority = 15)
	public void verifyCategorySectionIsVisible() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifyCategorySectionIsVisible");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();
	    test.pass("✅ Navigated to Home Page");

	    boolean isVisible = HomePage.isCategorySectionVisible();
	    test.pass("✅ Checked visibility of Category Section");

	    String screenshot = Screenshotutilities.capturescreen(driver, "CategorySection");
	    test.pass("✅ Captured screenshot for Category Section");

	    if (isVisible) {
	        test.pass("✅ Category section is visible").addScreenCaptureFromPath(screenshot);
	    } else {
	        test.fail("❌ Category section is NOT visible").addScreenCaptureFromPath(screenshot);
	        Assert.fail("Category section should be visible.");
	    }
	}

	@Test(priority = 16)
	public void verifyFeaturedItemsSectionIsVisible() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifyFeaturedItemsSectionIsVisible");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();
	    test.pass("✅ Navigated to Home Page");

	    boolean isVisible = HomePage.isFeaturedItemsSectionVisible();
	    test.pass("✅ Checked visibility of Featured Items Section");

	    String screenshot = Screenshotutilities.capturescreen(driver, "FeaturedItemsSection");
	    test.pass("✅ Captured screenshot for Featured Items Section");

	    if (isVisible) {
	        test.pass("✅ Featured Items section is visible").addScreenCaptureFromPath(screenshot);
	    } else {
	        test.fail("❌ Featured Items section is NOT visible").addScreenCaptureFromPath(screenshot);
	        Assert.fail("Featured Items section should be visible.");
	    }
	}

	@Test(priority = 17)
	public void verifyRecommendedItemsSectionIsVisible() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifyRecommendedItemsSectionIsVisible");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();
	    test.pass("✅ Navigated to Home Page");

	    HomePage.scrollPageDown(2000);
	    test.pass("✅ Scrolled down to Recommended Items Section");

	    boolean isVisible = HomePage.isRecommendedItemsSectionVisible();
	    test.pass("✅ Checked visibility of Recommended Items Section");

	    String screenshot = Screenshotutilities.capturescreen(driver, "RecommendedItemsSection");
	    test.pass("✅ Captured screenshot for Recommended Items Section");

	    if (isVisible) {
	        test.pass("✅ Recommended Items section is visible").addScreenCaptureFromPath(screenshot);
	    } else {
	        test.fail("✅ Recommended Items section is NOT visible").addScreenCaptureFromPath(screenshot);
	        Assert.fail("Recommended Items section should be visible.");
	    }
	}

	@Test(priority = 18)
	public void verifyCarouselIndicatorDotIsVisibleAndWorking() throws IOException {
	    ExtentTest test = extent.createTest("Test Execution: verifyCarouselIndicatorDotIsVisibleAndWorking");

	    HomePage HomePage = new HomePage(driver);
	    HomePage.clickHome();
	    test.pass("✅ Navigated to Home Page");

	    boolean isVisible = HomePage.areCarouselIndicatorsVisible();
	    test.pass("✅ Checked visibility of Carousel Indicators");

	    String screenshot = Screenshotutilities.capturescreen(driver, "CarouselIndicators");
	    test.pass("✅ Captured screenshot for Carousel Indicators");

	    if (isVisible) {
	        HomePage.clickCarouselIndicator(0); // Click first dot
	        test.pass("✅ Carousel indicator dot clicked successfully");
	        test.pass("✅ Carousel indicator dot is visible and clickable").addScreenCaptureFromPath(screenshot);
	    } else {
	        test.fail("❌ Carousel indicator dot is NOT visible").addScreenCaptureFromPath(screenshot);
	        Assert.fail("Carousel indicator dot should be visible.");
	    }
	}


	@DataProvider(name = "subscriptionData")
	public Object[][] getSubscriptionData() throws IOException {
	    return Excelutilities.getdata(projectpath + "\\src\\test\\resources\\testdata\\HomePage.xlsx", "Emails");
	}
}