package com.siddhant.drive.designPattern.creational.factory;

public class Rectange extends Shape{

    private double length;
    private double breadth;

    public Rectange(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double getParameter(){
        return 2*(length + breadth);
    }
    @Override
    public double getArea(){
        return length*breadth;
    }

    @Override
    public String toString(){
        return "This is rectangle";
    }
}