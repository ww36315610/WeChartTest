package com.selenium.web.test;

import com.selenium.web.test.BasicUnitTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * testhome测试社区首页测试
 * 1.导入依赖
 * 2.初始化webDriver
 * 3.编写测试类
 * 4.断言
 */
public class TestHomePage extends BasicUnitTest {


    private WebDriver driver;
    private Map<String, Object> map;
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


    @Test
    public void testHomePage() {
        driver.get("https://testerhome.com");
        driver.manage().window().setSize(new Dimension(1440, 877));
        //显示等待，等待q可以被点击
        new WebDriverWait(driver, 10000)
                .until(ExpectedConditions.elementToBeClickable(By.name("q")));
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("霍格沃兹测试学院");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("霍格沃兹测试学院")).click();
        //模糊链接
//        driver.findElement(By.partialLinkText("沃兹")).click();
//        Actions执行pc端鼠标滑动等，此处为"右键"
        new Actions(driver).contextClick().perform();
    }


    @After
    public void tearDown() throws Exception {
        System.out.println("--------web自动化测试正在结束--------");
        Thread.sleep(5000);
        driver.quit();
    }

}
