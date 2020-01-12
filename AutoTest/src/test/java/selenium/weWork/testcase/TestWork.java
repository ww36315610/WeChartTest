package selenium.weWork.testcase;

import org.junit.*;
import selenium.weWork.page.APP;

public class TestWork extends BasicTest {

    @Test
    public void testAdd() {
        String phone = "18711181119";
        app.toMemberAdd().add(phone, phone, phone);
    }

    @Test
    public void testDelete() throws Exception{
        String phone = "18800001112";
        app.toMemberAdd().add(phone, phone, phone);
                Thread.sleep(2000);
        app.toMemberAdd().delete(phone);
    }
}
