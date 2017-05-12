package com.gao.thinking.proxy.typeInformation.NullObject;

import com.gao.thinking.proxy.util.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 * @Author 黄昌焕
 * @Date 2017-05-08  17:07
 */
public class NullRobot {
    public static Robot newNullRobot(Class<? extends Robot> type){
        return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(), new Class[]{Null.class, Robot.class}, new NullRobotProxyHandler(type));
    }
    public static void main(String[] args){
        Robot[] bots = {
                new SnowRemovalRobot("SnowBee"), newNullRobot(SnowRemovalRobot.class)
        };
        for(Robot bot:bots){
            Robot.Test.test(bot);
            System.out.println((bot instanceof Null));
        }
    }
}

class NullRobotProxyHandler implements InvocationHandler{
    private String nullName;
    private Robot proxied = new NRoot();
    NullRobotProxyHandler(Class<? extends Robot> type){
        nullName = type.getSimpleName() + "NullRobot";
    }

    private class NRoot implements Null,Robot{

        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied,args);
    }
}