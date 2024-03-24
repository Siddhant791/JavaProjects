package com.siddhant.drive.designPattern.creational.factory;

public class Square extends Shape {

    private double side;

    public Square(double side){
        this.side=side;
    }

    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public double getParameter() {
        return 4*side;
    }

    @Override
    public String toString() {
        return "This is square";
    }
}
