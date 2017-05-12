package com.gao.thinking.proxy.typeInformation.InterfacesAndTypeInformation;

import com.gao.thinking.proxy.typeInformation.InterfacesAndTypeInformation.interfacea.A;
import com.gao.thinking.proxy.typeInformation.InterfacesAndTypeInformation.packegeaccess.HiddenC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author 黄昌焕
 * @Date 2017-05-12  12:48
 */
public class HiddenImplementation {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        A a= HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        callHiddenMethod(a, "u");
        callHiddenMethod(a,"v");
        callHiddenMethod(a,"w");
    }
    static void callHiddenMethod(Object a,String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
