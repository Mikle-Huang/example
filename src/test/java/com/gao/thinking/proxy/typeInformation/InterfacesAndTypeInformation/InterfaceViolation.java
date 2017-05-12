package com.gao.thinking.proxy.typeInformation.InterfacesAndTypeInformation;

import com.gao.thinking.proxy.typeInformation.InterfacesAndTypeInformation.interfacea.A;

/**
 * interface A implementation type
 *
 * @Author »Æ²ý»À
 * @Date 2017-05-12  0:17
 */
class B implements A {
    @Override
    public void f() {
        System.out.println("method : f()");
    }

    public void g(){
        System.out.println("method : g()");
    }
}

public class InterfaceViolation{
    public static void main(String[] args){
        A a=new B();
        a.f();
        System.out.println(a.getClass().getName());
        if(a instanceof B){
            B b=(B)a;
            b.g();
            System.out.println("a instanceof B is true!");
        }
    }
}

