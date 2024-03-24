package com.siddhant.drive.designPattern.creational.factory;

public class ShapeFactory {

    public static Shape getShape(String type, double length, double breadth){
        if ("rectangle".equalsIgnoreCase(type)){
            return new Rectange(length,breadth);
        } else if ("Square".equalsIgnoreCase(type)) {
            return new Square(length);
        }else{
            throw new RuntimeException("Invalid Shape");
        }
    }
}
