package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasicAppium {

    private AppiumDriver appiumDriver;

    @BeforeEach
    public void openApplication() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName","lucky");
        capabilities.setCapability("platformVersion","8.0.0");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity",".Calculator");
        capabilities.setCapability("platformName","Android");

        appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        // implicit
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterEach
    public void closeApplication(){
        appiumDriver.quit();
    }

    @Test
    public void verifyCalculator() throws InterruptedException {
        Thread.sleep(5000);

        // 2 com.android.calculator2:id/digit_2
        appiumDriver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
        // + com.android.calculator2:id/op_add
        appiumDriver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        // 5 com.android.calculator2:id/digit_5
        appiumDriver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        // = com.android.calculator2:id/eq
        appiumDriver.findElement(By.id("com.android.calculator2:id/eq")).click();
        Thread.sleep(2000);
        // resul com.android.calculator2:id/result
        String expected = "7";
        String actual = appiumDriver.findElement(By.id("com.android.calculator2:id/formula")).getText();
        Assertions.assertEquals(expected,actual,"error");
    }
}

