package com.selenium.web.weChart.test.function;

import com.selenium.web.weChart.po.Po_ContactPage;
import org.junit.Test;

public class ContactPageTest extends BasicTest {
    Po_ContactPage po_contactPage;

    @Test
    public void addTest() {
        po_contactPage = agentPage.getContactPage();
        po_contactPage.clickButton("添加成员");
        po_contactPage.add("wangjian", "123123", "18000001111");
    }
}
