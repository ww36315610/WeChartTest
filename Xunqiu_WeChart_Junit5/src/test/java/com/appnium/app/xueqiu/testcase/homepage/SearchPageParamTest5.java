package com.appnium.app.xueqiu.testcase.homepage;


import com.appnium.app.xueqiu.po.Po_HomePage;
import com.appnium.app.xueqiu.po.homepage.SearchPage;

import org.junit.After;
import org.junit.jupiter.api.*;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import sun.tools.jps.Arguments;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SearchPageParamTest5 {
    private static Po_HomePage po_homePage;
    private SearchPage searchPage;


    @BeforeAll
    public static void beforeAll() {
        po_homePage = new Po_HomePage();
    }

    @BeforeEach
    public void before() {
        searchPage = po_homePage.toSearchPage();
    }

    @Order(3)
    @ParameterizedTest
    @MethodSource("data")
    public void searchTest(String stock,Double price) {
        double priceGet = searchPage.search(stock).getPrice();
        assertThat(price, greaterThanOrEqualTo(priceGet));
    }


    public static Stream<org.junit.jupiter.params.provider.Arguments> data(){
        return Stream.of(
                arguments("xiaomi",10.00),
                arguments("alibaba", 200.00),
                arguments("pdd", 50.00),
                arguments("jd", 50.00)
        );
    }

    @AfterEach
    public void after(){
        searchPage.cancel();
    }
}
