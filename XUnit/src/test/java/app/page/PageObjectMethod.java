package app.page;

import java.util.HashMap;
import java.util.List;

public class PageObjectMethod {
    /**
     * 定义测试步骤接收
     */
    public List<HashMap<String,String>> steps;

    public List<HashMap<String, String>> getSteps() {
        return steps;
    }

    public void setSteps(List<HashMap<String, String>> steps) {
        this.steps = steps;
    }
}
