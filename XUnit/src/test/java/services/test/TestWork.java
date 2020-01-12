package services.test;

import com.google.common.collect.Maps;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.api.BasicAPI;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestWork {

    static String token;
    static int parentDepartId = 5;

    @BeforeAll
    public static void getToken() {
        token =
                given()
                        .param("corpid", "wwe2c3250da5791212")
                        .param("corpsecret", "oE0Sn1Ol822V9jdK3Pzop9N-gFwsqiu2KHB8Oa6ng74")
                .when()
                        .log().all()
                        .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                        .log().all()
                        .body("errcode", equalTo(0))
                .extract()
                        .body().path("access_token");
        System.out.println(token);
    }

    @Test
    public void departCreate() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("name", "部门2");
        map.put("parentid", parentDepartId);

        Response response =
                given()
                        .queryParam("access_token", token) //post 发送个别参数
                        .contentType(ContentType.JSON)
                        .body(map)
                .when()
                        .log().all()
                        .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then()
                        .log().all()
                        .body("errcode", equalTo(0))
                .extract().response();
    }

    @Test
    public void getDepartMents() {
        given()
                .queryParam("access_token", token)
                .queryParam("id", parentDepartId)
        .when()
                .log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
        .then()
                .log().all()
                .body("errcode", equalTo(0));

    }

    public static void main(String[] args) {
        try {
            System.out.println("try111");
            System.out.println(1/0);
            System.out.println("try222");
        }catch (Exception e){
            System.out.println("catch");
            e.printStackTrace();
        }
        System.out.println("---hou---");
        get();
    }

    public static void get(){
        BasicAPI v = new BasicAPI(){};
        v.mm();
    }
}
