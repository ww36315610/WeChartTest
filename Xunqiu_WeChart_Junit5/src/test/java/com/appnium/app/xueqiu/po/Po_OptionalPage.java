package com.appnium.app.xueqiu.po;


import com.appnium.app.xueqiu.basic.BasicObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 自选页面
 */
public class Po_OptionalPage extends BasicObject {


    //删除自选股票
    public Po_OptionalPage deleteOptionalStock() {
        click(By.id("com.xueqiu.android:id/edit_group"));
        click(By.id("com.xueqiu.android:id/check_all"));
        click(By.id("com.xueqiu.android:id/cancel_follow"));
        click(By.id("com.xueqiu.android:id/md_buttonDefaultPositive"));
        click(By.id("com.xueqiu.android:id/action_close"));
        return this;
    }

    //获取所有股票名称
    public List<String> getAllStocks() {
        //处理弹出框
        handleAlert();

        List<String> stocks = new ArrayList<>();
        findElements(By.id("com.xueqiu.android:id/portfolio_stockName")).forEach(element -> {
            stocks.add(element.getText());
        });
        return stocks;
    }

    //加入自选功能
    public Po_OptionalPage addDefaultOptionalStock() {
        click(By.id("com.xueqiu.android:id/add_to_portfolio_stock"));
        return this;
    }

    //添加其他股票
    public void addOtherStock() {

    }
}
