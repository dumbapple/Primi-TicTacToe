package test;

import model.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShapeTest {

    Shape shape;

    @BeforeEach
    public void setup() {
        shape = new Shape();
    }

    @Test
    public void testConstructor() {
        assertTrue(shape.getAssociatedPlayer() == null);
        assertTrue(shape.getSpotsOccupied().isEmpty());
    }


}
