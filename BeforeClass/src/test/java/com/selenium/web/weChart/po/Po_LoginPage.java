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
    public Po_LoginPage login() {
        //请求地址
        driver.get(URL);
        //初始化等待，隐式等待
        waitDriverWait(null, 0, "yin");
        //设置窗口最大化
        makeWindowSize(0, 0, "max");

        //点击登录按钮
        findElement(By.linkText("企业登录"),1000).click();
        System.out.println("cookie:::" + driver.manage().getCookies());
        driver.manage().addCookie(new Cookie("wwrtx.refid", refid));
        driver.manage().addCookie(new Cookie("wwrtx.sid", sid));
        driver.navigate().refresh();
        return this;
    }
}