package com.selenium.web.weChart.test.function;

import com.selenium.web.weChart.po.AgentPage;
import org.junit.Before;
import org.junit.Test;

public class LoginPageTest {
    public static AgentPage agentPage;

    @Before
    public void setUp(){
        agentPage = new AgentPage();


    }
    @Test
    public void loginTest(){
        agentPage.getLogin();
    }

}
