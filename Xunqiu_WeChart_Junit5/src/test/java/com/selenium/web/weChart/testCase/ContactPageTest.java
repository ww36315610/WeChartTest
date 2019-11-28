package com.selenium.web.weChart.testCase;

import com.selenium.web.weChart.po.Po_ContactPage;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 测试通讯录功能
 */
public class ContactPageTest extends BasicTest {
    private static Po_ContactPage po_contactPage;

    @BeforeClass
    public static void beforeContactPageTest() {
        po_contactPage = agentPage.getContactPage();
    }

    /**
     * 测试添加功能
     */
    @Test
    public void addTest() {
        po_contactPage.clickButton("添加成员");
        po_contactPage.add("wangjian", "123123", "18000001111");
    }


    @Test()
    public void deleteTest() {
        po_contactPage.delete("memberSearchInput", "18000001111");
    }


    @Test
    public void fileUpTest(){
        String inputFile = "/Users/apple/Desktop/uploadFile/通讯录批量导入模板.xlsx ";
        po_contactPage.fileUp(inputFile);
    }
//    @Test
//    public void searchTest() {
//        po_contactPage = agentPage.getContactPage();
//        po_contactPage.search("memberSearchInput", "18711171117");
//    }
}
