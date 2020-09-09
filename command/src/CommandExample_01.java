/**
 * A command is a behavioral design pattern that turns requests into objects, allowing them to be passed as arguments when calling methods.
 *
 * The command pattern solves the incompatibility problem when we need to call something but we don't know what exactly.
 */
public class CommandExample_01 {
    public static void main(String[] args) {
        final Command lightCommand = new LightCommand(new Light());
        final Command musicPlayerCommand = new MusicPlayerCommand(new MusicPlayer());
        final Command command1 = new LightAndMusicCommand(new Light(), new MusicPlayer());
        final Command command2 = new PhoneCommand(new Phone(), "Mike");
        final Button button = new Button(command2);
        button.pressButton();

    }
}

class Button {
    private Command command;

    public Button(final Command command) {
        this.command = command;
    }

    void pressButton() {
        this.command.execute();
    }
}

interface Command {
    void execute();
}

class LightCommand implements Command {

    private Light light;

    public LightCommand(final Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.switchLight();
    }
}

class MusicPlayerCommand implements Command {

    private MusicPlayer musicPlayer;

    public MusicPlayerCommand(final MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        this.musicPlayer.playMusic();
    }
}

class LightAndMusicCommand implements Command {

    private Light light;
    private MusicPlayer musicPlayer;

    public LightAndMusicCommand(final Light light, final MusicPlayer musicPlayer) {
        this.light = light;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        this.light.switchLight();
        this.musicPlayer.playMusic();
    }
}

class PhoneCommand implements Command {

    private Phone phone;
    private String name;

    public PhoneCommand(final Phone phone, final String name) {
        this.phone = phone;
        this.name = name;
    }

    @Override
    public void execute() {
        this.phone.makeCall(this.name);
    }
}

class Light {
    boolean isOn;

    public void switchLight() {
        this.isOn = !this.isOn;
        System.out.println("Light is " + (this.isOn? "on":"off"));
    }
}

class MusicPlayer {
    public void playMusic() {
        System.out.println("Play music...");
    }
}

class Phone {
    public void makeCall(String name) {
        System.out.println("Make call to " + name);
    }
}