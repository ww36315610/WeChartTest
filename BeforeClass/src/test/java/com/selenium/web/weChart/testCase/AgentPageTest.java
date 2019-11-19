package com.selenium.web.weChart.testCase;

import org.junit.Ignore;
import org.junit.Test;

public class AgentPageTest extends BasicTest {

    @Test
    public void changeClick() {
        agentPage.testClick();
    }

    /**
     * 测试登录
     */
    @Test
    @Ignore
    public void getLoginTest() {
        agentPage.getLogin();
    }

    /**
     * 测试通讯录
     */
    @Test
    public void getContactPageTest() {
        agentPage.getContactPage();
    }

    /**
     * 测试应用管理
     */
    @Test
    public void geApplicationTest() {
        agentPage.geApplication();
    }

    /**
     * 测试客户联系
     */
    @Test
    public void getCustomerTest() {
        agentPage.getCustomer();
    }

    /**
     * 测试管理工具
     */
    @Test
    public void getManagementTest() {
        agentPage.getManagement();
    }

    /**
     * 测试我的企业
     */
    @Test
    public void getMyBusinessTest() {
        agentPage.getMyBusiness();
    }
}
