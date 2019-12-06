package offer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PengInvokeHander implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("你好！");
        return null;
    }
}
