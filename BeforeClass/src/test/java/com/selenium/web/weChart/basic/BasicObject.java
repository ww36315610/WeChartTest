package com.selenium.web.weChart.basic;

import com.driver.MakeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * basic类-基类
 * 1。获取driver
 * 2。获取一些动态变化的参数-如url-登录名等-todo：【配置文件获取】
 * 3。定义一些公共方法-等待-窗口等
 */
public class BasicObject {

    //TODO：参数获取请求地址
    protected static String url = "https://work.weixin.qq.com/";

    //TODO:外部传入选择不同的driver
    //    public String chooseDriver = System.getProperty("driver");
    protected static WebDriver driver = (ChromeDriver) MakeDriver.getDriverByParam("chrome");

    /**
     * 统一获取对象
     *
     * @return
     */
    public static WebElement findElement(By by) {
        return driver.findElement(by);
    }


    /**
     * 操作等待时间
     *
     * @return
     */
    public static void waitDriverWait(By by, int timeout) {
        if (timeout == 0) {
            // 隐式等待
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else {
            //显示等待
            //等待元素加载到dom中
            //new WebDriverWait(driver,timeout).until(ExpectedConditions);
            //等待"按钮"可以被点击
            new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));

        }

    }

    /**
     * 动态设置窗口的大小
     */

    public static void makeWindowSize(int width, int heigth, String max) {
        if (null != max || max.equals("max")) {
            driver.manage().window().maximize();
        } else {
            driver.manage().window().setSize(new Dimension(width, heigth));
        }
    }
}
