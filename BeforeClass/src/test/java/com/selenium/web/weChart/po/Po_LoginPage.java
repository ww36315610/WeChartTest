package com.selenium.web.weChart.po;

import com.selenium.web.weChart.basic.BasicObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

/**
 * 登录
 */
public class Po_LoginPage extends BasicObject {

    /**
     * 登录操作
     */
    public static Po_HomePage login() {
        //TODO：参数化选择不同的浏览器
        driver.get(url);
        //初始化等待，隐式等待
        waitDriverWait(null, 0);
        //设置窗口最大化
        makeWindowSize(0, 0, "max");

        //点击登录按钮
        findElement(By.linkText("企业登录")).click();
        System.out.println("cookie:::" + driver.manage().getCookies());
        driver.manage().addCookie(new Cookie("wwrtx.refid", "27486321751734678"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "JvZOmWG4Uap9Glla7YBqRlSedf_EgV2kcp0E6cE3ZIP77Di8L1LGVVlD2Qt248Ud"));
        driver.navigate().refresh();
        return new Po_HomePage();
    }
}