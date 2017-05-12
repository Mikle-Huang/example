package com.gao.thinking.proxy.typeInformation.InterfacesAndTypeInformation;

import com.gao.thinking.proxy.typeInformation.InterfacesAndTypeInformation.interfacea.A;

import java.lang.reflect.InvocationTargetException;

/**
 * the interface as a private inner class
 * @Author 黄昌焕
 * @Date 2017-05-12  13:33
 */
public class InnerImplementation {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        A a = InnerA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        HiddenImplementation.callHiddenMethod(a,"g");
        HiddenImplementation.callHiddenMethod(a,"u");
        HiddenImplementation.callHiddenMethod(a,"v");
        HiddenImplementation.callHiddenMethod(a,"w");
    }
}

class InnerA{
    private static class C implements A {//private inner class
        @Override
        public void f() {
            System.out.println("public C.f()");
        }
        public void g(){
            System.out.println("public C.g()");
        }
        void u(){
            System.out.println("package C.u()");
        }
        protected void v(){
            System.out.println("protected C.v()");
        }
        private void w(){
            System.out.println("private C.w()");
        }
    }
    public static A makeA(){
        return new C();
    }
}
