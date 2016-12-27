package com.gao.thinking.proxy.simpleDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDKֻ֧�ֶԽӿڵĶ�̬����
 *JDK��̬�����Ҫ��:
 * (1).ʵ����InvocationHandler�Ĵ�������,ʵ��invoke����,�÷����Ǵ������Ŀ����󷽷����ṩ��������ķ���
 * (2).ʹ��Proxy.newProxyInstance(�������,����ӿ��б�,InvocationHandler����);����,����ʵ����ָ���ӿڵĶ�̬����
 *
 * @Author �Ʋ���
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
        //�����ô���
        consumer(real);
        //ʹ�ô���
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
/**
 *��������
 */
class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;
    public DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }
    //��̬�������Ŀ�����ķ���
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic proxy handler");
        return method.invoke(proxied,args);
    }
}