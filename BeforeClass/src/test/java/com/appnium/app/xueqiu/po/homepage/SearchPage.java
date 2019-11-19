package com.appnium.app.xueqiu.po.homepage;

import com.appnium.app.xueqiu.basic.BasicObject;
import com.appnium.app.xueqiu.po.Po_HomePage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class SearchPage extends BasicObject {

    //查询股票功能
    public SearchPage search(String searchStock) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(searchStock);
        findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).click();
//        findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView")).click();
        return new SearchPage();
    }

    //获取股票价格
    public double getPrice() {
        return Double.parseDouble(driver.findElement(By.id("com.xueqiu.android:id/current_price")).getText());
    }

    //
    public Po_HomePage cancel(){
        findElementAndClick(By.id("com.xueqiu.android:id/action_close"));
        return new Po_HomePage();
    }
}
