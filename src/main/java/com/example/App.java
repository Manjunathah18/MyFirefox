package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class App {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");

        FirefoxOptions options = new FirefoxOptions();

        // IMPORTANT: let Selenium find Firefox automatically
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new FirefoxDriver(options);

        try {
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://www.automationexercise.com/");

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
