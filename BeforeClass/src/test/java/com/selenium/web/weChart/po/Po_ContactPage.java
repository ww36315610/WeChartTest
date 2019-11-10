package com.selenium.web.weChart.po;

import com.selenium.web.weChart.basic.BasicObject;
import org.openqa.selenium.By;

/**
 * 通讯录
 */
public class Po_ContactPage extends BasicObject {

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
        findElement(By.name("id")).sendKeys(id);
        findElement(By.name("phone")).sendKeys(phone);
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
