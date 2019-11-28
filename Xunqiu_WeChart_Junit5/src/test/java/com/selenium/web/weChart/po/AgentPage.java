package com.selenium.web.weChart.po;

import com.google.common.collect.Maps;
import com.selenium.web.weChart.basic.BasicObject;
import org.openqa.selenium.By;

import java.util.Map;

/**
 * 代理分发类
 * 1.分发到各个页面
 * 2.第一层所有的功能都定义为PO，返回第二层PO
 */
public class AgentPage extends BasicObject {

    private static Map<String, Object> map = Maps.newHashMap();

    static {
        map.put("首页", "//*[@id=\"menu_index\"]/span");
        map.put("通讯录", "//*[@id=\"menu_contacts\"]/span");
        map.put("应用管理", "//*[@id=\"menu_apps\"]/span");
        map.put("客户联系", "//*[@id=\"menu_customer\"]/span");
        map.put("管理工具", "//*[@id=\"menu_manageTools\"]/span");
        map.put("我的企业", "//*[@id=\"menu_profile\"]/span");
//        menu_manageTools
    }

    public void testClick() {
        map.forEach((k, v) -> {
            findElement(By.xpath(v.toString()),500).click();
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 登录操作
     *
     * @return 首页
     */
    public Po_LoginPage getLogin() {
        return new Po_LoginPage().login();
    }

    /**
     * 测试结束，推出浏览器
     */
    public void tearDown() {
        System.out.println("--------正在关闭浏览器……--------");
        driver.quit();
        System.out.println("--------浏览器正常关闭……--------");
    }


    /**
     * 获取首页
     *
     * @return
     */
    public Po_HomePage getHomePage() {
        findElement(By.xpath(map.get("首页").toString()),200).click();
        return new Po_HomePage();
    }

    /**
     * 获取通讯录
     *
     * @return
     */
    public Po_ContactPage getContactPage() {
        findElement(By.xpath(map.get("通讯录").toString()),200).click();
        return new Po_ContactPage();
    }

    /**
     * 获取应用管理
     *
     * @return
     */
    public Po_Application geApplication() {
        findElement(By.xpath(map.get("应用管理").toString()),200).click();
        return new Po_Application();
    }

    /**
     * 获取客户联系
     *
     * @return
     */
    public Po_Customer getCustomer() {
        findElement(By.xpath(map.get("客户联系").toString()),200).click();
        return new Po_Customer();
    }

    /**
     * 获取管理工具
     *
     * @return
     */
    public Po_Management getManagement() {
        findElement(By.xpath(map.get("管理工具").toString()),2000).click();
//        findElement(By.linkText("管理工具"),200).click();
        findElement(By.id("menu_manageTools")).click();
        return new Po_Management();
    }

    /**
     * 获取我的企业
     *
     * @return
     */
    public Po_MyBusiness getMyBusiness() {
        findElement(By.xpath(map.get("我的企业").toString()),200).click();
        return new Po_MyBusiness();
    }
}
