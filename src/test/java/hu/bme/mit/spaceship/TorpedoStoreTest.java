package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    private TorpedoStore store;

    @BeforeEach
    void init() {
        store = new TorpedoStore(10);
    }

    @Test
    void fire_Success() {
        // Arrange
        store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
        assertEquals(0, store.getTorpedoCount());
    }

    @Test
    void fire_Failure_NotEnoughTorpedoes() {
        // Arrange
        store = new TorpedoStore(1);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> store.fire(2));
    }

    @Test
    void fire_Failure_NegativeTorpedoes() {
        // Arrange
        store = new TorpedoStore(1);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> store.fire(-1));
    }

    @Test
    void fire_Success_MultipleTorpedoes() {
        // Arrange
        store = new TorpedoStore(5);

        // Act
        boolean result = store.fire(3);

        // Assert
        assertEquals(true, result);
        assertEquals(2, store.getTorpedoCount());
    }

    @Test
    void isEmpty_True_WhenNoTorpedoes() {
        // Arrange
        store = new TorpedoStore(0);

        // Act
        boolean result = store.isEmpty();

        // Assert
        assertEquals(true, result);
    }

    @Test
    void isEmpty_False_WhenTorpedoesAvailable() {
        // Arrange
        store = new TorpedoStore(1);

        // Act
        boolean result = store.isEmpty();

        // Assert
        assertEquals(false, result);
    }

    @Test
    void getTorpedoCount_ReturnsCorrectCount() {
        // Arrange
        store = new TorpedoStore(5);

        // Act
        int count = store.getTorpedoCount();

        // Assert
        assertEquals(5, count);
    }
}
