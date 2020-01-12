package services.testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.api.Department;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class TestDepartment {
    static int parentDepartId = 5;
    static Department department = new Department();

    @BeforeAll
    public static void beforeAll() {
        //删除部门parentid = 5的所有子部门、使用 jsonPath 表达式
        /**
         * 删除部门parentid = 5的所有子部门、使用 jsonPath 表达式
         * 1.获取json列表 department：{"parentid":{"id":1},{"id":2}} 下面所有的id
         * 2.遍历删除每个id下的内容
         * 3.语法：then().extract().body().path()
         * 4.定位："department.findAll{d -> d.parentid == " + parentDepartId + "}.id"
         */
        ArrayList<Integer> ids = department.list(parentDepartId).then().extract().body().path("department.findAll{d -> d.parentid == " + parentDepartId + "}.id");
        System.out.println("-------::::" + ids);
        ids.forEach(id -> {
            department.delete(id);
        });
    }

    @Test
    public void list() {
        department.list(parentDepartId).then().body("errmsg", equalTo("ok"));
    }

    /**
     * 创建部门
     * 1.查找包含创建目录name的id
     * 2.删除此id下的部门
     * 3.创建新的目录
     */
    @Test
    public void create() {
        String name = "createMy";
        int id = 0;
        // 使用 jsonPath 表达式 ||删除name = "createMy" 的子部门
        try {
            id = department.list(parentDepartId).then().extract().body().path("department.find{d -> d.name == '" + name + "'}.id");
            department.delete(id);
        }catch (Exception e){
            if (id >0) {
                department.delete(id);
            }
        }
        department.create(name, parentDepartId).then().body("errmsg", equalTo("created"));
        department.list(parentDepartId).then().body("department.findAll{d -> d.name == '" + name + "'}.id", hasSize(1));
    }

    /**
     * 删除部门
     * 1.创建部门
     * 2.删除部门
     */
    @Test
    public void delete() {
        //创建新的部门，并返回部门id
        int id = department.create("部门createBydelete", parentDepartId)
                .then().body("errcode", equalTo(0))
                .extract().path("id");
        System.out.println("-------:::" + id);
        department.delete(id).then().body("errmsg", equalTo("deleted"));
    }

    @Test
    public void update() {
    }

    /**
     * 根据部门name删除
     */


    /**
     * 1.检查是否创建过
     * 2.如果有删除
     * 3.创建
     * 4.断言
     */
    @Test
    public void testCreate(){
        String name="Buser_my";
        int departmentID = 8;
        List<String> names = department.list(departmentID).then().extract().body().path("department.findAll{d -> d.name != ''}.name");
        if(names.size()>0){
            names.forEach(n->{
                System.out.println("list------"+n);
                if(n.equals(name)){

                    department.delete(departmentID);
                }
            });
        }
        department.create(name,departmentID);
    }

    /**
     * 1.父部门id= 8
     * 1.创建部门-B_chirlren2
     * 2.删除部门-B_chirlren2
     */
    @Test
    public void testDelete(){
        int departmentID = 8;
        String partName ="B_chirlren2";
        int newID = department.create(partName,departmentID).then().extract().body().path("id");
        try {
            System.out.println("创建完毕(^_^)");
            Thread.sleep(5000);
            System.out.println("准备删除newID："+newID);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        department.delete(newID);
    }
}
