package factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SecurityCheckFactoryTest {
    private Object componentPort;

    @Test
    void build() {
        componentPort = SecurityCheckFactory.build();
        assertNotNull(componentPort);
    }
}
