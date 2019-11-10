package com.selenium.web.weChart.po;

import com.selenium.web.weChart.basic.BasicObject;
import org.openqa.selenium.By;

/**
 * 通讯录
 */
public class Po_ContactPage extends BasicObject {

    /**
     * 根据按钮名称选择点击的功能
     * 1.添加成员
     * 2.批量导入/导出
     * 3.设置所在部门
     * 4.删除
     * 5.微信邀请
     */
    public void clickButton(String buttonName) {
        findElement(By.linkText(buttonName)).click();
        waitDriverWait(null,10,"yin");
    }

    /**
     * 增加联系人
     *
     * @param username
     * @param id
     * @param phone
     * @return
     */
    public Po_ContactPage add(String username, String id, String phone) {
        findElement(By.name("username")).sendKeys(username);
        findElement(By.name("acctid")).sendKeys(id);
        findElement(By.name("mobile")).sendKeys(phone);
        return this;
    }

    /**
     * 删除联系人
     *
     * @param keyword
     * @return
     */
    public Po_ContactPage delete(String keyword) {
        findElement(By.id("memberSearchInput")).sendKeys(keyword);
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
        findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }
}
