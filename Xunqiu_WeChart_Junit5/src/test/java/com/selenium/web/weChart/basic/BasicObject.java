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

    //请求地址
    protected static String URL;
    //定义driver
    protected static WebDriver driver;

    //Cookie信息
    protected static String refid;
    protected static String sid;

    /**
     * 静态代码块赋值
     * TODO：外部配置文件参数化
     */
    static {
        URL = "https://work.weixin.qq.com/";
        driver = (ChromeDriver) MakeDriver.getDriverByParam("chrome");
        //liunx 启动命令获取driver  driver = System.getProperty("driver");
        refid = "1215879352779807";
        sid = "JvZOmWG4Uap9Glla7YBqRqy5BYWDkOrNp7NLtu1Oq0iQPYZFo6CDjK2CZbVkJ185";
    }


    /**
     * 统一获取对象
     *
     * @return
     */
    public static WebElement findElement(By by, int timout) {
        //添加等待时间
        waitDriverWait(by, timout, null);
        return driver.findElement(by);
    }

    public static WebElement findElement(By by) {
        //添加等待时间[thread sleep 1s]
        waitDriverWait(by, 2000, null);
        return driver.findElement(by);
    }


    /**
     * 操作等待时间
     *
     * @return
     */
    public static void waitDriverWait(By by, int timeout, String type) {
        if ("yin".equals(type)) {
            // 隐式等待
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        } else if ("xian".equals(type)) {
            //显示等待
            //等待元素加载到dom中
            new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
            //等待"按钮"可以被点击
            new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
        } else {
            try {
                //强制sleep
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
