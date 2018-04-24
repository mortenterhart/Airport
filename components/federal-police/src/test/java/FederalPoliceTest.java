import org.junit.Test;

import static org.junit.Assert.*;


public class FederalPoliceTest {

    @Test
    public void testGetInstanceNotNull() {
        assertNotNull(FederalPolice.getInstance());
    }

    @Test
    public void testInnerMethodVerifyNullPassport() {
        assertFalse(FederalPolice.getInstance().innerMethodVerify(null));
    }

    @Test
    public void testInnerMethodVerifyNotNullPassport() {
        assertTrue(FederalPolice.getInstance().innerMethodVerify(new Passport("id","picture","string", null)));
    }

    @Test
    public void testInnerMethodScanNullPassport() {
        assertFalse(FederalPolice.getInstance().innerMethodScan(null));
    }

    @Test
    public void testInnerMethodArrestNotNullPassport() {
        assertTrue(FederalPolice.getInstance().innerMethodScan(new Passport("id","picture","string", null)));
    }

    @Test
    public void testInnerMethodInspectWeaponTrue() {
        SpecialGood specialGood = new SpecialGood(SpecialGoodType.Weapon);
        assertTrue(FederalPolice.getInstance().innerMethodInspectWeapon(specialGood));
    }

    @Test
    public void testInnerMethodInspectWeaponFalse() {
        SpecialGood specialGood = new SpecialGood(SpecialGoodType.Bike);
        assertFalse(FederalPolice.getInstance().innerMethodInspectWeapon(specialGood));
    }

    @Test
    public void testInnerMethodInspectMunitionTrue() {
        SpecialGood specialGood = new SpecialGood(SpecialGoodType.Munition);
        assertTrue(FederalPolice.getInstance().innerMethodInspectMunition(specialGood));
    }

    @Test
    public void testInnerMethodInspectMunitionFalse() {
        SpecialGood specialGood = new SpecialGood(SpecialGoodType.DangerousGoods);
        assertFalse(FederalPolice.getInstance().innerMethodInspectMunition(specialGood));
    }

//    @Test
//    public void testInnerMethodNotifyGroundOperations() {
//        FederalPoliceReceipt receipt = new FederalPoliceReceipt(0,0, null,null);
//        try{
//            FederalPolice.getInstance().innerMethodNotifyGroundOperations(receipt);
//            assertTrue(true);
//        }catch (Exception e){
//            e.printStackTrace();
//            assertTrue(false);
//        }
//    }
}