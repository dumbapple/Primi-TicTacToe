package test;

import model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositionTest {
    Position position;

    @BeforeEach
    public void setup() {
        position = new Position("name");
    }

    @Test
    public void testConstructor() {
        assertTrue(position.isFilled() == false);
        assertEquals("name", position.getName());
        assertTrue(position.getOccupiedShape() == null);
    }
}
