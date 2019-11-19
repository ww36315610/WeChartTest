package com.selenium.web.weChart.testCase.management;

import com.selenium.web.weChart.po.Po_Management;
import com.selenium.web.weChart.po.management.Broadcast;
import com.selenium.web.weChart.testCase.BasicTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItem;

public class BroadcastTest extends BasicTest {
    private static Po_Management po_management;
    private static Broadcast broadcast;

    //
    private static String range;
    private static String title;
    private static String body;
    private static String summary;
    private static String author;

    static {
        range = "王健";
        title ="通告:auto_001"+System.currentTimeMillis();
        body="你所负责的项目测试通过";
        summary ="测试报告";
        author="自动化测试中心";

    }

    @BeforeClass
    public static void beforeContactPageTest() {
        po_management = agentPage.getManagement();
        broadcast = po_management.groupSentMessage();
    }

    @Test
    public void sendMessageTest(){
        List<String> sendedMsg = broadcast.sendMessage(range, title, body, summary, author).getSendedMsg();
        System.out.println("===="+sendedMsg);
        assertThat(sendedMsg,hasItem(title));
    }

}
