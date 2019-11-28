package app.testcase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.jupiter.api.TestReporter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TestResources {
    public String name;
    public int age;

    @Test
    public void readFile() {
        System.out.println(this.getClass().getName());
        System.out.println(this.getClass().getCanonicalName());
        System.out.println(this.getClass().getResource("/"));
        System.out.println(this.getClass().getResource("/app/testcase/TestStock.yaml"));
        try {
            System.out.println(FileUtils.readFileToString(new File(this.getClass().getResource("/app/testcase/TestStock.yaml").getPath())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写json文件
     */
    @Test
    public void writeJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("demo.json"), this);
    }

    /**
     * 读取json文件
     */
    @Test
    public void readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TestResources demo = mapper.readValue(new File("demo.json"), this.getClass());
        System.out.println(demo);
        System.out.println(demo.name);
        System.out.println(demo.age);
    }

    /**
     * 读取yaml文件
     */
    @Test
    public void readYaml() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Object[][] demo = mapper.readValue(this.getClass().getResourceAsStream("/app/testcase/TestStock.yaml"), Object[][].class);
        System.out.println(demo);
        System.out.println(demo.length);
        System.out.println(demo[0].length);
        System.out.println(demo[0]);
        System.out.println(demo[0][0]);
    }
}
