package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.Dimension;

public class App {

    public static void main(String[] args) throws InterruptedException {

        // Set GeckoDriver path
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");

        // Firefox Options for Jenkins
        FirefoxOptions options = new FirefoxOptions();

        // Correct binary path (Linux)
        options.setBinary("/usr/bin/firefox");

        // Headless mode + stability args
        options.addArguments("--headless");
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");

        WebDriver driver = new FirefoxDriver(options);

        try {
            // Set window size (important in headless)
            driver.manage().window().setSize(new Dimension(1920, 1080));

            // -------------------------------
            // 1️⃣ SauceDemo Login
            // -------------------------------
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(2000);

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            System.out.println("SauceDemo Login Successful");

            // -------------------------------
            // 2️⃣ Open AutomationExercise (New Tab)
            // -------------------------------
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://automationexercise.com/");
            Thread.sleep(2000);

            System.out.println("Opened AutomationExercise");

            // -------------------------------
            // 3️⃣ Practice Test Automation Login
            // -------------------------------
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://practicetestautomation.com/practice-test-login/");
            Thread.sleep(2000);

            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            System.out.println("Practice Test Login Successful");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Browser Closed");
        }
    }
}
