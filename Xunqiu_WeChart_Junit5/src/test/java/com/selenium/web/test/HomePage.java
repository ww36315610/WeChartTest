package com.selenium.web.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasicUnitTest {
    String url = "https://work.weixin.qq.com/wework_admin/frame";

    @Before
    public void HomePageBefore() {
        map.put("首页", "//*[@id=\"menu_index\"]/span");
        map.put("通讯录", "//*[@id=\"menu_contacts\"]/span");
        map.put("应用管理", "//*[@id=\"menu_apps\"]/span");
        map.put("客户联系", "//*[@id=\"menu_customer\"]/span");
        map.put("管理工具", "//*[@id=\"menu_manageTools\"]/span");
        map.put("我的企业", "//*[@id=\"menu_profile\"]/span");
    }


    @Test
    public void testHomePage() {
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1440, 877));
        //显示等待，等待q可以被点击
        new WebDriverWait(driver, 10000)
                .until(ExpectedConditions.elementToBeClickable(By.name("q")));
      //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        map.forEach((k, v) -> {
            driver.findElement(By.xpath(v.toString())).click();
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
