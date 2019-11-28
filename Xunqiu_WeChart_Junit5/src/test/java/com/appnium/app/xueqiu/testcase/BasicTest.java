package com.appnium.app.xueqiu.testcase;

import com.appnium.app.xueqiu.po.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BasicTest {
    public static App app = new App();

    /**
     * 父类初始化定义
     */
    @BeforeAll
    public static void setUp() {
//        app = new App();
        //登录
//        app.getLogin();
    }


    /**
     * 测试结束，推出app
     *
     * @throws Exception
     */

    @AfterAll
    public static void tearDown() {
        app.tearDown();
    }
}
