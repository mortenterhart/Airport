package factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ScannerFactoryTest {
    private Object componentPort;

    @Test
    void build() {
        componentPort = ScannerFactory.build();
        assertNotNull(componentPort);
    }
}
