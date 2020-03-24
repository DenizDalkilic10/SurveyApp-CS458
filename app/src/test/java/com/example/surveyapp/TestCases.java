package com.example.surveyapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class TestCases {

    public AppiumDriver driver;
    WebElement buttonOne;

    @BeforeTest
    public  void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        /* These are the capabilities we must provide to run our test on TestObject */
        capabilities.setCapability("deviceName", "PASTE_DEVICE_NAME");
        capabilities.setCapability("testobject_api_key", "PASTE_API_KEY");

        /* Check your Basic Setup page to find the URL that corresponds to your device */
        URL appiumURL = new URL("PASTE_URL");

        driver = new AndroidDriver(appiumURL, capabilities);
    }

    @Test
    public void testSurvey() {

        // Test case 1 - Successful Submission
        driver.findElementById("name_field").sendKeys();
        driver.findElementById("surname_field").sendKeys();
        driver.findElementById("city_field").sendKeys();
        driver.findElementById("occupation_field").sendKeys();
        driver.findElementById("dateText").sendKeys();
        driver.findElementById("male").click();
        driver.findElementById("female").click();
        driver.findElementById("button").click();
        driver.findElementById("date_button").click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        // Test case 2 - Failed Login: Empty name
        driver.findElementById("name_field").sendKeys();
        driver.findElementById("surname_field").sendKeys();
        driver.findElementById("city_field").sendKeys();
        driver.findElementById("occupation_field").sendKeys();
        driver.findElementById("dateText").sendKeys();
        driver.findElementById("male").click();
        driver.findElementById("female").click();
        driver.findElementById("button").click();
        driver.findElementById("date_button").click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        // Test case 3 - Failed Login: Empty Surname
        driver.findElementById("name_field").sendKeys();
        driver.findElementById("surname_field").sendKeys();
        driver.findElementById("city_field").sendKeys();
        driver.findElementById("occupation_field").sendKeys();
        driver.findElementById("dateText").sendKeys();
        driver.findElementById("male").click();
        driver.findElementById("female").click();
        driver.findElementById("button").click();
        driver.findElementById("date_button").click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        // Test case 4 - Failed Login:
        driver.findElementById("name_field").sendKeys();
        driver.findElementById("surname_field").sendKeys();
        driver.findElementById("city_field").sendKeys();
        driver.findElementById("occupation_field").sendKeys();
        driver.findElementById("dateText").sendKeys();
        driver.findElementById("male").click();
        driver.findElementById("female").click();
        driver.findElementById("button").click();
        driver.findElementById("date_button").click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        // Test case 5
        driver.findElementById("name_field").sendKeys();
        driver.findElementById("surname_field").sendKeys();
        driver.findElementById("city_field").sendKeys();
        driver.findElementById("occupation_field").sendKeys();
        driver.findElementById("dateText").sendKeys();
        driver.findElementById("male").click();
        driver.findElementById("female").click();
        driver.findElementById("button").click();
        driver.findElementById("date_button").click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    @AfterTest
    public void End() {
        driver.quit();
    }

}
