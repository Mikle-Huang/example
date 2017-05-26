package com.gao.thinking.proxy.simpleDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK只支持对接口的动态代理
 *JDK动态代理的要素:
 * (1).实现了InvocationHandler的代理处理类,实现invoke方法,该方法是代理调用目标对象方法及提供额外操作的方法
 * (2).使用Proxy.newProxyInstance(类加载器,代理接口列表,InvocationHandler对象);方法,创建实现了指定接口的动态代理
 *
 * @author  黄昌焕
 */
public class JDKSimpleProxyDemo {
    private static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse();
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        //不是用代理
        consumer(real);
        //使用代理
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
/**
 *代理处理类
 */
class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;
    DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }
    //动态代理调用目标对象的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic proxy handler==执行方法前");
        Object obj= method.invoke(proxied,args);
        System.out.println("dynamic proxy handler==执行方法后");
        return obj;
    }
}