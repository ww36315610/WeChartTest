package com.appnium.app.xueqiu.testcase.homepage;


import com.appnium.app.xueqiu.po.Po_HomePage;
import com.appnium.app.xueqiu.po.homepage.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@RunWith(Parameterized.class)
public class SearchPageParamTest {
    private static Po_HomePage po_homePage;
    private SearchPage searchPage;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"alibaba", 200},
                {"xiaomi", 10},
                {"jd", 50},
                {"pdd", 50}
        });
    }

    //实际值
    @Parameterized.Parameter(0)
    public String stock;

    //期望值
    @Parameterized.Parameter(1)
    public double price;


    @BeforeClass
    public static void beforeAll() {
        po_homePage = new Po_HomePage();
    }

    @Before
    public void before() {
        searchPage = po_homePage.toSearchPage();
    }

    @Test
    public void searchTest() {
        double priceGet = searchPage.search(stock).getPrice();
        assertThat(price, greaterThanOrEqualTo(priceGet));
    }

    @After
    public void after(){
        searchPage.cancel();
    }
}
