package app.page;

import java.util.HashMap;
import java.util.List;

/**
 * 存储yaml中转化的类
 */
public class TestCaseSteps {
    public List<HashMap<String,String>> steps;

    public List<HashMap<String, String>> getSteps() {
        return steps;
    }

    public void setSteps(List<HashMap<String, String>> steps) {
        this.steps = steps;
    }
}
