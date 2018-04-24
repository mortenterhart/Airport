package factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BoardingControlFactoryTest {
    private Object boardingControlPort;

    @Test
    public void testFactoryBuildNotNull() {
        boardingControlPort = BoardingControlFactory.build();
        assertNotNull(boardingControlPort);
    }
}
