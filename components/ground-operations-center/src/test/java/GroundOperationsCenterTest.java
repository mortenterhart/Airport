import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class GroundOperationsCenterTest {

    @Test
    public void test(){
        assertNotNull(GroundOperationsCenter.getInstance());
    }
}
