package leetCode;

import java.util.concurrent.Semaphore;

public class Test extends TTTTT {


    public static void main(String[] args)  {
     Test t = new Test();
        try {
            t.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getClass().getSuperclass().getName());
    }
}
