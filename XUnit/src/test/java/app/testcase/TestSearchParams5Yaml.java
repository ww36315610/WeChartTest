package app.testcase;

import app.page.App;
import app.page.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * junit4 参数化测试
 */
public class TestSearchParams5Yaml {


    public static SearchPage searchPage;

    @BeforeAll
    public static void setup() throws MalformedURLException {
        App.start();
    }

    @BeforeEach
    public void before() throws IOException{
        searchPage = App.toSearch();
    }

    @Order(3)
    @ParameterizedTest
    @MethodSource("data")
    public void searchTest(String stock, Double price) throws IOException {
        double priceGet = searchPage.search(stock).getCurrentPrice();
        assertThat(price, greaterThanOrEqualTo(priceGet));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments("xiaomi", 10.00),
                arguments("alibaba", 200.00),
                arguments("pdd", 50.00),
                arguments("jd", 50.00)
        );
    }

    @AfterEach
    public void after() throws IOException {
        searchPage.cancel();
    }
}
