package app.testcase;

import app.page.App;
import app.page.SearchPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class TestSearch {

    public static SearchPage searchPage;

    @BeforeAll
    public static void setup() throws IOException {
        App.getInstance().start();
        searchPage = App.getInstance().toSearch();
    }

    @Test
    public void search() throws IOException {
        assertThat(searchPage.search("alibaba").getCurrentPrice(), lessThanOrEqualTo(200.00));
    }
}
