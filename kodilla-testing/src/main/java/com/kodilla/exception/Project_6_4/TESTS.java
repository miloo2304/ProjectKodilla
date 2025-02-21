package com.kodilla.exception.Project_6_4;
import org.junit.jupiter.api.*;

public class TESTS {

    class ShapeCollectorTest {
        private ShapeCollector shapeCollector;
        private Shape circle;
        private Shape square;
        private Shape triangle;

        @BeforeEach
        void setUp() {
            shapeCollector = new ShapeCollector();
            circle = new Circle(5);
            square = new Square(4);
            triangle = new Triangle(3, 6);
        }
        @AfterEach
        void setDown() {
            shapeCollector = null;
            circle = null;
            square = null;
            triangle = null;
            System.out.println("TESTS COMPLETE");
        }
        @Test
        @DisplayName("Test method addFigure")
        void testAddFigure() {
            // When
            shapeCollector.addFigure(circle);

            // Then
            Assertions.assertEquals(1, shapeCollector.getShapes().size());
            Assertions.assertEquals("circle", shapeCollector.getShapes().get(0).getShapeName(),"The result should be circle");
        }

        @Test
        @DisplayName("Test method removeFigure")
        void testRemoveFigure() {
            // Given
            shapeCollector.addFigure(square);

            // When
            boolean result = shapeCollector.removeFigure(square);

            // Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapes().size(), "The result should be empty");
        }
        @Test
        @DisplayName("Test method addFigure_v2")
        void testAddFigures() {
            // When
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);

            // Then
            Assertions.assertEquals(3, shapeCollector.getShapes().size());
            Assertions.assertEquals("circle", shapeCollector.getShapes().get(0).getShapeName());
            Assertions.assertEquals("square", shapeCollector.getShapes().get(1).getShapeName());
            Assertions.assertEquals("triangle", shapeCollector.getShapes().get(2).getShapeName(), "The result should be: circle, square, triangle");
        }
        @Test
        @DisplayName("Test method removeFigures")
        void testRemoveFigures() {
            // Given
            shapeCollector.addFigure(square);
           shapeCollector.addFigure(circle);
           shapeCollector.addFigure(triangle);

            // When
            boolean result2 = shapeCollector.removeFigure(triangle);
            boolean result = shapeCollector.removeFigure(square);
            boolean result1= shapeCollector.removeFigure(circle);

            // Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapes().size(),"The result should be an empty list");
        }
        @Test
        @DisplayName("Test getFigure")
        void testGetFigure() {
            // Given
            shapeCollector.addFigure(triangle);

            // When
            Shape retrievedShape = shapeCollector.getFigure(0);

            // Then
            Assertions.assertNotNull(retrievedShape);
            Assertions.assertEquals("triangle", retrievedShape.getShapeName(), "The result should be triangle");
        }

        @Test
        @DisplayName("Test getFigureOutOfBounds")
        void testGetFigureOutOfBounds() {
            // When
            Shape retrievedShape = shapeCollector.getFigure(0);

            // Then
            Assertions.assertNull(retrievedShape, "The result should be null");
        }

        @Test
        @DisplayName("Test showFigures")
        void testShowFigures() {
            // Given
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);

            // When
            String result = shapeCollector.showFigures();

            // Then
            Assertions.assertTrue(result.contains("circle"));
            Assertions.assertTrue(result.contains("square"));
            Assertions.assertTrue(result.contains("triangle"));
        }
    }
}
