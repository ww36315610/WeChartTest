package com.appnium.app.xueqiu.po;

import com.appnium.app.xueqiu.basic.BasicObject;
import com.appnium.app.xueqiu.po.homepage.SearchPage;

/**
 * 首页
 */
public class Po_HomePage extends BasicObject {

    /**
     * 跳转到查询页面【searchPage】
     * @return
     */
    public SearchPage toSearchPage(){
        driver.findElementById("com.xueqiu.android:id/home_search").click();
        return new SearchPage();
    }

}
