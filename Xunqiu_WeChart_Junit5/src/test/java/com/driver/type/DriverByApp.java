package com.driver.type;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverByApp {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() throws MalformedURLException {
        System.out.println("----安卓自动化开始----");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        //设置清除缓存-下面基础操作
        desiredCapabilities.setCapability("noRest", "false");
        desiredCapabilities.setCapability("autoGrantPermissions", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        //增加隐式等待
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //增加显示等待确保首页加载成功【等待搜索按钮出现「第一个case的按钮」】
        long start = System.currentTimeMillis();
        new WebDriverWait(driver, 40)
                .until(x -> {
                    String xml = driver.getPageSource();
                    Boolean exist = xml.contains("home_search") || xml.contains("image_cancel");
                    System.out.println((System.currentTimeMillis() - start) / 1000);
                    System.out.println(exist);
                    return exist;
                });
        return driver;
    }

    public static AndroidDriver getDriver1() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noReset", false);
        desiredCapabilities.setCapability("autoGrantPermissions", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        long start = System.currentTimeMillis();
        new WebDriverWait(driver, 40)
                .until(x -> {
                    String xml = driver.getPageSource();
                    Boolean exist = xml.contains("home_search") || xml.contains("image_cancel");
                    System.out.println((System.currentTimeMillis() - start) / 1000);
                    System.out.println(exist);
                    return exist;
                });
        return driver;
    }

}
