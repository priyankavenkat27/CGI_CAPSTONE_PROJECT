package com.ecom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators (from both codes)
    private By productsLink = By.partialLinkText("Products");
    private By searchBox = By.id("search_product");
    private By searchBtn = By.id("submit_search");
    private By productName = By.xpath("//div[@class='productinfo text-center']/p");
    private By addToCartButtons = By.xpath("//a[text()='Add to cart']");
    private By continueShoppingBtn = By.xpath("//button[text()='Continue Shopping']");
    private By searchedProductsHeader = By.xpath("//h2[text()='Searched Products']");

    // Extra locators from code1
    By TestCasesIcon = By.linkText("Test Cases");
    By logo = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
    By productsIcon = By.xpath("//a[@href='/products']");
    By cartIcon = By.xpath("//a[@href='/view_cart']");
    By signupLoginIcon = By.xpath("//a[@href='/login']");
    By videoTutorialsIcon = By.xpath("//a[contains(text(),'Video Tutorials')]");
    By homeIcon = By.xpath("//a[@href='/']");
    By contactUsIcon = By.xpath("//a[@href='/contact_us']");
    By apiTestingIcon = By.xpath("//a[contains(text(),'API Testing')]");
    By scrollToTopArrow = By.id("scrollUp");

    By AddFirstProductButton = By.xpath("(//a[text()='Add to cart'])[1]");
    By continueShop = By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button");
    By productDetail = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[1]/div/img");
    By viewProduct = By.xpath("(//a[text()='View Product'])[1]");
    By Offerlogo = By.xpath("//*[@id=\"sale_image\"]");
    By categorySection = By.xpath("/html/body/section[2]/div/div/div[1]/div/h2");
    By brandsSection = By.xpath("/html/body/section[2]/div/div/div[1]/div/div[3]/h2");
    By AllProductSection = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");

    By productNameDetail = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");
    By productCategoryDetail = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]");
    By productPriceDetail = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span");
    By productAvailability = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b");
    By productCondition = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b");
    By productBrand = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b");

    By categoryWomen = By.linkText("WOMEN");
    By categoryMen = By.linkText("MEN");
    By categoryKids = By.linkText("KIDS");

    By subscriptionInput = By.id("susbscribe_email");
    By subscriptionButton = By.id("subscribe");
    By subscriptionSuccess = By.xpath("//div[@class='alert-success alert']");

    By reviewName = By.xpath("//*[@id=\"name\"]");
    By reviewEmail = By.id("email");
    By reviewText = By.xpath("//*[@id=\"review\"]");
    By reviewSubmitBtn = By.id("button-review");

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== Helpers (from code2) =====
    private WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ===== Actions (merged) =====
    public void clickProductsLink() {
        waitForClickable(productsLink).click();
    }

    public void searchProduct(String product) {
        WebElement search = waitForVisible(searchBox);
        search.clear();
        search.sendKeys(product);
        driver.findElement(searchBtn).click();
    }

    public void clickSearchproduct() {
        driver.findElement(searchBtn).click();
    }

    public boolean isSearchedProductsHeaderVisible() {
        return waitForVisible(searchedProductsHeader).isDisplayed();
    }

    public boolean isSearchResultDisplayed() {
        List<WebElement> results = driver.findElements(productName);
        return !results.isEmpty();
    }

    public String getFirstProductName() {
        return waitForVisible(productName).getText();
    }

    public List<String> getAllProductNames() {
        List<WebElement> names = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productName));
        return names.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    // Two versions of clickAddToCart preserved
    public void clickAddToCart(int index) {
        List<WebElement> buttons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartButtons));
        if (index >= 0 && index < buttons.size()) {
            buttons.get(index).click();
        } else {
            throw new IllegalArgumentException("Invalid product index: " + index);
        }
    }

    public boolean clickAddToCartSafe(int index) {
        List<WebElement> buttons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartButtons));
        if (index >= 0 && index < buttons.size()) {
            buttons.get(index).click();
            return true;
        }
        return false;
    }

    public void addFirstProductToCart() {
        clickAddToCart(0);
    }

    public boolean addFirstProductToCartVisible() {
        return driver.findElement(AddFirstProductButton).isDisplayed();
    }

    public void FirstProductToCart() {
        driver.findElement(AddFirstProductButton).click();
    }

    public void clickContinueShopping() {
        waitForClickable(continueShoppingBtn).click();
    }

    public void clickContinueShop() {
        driver.findElement(continueShop).click();
    }

    // ===== UI Validations =====
    public boolean isTestCasesIconDisplayed() { return driver.findElement(TestCasesIcon).isDisplayed(); }
    public boolean isLogoDisplayed() { return driver.findElement(logo).isDisplayed(); }
    public boolean ispromtionalBannerDisplayed() { return driver.findElement(Offerlogo).isDisplayed(); }
    public boolean isProductsIconDisplayed() { return driver.findElement(productsIcon).isDisplayed(); }
    public boolean isCartIconDisplayed() { return driver.findElement(cartIcon).isDisplayed(); }
    public boolean isSignupLoginIconDisplayed() { return driver.findElement(signupLoginIcon).isDisplayed(); }
    public boolean isVideoTutorialsIconDisplayed() { return driver.findElement(videoTutorialsIcon).isDisplayed(); }
    public boolean isHomeIconDisplayed() { return driver.findElement(homeIcon).isDisplayed(); }
    public boolean isContactUsIconDisplayed() { return driver.findElement(contactUsIcon).isDisplayed(); }
    public boolean isApiTestingIconDisplayed() { return driver.findElement(apiTestingIcon).isDisplayed(); }

    // ===== Product detail validations =====
    public boolean ViewProduct() { return driver.findElement(viewProduct).isDisplayed(); }
    public boolean ViewProductDetail() { return driver.findElement(productDetail).isDisplayed(); }
    public boolean ViewProductName() { return driver.findElement(productNameDetail).isDisplayed(); }
    public boolean ViewProductCategory() { return driver.findElement(productCategoryDetail).isDisplayed(); }
    public boolean ViewProductPrice() { return driver.findElement(productPriceDetail).isDisplayed(); }
    public boolean ViewProductAvailability() { return driver.findElement(productAvailability).isDisplayed(); }
    public boolean ViewProductCondition() { return driver.findElement(productCondition).isDisplayed(); }
    public boolean ViewProductBrand() { return driver.findElement(productBrand).isDisplayed(); }

    public void clickViewProduct() { driver.findElement(viewProduct).click(); }

    // ===== Category & Brands =====
    public boolean isCategorySection() { return driver.findElement(categorySection).isDisplayed(); }
    public boolean isBrandSection() { return driver.findElement(brandsSection).isDisplayed(); }
    public boolean isAllProductSection() { return driver.findElement(AllProductSection).isDisplayed(); }

    public boolean selectCategoryWomen() { return driver.findElement(categoryWomen).isDisplayed(); }
    public boolean selectCategoryMen() { return driver.findElement(categoryMen).isDisplayed(); }
    public boolean selectCategoryKids() { return driver.findElement(categoryKids).isDisplayed(); }

    // ===== Subscription =====
    public void enterSubscription(String email) {
        WebElement element = driver.findElement(subscriptionInput);
        element.clear();
        element.sendKeys(email);
    }

    public void clickSubscriptionButton() {
        driver.findElement(subscriptionButton).click();
    }

    public boolean isSubscriptionSuccessDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionSuccess)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // ===== Scroll & Navigation =====
    public void clickScrollToTopArrow() {
        waitForClickable(scrollToTopArrow).click();
    }

    public void scrollPageDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // ===== Review =====
    public void submitReview(String name, String email, String review) {
        driver.findElement(reviewName).sendKeys(name);
        driver.findElement(reviewEmail).sendKeys(email);
        driver.findElement(reviewText).sendKeys(review);
        driver.findElement(reviewSubmitBtn).click();
    }

    // ===== Getters (from both codes) =====
    public By getProductsLinkLocator() { return productsLink; }
    public By getContinueShoppingLocator() { return continueShoppingBtn; }
    public By getAddToCartLocator() { return addToCartButtons; }
}
