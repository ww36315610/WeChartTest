package com.appnium.app.xueqiu.po;

import com.appnium.app.xueqiu.basic.BasicObject;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

public class App extends BasicObject {


    /**
     * 初始化
     *
     */
    public  Po_HomePage getHomePage(){

        return new Po_HomePage();
    }

    /**
     * 获取自选页面
     * @return
     */
    public Po_OptionalPage getOptionalPage(){
        return new Po_OptionalPage();
    }

    /**
     * 获取关注页面
     * @return
     */
    public  Po_FocusonPage getFocusonPage(){
        return new Po_FocusonPage();
    }

    /**
     * 获取行情页面
     * @return
     */
    public  Po_MarketPage getMarketPage(){
        return new Po_MarketPage();
    }

    /**
     * 获取交易页面
     * @return
     */
    public  Po_TradingPage getTradingPage(){
        return new Po_TradingPage();
    }

    /**
     * 测试结束，推出APP
     */
    public void tearDown() {
        System.out.println("--------正在关闭浏览器……--------");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
        System.out.println("--------浏览器正常关闭……--------");
    }


}
