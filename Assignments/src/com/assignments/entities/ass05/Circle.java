package com.assignments.entities.ass05;

public class Circle {
    private static final double PI = 3.14159265359;
    private double circleRadius;
    private double circleArea;


    public Circle() {
        this.circleRadius = 0;
        this.circleArea = 0;
    }

    public Circle(double circleRadius, double circleArea) {
        this.circleRadius = circleRadius;
        this.circleArea = circleArea;
    }

    public double getCircleRadius() {
        return circleRadius;
    }

    public void setCircleRadius(double circleRadius) {
        this.circleRadius = circleRadius;
    }

    public void setCircleArea(double circleArea) {
        this.circleArea = circleArea;
    }

    public double getCircleArea() {
        return circleArea;
    }

    void calculateCircleArea()
    {
        this.circleArea = 2 * PI * this.circleRadius * this.circleRadius;
    }
}
