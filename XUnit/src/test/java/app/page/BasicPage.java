package app.page;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.collect.Lists;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BasicPage {
    public static AndroidDriver driver;

    private PageObjectModel model = new PageObjectModel();

    //输入参数[测试步骤参数化]
    public static HashMap<String, Object> params = new HashMap<>();
    //存放结果[结果数据读取]
    public static HashMap<String, Object> result = new HashMap<>();

    public static HashMap<String, Object> getParams() {
        return params;
    }

    public static void setParams(HashMap<String, Object> params) {
        BasicPage.params = params;
    }

    public static HashMap<String, Object> getResult() {
        return result;
    }

    /**
     * 统一获取对象[去除广告]
     *
     * @return
     */
    public static WebElement findElement(By by) {
        System.out.println(by);
        //todo:递归
        //todo:如果定位得元素是动态变化位置 1.显示等待 2.循环判断3次，看位置是否在最下面
        try {
            return driver.findElement(by);
        } catch (Exception e) {
            handleAlert();
        }
        return driver.findElement(by);
    }

    public static void click(By by) {
        System.out.println(by);
        //todo:递归
        try {
            driver.findElement(by).click();
        } catch (Exception e) {
            handleAlert();
            driver.findElement(by).click();
        }
    }

    public static List<WebElement> findElements(By by) {
        System.out.println(by);
        return driver.findElements(by);
    }

    //处理弹窗问题
    protected static void handleAlert() {
        By tips = By.id("com.xueqiu.android:id/snb_tip_text");
        List<By> alertBoxs = new ArrayList<>();
        //todo: 不需要所有的都判断是否存在
        //search时候升级弹框
        alertBoxs.add(By.id("com.xueqiu.android:id/image_cancel"));
        //随便点击屏幕其他地方
        alertBoxs.add(tips);
        //添加自选，下次再说弹框
        alertBoxs.add(By.id("com.xueqiu.android:id/md_buttonDefaultNegative"));

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        alertBoxs.forEach(alert -> {
            List<WebElement> ads = null;
            try {
                ads = driver.findElements(alert);
            } catch (Exception e) {
                System.err.println("元素定位失败：" + alert + "：返回");
                return;
            }
            if (alert.equals(tips)) {
                System.out.println("^^^^^^^^^^^snb_tip fount^^^^^^^^^^^" + tips);
                //获取屏幕size
                Dimension size = driver.manage().window().getSize();
                try {
                    if (driver.findElements(tips).size() >= 1) {
                        //点击屏幕的中心位置[此处可以改动]
                        new TouchAction(driver).tap(PointOption.point(size.width / 2, size.height / 2)).perform();
                    }
                } catch (Exception e) {
                    System.err.println("～～～～～～～点击坐标报错～～～～～～～");
                } finally {
                    System.out.println("【" + alert + "】^^^^^^^^^^^snb_tip clicked^^^^^^^^^^^");
                }
            } else if (ads.size() >= 1) {
                ads.get(0).click();
            }
        });
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //处理弹窗
    private static void handleAlertByPageSource() {
        //todo:xpath匹配,标记 定位
        String xml = driver.getPageSource();
        List<String> alertBoxs = Lists.newArrayList();
        alertBoxs.add("xxx");
        alertBoxs.add("yyy");

        alertBoxs.forEach(alert -> {
            if (xml.contains(alert)) {
                driver.findElement(By.id(alert)).click();
            }
        });
    }

    /**
     * 统一获取配置文件的方法封装
     * 可以不需要每次调用都传入方法名
     *
     * @throws IOException
     */
    public void parseSteps() throws IOException {
        String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println("========" + method);
        parseSteps(method);
    }

    /**
     * 统一获取配置文件方法
     *
     * @param method
     * @throws IOException
     */
    private void parseSteps(String method) {
        //this.getClass()//谁调用生成谁的class路径，
        String yamlPath = "/" + this.getClass().getCanonicalName().replace('.', '/') + ".yaml";
        parseSteps(yamlPath, method);
    }

    /**
     * 生成统一配置yaml模版
     * 必须继承BasicPage类
     *
     * @param method
     * @param path
     */
    public void parseSteps(String path, String method) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        //把readValue的内容转成typeRef样式
        // TypeReference<HashMap<String, TestCaseSteps>> typeRef = new TypeReference<HashMap<String, TestCaseSteps>>() {};

        try {
            model = mapper.readValue(BasicPage.class.getResourceAsStream(path), PageObjectModel.class);
            parseSteps(model.methods.get(method));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseSteps(PageObjectMethod steps) {
        steps.getSteps().forEach(step -> {
            WebElement element = null;
            String id = step.get("id");
            if (id != null) {
                element = findElement(By.id(id));
            } else if (step.get("xpath") != null) {
                element = findElement(By.xpath(step.get("xpath")));
            } else if (step.get("aid") != null) {
                element = findElement(MobileBy.AccessibilityId(step.get("aid")));
            } else if (step.get("element") != null) {
                element = findElement(model.elements.get(step.get("element")).getLocator());
            }
            String send = step.get("send");
            //外部参数代替yaml配置里面参数
            if (send != null) {
                for (Map.Entry<String, Object> kv : params.entrySet()) {
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
                result.put(step.get("dump"), attribute);

            } else {
                element.click();
            }
        });
    }
}
