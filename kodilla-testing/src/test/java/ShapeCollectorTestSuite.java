import com.Project6_4.ShapeCollector;
import com.Project6_4.Shape;
import com.Project6_4.Circle;
import com.Project6_4.Rectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("Test of adding shapes")
    class AddShapeTests {
        @Test
        @DisplayName("Testing method addShape()")
        void shouldAddShapeToCollection() {
            ShapeCollector collector = new ShapeCollector();
            Shape shape = new Circle(5);
            collector.addShape(shape);

            assertEquals(shape, collector.getShape(0));
        }
    }

    @Nested
    @DisplayName("Test of delete shape")
    class RemoveShapeTests {
        @Test
        @DisplayName("Test of method addShape() and remove shape()")
        void shouldRemoveShapeFromCollection() {
            ShapeCollector collector = new ShapeCollector();
            Shape shape = new Rectangle(4, 6);
            collector.addShape(shape);
            collector.removeShape(shape);

            assertNull(collector.getShape(0));
        }
    }


    @Nested
    @DisplayName("Testy of names of shapes")
    class GetAllShapeNamesTests {
        @Test
        @DisplayName("Testing method getALlShapeNames()")
        void shouldReturnAllShapeNames() {
            ShapeCollector collector = new ShapeCollector();
            collector.addShape(new Circle(3));
            collector.addShape(new Rectangle(4, 6));

            assertEquals("Circle Rectangle", collector.getAllShapeNames());
        }

        @Test
        @DisplayName("Checking of return empty string from collection")
        void shouldReturnEmptyStringForEmptyCollection() {
            ShapeCollector collector = new ShapeCollector();
            assertEquals("", collector.getAllShapeNames());
        }
    }
    @Nested
    @DisplayName("Test of area")
    class GetAreaTests {
        @Test
        @DisplayName("Checking method getArea() for Circle")
        void shouldCalculateCircleArea() {
            Shape shape = new Circle(3);
            assertEquals(Math.PI * 9, shape.getArea(), 0.0001);
        }

        @Test
        @DisplayName("Checking method getArea() for Rectangle")
        void shouldCalculateRectangleArea() {
            Shape shape = new Rectangle(4, 6);
            assertEquals(24, shape.getArea());
        }
    }
}

