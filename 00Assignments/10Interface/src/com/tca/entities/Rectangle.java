package com.tca.entities;

public class Rectangle implements Shape{
    private double length;
    private double width;

    public Rectangle() {
        this.length = 0;
        this.width = 0;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    private double getArea(){
        return this.length * this.width;
    }


    @Override
    public void area() {
        System.out.println("Area of Rectangle : " + this.getArea());
    }
}
