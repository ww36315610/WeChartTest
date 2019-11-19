package com.appnium.app.xueqiu.testcase;

import com.appnium.app.xueqiu.po.App;
import com.selenium.web.weChart.po.AgentPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BasicTest {
    public static App app;

    /**
     * 父类初始化定义
     */
    @BeforeClass
    public static void setUp() {
        app = new App();
        //登录
//        app.getLogin();
    }


    /**
     * 测试结束，推出app
     *
     * @throws Exception
     */

    @AfterClass
    public void tearDown() {
        app.tearDown();
    }
}
