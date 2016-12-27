package com.gao.thinking.proxy.typeInformation.needOfRTTI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * 多态性(这种多态性很重要)
 *运行的时候才确定具体的对象,
 * @Author 黄昌焕
 * @Date 2016-12-20  00:25
 */
public class Shapes {
    private final static Logger logger = LoggerFactory.getLogger(Shapes.class);
    public static void main(String[] args){
        List<Shape> shapeList = Arrays.asList(new Circle(), new square(), new Triangle());
        for(Shape shape:shapeList){
            shape.draw();
        }
    }
}
//abstract class
abstract class Shape{
    void draw(){
        System.out.println(this + ".draw");
    }
    abstract public String toString ();
}
//derived class
class Circle extends Shape{
    @Override
    public String toString() {
        return "Circle";
    }
}
class square extends Shape{
    @Override
    public String toString() {
        return "square";
    }
}
class Triangle extends Shape{
    @Override
    public String toString() {
        return "Triangle";
    }
}