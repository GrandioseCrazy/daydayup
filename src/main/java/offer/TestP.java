package offer;

import java.lang.reflect.Proxy;

public class TestP {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Pengd o = (Pengd)Proxy.newProxyInstance(Pengd.class.getClassLoader(),new Class<?>[] { Pengd.class },
                new PengInvokeHander());
       o.hello();
       o.say();
    }
}
