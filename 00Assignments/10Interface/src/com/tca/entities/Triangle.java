package com.tca.entities;

public class Triangle implements Shape{

    private double height;
    private double base;

    public Triangle() {
        this.height = 0;
        this.base = 0;
    }

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }


    private double getArea(){
        return (this.height * this.base) / 2;
    }

    @Override
    public void area() {
        System.out.println("Area of Triangle : " + this.getArea());
    }
}
