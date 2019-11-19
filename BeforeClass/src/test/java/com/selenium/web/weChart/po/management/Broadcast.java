package com.selenium.web.weChart.po.management;

import com.selenium.web.weChart.basic.BasicObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * 群发消息功能
 */
public class Broadcast extends BasicObject {

    /**
     * 发送消息
     *
     * @param range
     * @param title
     * @param body
     * @param summary
     * @param author
     * @return
     */
    public Broadcast sendMessage(String range, String title, String body, String summary, String author) {

        findElement(By.linkText("选择需要发消息的应用")).click();
        findElement(By.cssSelector(".ww_icon_AppNotice")).click();
        findElement(By.linkText("确定")).click();

        findElement(By.linkText("选择发送范围")).click();
        findElement(By.id("memberSearchInput")).sendKeys(range);
        findElement(By.cssSelector(".ww_searchResult_title_peopleName")).click();
        findElement(By.linkText("确认")).click();

        //输入主题
        findElement(By.cssSelector(".ww_editorTitle")).sendKeys(title);

        //输入主要内容 1)切换frame
        System.out.println("bb:::" + driver.getWindowHandles());
        driver.switchTo().frame(0);
        findElement(By.cssSelector(".msg_noticeEditor_frameBody")).sendKeys(body);
        driver.switchTo().defaultContent();

//        Object[] windows = (String[]) driver.getWindowHandles().toArray();
//        for (int i = 0; i < windows.length; i++) {
//            System.out.println(windows[0].toString());
//        }
//        System.out.println("1111---"+driver.getPageSource());
//        driver.switchTo().window(windows[0].toString());
//        driver.switchTo().parentFrame();
//        driver.switchTo().defaultContent();
//        System.out.println("2222---"+driver.getPageSource());

        //滑动窗口
        ((JavascriptExecutor) (driver)).executeScript("window.scroll(0,1000)");
        findElement(By.cssSelector(".msg_edit_infoItem_textWord")).click();
        findElement(By.cssSelector(".qui_textarea")).sendKeys(summary);
        findElement(By.cssSelector(".js_amrd_sendName")).sendKeys(author);

        //滑动窗口
        ((JavascriptExecutor) (driver)).executeScript("window.scroll(0,1000)");
        findElement(By.linkText("发送")).click();
        findElement(By.linkText("确定")).click();
        return this;
    }

    public List<String> getSendedMsg() {
        findElement(By.linkText("已发送")).click();
        List<String> msg = new ArrayList<>();
        driver.findElements(By.cssSelector(".msg_history_msgList_td")).forEach(element -> {
            msg.add(element.getText());
        });
        return msg;
    }
}
