package com.gao.thinking.proxy.typeInformation.NullObject;

import java.util.Arrays;
import java.util.List;

/**
 * removing snow robot
 *
 * @Author 黄昌焕
 * @Date 2017-05-08  15:01
 */
public class SnowRemovalRobot implements Robot{
    private String name;
    public SnowRemovalRobot(String name){
        this.name = name;
    }
    public String name() {
        return name;
    }

    public String model() {
        return "SnowBot Series 11";
    }

    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                    public String description() {
                        return name + " can shovel snow";
                    }

                    public void command() {
                        System.out.println(name + " shoveling snow");
                    }
                },
                new Operation() {

                    public String description() {
                        return name + "can chip ice";
                    }

                    public void command() {
                        System.out.println(name + "chipping ice");
                    }
                },
                new Operation() {
                    public String description() {
                        return name+" can clear the roof";
                    }

                    public void command() {
                        System.out.println(name+" clearing roof");
                    }
                }
        );
    }

    public static void main(String[] args){
        Robot.Test.test(new SnowRemovalRobot("Slusher"));
    }
}
