package com.gao.thinking.proxy.simpleDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 一个简单的代理例子
 *
 * @Author 黄昌焕
 * @Date 2016-12-19  16:16
 */
public class SimpleProxyDemo {
    private final static Logger logger = LoggerFactory.getLogger(SimpleProxyDemo.class);
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse();
    }

    public static void main(String[] args) {
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
}
//目标对象
class RealObject implements Interface{

    public void doSomething() {
        System.out.println("RealObject doSomething");
    }

    public void somethingElse() {
        System.out.println("RealObject somethingElse");
    }
}
//简单代理对象
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
