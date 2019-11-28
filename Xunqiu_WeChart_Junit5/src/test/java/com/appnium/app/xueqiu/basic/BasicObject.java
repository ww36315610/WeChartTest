package com.appnium.app.xueqiu.basic;

import com.driver.MakeDriver;
import com.google.common.collect.Lists;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicObject {
    protected static AndroidDriver<WebElement> driver;

    /**
     * 静态代码块-选择app的Driver
     * TODO：外部配置文件参数化
     */
    static {
        driver = (AndroidDriver) MakeDriver.getDriverByParam("app");
    }

    /**
     * 统一获取对象[去除广告]
     *
     * @return
     */
    public static WebElement findElement(By by) {
        System.out.println(by);

        //todo:递归
        //todo:如果定位得元素是动态变化位置 1.显示等待 2.循环判断3次，看位置是否在最下面
        try {
            return driver.findElement(by);
        } catch (Exception e) {
            handleAlert();
        }
        return driver.findElement(by);
    }

    public static void click(By by) {
        System.out.println(by);

        //todo:递归
        try {
            driver.findElement(by).click();
        } catch (Exception e) {
            handleAlert();
            driver.findElement(by).click();
        }
    }

    public static List<WebElement> findElements(By by) {
        System.out.println(by);
        return driver.findElements(by);
    }

    //处理弹窗问题
    protected static void handleAlert() {
        By tips = By.id("com.xueqiu.android:id/snb_tip_text");
        List<By> alertBoxs = new ArrayList<>();
        //todo: 不需要所有的都判断是否存在
        //search时候升级弹框
        alertBoxs.add(By.id("com.xueqiu.android:id/image_cancel"));
        //随便点击屏幕其他地方
        alertBoxs.add(tips);
        //添加自选，下次再说弹框
        alertBoxs.add(By.id("com.xueqiu.android:id/md_buttonDefaultNegative"));

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        alertBoxs.forEach(alert -> {
            List<WebElement> ads = driver.findElements(alert);

            if (alert.equals(tips)) {
                System.out.println("^^^^^^^^^^^snb_tip fount^^^^^^^^^^^");
                //获取屏幕size
                Dimension size = driver.manage().window().getSize();
                try {
                    if (driver.findElements(tips).size() >= 1) {
                        //点击屏幕的中心位置[此处可以改动]
                        new TouchAction(driver).tap(PointOption.point(size.width / 2, size.height / 2)).perform();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("【" + alert + "】^^^^^^^^^^^snb_tip clicked^^^^^^^^^^^");
                }
            } else if (ads.size() >= 1) {
                ads.get(0).click();
            }
        });
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //处理弹窗
    private static void handleAlertByPageSource() {
//todo:xpath匹配,标记 定位
        String xml = driver.getPageSource();
        List<String> alertBoxs = Lists.newArrayList();
        alertBoxs.add("xxx");
        alertBoxs.add("yyy");

        alertBoxs.forEach(alert -> {
            if (xml.contains(alert)) {
                driver.findElement(By.id(alert)).click();
            }
        });

    }
}
