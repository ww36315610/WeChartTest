package app.testcase;

import app.page.App;
import app.page.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

/**
 * junit4 参数化测试
 */
@RunWith(Parameterized.class)
public class TestSearchParams4 {

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


    public static SearchPage searchPage;

    @BeforeClass
    public static void setup() throws MalformedURLException {
        App.getInstance().start();
    }

    @Before
    public void before() throws IOException {
        searchPage = App.getInstance().toSearch();
    }

    @Test
    public void search() throws IOException {
        assertThat(searchPage.search(stock).getCurrentPrice(), lessThanOrEqualTo(price));
    }


    @After
    public void after() throws IOException {
        searchPage.cancel();
    }
}
