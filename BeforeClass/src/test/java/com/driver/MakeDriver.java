package com.driver;

import com.driver.type.DriverByApp;
import com.driver.type.DriverByChrome;
import com.selenium.web.weChart.basic.BasicObject;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class MakeDriver{

    public static Object getDriverByParam(String param) {
        if (param.equals("chrome")) {
            return DriverByChrome.getDriver();
        } else if (param.equals("firefox")) {
            return DriverByChrome.getDriver();
        } else if (param.equals("app")) {
            try {
                return DriverByApp.getDriver();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
