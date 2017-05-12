package com.gao.thinking.proxy.typeInformation.InterfacesAndTypeInformation;

import java.lang.reflect.Field;

/**
 * access fields,even private field
 * @Author 黄昌焕
 * @Date 2017-05-12  13:56
 */
public class modifyingPrivateFields {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);
        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        System.out.println("f.getInt(pf):"+f.getInt(pf));
        f.setInt(pf,47);
        System.out.println(pf);
        f = pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        System.out.println("f.get(pf)"+f.get(pf));
        f.set(pf,"No you are not!");
        System.out.println(pf);
        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        System.out.println("f.get(pf)"+f.get(pf));
        f.set(pf,"No,you are not !");
        System.out.println(pf);
    }
}

class WithPrivateFinalField{
    private int i=1;
    private final String s = "i am totally safe";
    private String s2 = "am i safe";
    public String toString(){
        return "i= " + i + "," + s + "," + s2;
    }
}
