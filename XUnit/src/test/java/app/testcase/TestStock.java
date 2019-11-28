package app.testcase;

import app.page.App;
import app.page.SearchPage;
import app.page.StockPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class TestStock {
    private static StockPage stockPage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.start();
        stockPage = App.toStock();
    }

    //测试添加自选股票功能
    @Order(1)
    @Test
    public void test1() throws IOException{
        if (stockPage.getAllStocks().size() >= 1) {
            stockPage.deleteAll();
        }
        assertThat(stockPage.addDefaultOptionalStock().getAllStocks().size(), lessThanOrEqualTo((10)));
    }

    //测试从搜索到添加股票功能
    @Order(2)
    @Test
    public void test2() throws IOException {
        if (stockPage.getAllStocks().size() >= 1) {
            stockPage.deleteAll();
        }
        stockPage.toSearch().search("pdd").select().cancel();
        assertThat(stockPage.getAllStocks(), hasItem("拼多多"));
    }
}
