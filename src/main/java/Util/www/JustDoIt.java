package Util.www;


import java.lang.reflect.Field;
import java.util.concurrent.Executors;

public class JustDoIt {
    @DoubleP(name = "1")
    String name;


    public static void main(String[] args) throws Exception {

//        System.out.println(DoubleP.class.isAnnotation());
        System.out.println(JustDoIt.class.isInstance(new Object()));

//        Class<JustDoIt> justDoItClass = JustDoIt.class;
//        JustDoIt justDoIt = justDoItClass.newInstance();
//        Field filed = justDoItClass.getDeclaredField("name");
//        DoubleP annotation = filed.getAnnotation(DoubleP.class);
//        String name = annotation.name();
//        filed.set(justDoIt,name);
//        System.out.println(justDoIt.name);
    }

}
