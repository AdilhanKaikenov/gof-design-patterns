import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A composer is a structural pattern that allows you to create and work with a tree of objects in the same way as with a single object.
 * <p>
 * Every sentence is composed of words which are in turn composed of characters.
 * Each of these objects is printable and they can have something printed before or after them like sentence
 * always ends with full stop and word always has space before it.
 * <p>
 * Composite pattern lets clients treat the individual objects in a uniform manner.
 * Составной шаблон позволяет клиентам обрабатывать отдельные объекты единообразно.
 */
public class CompositeExample_01 {
    public static void main(String[] args) {
        Messenger messenger = new Messenger();
        final LetterComposite orcMessage = messenger.messageFromOrcs();
        orcMessage.print();
        final LetterComposite elfMessage = messenger.messageFromElves();
        elfMessage.print();
    }
}

// Here we have the base class LetterComposite and the different printable types Letter, Word and Sentence.
abstract class LetterComposite {

    private final List<LetterComposite> children = new ArrayList<>();

    public void add(LetterComposite letter) {
        this.children.add(letter);
    }

    public int count() {
        return this.children.size();
    }

    protected void printThisBefore() {
    }

    protected void printThisAfter() {
    }

    public void print() {
        printThisBefore();
        this.children.forEach(LetterComposite::print);
        printThisAfter();
    }
}

class Letter extends LetterComposite {

    private final char character;

    public Letter(char c) {
        this.character = c;
    }

    @Override
    protected void printThisBefore() {
        System.out.print(character);
    }
}

class Word extends LetterComposite {

    public Word(List<Letter> letters) {
        letters.forEach(this::add);
    }

    public Word(char... letters) {
        for (char letter : letters) {
            this.add(new Letter(letter));
        }
    }

    @Override
    protected void printThisBefore() {
        System.out.print(" ");
    }
}

class Sentence extends LetterComposite {

    public Sentence(List<Word> words) {
        words.forEach(this::add);
    }

    @Override
    protected void printThisAfter() {
        System.out.print(".");
    }
}

// We have a messenger to carry messages:
class Messenger {

    LetterComposite messageFromOrcs() {
        final List<Word> words = Stream.of(
                new Word('W', 'h', 'e', 'r', 'e'),
                new Word('t', 'h', 'e', 'r', 'e'),
                new Word('i', 's'),
                new Word('a'),
                new Word('w', 'h', 'i', 'p'),
                new Word('t', 'h', 'e', 'r', 'e'),
                new Word('i', 's'),
                new Word('a'),
                new Word('w', 'a', 'y')
        ).collect(Collectors.toList());

        return new Sentence(words);
    }

    LetterComposite messageFromElves() {
        final List<Word> words = Stream.of(
                new Word('M', 'u', 'c', 'h'),
                new Word('w', 'i', 'n', 'd'),
                new Word('p', 'o', 'u', 'r', 's'),
                new Word('f', 'r', 'o', 'm'),
                new Word('y', 'o', 'u', 'r'),
                new Word('m', 'o', 'u', 't', 'h')
        ).collect(Collectors.toList());

        return new Sentence(words);
    }
}