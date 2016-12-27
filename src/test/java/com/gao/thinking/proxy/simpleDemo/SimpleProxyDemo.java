package com.gao.thinking.proxy.simpleDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * һ���򵥵Ĵ�������
 *
 * @Author �Ʋ���
 * @Date 2016-12-19  16:16
 */
public class SimpleProxyDemo {
    private final static Logger logger = LoggerFactory.getLogger(SimpleProxyDemo.class);
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse();
    }

    public static void main(String[] args) {
        logger.error("����");
        //���ô���
        consumer(new RealObject());
        //ʹ�ô���
        consumer(new SimpleProxy(new RealObject()));
    }
}
//�ӿ�
interface Interface{
    void doSomething();

    void somethingElse();
}
//Ŀ�����
class RealObject implements Interface{

    public void doSomething() {
        System.out.println("RealObject doSomething");
    }

    public void somethingElse() {
        System.out.println("RealObject somethingElse");
    }
}
//�򵥴������
class SimpleProxy implements Interface{
    private Interface proxy;
    public SimpleProxy(Interface proxy){
        this.proxy=proxy;
    }
    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxy.doSomething();
    }

    @Override
    public void somethingElse() {
        System.out.println("SimpleProxy somethingElse");
        proxy.somethingElse();
    }
}
