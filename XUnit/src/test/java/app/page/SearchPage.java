package app.page;

import io.appium.java_client.MobileElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 雪球APP搜索页
 */
public class SearchPage extends BasicPage {

//    //定义搜索按钮
//    By inputText = By.id("com.xueqiu.android:id/search_input_text");
//    By name = By.id("com.xueqiu.android:id/name");

    /**
     * 搜索功能
     *
     * @return
     */
    public SearchPage search(String keyword) throws IOException {
        //搜索栏输入股票代码
//        findElement(inputText).sendKeys(stock);
//        click(name);
        HashMap<String, Object> data = new HashMap<>();
        data.put("keyword", keyword);
        setParams(data);
        parseSteps();
        return this;
    }

    /**
     * 获取股票价格
     */
    public Double getCurrentPrice() throws IOException {
        parseSteps();
        MobileElement element = (MobileElement) findElement(By.id("com.xueqiu.android:id/current_price"));
        Double price = Double.valueOf(element.getText());
        return price;
    }

    /**
     * 点击取消按钮
     */
    public SearchPage cancel() throws IOException {
//        click(By.id("com.xueqiu.android:id/action_close"));
        parseSteps();
        return new SearchPage();
    }


    /**
     * 获取所有股票列表
     */
    public SearchPage select() throws IOException {
//        click(By.id("com.xueqiu.android:id/follow_btn"));
        parseSteps();
        return this;
    }


    //点击加入自选按钮
    public SearchPage addOptional() throws IOException {
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
