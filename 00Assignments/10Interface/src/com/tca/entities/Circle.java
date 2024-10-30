package com.tca.entities;

public class Circle implements Shape{
    private static final double PI = 3.14;
    private double radius;

    public Circle() {
        this.radius = 0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return  PI * this.radius * this.radius;
    }


    @Override
    public void area() {
        System.out.println("Area of Circle : " + this.getArea());
    }
}
