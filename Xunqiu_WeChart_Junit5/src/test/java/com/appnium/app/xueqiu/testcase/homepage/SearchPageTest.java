package com.appnium.app.xueqiu.testcase.homepage;


import com.appnium.app.xueqiu.po.Po_HomePage;
import com.appnium.app.xueqiu.po.homepage.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class SearchPageTest {
    private static Po_HomePage po_homePage;
    private SearchPage searchPage;
    private static String stock;
    private static double price;

    static {
        stock = "alibaba";
        price = 200;
    }


    @BeforeClass
    public static void setUp() {
        po_homePage = new Po_HomePage();

    }

    @Before
    public void before() {
        searchPage = po_homePage.toSearchPage();
    }

    @Test
    public void searchTest() {
        double priceGet = searchPage.search(stock).getPrice();
        System.out.println("----===----" + priceGet);
        assertThat(price, greaterThanOrEqualTo(priceGet));
    }

    @Test
    public void addOptionalTest(){
        System.out.println("----------加入自选----------");
        searchPage.search(stock).addOptional();
    }

    @After
    public void after() {
        searchPage.cancel();
    }

}
