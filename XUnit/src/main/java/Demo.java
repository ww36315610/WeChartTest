public class Demo {

    public static void main(String[] args) {
        Test t1 = new Test();
        Demo demo = new Demo();
        t1.setId(1);
        t1.setName("name");
        demo.method1(t1);

    }

    public void method1(Test test1) {
        System.out.println(this.getClass());
        System.out.println(this);
    }
}
