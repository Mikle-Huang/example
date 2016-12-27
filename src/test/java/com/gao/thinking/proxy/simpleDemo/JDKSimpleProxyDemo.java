package com.gao.thinking.proxy.simpleDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK只支持对接口的动态代理
 *JDK动态代理的要素:
 * (1).实现了InvocationHandler的代理处理类,实现invoke方法,该方法是代理调用目标对象方法及提供额外操作的方法
 * (2).使用Proxy.newProxyInstance(类加载器,代理接口列表,InvocationHandler对象);方法,创建实现了指定接口的动态代理
 *
 * @Author 黄昌焕
 * @Date 2016-12-19  17:31
 */
public class JDKSimpleProxyDemo {
    private final static Logger logger = LoggerFactory.getLogger(JDKSimpleProxyDemo.class);
    public static void consumer(Interface iface){
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
    public DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }
    //动态代理调用目标对象的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic proxy handler");
        return method.invoke(proxied,args);
    }
}