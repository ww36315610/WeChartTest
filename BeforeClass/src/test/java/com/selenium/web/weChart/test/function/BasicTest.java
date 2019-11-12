package com.selenium.web.weChart.test.function;

import com.selenium.web.weChart.po.AgentPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BasicTest {

    public static AgentPage agentPage;

    /**
     * 父类初始化定义
     */
    @BeforeClass
    public static void setUp() {
        agentPage = new AgentPage();
        //登录
        agentPage.getLogin();
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
        agentPage.tearDown();
    }
}
