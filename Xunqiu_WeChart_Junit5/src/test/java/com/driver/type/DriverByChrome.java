package com.driver.type;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverByChrome {


    //获取chrome驱动
    public static ChromeDriver getDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("pageLoadStrategy", "none");
        WebDriver driver = new ChromeDriver(chromeOptions);
//        WebDriver driver = new ChromeDriver();
        //加入隐式等待，来解决网络不稳定跟广告等
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("--------开始web自动化测试--------");
        return (ChromeDriver) driver;
    }

}
