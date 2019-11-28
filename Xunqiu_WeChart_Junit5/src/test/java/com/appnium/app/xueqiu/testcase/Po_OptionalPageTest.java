package com.appnium.app.xueqiu.testcase;

import com.appnium.app.xueqiu.po.Po_HomePage;
import com.appnium.app.xueqiu.po.Po_OptionalPage;
import com.appnium.app.xueqiu.po.homepage.SearchPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class Po_OptionalPageTest extends BasicTest {
    private static Po_OptionalPage po_optionalPage;
    private static Po_HomePage po_homePage;
    private SearchPage searchPage;
    private static String stock;
    private static double price;

    static {
        stock = "alibaba";
        price = 200;
    }


    @BeforeAll
    public static void setUp() {
        //实例化雪球首页
        po_homePage = new Po_HomePage();
        // 切换到自选页面
        po_optionalPage = app.getOptionalPage();
    }

    @BeforeEach
    public void beforeEach() {

    }

    /**
     * 测试添加自选股票功能
     */
    @Order(1)
    @Test
    public void testAddDefaultOptionalStock() {
        System.out.println("order：：1");
        //先判断是否有股票，有的化清空
        if (po_optionalPage.getAllStocks().size() >= 1) {
            po_optionalPage.deleteOptionalStock();
        }

        assertThat(po_optionalPage.addDefaultOptionalStock().getAllStocks().size(), greaterThanOrEqualTo(6));
    }

    @Order(2)
    @Test
    public void test() {
        System.out.println("order：：2");
        //先判断是否有股票，有的化清空
        if (po_optionalPage.getAllStocks().size() >= 1) {
            po_optionalPage.deleteOptionalStock();
        }
        //切换到首页
        po_homePage = app.getHomePage();
        //添加自选股票
        searchPage = po_homePage.toSearchPage();
        searchPage.search(stock);
        searchPage.addOptional();
    }

    /**
     * 测试添加其他股票功能呢
     */
    @Test
    public void testAddOtherStock() {
        po_optionalPage.addOtherStock();
    }


}
