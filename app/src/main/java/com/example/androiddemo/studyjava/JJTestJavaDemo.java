package com.example.androiddemo.studyjava;

//http://c.biancheng.net/view/5672.html

interface JJTestInterface1 {

    int a = 10;
    String address = "anhui";

    void test();
    String getAddress();
}

public class JJTestJavaDemo implements JJTestInterface1 {

    static double TAG_A = 10; //静态常量

    public static float TAG_B = 10;

    public static final float TAG_C = 10;

    final int TAG_D = 10; //常量

    private String name = "jxf";
    protected Integer age = 19;

    String username,address,phone,tel;    // 声明多个变量
    int num1=12,num2=23,result=35;    // 声明并初始化多个变量


    public static void main(String[] arg) { //java main方法

        final int d = 10;
        TAG_A = 20;
    }

    //构造方法
    JJTestJavaDemo() {
        name = "jxf123";
    }
    JJTestJavaDemo(int a) {
        super();
        name = "jxf123";
    }
    JJTestJavaDemo(int a, int b) {
        name = "jxf123";
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    void test123() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            CloneNotSupportedException {

        Person p = new Person();

        Class c1 = Class.forName("Person");
        Person p2 = (Person) c1.newInstance();

        name = "new jxf";
        // 声明并初始化数组
        int[] numbers = {43, 32, 53, 54, 75, 7, 10};
        System.out.println("----for----");
        // for语句
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Count is:" + numbers[i]);
        }
        // for-each语句
        for (int item : numbers) {
            System.out.println("Count is:" + item);
        }
        int i = 1;
        int n = 1;
        while (i <= 10) {
            n = n * i;
            i++;
        }
        System.out.println("10的阶乘结果为：" + n);
    }

    @Override
    public void test() {

        int a = 10;
        final int b = 10;
        JJTestInterface1 anonyInter = new JJTestInterface1() {

            @Override
            public void test() {

            }

            @Override
            public String getAddress() {
                return "";
            }
        };
        anonyInter.test();
    }

    @Override
    public String getAddress() {
        this.address = "jxf";
        return this.address;
    }
}
