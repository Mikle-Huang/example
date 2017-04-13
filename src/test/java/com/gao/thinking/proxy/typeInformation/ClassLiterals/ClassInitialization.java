package com.gao.thinking.proxy.typeInformation.ClassLiterals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @Author »Æ²ý»À
 * @Date 2017-04-13  6:52
 */
public class ClassInitialization {
    private final static Logger logger = LoggerFactory.getLogger(ClassInitialization.class);
    public static Random rand = new Random(47);
    public static void main (String[] args) throws ClassNotFoundException {
        Class initable=Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("com.gao.thinking.proxy.typeInformation.ClassLiterals.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}


class Initable{
    static final int staticFinal=47;
    static final int staticFinal2=ClassInitialization.rand.nextInt(1000);
    static{
        System.out.println("Initializing Initable");
    }
}

class Initable2{
    static int staticNonFinal=147;
    static {
        System.out.println("Initializing initable2");
    }
}

class Initable3{
    static int staticNonFinal=74;
    static{
        System.out.println("Initializing Initables3");
    }
}