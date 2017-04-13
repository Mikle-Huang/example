package com.gao.thinking.proxy.typeInformation.theClassObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class has many interesting methods , here are a few of them
 *
 * @author  黄昌焕
 */
public class ToyTest {
    private final static Logger logger = LoggerFactory.getLogger(ToyTest.class);

    public static void main(String[] args) {
        Class c=null;
        logger.info("test");
        try {
            c = Class.forName("com.gao.thinking.proxy.typeInformation.theClassObject.fancytoy");
        } catch (Exception e) {
            logger.error("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for(Class face:c.getInterfaces())printInfo(face);
        Class up=c.getSuperclass();
        Object obj=null;
        try {
            //Requires default constructor
            obj=up.newInstance();
        } catch (InstantiationException e) {
            logger.error("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            logger.error("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }

    private static void printInfo(Class cc){
        System.out.println("===Class name: "+cc.getName());
        System.out.println("is interface ?["+cc.isInterface()+"]");
        System.out.println("Simple name: "+cc.getSimpleName());
        System.out.println("Canonical name: "+cc.getCanonicalName());
    }
}

interface HasBatteries{}
interface WaterProof{}
interface Shoots{}

class Toy{
    //comment out  the following default constructor
    //to see the Exception
    private Toy(){}
    Toy(int i){}
}

class FancyToy  extends Toy implements HasBatteries,WaterProof,Shoots{
    FancyToy(){super(1);}
}