package com.selenium.web.weChart.test.function;

import com.selenium.web.weChart.po.AgentPage;
import org.junit.Before;
import org.junit.Test;

public class AgentPageTest {
    public static AgentPage agentPage;

    @Before
    public void setUp(){
        agentPage = new AgentPage();
        agentPage.getLogin();


    }
//    @Test
//    public void loginTest(){
//        agentPage.getLogin();
//    }

    @Test
    public void changeClick(){
        agentPage.testClick();
    }
}
