package services.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import services.Work;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class User {

    /**
     * 获取用户
     * @param userid
     * @return
     */
    public Response get(String userid) {
        return given()
                    .param("access_token", Work.getInstance().getToken())
                    .param("userid", userid)
                .when().log().all()
                    .get("https://qyapi.weixin.qq.com/cgi-bin/user/get")
                .then().log().all()
                    .body("errcode", equalTo(0))
                .extract().response();
    }

    /**
     * 获取部门用户列表
     * @param department_id
     * @return
     */
    public Response list(int department_id) {
        return given()
                .param("access_token", Work.getInstance().getToken())
                .param("department_id", department_id)
                .when().log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/user/list")
                .then().log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }

    /**
     * 创建用户
     * TODO：数据驱动，模版技术
     * @param map
     * @return
     */
    public Response create(HashMap<String,Object> map){
        map.put("userid","ww"+System.currentTimeMillis());
        map.put("name","");
        map.put("department","");
        Response response =
                given()
                        .queryParam("access_token", Work.getInstance().getToken()) //post 发送个别参数
                        .contentType(ContentType.JSON)
                        .body(map)
                .when().log().all()
                    .post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
                .then().log().all()
                    .body("errcode",equalTo(0))
                .extract().response();
        return response;
    }

    /**
     * 更新用户
     * @param userid
     * @param map
     * @return
     */
    public Response update(String userid,HashMap<String,Object> map){
        map.put("userid",userid);
        map.put("name","update"+System.currentTimeMillis());
        Response response =
                given()
                    .queryParam("access_token",Work.getInstance().getToken())
                    .contentType(ContentType.JSON)
                    .body(map)
                .when().log().all()
                    .post("https://qyapi.weixin.qq.com/cgi-bin/user/update")
                .then().log().all()
                    .body("errcode",equalTo(0))
                .extract().response();
        return response;
    }

    /**
     * 删除用户
     * @param userid
     * @return
     */
    public Response delete(String userid){
        Response response =
                given()
                    .param("access_token",Work.getInstance().getToken())
                    .param("userid",userid)
                .when().log().all()
                    .get("https://qyapi.weixin.qq.com/cgi-bin/user/delete")
                .then().log().all()
                        .body("errcode",equalTo(0))
                .extract().response();
        return response;
    }
}
