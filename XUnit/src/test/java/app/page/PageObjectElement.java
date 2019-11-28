package app.page;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;

public class PageObjectElement {
    public List<HashMap<String, String>> element;

    public By getLocator() {
        //获取平台
        String osOrigin = BasicPage.driver.getCapabilities().getPlatform().toString().toLowerCase();
        return By.id("xx");
    }

    public By getLocator(String os, String version) {
        //获取平台
        HashMap<String, String> matcher = (HashMap<String, String>) element.stream().filter(x -> x.get("os") == os && x.get("version") == version).toArray()[0];
        if (matcher.get("id") != null) {
            return By.id(matcher.get("id"));
        } else if (matcher.get("xpath") != null) {
            return By.xpath(matcher.get("xpath"));
        }

//        for (HashMap<String, String> matcher1 : element) {
//            if (matcher1.get("id") != null) {
//                return By.id(matcher1.get("id"));
//            } else if (matcher1.get("xpath") != null) {
//                return By.xpath(matcher1.get("xpath"));
//            }
//            break;
//        }

        return null;
    }

    public List<HashMap<String, String>> getElement() {
        return element;
    }

    public void setElement(List<HashMap<String, String>> element) {
        this.element = element;
    }
}
