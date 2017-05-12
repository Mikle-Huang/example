package com.gao.thinking.proxy.typeInformation.checkingBeforeACast;

import java.util.Calendar;
import java.util.Date;

/**
 * person
 *
 * @Author »Æ²ý»À
 * @Date 2017-04-14  22:22
 */
public class Cat extends Pet{
    public Cat(String name){
        super(name);
    }
    public Cat(){
        super();
    }

    public static void main(String[] args){
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
        assert (1>2);
        Calendar calendar= Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.add(Calendar.DATE,-1);
        System.out.println(calendar.getTime());
        System.out.println(new Date());

    }
}
