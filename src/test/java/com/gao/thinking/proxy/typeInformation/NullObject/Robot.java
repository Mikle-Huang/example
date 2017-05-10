package com.gao.thinking.proxy.typeInformation.NullObject;

import com.gao.thinking.proxy.util.Null;

import java.util.List;

/**
 * robot interface
 *
 * @Author 黄昌焕
 * @Date 2017-05-08  14:49
 */
public interface Robot {
    String name();

    String model();

    List<Operation> operations();

    class Test{
        public static void test(Robot r){
            if(r instanceof Null){
                System.out.println("[Null Robot]");
            }
            System.out.println("Robot name: "+r.name());
            System.out.println("Robot model: "+r.model());
            for(Operation operation:r.operations()){
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}
