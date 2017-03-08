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

    //Implement a rotate(Shape) method in Shapes.java, such that it checks to see if it is rotating a Circle (and, if so, doesn’t perform the operation).
    private static Boolean rotate(Shape shape){
            if(shape instanceof  Circle)return true;
            return false;
    }
    public static void main(String[] args){
        List<Shape> shapeList = Arrays.asList(new Circle(), new square(), new Triangle());
        for(Shape shape:shapeList){
            shape.draw();
        }
        // Add Rhomboid to Shapes.java. Create a Rhomboid, upcast it to a Shape, then downcast it back to a Rhomboid. Try downcasting to a Circle and see what happens.
        Shape shape=new Rhomboid();
        try {
            Rhomboid rhomboid= (Rhomboid) shape;
            Circle circle= (Circle) shape;
        } catch (ClassCastException e) {
            logger.error(e.toString());
        }
        //Modify the previous exercise so that it uses instanceof to check the type before performing the downcast.
        if(shape instanceof Rhomboid){
            System.out.println("shape can downcast to Rhomboid! ");
            Rhomboid rhomboid = (Rhomboid) shape;
        }else {
            System.out.println("shape can not downcast to Rhomboid!");
        }
        if(shape instanceof Circle){
            System.out.println("shape can downcast to circle! ");
            Circle circle = (Circle) shape;
        }else {
            System.out.println("shape can not downcast to circle!");
        }
        //Implement a rotate(Shape) method in Shapes.java, such that it checks to see if it is rotating a Circle (and, if so, doesn’t perform the operation).
        if(rotate(shape)){
            System.out.println("shape can downcast to circle! ");
            Circle circle = (Circle) shape;
        }else{
            System.out.println("shape can not downcast to circle!");
        }
        //Modify Shapes.java so that it can "highlight" (set a flag in) all shapes of a particular type. The toString( ) method for each derived Shape should indicate whether that Shape is "highlighted."

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
class Rhomboid extends Shape{

    @Override
    public String toString() {
        return "Rhomboid";
    }
}