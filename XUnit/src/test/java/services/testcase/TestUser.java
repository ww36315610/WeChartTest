package services.testcase;

import com.google.common.collect.Maps;
import org.junit.BeforeClass;
import org.junit.Test;
import services.api.User;

import java.util.HashMap;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestUser {
    static User user;
    static int department_id = 1;
    static String userid = "18800001111";
    static String userName = "18800001111";

    @BeforeClass
    public static void beforClass() {
        user = new User();
        userid = user.list(department_id).
                then().extract().body().path("userlist.find{d -> d.name == '" + userName + "'}.userid");
        System.out.println("---------" + userid);
    }

    @Test
    public void get() {
      String name =  user.get(userid).then().extract().body().path("name");
        System.out.println("========"+name);
//        "department.findAll{d -> d.name == '" + name + "'}.id",
    }

    @Test
    public void create() {
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("aaa", "aaa");
        System.out.println(map);
    }
}