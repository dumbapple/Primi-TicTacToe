package test;

import model.Player;
import model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    Player player;

    @BeforeEach
    public void setup() {
        player = new Player();
    }

    @Test
    public void testConstructor() {
        assertTrue(player.getSelectedShape() == null);
        assertTrue(player.getWinnerStatus() == false);
        assertTrue(player.getPositionsCovered().isEmpty());
    }

    @Test
    public void testAddPositionCovered() {
        Position positionA = new Position("A");
        Position positionB = new Position("B");
        player.addPositionCovered(positionA);
        assertEquals(1, player.getPositionsCovered().size());
        player.addPositionCovered(positionA);
        assertEquals(1, player.getPositionsCovered().size());
        player.addPositionCovered(positionB);
        assertEquals(2, player.getPositionsCovered().size());
    }
}
