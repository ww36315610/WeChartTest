package com.appnium.app.xueqiu.basic;

import com.driver.MakeDriver;
import com.google.common.collect.Lists;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BasicObject {
    protected static AndroidDriver driver;

    /**
     * 静态代码块赋值
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
    public static MobileElement findElement(By by) {
        //todo:递归
        //todo:如果定位得元素是动态变化位置 1.显示等待 2.循环判断3次，看位置是否在最下面

        try {
            return (MobileElement) driver.findElement(by);
        } catch (Exception e) {
            handleAlert();
        }
        return (MobileElement) driver.findElement(by);
    }

    public static void click(By by) {
        //todo:递归
        try {
            driver.findElement(by).click();
        } catch (Exception e) {
            handleAlert();
            driver.findElement(by).click();
        }
    }

    //处理弹窗问题
    private static void handleAlert() {
        List<By> alertBoxs = new ArrayList<>();
        //todo:不需要所有的都判断是否存在
        alertBoxs.add(By.id("com.xueqiu.android:id/image_cancel"));
//        alertBoxs.add(By.xpath("dddd"));

        alertBoxs.forEach(alert -> {
            By adsLocator = alert;
            List<WebElement> ads = driver.findElements(adsLocator);
            if (ads.size() >= 1) {
                ads.get(0).click();
            }
        });
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
