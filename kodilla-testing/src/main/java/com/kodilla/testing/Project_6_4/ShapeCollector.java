package com.kodilla.testing.Project_6_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

        public class ShapeCollector {
            private List<Shape> shapes = new ArrayList<>();

            public void addFigure(Shape shape) {
                shapes.add(shape);
            }

            public boolean removeFigure(Shape shape) {
                return shapes.remove(shape);
            }

            public Shape getFigure(int n) {
                if (n >= 0 && n < shapes.size()) {
                    return shapes.get(n);
                }
                return null;
            }

            public List<Shape> getShapes() {
                return shapes;
            }

            public String showFigures() {
                StringBuilder figures = new StringBuilder();
                for (Shape shape : shapes) {
                    figures.append(shape.getShapeName()).append(", ");
                }
                return figures.toString().trim();
            }
        }