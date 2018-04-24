package factory;

import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertNotNull;


public class CustomsFactoryTest {

    private Object componentPort;

    @Test
    public void build() {
        componentPort=CustomsFactory.build();
        assertNotNull(componentPort);
    }
}
