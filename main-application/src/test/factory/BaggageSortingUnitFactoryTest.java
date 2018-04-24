package factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BaggageSortingUnitFactoryTest {

    private Object componentPort;

    @Test
    void build() {
        componentPort = BaggageSortingUnitFactory.build();
        assertNotNull(componentPort);
    }
}