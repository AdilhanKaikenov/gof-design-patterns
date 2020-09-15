import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyExample_01 {
    public static void main(String[] args) {

        InvocationHandler invocationHandler = new ReaderInvocationHandler();
        Object proxyInstance = Proxy.newProxyInstance(ProxyExample_01.class.getClassLoader(), new Class[] {Reader.class}, invocationHandler);

        String result = (((Reader) proxyInstance)).read("Hello Proxy!");
        System.out.println(result);
    }
}

interface Reader {
    String read(String str);
}

class MyReader implements Reader {

    @Override
    public String read(String str) {
        return str;
    }
}

class ReaderInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Object arg : args) {
            System.out.println("Argument: " + arg);
        }

        final Object result = method.invoke(new MyReader(), args);
        System.out.println("Result: " + result);
        
        return result;
    }
}