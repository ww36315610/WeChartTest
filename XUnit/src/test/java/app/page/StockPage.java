package app.page;

import org.openqa.selenium.By;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 雪球APP自选页
 */
public class StockPage extends BasicPage {

    /**
     * 删除自选股票
     */
    public StockPage deleteAll() throws IOException{
//        click(By.id("com.xueqiu.android:id/edit_group"));
//        click(By.id("com.xueqiu.android:id/check_all"));
//        click(By.id("com.xueqiu.android:id/cancel_follow"));
//        click(By.id("com.xueqiu.android:id/md_buttonDefaultPositive"));
//        click(By.id("com.xueqiu.android:id/action_close"));
        parseSteps();
        return this;
    }

    /**
     * 获取自选股票列表
     */
    public List<String> getAllStocks() {
        //先进行弹窗异常处理
        handleAlert();

        List<String> stocks = new ArrayList<>();
        findElements(By.id("com.xueqiu.android:id/portfolio_stockName")).forEach(element -> {
            stocks.add(element.getText());
        });
        System.out.println(stocks);
        return stocks;
    }

    /**
     * 加入自选功能
     */
    public StockPage addDefaultOptionalStock() throws IOException{
//        click(By.id("com.xueqiu.android:id/add_to_portfolio_stock"));
        parseSteps();
        return this;
    }


    /**
     * 跳转Search页面
     */
    public SearchPage toSearch() throws IOException{
        //点击搜索🔍页面
//        click(By.id("com.xueqiu.android:id/action_search"));
        parseSteps();
        return new SearchPage();
    }
}

