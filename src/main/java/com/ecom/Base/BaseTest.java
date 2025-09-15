package com.ecom.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ecom.Utilities.Extentmanager;
import com.ecom.Utilities.Screenshotutilities;

public class BaseTest {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static Properties config;
    public static String screenshotPath;

    // 🔹 Initialize Extent Reports once before suite
    @BeforeSuite
    public void startReport() {
        extent = Extentmanager.getInstance();
    }

    // 🔹 Setup browser & driver per class
    @BeforeClass
    public void setupClass() throws IOException {
        // Load config.properties
        config = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "\\src\\main\\java\\com\\ecom\\config\\config.properties");
        config.load(fis);

        // Browser
        String browser = config.getProperty("browser").trim();
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("❌ Browser not supported: " + browser);
        }

        driver.manage().window().maximize();

        // Timeouts
        int implicitWait = Integer.parseInt(config.getProperty("implicitWait", "10"));
        int pageLoadTimeout = Integer.parseInt(config.getProperty("pageLoadTimeout", "20"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));

        // Base URL
        driver.get(config.getProperty("baseUrl"));

        // Screenshot folder
        screenshotPath = config.getProperty("screenshotPath", "screenshots/");

        // Extent Test for this class
        test = extent.createTest("Test Execution: " + this.getClass().getSimpleName());
    }

    // 🔹 Close browser after all tests in class
    @AfterClass
    public void teardownClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    // 🔹 Flush Extent Report only once after suite
    @AfterSuite
    public void endReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    // 🔹 Manual screenshot helper
    public void captureScreenshot(String name) {
        try {
            Screenshotutilities.capturescreen(driver, screenshotPath + name);
        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }
}