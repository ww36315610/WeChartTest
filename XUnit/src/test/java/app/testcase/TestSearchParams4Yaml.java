package app.testcase;

import app.page.App;
import app.page.SearchPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
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
public class TestSearchParams4Yaml {

    @Parameterized.Parameters
    public static Collection<Object[]> data() throws IOException {
//        return Arrays.asList(new Object[][]{
//                {"alibaba", 200},
//                {"xiaomi", 10},
//                {"jd", 50},
//                {"pdd", 50}
//        });

        //此处要设置yaml文件路径跟此类报名一致：app.testcase.TestSearchParams4Yaml
        String yamlPath = "/" + TestSearchParams4Yaml.class.getCanonicalName().replace('.', '/') + ".yaml";
        System.out.println(yamlPath);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Object[][] demo = mapper.readValue(TestSearchParams4Yaml.class.getResourceAsStream(yamlPath), Object[][].class);
        return Arrays.asList(demo);
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
