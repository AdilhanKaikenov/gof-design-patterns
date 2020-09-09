/**
 * It helps to build a chain of objects. A request enters from one end and keeps going from an object to another until it finds a suitable handler.
 *
 * We call a method, and it goes through a chain of calls to different methods and they all handle this.
 *
 * The idea is that one method is split into separate classes and each of them deals with its own aspect, so one call can be processed by several classes.
 */
public class ChainOfResponsibilityExample_01 {
    public static void main(String[] args) {
        MessageHandler handler = new MessageVerifyHandler(
                new MessageAddExclamationMarkHandler(
                        new MessagePrintHandler(null)));
        handler.handle("Hello world");
    }
}

abstract class MessageHandler {

    protected MessageHandler messageHandler;

    public MessageHandler(final MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    abstract void handle(String mgs);
}

// Print message
class MessagePrintHandler extends MessageHandler {

    public MessagePrintHandler(final MessageHandler messageHandler) {
        super(messageHandler);
    }

    @Override
    void handle(final String mgs) {
        System.out.println(mgs);
    }
}

// Verify message
class MessageVerifyHandler extends MessageHandler {

    public MessageVerifyHandler(final MessageHandler messageHandler) {
        super(messageHandler);
    }

    @Override
    void handle(final String mgs) {
        if (!mgs.matches(".*\\d.*")) {
            messageHandler.handle(mgs);
        }
    }
}

// Add an exclamation mark to the end of the message
class MessageAddExclamationMarkHandler extends MessageHandler {

    public MessageAddExclamationMarkHandler(final MessageHandler messageHandler) {
        super(messageHandler);
    }

    @Override
    void handle(final String mgs) {
        messageHandler.handle(mgs + "!");
    }
}