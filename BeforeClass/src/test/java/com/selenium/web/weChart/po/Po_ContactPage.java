package com.selenium.web.weChart.po;

import com.selenium.web.weChart.basic.BasicObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 通讯录
 */
public class Po_ContactPage extends BasicObject {

    /**
     * 根据按钮名称选择点击的功能[也可以用于文本框等点击操作]
     * 1.添加成员
     * 2.批量导入/导出
     * 3.设置所在部门
     * 4.删除
     * 5.微信邀请
     */
    public void clickButton(String clickName) {
        findElement(By.linkText(clickName), 2000).click();
        waitDriverWait(null, 10, "yin");
    }

    /**
     * sendkeys
     * 选择文本框并输入信息
     */
    public void sendKeys(String clickByType, String sendValue) {
       WebElement element =  findElement(By.id(clickByType), 2000);
       element.click();
       element.sendKeys(sendValue);
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
        findElement(By.name("username"), 500).sendKeys(username);
        findElement(By.name("acctid"), 0).sendKeys(id);
        findElement(By.name("mobile"), 0).sendKeys(phone);
        findElement(By.linkText("保存"), 1000).click();
        return this;
    }

    /**
     * 删除联系人
     *
     * @param keyword
     * @return
     */
    public Po_ContactPage delete(String keyword) {
        findElement(By.id("memberSearchInput"), 500).sendKeys(keyword);
        findElement(By.linkText("删除"), 0).click();
        findElement(By.linkText("确认"), 0).click();
        findElement(By.id("clearMemberSearchInput"), 0).click();
        return this;
    }

    /**
     * 搜索功能
     *
     * @param clickName
     * @param searchValue
     * @return
     */
    public Po_ContactPage search(String clickName, String searchValue) {
        sendKeys(clickName, searchValue);
        return this;
    }
}
