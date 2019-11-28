package com.appnium.app.xueqiu.po.homepage;

import com.appnium.app.xueqiu.basic.BasicObject;
import com.appnium.app.xueqiu.po.Po_HomePage;
import com.appnium.app.xueqiu.po.Po_OptionalPage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class SearchPage extends BasicObject {

    private By inpputBox = By.id("com.xueqiu.android:id/search_input_text");

    //查询股票功能
    public SearchPage search(String searchStock) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        findElement(inpputBox).sendKeys(searchStock);
        click(By.id("com.xueqiu.android:id/name"));
        return new SearchPage();
    }

    //获取股票价格
    public double getPrice() {
        return Double.parseDouble(driver.findElement(By.id("com.xueqiu.android:id/current_price")).getText());
    }

    //点击取消按钮
    public Po_HomePage cancel() {
        click(By.id("com.xueqiu.android:id/action_close"));
        return new Po_HomePage();
    }

    //点击加入自选按钮
    public SearchPage addOptional() {
        String buttonText = driver.findElement(By.id("com.xueqiu.android:id/follow_btn")).getText();
        if (!buttonText.endsWith("已添加")) {
            //点击 加自选
            click(By.id("com.xueqiu.android:id/follow_btn"));
            //点击取消，进入首页
            cancel();
        }
        return this;
    }
}
