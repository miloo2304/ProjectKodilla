package com.kodilla.exception.Project_6_4;

class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public String getShapeName() {
        return "square";
    }

    @Override
    public double getField() {
        return side * side;
    }
}