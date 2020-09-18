public class FacadeExample_01 {
    public static void main(String[] args) {
        final LivingRoom livingRoom = new LivingRoom();
        livingRoom.pressButton("5", "22");

        final BedRoom bedRoom = new BedRoom();
        bedRoom.pressButton("10", "21");
    }
}

class RoomFacade {
    private Tv tv = new Tv();
    private AirConditioning airConditioning = new AirConditioning();
    private Light light = new Light();

    public void pressButton(String channel, String temperature) {
        this.tv.playChannel(channel);
        this.airConditioning.setTemperature(temperature);
        this.light.turnLignt();
    }

}

class Tv {
    void playChannel(String channel) {
        System.out.println("Play channel " + channel);
    }
}

class AirConditioning {
    void setTemperature(String temperature) {
        System.out.println("Set temperature " + temperature);
    }
}

class Light {
    void turnLignt() {
        System.out.println("Run light");
    }
}

class LivingRoom {

    RoomFacade roomFacade = new RoomFacade();

    public void pressButton(String channel, String temperature) {
        System.out.println("You are in the Living Room");
        this.roomFacade.pressButton(channel, temperature);
    }
}

class BedRoom {

    RoomFacade roomFacade = new RoomFacade();

    public void pressButton(String channel, String temperature) {
        System.out.println("You are in your Bed Room");
        this.roomFacade.pressButton(channel, temperature);
    }
}