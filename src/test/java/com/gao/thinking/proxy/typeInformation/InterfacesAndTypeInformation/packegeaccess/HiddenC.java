package com.gao.thinking.proxy.typeInformation.InterfacesAndTypeInformation.packegeaccess;

import com.gao.thinking.proxy.typeInformation.InterfacesAndTypeInformation.interfacea.A;

/**
 * @Author 黄昌焕
 * @Date 2017-05-12  12:45
 */
public class HiddenC {
    public static A makeA(){
        return new C();
    }
}

class C implements A {

    @Override
    public void f() {
        System.out.println(" public C.f()");
    }
    public void g(){
        System.out.println("public C.g()");
    }
    void u(){
        System.out.println("public C.u()");
    }
    protected void v(){
        System.out.println("protected C.v()");
    }
    private void w(){
        System.out.println("private C.w()");
    }
}