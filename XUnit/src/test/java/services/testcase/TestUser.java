package services.testcase;

import com.google.common.collect.Maps;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.api.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestUser {
    static User user;
    static int department_id = 1;
    static String userid = "18800001111";
    static String userName = "18800001111";

    @BeforeAll
    public static void beforClass() {
        user = new User();
        String getUserID = user.list(department_id).
                then().extract().body().path("userlist.find{d -> d.name == '" + userName + "'}.userid");
        userid = getUserID == null ? userid : getUserID;
        System.out.println("---------" + userid);
    }

    @Test
    public void get() {
        user.get(userid).then().body("userid", equalTo(userid));
    }

    @Test
    public void update() {
        String updateName = "UpdateName" + System.currentTimeMillis();
        String updateAddress = "updateAddress11" + System.currentTimeMillis();
        HashMap<String, Object> data = Maps.newHashMap();
        data.put("name", updateName);
        data.put("address", updateAddress);
        user.update(userid, data);
        user.get(userid).then().body("name", equalTo(updateName));
    }

    @Test
    public void create() {
        String userid = "userid_" + System.currentTimeMillis();
        String name = "name_" + System.currentTimeMillis();
        int[] department = new int[]{1,2};

        HashMap<String, Object> map = Maps.newHashMap();
        map.put("name", name);
        map.put("department", department);
        map.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));
        user.create(userid, map).then().body("errcode", equalTo(0));
        user.get(userid).then().body("name", equalTo(name));
    }


    @Test
    public void cloneUser(){
        String userid = "userid_" + System.currentTimeMillis();
        String name = "name_" + System.currentTimeMillis();

        HashMap<String, Object> map = Maps.newHashMap();
        map.put("name", name);
        map.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));
        user.clone(userid, map).then().body("errcode", equalTo(0));
        user.get(userid).then().body("name", equalTo(name));
    }
}