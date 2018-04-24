import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AirCargoPalletLifterTests {

@Test
    public void upTest(){

        boolean expectedDownStatus = false;

        AirCargoPalletLifter lifter = new AirCargoPalletLifter();

        Assertions.assertEquals(expectedDownStatus, lifter.innerUp());

    }

    @Test
    public void downTest(){

        boolean expectedDownStatus = true;

        AirCargoPalletLifter lifter = new AirCargoPalletLifter();

        Assertions.assertEquals(expectedDownStatus, lifter.innerDown());

    }

    @Test
    public void moveTest(){

    AirCargoPalletLifter lifter = new AirCargoPalletLifter();
    Stowage stowage = new Stowage(null);

    ArrayList<AirCargoPallet> expectedValue3 = new ArrayList<AirCargoPallet>();
    expectedValue3.add(new AirCargoPallet("1","1"));
    expectedValue3.add(new AirCargoPallet("2","2"));
    expectedValue3.add(new AirCargoPallet("3","3"));

    Assertions.assertEquals(3, lifter.innerMove(expectedValue3, stowage));


    }





}
