package selenium.weWork.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasicPage {
    public static WebDriver driver;

    /**
     * 初始化driver
     */
    static {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * 定义findByElement方法，返回WebElement
     *
     * @param by
     * @return
     */
    public WebElement findElement(By by) {
        return APP.driver.findElement(by);
    }

    /**
     * 定义findByElement方法，返回WebElement
     *
     * @param by
     * @return
     */
    public WebElement findElement(By by, Integer timeOut) {
        return APP.driver.findElement(by);
    }


}
