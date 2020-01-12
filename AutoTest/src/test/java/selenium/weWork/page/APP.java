package selenium.weWork.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;

public class APP extends BasicPage {

    //请求地址
    private final static String URL = "https://work.weixin.qq.com/";
    //Cookie信息
    private final static String refid = "24367782073311728";
    private final static String sid = "JvZOmWG4Uap9Glla7YBqRsTmoGH14YoXk5qsXrqJ-GLgKdcEsDzLF5-a8mYXRiL4";

    /**
     * 登陆操作
     */
    public APP loginWithCookie() {
        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1440, 797));
        driver.findElement(By.linkText("企业登录")).click();
        driver.manage().addCookie(new Cookie("wwrtx.refid", refid));
        driver.manage().addCookie(new Cookie("wwrtx.sid", sid));
        driver.navigate().refresh();
        return this;
    }

    /**
     * 链接到添加
     *
     * @return
     */
    public ContactPage toContactAdd() {
        return new ContactPage();
    }

    /**
     * 链接到"添加用户页面"
     *
     * @return
     */
    public ContactPage toMemberAdd() {
        //点击添加通讯录
        driver.findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }


    /**
     * 测试结束，推出浏览器
     */
    public void tearDown() {
        System.out.println("--------正在关闭浏览器……--------");
        driver.quit();
        System.out.println("--------浏览器正常关闭……--------");
    }
}
