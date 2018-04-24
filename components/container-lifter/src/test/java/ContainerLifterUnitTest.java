import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ContainerLifterUnitTest {

    @Test
    public void liftTest(){
        ArrayList<Container> containers = new ArrayList<Container>();
        Stowage stowage = new Stowage(containers);
        ContainerLifter containerLifter = new ContainerLifter();
        Assertions.assertEquals(1,containerLifter.innerLift(containers, stowage));

    }

    @Test
    public void upTest(){
        ContainerLifter containerLifter = new ContainerLifter();
        Assertions.assertEquals(false,containerLifter.innerUp());

    }

    @Test
    public void downTest(){
        ContainerLifter containerLifter = new ContainerLifter();
        Assertions.assertEquals(true,containerLifter.innerDown());

    }

}
