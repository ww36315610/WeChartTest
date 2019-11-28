package com.appnium.app.xueqiu.po;

import com.appnium.app.xueqiu.basic.BasicObject;
import org.openqa.selenium.By;

public class App extends BasicObject {


    /**
     * 初始化
     */
    public Po_HomePage getHomePage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='雪球']"));
        return new Po_HomePage();
    }

    /**
     * 获取自选页面
     *
     * @return
     */
    public Po_OptionalPage getOptionalPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='自选']"));
        return new Po_OptionalPage();
    }

    /**
     * 获取关注页面
     *
     * @return
     */
    public Po_FocusonPage getFocusonPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='关注']"));
        return new Po_FocusonPage();
    }

    /**
     * 获取行情页面
     *
     * @return
     */
    public Po_MarketPage getMarketPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='行情']"));
        return new Po_MarketPage();
    }

    /**
     * 获取交易页面
     *
     * @return
     */
    public Po_TradingPage getTradingPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='交易']"));
        return new Po_TradingPage();
    }

    /**
     * 测试结束，推出APP
     */
    public void tearDown() {
        System.out.println("--------正在关闭APP……--------");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
        System.out.println("--------APP正常关闭……--------");
    }


}
