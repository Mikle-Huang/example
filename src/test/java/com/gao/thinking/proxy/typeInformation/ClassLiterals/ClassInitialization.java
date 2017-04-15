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
    public static void main (String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class initable=Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);//final and compile time already
        System.out.println(Initable.staticFinal2);//run time
        System.out.println(Initable2.staticNonFinal);//not final ,so compile time do not being setted
        Class initable3 = Class.forName("com.gao.thinking.proxy.typeInformation.ClassLiterals.Initable3");
        System.out.println("After creating Initable3 ref");
        initable3.newInstance();
        System.out.println(Initable3.staticNonFinal);


        //test
        Class<?> newClass=int.class;

    }
}


class Initable{
    static final int staticFinal=47;
    static final int staticFinal2=ClassInitialization.rand.nextInt(1000);
    static{
        System.out.println("Initializing Initable");
    }
    public Initable(){
        System.out.println("construct Initable");
    }
}

class Initable2{
    static int staticNonFinal=147;
    static {
        System.out.println("Initializing initable2");
    }
    public Initable2(){
        System.out.println("construct Initable2");
    }
}

class Initable3{
    static int staticNonFinal=74;
    static{
        System.out.println("Initializing Initables3");
    }
    public Initable3(){
        System.out.println("construct Initable3");
    }
}