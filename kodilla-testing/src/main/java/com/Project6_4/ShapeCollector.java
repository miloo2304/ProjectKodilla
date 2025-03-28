package com.Project6_4;
import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    public Shape getShape(int index) {
        if (index >= 0 && index < shapes.size()) {
            return shapes.get(index);
        }
        return null;
    }

    public String getAllShapeNames() {
        StringBuilder names = new StringBuilder();
        for (Shape shape : shapes) {
            names.append(shape.getName()).append(" ");
        }
        return names.toString().trim();
    }
}
