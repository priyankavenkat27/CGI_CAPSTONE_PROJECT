package com.ecom.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By homeBreadcrumb = By.cssSelector("a[href='/']");
    By cartBreadcrumb = By.cssSelector("li.active");
    By hereLink = By.linkText("here");
    By deleteIcons = By.cssSelector("a.cart_quantity_delete"); // multiple delete icons
    By proceedToCheckoutBtn = By.cssSelector("a.btn.btn-default.check_out");
    By subscriptionEmailBox = By.id("susbscribe"); // correct id
    By subscriptionBtn = By.id("subscribe");
    By commentsTextBox = By.name("message");
    By scrollToTopArrow = By.id("scrollUp");
    By breadcrumbhome = By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[1]/a");
    
    By TestCasesIcon = By.linkText("Test Cases");
    By logo = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
    By productsIcon = By.xpath("//a[@href='/products']");
    By cartLink = By.xpath("//a[@href='/view_cart']");
    By signupLoginIcon = By.xpath("//a[@href='/login']");
    By videoTutorialsIcon = By.xpath("//a[contains(text(),'Video Tutorials')]");
    By homeIcon = By.xpath("//a[@href='/']");
    By contactUsIcon = By.xpath("//a[@href='/contact_us']");
    By apiTestingIcon = By.xpath("//a[contains(text(),'API Testing')]");
    By shoppingBreadCrumb = By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]");
    By AddFirstProductButton =By.xpath("(//a[text()='Add to cart'])[1]");
    private By subscriptionSuccessMsg = By.id("success-subscribe");
    By viewcartLink = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    
    By itemdisplay = By.xpath("//*[@id=\"cart_info_table\"]/thead/tr/td[1]");
    By descriptiondisplay = By.xpath("//*[@id=\"cart_info_table\"]/thead/tr/td[2]");
    By pricedisplay = By.xpath("//*[@id=\"cart_info_table\"]/thead/tr/td[3]");
    By quantitydisplay = By.xpath("//*[@id=\"cart_info_table\"]/thead/tr/td[4]");
    By totaldisplay = By.xpath("//*[@id=\"cart_info_table\"]/thead/tr/td[5]");
  
    By subscriptionInput = By.id("susbscribe_email");
    By subscriptionButton = By.id("subscribe");
    By subscriptionSuccess = By.xpath("//div[@class='alert-success alert']");
    


    // ================= Actions =================

    public void clickHomeBreadcrumb() {
        wait.until(ExpectedConditions.elementToBeClickable(homeBreadcrumb)).click();
    }

    public void clickCartBreadcrumb() {
        wait.until(ExpectedConditions.elementToBeClickable(cartBreadcrumb)).click();
    }

    public void clickHereLink() {
        wait.until(ExpectedConditions.elementToBeClickable(hereLink)).click();
    }

    public WebElement getProceedToCheckoutBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));
    }

    public void clickDeleteIcon(int index) { // delete specific product by index
        List<WebElement> icons = driver.findElements(deleteIcons);
        if (index < icons.size()) {
            wait.until(ExpectedConditions.elementToBeClickable(icons.get(index))).click();
        }
    }

    public void clickDeleteAllProducts() { // delete all products
        List<WebElement> icons = driver.findElements(deleteIcons);
        for (WebElement icon : icons) {
            wait.until(ExpectedConditions.elementToBeClickable(icon)).click();
            // small pause if needed for DOM update
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
    
    public boolean isProceedToCheckout() {
        return driver.findElement(proceedToCheckoutBtn).isDisplayed();
    }

    public void clickProceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
    }

    public void enterSubscriptionEmail(String email) {
        WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionEmailBox));
        emailBox.clear();
        emailBox.sendKeys(email);
    }

    public void clickSubscribe() {
        wait.until(ExpectedConditions.elementToBeClickable(subscriptionBtn)).click();
    }

    public void enterComments(String comments) {
        WebElement commentsBox = wait.until(ExpectedConditions.visibilityOfElementLocated(commentsTextBox));
        commentsBox.clear();
        commentsBox.sendKeys(comments);
    }

    public String getEnteredComments() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(commentsTextBox)).getAttribute("value");
    }

    public void clickScrollToTopArrow() {
        wait.until(ExpectedConditions.elementToBeClickable(scrollToTopArrow)).click();
    }

    // ================= Verification Methods =================

    public boolean isDeleteIconPresent() {
        return driver.findElements(deleteIcons).size() > 0;
    }

    public boolean isHereLinkPresent() {
        return driver.findElements(hereLink).size() > 0;
    }

    public boolean isSubscriptionIconPresent() {
        return driver.findElements(subscriptionBtn).size() > 0;
    }

    // Extra scroll methods
    public void scrollPageDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    
    public boolean isTestCasesIconDisplayed() {
        return driver.findElement(TestCasesIcon).isDisplayed();
    }
    
    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public boolean isProductsIconDisplayed() {
        return driver.findElement(productsIcon).isDisplayed();
    }
    
    public void clickProductsIcon() {
        driver.findElement(productsIcon).click();
    }
    
    public void clickBreadcrumbhome() {
        driver.findElement(breadcrumbhome).click();
    }

    public void clickCart() {
        driver.findElement(cartLink).click();
    }
    
    public void clickViewCartButton() {
        driver.findElement(viewcartLink).click();
    }

    public boolean isSignupLoginIconDisplayed() {
        return driver.findElement(signupLoginIcon).isDisplayed();
    }

    public boolean isVideoTutorialsIconDisplayed() {
        return driver.findElement(videoTutorialsIcon).isDisplayed();
    }

    public boolean isHomeIconDisplayed() {
        return driver.findElement(homeIcon).isDisplayed();
    }
    
    public boolean isItemDisplayed() {
        return driver.findElement(itemdisplay).isDisplayed();
    }
    
    public boolean isDescriptionDisplayed() {
        return driver.findElement(descriptiondisplay).isDisplayed();
    }
    
    public boolean isPriceDisplayed() {
        return driver.findElement(pricedisplay).isDisplayed();
    }
    
    public boolean isQuantityDisplayed() {
        return driver.findElement(quantitydisplay).isDisplayed();
    }
    
    public boolean isTotalDisplayed() {
        return driver.findElement(totaldisplay).isDisplayed();
    }

    public boolean isContactUsIconDisplayed() {
        return driver.findElement(contactUsIcon).isDisplayed();
    }

    public boolean isApiTestingIconDisplayed() {
        return driver.findElement(apiTestingIcon).isDisplayed();
    }
    
    public void enterSubscription(String email) {
        WebElement element = driver.findElement(subscriptionInput);
        element.clear();
        element.sendKeys(email);
    }
    
    public boolean isShippingCartBreadcrumb() {
        return driver.findElement(shoppingBreadCrumb).isDisplayed();
    }

    public void clickSubscriptionButton() {
        driver.findElement(subscriptionButton).click();
    }
    
    public void addFirstProductToCart() {
        driver.findElement(AddFirstProductButton).click();
    }
    
    public boolean isSubscriptionSuccessDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionSuccess)).isDisplayed();
        } catch (TimeoutException e) {
            return false; // returns false if the message doesn't appear within wait time
        }
    }
    
    public boolean isCartEmptyMessageVisible() {
        List<WebElement> msg = driver.findElements(By.xpath("//*[contains(text(),'Cart is empty!')]"));
        return !msg.isEmpty() && msg.get(0).isDisplayed();
    }
    
    private WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public String getSubscriptionSuccessMessage() {
        return waitForVisible(subscriptionSuccessMsg).getText();
    }

    public boolean isSubscriptionSuccessVisible() {
        return !driver.findElements(subscriptionSuccessMsg).isEmpty();
    }
    
    public boolean isSubscriptionBoxVisible() {
        return !driver.findElements(subscriptionEmailBox).isEmpty();
    }
    
    public WebElement getSubscriptionEmailField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionEmailBox));
    }
    
    private WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}

