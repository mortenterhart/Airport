public class SpecialGoodRoboter {
    private String id;
    private boolean isDown;

    private static SpecialGoodRoboter instance = new SpecialGoodRoboter("SGR01");

    public Port port;

    public SpecialGoodRoboter(String id) {
        this.id = id;
        isDown = true;
        port = new Port();
    }

    public boolean innerUp(){
        isDown = false;
        return  isDown;
    }

    public boolean innerDown(){
        isDown = true;
        return isDown;
    }




    public static SpecialGoodRoboter getInstance() {return instance;}

    public class Port implements ISpecialGoodRoboter{

        public boolean up(){
            return innerUp();
        }

        public void move(SpecialGood specialGood) {

        }

        public void secure(SpecialGood specialGood) {

        }

        public boolean down() {
            return innerDown();
        }
    }
}
