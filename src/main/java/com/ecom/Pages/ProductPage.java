package com.ecom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private By productsLink = By.partialLinkText("Products");
    private By searchBox = By.id("search_product");
    private By searchBtn = By.id("submit_search");
    private By productName = By.xpath("//div[@class='productinfo text-center']/p");
    private By addToCartButtons = By.xpath("//a[text()='Add to cart']");
    private By continueShoppingBtn = By.xpath("//button[text()='Continue Shopping']");
    private By searchedProductsHeader = By.xpath("//h2[text()='Searched Products']");

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void clickProductsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(productsLink)).click();
    }

    public void searchProduct(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).clear();
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchBtn).click();
    }

    public boolean isSearchedProductsHeaderVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductsHeader)).isDisplayed();
    }

    public String getFirstProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public void clickAddToCart(int index) {
        List<WebElement> buttons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartButtons));
        if (index >= 0 && index < buttons.size()) {
            buttons.get(index).click();
        } else {
            throw new IllegalArgumentException("Invalid product index: " + index);
        }
    }

    public void clickContinueShopping() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn)).click();
    }

    // Getters for locators (optional, for assertions in test layer)
    public By getProductsLinkLocator() { return productsLink; }
    public By getContinueShoppingLocator() { return continueShoppingBtn; }
    public By getAddToCartLocator() { return addToCartButtons; }
}
