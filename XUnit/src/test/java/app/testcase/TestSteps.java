package app.testcase;

import app.page.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestSteps {


    @Test
    public void steps() throws JsonProcessingException {
        HashMap<String, TestCaseSteps> testcase = new HashMap<String, TestCaseSteps>();
        TestCaseSteps testcaseStep = new TestCaseSteps();

        List<HashMap<String, String>> steps = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("id", "xxxx");
        map.put("send", "xxxx");
        steps.add(map);

        testcaseStep.setSteps(steps);
        testcase.put("search", testcaseStep);

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(testcase));
    }

    @Test
    public void parseSteps() throws IOException {
        //启动APP
        App.start();
        BasicPage basicPage = new BasicPage();
        basicPage.parseSteps("search");
    }


    @Test
    public void testModel() throws JsonProcessingException {
        PageObjectModel model = new PageObjectModel();
        //定义method对象
        PageObjectMethod pageObjectMethod = new PageObjectMethod();
        //定义element对象
        PageObjectElement pageObjectElement = new PageObjectElement();

        List<HashMap<String,String>> methodList = Lists.newArrayList();
        HashMap<String, String> methodMap = Maps.newHashMap();
        List<HashMap<String,String>> elementList = Lists.newArrayList();
        HashMap<String, String> elementMap = Maps.newHashMap();

        //methods赋值
        methodMap.put("id", "xxx");
        methodMap.put("send", "xxx");
        methodList.add(methodMap);
        pageObjectMethod.setSteps(methodList);

        //elements赋值
        elementMap.put("id", "xxx");
        elementMap.put("os", "android");
        elementList.add(elementMap);
        pageObjectElement.setElement(elementList);

        //model赋值
        model.elements.put("search_locator", pageObjectElement);
        model.methods.put("search", pageObjectMethod);

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(model));
    }
}
