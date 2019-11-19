package com.driver.type;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverByApp {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noRest", "false");
        desiredCapabilities.setCapability("autoGrantPermissions",true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        //增加隐士等待
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("----安卓自动化开始----");
        return driver;
    }
}
