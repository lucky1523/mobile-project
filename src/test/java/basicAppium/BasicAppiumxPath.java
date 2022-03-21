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

public class BasicAppiumxPath {

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

        //click 2 com.android.calculator2:id/digit_2
        appiumDriver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
        // click +  com.android.calculator2:id/op_add
        appiumDriver.findElement(By.xpath("//android.widget.ImageView[contains(@resource-id,'op_add')]")).click();
        // click 5  com.android.calculator2:id/digit_5
        //android.widget.TextView[contains(@resource-id,'result')]
        //android.widget.ImageView[contains(@resource-id,'op_add')]
        appiumDriver.findElement(By.xpath("//android.widget.Button[@text='5']")).click();
        // click = com.android.calculator2:id/eq
        appiumDriver.findElement(By.xpath("//android.widget.ImageView[@content-desc='igual a']")).click();
        Thread.sleep(2000);
        // verificar que la suma 7  com.android.calculator2:id/result
        String expectedResult="7";
        String actualResult=appiumDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.android.calculator2:id/formula']")).getText();

        Assertions.assertEquals(expectedResult,actualResult,"ERROR la suma es incorrecta");

    }
}
