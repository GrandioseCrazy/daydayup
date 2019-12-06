package leetCode;


import javax.xml.soap.Text;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author:pengpeng
 * @Description:
 * @Date: Create in 11:23 2019/11/24 0024
 * @Others:
 * @Version:1.0
 **/
public class TTTTT {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<Person> personClass = Person.class;
        Method get = personClass.getDeclaredMethod("get", null);
        Field address = personClass.getDeclaredField("address");
        address.setAccessible(true);
        System.out.println(address.getName());
        Person person = personClass.newInstance();
        address.set(person,"aaaa");
        System.out.println(address.get(person));

//        System.out.println(address.getName());
        get.setAccessible(true);
        Object invoke = get.invoke(personClass.newInstance());

        System.out.println((int)invoke);


    }


    public static int minTimeToVisitAllPoints(int[][] arr) {

        if (arr.length <= 1) {
            return 0;
        }
        int count = 0;
        for (int i= 1; i < arr[0].length; i++) {
            count += Math.max(Math.abs(arr[i][0]-arr[i-1][0]),Math.abs(arr[i][1]-arr[i - 1][1]));
        }
        return count;

    }

    public void  say() {
        System.out.println("hello");
    }
}
