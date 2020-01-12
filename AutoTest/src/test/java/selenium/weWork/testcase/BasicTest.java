package selenium.weWork.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import selenium.weWork.page.APP;

public class BasicTest {

    public static APP app;

    /**
     * 父类初始化定义
     */
    @BeforeClass
    public static void setUp() {
        app = new APP();
        //登录
        app.loginWithCookie();
    }


    /**
     * 测试结束，推出浏览器
     *
     * @throws Exception
     */
    @AfterClass
    public static void tearDown() throws Exception {
        System.out.println("--------web自动化测试正在结束--------");
        Thread.sleep(10000);
        app.tearDown();
    }
}
