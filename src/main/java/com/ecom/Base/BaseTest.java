package com.ecom.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
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

    // 🔹 Initialize Extent Reports once before suite
    @BeforeSuite
    public void startReport() {
        extent = Extentmanager.getInstance();
    }

    @BeforeMethod
    public void setup() throws IOException {
        // Load config.properties
        config = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                "\\src\\main\\java\\com\\ecom\\config\\config.properties");
        config.load(fis);

        // Read browser from config
        String browser = config.getProperty("browser").trim();
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("❌ Browser not supported: " + browser);
        }

        driver.manage().window().maximize();

        // Read waits from config
        int implicitWait = Integer.parseInt(config.getProperty("implicitWait", "10"));
        int pageLoadTimeout = Integer.parseInt(config.getProperty("pageLoadTimeout", "20"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));

        // Always open homepage before each test
        driver.get(config.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (driver != null) {
            try {
                if (result.getStatus() == ITestResult.FAILURE) {
                    // Use path from config
                    String screenshotPath = config.getProperty("screenshotPath", "screenshots/");
                    Screenshotutilities.capturescreen(driver, screenshotPath + result.getName());
                }
            } catch (Exception e) {
                System.out.println("Screenshot capture skipped: " + e.getMessage());
            } finally {
                driver.quit();
            }
        }
    }

    // 🔹 Flush Extent Report only once after suite
    @AfterSuite
    public void endReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}

