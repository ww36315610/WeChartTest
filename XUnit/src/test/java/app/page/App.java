package app.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class App extends BasicPage {
    /**
     * 初始化：AndroidDriver
     *
     * @throws MalformedURLException
     */
    public static void start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noRest", "true");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        //增加隐式等待
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //增加显示等待确保首页加载成功【等待搜索按钮出现「第一个case的按钮」】
        long start = System.currentTimeMillis();
        new WebDriverWait(driver, 40)
                .until(x -> {
                    String xml = driver.getPageSource();
                    Boolean exist = xml.contains("home_search") || xml.contains("image_cancel");
                    System.out.println((System.currentTimeMillis() - start) / 1000);
                    System.out.println(exist);
                    return exist;
                });
    }

    /**
     * 点击到Search页面
     */

    public static SearchPage toSearch() throws IOException {
//        findElement(By.id("com.xueqiu.android:id/home_search")).click();
//        System.out.println(driver.getPageSource());
        String path = "/app/page/app.yaml";
        parseSteps("toSearch", path);
        return new SearchPage();
    }

    /**
     * 点击到雪球首页Tab页面
     */
    public static HomePage toHomePage() throws IOException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        click(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='雪球']"));
        String path = "/app/page/app.yaml";
        parseSteps("toSearch", path);
        return new HomePage();
    }

    /**
     * 点击到自选Tab页面
     */
    public static StockPage toStock() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='自选']"));
        return new StockPage();
    }

    /**
     * 点击到关注Tab页面
     */

    /**
     * 点击到行情Tab页面
     */

    /**
     * 点击到交易Tab页面
     */
}