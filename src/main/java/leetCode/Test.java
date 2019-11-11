package leetCode;

import java.util.concurrent.Semaphore;

public class Test {


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore.release();
    }
}
