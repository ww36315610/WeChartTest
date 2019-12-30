package services.testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.Work;
import services.api.Department;

import static org.hamcrest.Matchers.equalTo;

public class TestDepartment {
    static String token;
    static Work work;
    static int parentDepartId=5;
    Department department = new Department();
    @BeforeAll
    public static void beforeAll(){
        work = Work.getInstance();
        token = work.getToken();
    }

    @Test
    public void list(){
        department.list(parentDepartId).then().body("errmsg",equalTo("ok"));
    }

    @Test
    public void create(){}

    @Test
    public void delete(){}

    @Test
    public void update(){}
}
