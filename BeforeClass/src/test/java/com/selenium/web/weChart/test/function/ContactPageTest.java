package com.selenium.web.weChart.test.function;

import com.selenium.web.weChart.po.Po_ContactPage;
import org.junit.Test;

/**
 * 测试通讯录功能
 */
public class ContactPageTest extends BasicTest {
    Po_ContactPage po_contactPage;

    /**
     * 测试添加功能
     */
    @Test
    public void addTest() {
        po_contactPage = agentPage.getContactPage();
        po_contactPage.clickButton("添加成员");
        po_contactPage.add("wangjian", "123123", "18000001111");
    }

    @Test
    public void deleteTest() {
        po_contactPage = agentPage.getContactPage();
        po_contactPage.clickButton("添加成员");
    }

    @Test
    public void searchTest() {
        po_contactPage = agentPage.getContactPage();
        po_contactPage.search("memberSearchInput", "18711171117");
    }
}
