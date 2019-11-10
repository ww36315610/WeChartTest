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
    }

    public void testClick(){
        map.forEach((k, v) -> {
            findElement(By.xpath(v.toString())).click();
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
    public Po_HomePage getLogin() {
        findElement(By.xpath(map.get("首页").toString())).click();
        return Po_LoginPage.login();
    }

    /**
     * 获取首页
     *
     * @return
     */
    public Po_HomePage getHomePage() {
        return new Po_HomePage();
    }

    /**
     * 获取通讯录
     *
     * @return
     */
    public Po_ContactPage getContactPage() {
        return new Po_ContactPage();
    }

    /**
     * 获取应用管理
     *
     * @return
     */
    public Po_Application geApplication() {
        return new Po_Application();
    }

    /**
     * 获取客户联系
     *
     * @return
     */
    public Po_Customer getCustomer() {
        return new Po_Customer();
    }

    /**
     * 获取管理工具
     *
     * @return
     */
    public Po_Management getManagement() {
        return new Po_Management();
    }

    /**
     * 获取我的企业
     *
     * @return
     */
    public Po_MyBusiness getMyBusiness() {
        return new Po_MyBusiness();
    }
}
