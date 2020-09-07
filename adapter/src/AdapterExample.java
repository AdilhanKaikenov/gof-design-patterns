/**
 * Adapter pattern lets you wrap an incompatible object in an adapter to make it compatible with another class.
 *
 * Wikipedia says:
 *
 * In software engineering, the adapter pattern is a software design pattern that allows the interface of an existing class to be used as another interface.
 * It is often used to make existing classes work with others without modifying their source code.
 */
public class AdapterExample {
    public static void main(String[] args) {
        AmericanSocket americanSocket = new SimpleAmericanSocket();
        EuroSocket euroSocket = new SocketAdapter(americanSocket); // adapter
        Radio radio = new Radio();

        radio.turnOn(euroSocket); // Now we can listen to the radio
    }
}

interface EuroSocket {
    void getPower();
}

interface AmericanSocket {
    void getPower();
}

/**
 * Adapter class that combines our European socket with our American socket.
 */
class SimpleAmericanSocket implements AmericanSocket {

    @Override
    public void getPower() {
        System.out.println("Get 110 volt (american)");
    }
}

class SocketAdapter implements EuroSocket {

    private AmericanSocket americanSocket;

    public SocketAdapter(final AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    @Override
    public void getPower() {
        this.americanSocket.getPower();
    }
}

class Radio {

    /*
    Radio only works with European socket.
     */
    public void turnOn(EuroSocket socket) {
        socket.getPower();
    }
}