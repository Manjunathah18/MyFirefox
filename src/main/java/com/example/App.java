package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

public class App {
    public static void main(String[] args) {

        // Set path (Jenkins will use workspace path)
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");

        // Headless mode for Jenkins
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/usr/bin/firefox"); 
        options.addArguments("--headless");

        WebDriver driver = new FirefoxDriver(options);

        try {
            driver.manage().window().maximize();

            // First site
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // New tab 1
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://www.automationexercise.com/");

            // New tab 2
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

        } finally {
            driver.quit();
        }
    }
}
