package app.page;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageObjectModel {
    /**
     * 定义element接收
     */
    public HashMap<String, PageObjectElement> elements = new HashMap<>();
    /**
     * 定义method接收
     */
    public HashMap<String, PageObjectMethod> methods = new HashMap<>();

    /**
     * 根据方法名获取yaml中执行步骤对象
     */
    public PageObjectMethod getMethod(String method) {
        return methods.get(method);
    }

    /**
     * PageObjectModel.run("method").get("result")
     * @param method
     */
    public void run(String method) {
        //获取Methods对象
        PageObjectMethod steps = getMethod(method);
        steps.getSteps().forEach(step -> {
            WebElement element = null;
            String id = step.get("id");
            if (id != null) {
                element = BasicPage.driver.findElement(By.id(id));
            } else if (step.get("xpath") != null) {
                element = BasicPage.driver.findElement(By.xpath(step.get("xpath")));
            } else if (step.get("aid") != null) {
                element = BasicPage.driver.findElement(MobileBy.AccessibilityId(step.get("aid")));
            } else if (step.get("element") != null) {
                element = BasicPage.driver.findElement(elements.get(step.get("element")).getLocator());
            }
            String send = step.get("send");
            //外部参数代替yaml配置里面参数
            if (send != null) {
                for (Map.Entry<String, Object> kv : BasicPage.getParams().entrySet()) {
                    if (send.contains("${" + kv.getKey() + "}")) {
                        System.out.println(kv);
                        send = send.replace("${" + kv.getKey() + "}", kv.getValue().toString());
                    }
                }
                System.out.println("---" + send);
                element.sendKeys(send);
            } else if (step.get("get") != null) {
                //获取text取值                   //此处取得是配置文件get值text
                String attribute = element.getAttribute(step.get("get"));
                //给结果hasMap赋值，get(dump)取得是配置文件的price
                BasicPage.getResult().put(step.get("dump"), attribute);

            } else {
                element.click();
            }
        });
    }
}
