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

public class WhenDoAppium {

    private AppiumDriver appiumDriver;

    @BeforeEach
    public void openApplication() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName","lucky");
        capabilities.setCapability("platformVersion","8.0.0");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity",".ui.HomeActivity");
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
        Thread.sleep(2000);
        String nombreProyecto= "Luciano";

        // 2 com.android.calculator2:id/digit_2
        appiumDriver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        // + com.android.calculator2:id/op_add
        appiumDriver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(nombreProyecto);
        // 5 com.android.calculator2:id/digit_5
        appiumDriver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("Luciano Descripcion");
        // = com.android.calculator2:id/eq
        appiumDriver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
        Thread.sleep(2000);
        // resul com.android.calculator2:id/result
        String expected = nombreProyecto;
        String actual = appiumDriver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text='"+nombreProyecto+"']")).getText();
        Assertions.assertEquals(expected,actual,"error");
    }
}

