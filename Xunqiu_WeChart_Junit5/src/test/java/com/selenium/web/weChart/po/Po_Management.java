package com.selenium.web.weChart.po;

import com.selenium.web.weChart.basic.BasicObject;
import com.selenium.web.weChart.po.management.Broadcast;
import org.openqa.selenium.By;

/**
 * 管理工具
 */
public class Po_Management extends BasicObject {

    /**
     * 群发消息
     *
     * @return
     */
    public Broadcast groupSentMessage() {
//        findElement(By.linkText("消息群发")).click();
////        findElement(By.cssSelector(".manageTools_cnt_itemLink js_show_SendMessage")).click();
        findElement(By.xpath("//*[@id=\"js_manageTools_index\"]/div/ul/li[3]/a/div/div[1]")).click();
        return new Broadcast();
    }
}
