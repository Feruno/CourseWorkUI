package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DetailedForecast10daysTests {
    WebDriver webDriver;

    @Before
    public void openBrowser() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void checkDynamicLoading() {
        DetailedForecast10days webDriverDetailedForecast;

        webDriverDetailedForecast = new DetailedForecast10days(webDriver);

        webDriverDetailedForecast.clcickDetailedForecast10days();
        webDriverDetailedForecast.findTemperatureMorning(5);

    }

    @After
    public void closeBrowser() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}
