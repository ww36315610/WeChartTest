package selenium.weWork.page;

import org.openqa.selenium.By;

public class ContactPage extends BasicPage {

    /**
     * 添加成员
     * @param username
     * @param acctid
     * @param phone
     * @return
     */
    public ContactPage add(String username, String acctid, String phone) {
        findElement(By.name("username")).sendKeys(username);
        findElement(By.name("acctid")).sendKeys(acctid);
        findElement(By.name("mobile")).sendKeys(phone);
        findElement(By.linkText("保存")).click();
        return this;
    }

    /**
     * 删除成员
     * @param keyWord
     * @return
     */
    public ContactPage delete(String keyWord){
        findElement(By.id("memberSearchInput")).sendKeys(keyWord);
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
        return this;
    }
}
