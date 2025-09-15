package com.ecom.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	 // 🔹 Locators
    private By navHome = By.xpath("//a[contains(text(),' Home')]"); // home navigation link
    private By logo = By.xpath("//div[@class='logo pull-left']"); // site logo
    private By navSignupLogin = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By navCart = By.xpath("//a[contains(text(),'Cart')]");
    private By navContactUs = By.xpath("//a[contains(text(),'Contact us')]");
    private By navProducts = By.xpath("//a[contains(text(),'Products')]");
    private By navTestCases = By.xpath("//a[contains(text(),'Test Cases')]");
    private By navApiTesting = By.xpath("//a[contains(@href,'/api_list')]");
    private By navVideoTutorials = By.xpath("//a[contains(@href,'youtube.com')]");
    private By automationLogo = By.xpath("//img[contains(@src,'logo.png')]");
    private By viewProductBtn = By.xpath("//a[contains(text(),'View Product')]");
    private By brandsSection = By.xpath("//h2[contains(text(),'Brands')]");
    private By categorySection = By.xpath("//div[@class='left-sidebar']/h2[contains(text(),'Category')]");
    private By featuredItemsSection = By.xpath("//h2[contains(text(),'Features Items')]");
    private By recommendedItemsSection = By.xpath("//h2[contains(text(),'recommended items')]");
    private By carouselLeftArrow = By.xpath("//a[@class='left control-carousel']");
    private By carouselRightArrow = By.xpath("//a[@class='right control-carousel']");

    private By carouselIndicators = By.cssSelector(".carousel-indicators li");

    // 🔹 Subscription section
    private By subscriptionEmail = By.id("susbscribe_email");
    private By subscribeBtn = By.id("subscribe");
    private By successMsg = By.xpath("//div[contains(text(),'You have been successfully subscribed!')]");

    

    // ✅ Page actions
    
    public void clickHome() {
        driver.findElement(navHome).click();
    }
    
    
    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }
    public boolean isSignupLoginButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement signupBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(navSignupLogin));
            return signupBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickSignupLogin() {
        driver.findElement(navSignupLogin).click();
    }
    public boolean isCartButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement cartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(navCart));
            return cartBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickCart() {
        driver.findElement(navCart).click();
    }
    public boolean isContactUsButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement contactBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(navContactUs));
            return contactBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickContactUs() {
        driver.findElement(navContactUs).click();
    }
    public boolean isProductsButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement productsBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(navProducts));
            return productsBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickProducts() {
        driver.findElement(navProducts).click();
    }
   
    public boolean isTestCasesButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement testCasesBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(navTestCases));
            return testCasesBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickTestCases() {
        driver.findElement(navTestCases).click();
    }
    public boolean isApiTestingButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement apiBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(navApiTesting));
            return apiBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickApiTesting() {
        driver.findElement(navApiTesting).click();
    }
    public boolean isVideoTutorialsButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement videoBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(navVideoTutorials));
            return videoBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickVideoTutorials() {
        driver.findElement(navVideoTutorials).click();
    }

    // ✅ Subscription
    public void enterSubscriptionEmail(String email) {
        driver.findElement(subscriptionEmail).sendKeys(email);
    }

    public void clearsubscriptionEmail() {
        driver.findElement(subscriptionEmail).clear();
    }

    public void clickSubscribe() {
        driver.findElement(subscribeBtn).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }

    public void scrollPageDown(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ")");
    }
    public void clickScrollToTopArrow() {
        WebElement scrollArrow = driver.findElement(By.id("scrollUp"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", scrollArrow);
    }

    public boolean isAutomationLogoVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement logoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(automationLogo));
            return logoElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isViewProductButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(viewProductBtn));
            return btn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isBrandsSectionVisible() {
        return driver.findElements(brandsSection).size() > 0 &&
               driver.findElement(brandsSection).isDisplayed();
    }

    public boolean isCategorySectionVisible() {
        return driver.findElements(categorySection).size() > 0 &&
               driver.findElement(categorySection).isDisplayed();
    }

    public boolean isFeaturedItemsSectionVisible() {
        return driver.findElements(featuredItemsSection).size() > 0 &&
               driver.findElement(featuredItemsSection).isDisplayed();
    }

    public boolean isRecommendedItemsSectionVisible() {
        return driver.findElements(recommendedItemsSection).size() > 0 &&
               driver.findElement(recommendedItemsSection).isDisplayed();
    }
   

  

    public boolean areCarouselIndicatorsVisible() {
        List<WebElement> indicators = driver.findElements(carouselIndicators);
        return indicators.size() > 0 && indicators.get(0).isDisplayed();
    }


    public void clickCarouselLeftArrow() {
        WebElement arrow = driver.findElement(carouselLeftArrow);
        new Actions(driver).moveToElement(arrow).click().perform();
    }

    public void clickCarouselRightArrow() {
        WebElement arrow = driver.findElement(carouselRightArrow);
        new Actions(driver).moveToElement(arrow).click().perform();
    }

    public void clickCarouselIndicator(int index) {
        List<WebElement> indicators = driver.findElements(carouselIndicators);
        if (index >= 0 && index < indicators.size()) {
            indicators.get(index).click();
        }
    }



}