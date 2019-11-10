package com.selenium.web.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BasicUnitTest {

    public WebDriver driver;
    public Map<String, Object> map;
    JavascriptException js;

    @Before
    public void setUp() {
        System.out.println("--------开始web自动化测试--------");
        driver = new ChromeDriver();
        //加入隐式等待，来解决网络不稳定跟广告等
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        map = new HashMap<String, Object>();
//        js = (JavascriptException) driver;
    }


    @After
    public void tearDown() throws Exception {
        System.out.println("--------web自动化测试正在结束--------");
        Thread.sleep(5000);
        driver.quit();
    }


}
