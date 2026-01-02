package com.ejemplo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static ChromeDriver createDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--log-level=3"); // Reduce logs de ChromeDriver
        options.addArguments("--silent");      // Menos mensajes
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        return new ChromeDriver(options);
    }
}
