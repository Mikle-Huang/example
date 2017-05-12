package com.gao.thinking.proxy.typeInformation.InterfacesAndTypeInformation;

/**
 * interface A implementation type
 *
 * @Author »Æ²ý»À
 * @Date 2017-05-12  0:17
 */
public class B implements A{

    @Override
    public void f() {
        System.out.println("method : f()");
    }

    public void g(){
        System.out.println("method : g()");
    }
}

class C implements A{

    @Override
    public void f() {
        System.out.println("i am C");
    }
}

class InterfaceViolation{
    public static void main(String[] args){
        A a=new B();
        a.f();
        System.out.println(a.getClass().getName());
        if(a instanceof B){
            B b=(B)a;
            b.g();
            System.out.println("a instanceof B is true!");
        }
        if(a instanceof C){
            System.out.println("a instanceof C is true!");
        }
    }
}

