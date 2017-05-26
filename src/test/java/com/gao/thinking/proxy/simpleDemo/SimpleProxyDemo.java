package com.gao.thinking.proxy.simpleDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 简单的静态代理
 *
 * @author  huangchanghuan
 */
public class SimpleProxyDemo {
    private final static Logger logger = LoggerFactory.getLogger(SimpleProxyDemo.class);

    private static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse();
    }

    public static void main(String[] args) {//测试
        logger.error("测试");
        //不用代理
        consumer(new RealObject());
        //使用代理
        consumer(new SimpleProxy(new RealObject()));
    }
}
//接口
interface Interface{
    void doSomething();

    void somethingElse();

    void doMoreThing();
}
//被代理类(委托类)
class RealObject implements Interface{

    public void doSomething() {
        System.out.println("RealObject doSomething");
    }

    public void somethingElse() {
        System.out.println("RealObject somethingElse");
    }

    @Override
    public void doMoreThing() {
        System.out.println("RealObject doMoreThing");
    }
}
//代理类
class SimpleProxy implements Interface{
    private Interface proxy;
    SimpleProxy(Interface proxy){
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

    @Override
    public void doMoreThing() {

    }
}
