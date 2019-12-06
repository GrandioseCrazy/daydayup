package leetCode;

public class Person {
    String name;
    int age;
    private String address = "123";
    public static void say(){
        System.out.println("hello");
    }
    private static void speak(){
        System.out.println("hello");
    }
    private  int get() {
        System.out.println("get");
        return 1;
    }
}
