import java.util.ArrayList;
import java.util.List;

public class MediatorExample_01 {
    public static void main(String[] args) {
        final ChatMediator chatMediator = new ChatMediator();
        final ColleagueImpl mike = new ColleagueImpl(chatMediator, "Mike");
        chatMediator.addColleague(mike);
        chatMediator.addColleague(new ColleagueImpl(chatMediator, "Kent"));
        chatMediator.addColleague(new ColleagueImpl(chatMediator, "Den"));

        mike.sendMessage("Hello colleagues!");
    }
}

interface Chat {
    void sendMessage(String message, Colleague colleague);
    void addColleague(Colleague me);
}

class ChatMediator implements Chat {

    private List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void sendMessage(final String message, final Colleague me) {
        this.colleagues.forEach(colleague -> {
            if (colleague != me) {
                colleague.printMessage(message);
            }
        });
    }

    @Override
    public void addColleague(final Colleague colleague) {
        this.colleagues.add(colleague);
    }
}

abstract class Colleague {
    protected Chat chat;
    protected String name;

    public Colleague(final Chat chat, final String name) {
        this.chat = chat;
        this.name = name;
    }

    abstract void sendMessage(String message);
    abstract void printMessage(String message);

}

class ColleagueImpl extends Colleague {

    public ColleagueImpl(final Chat chat, final String name) {
        super(chat, name);
    }

    @Override
    void sendMessage(final String message) {
        this.chat.sendMessage(message, this);
    }

    @Override
    void printMessage(final String message) {
        System.out.println(this.name + " " + message);
    }
}