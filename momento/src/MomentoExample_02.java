import java.util.Stack;

public class MomentoExample_02 {
    public static void main(String[] args) {
        final Stack<Object> states = new Stack<>();

        Star star = new Star(StarType.SUN, 10000000, 500000);
        System.out.println(star.toString());

        states.add(star.getMemento());
        star.timePasses();
        System.out.println(star.toString());

        states.add(star.getMemento());
        star.timePasses();
        System.out.println(star.toString());

        states.add(star.getMemento());
        star.timePasses();
        System.out.println(star.toString());

        states.add(star.getMemento());
        star.timePasses();
        System.out.println(star.toString());

        while (states.size() > 0) {
            star.setMemento((StarMemento) states.pop());
            System.out.println(star.toString());
        }
    }
}

enum StarType {
    SUN("sun"),
    RED_GIANT("red giant"),
    WHITE_DWARF("white dwarf"),
    SUPERNOVA("supernova"),
    DEAD("dead star");

    private String state;

    StarType(final String state) {
        this.state = state;
    }
}

interface StarMemento {
}

class Star {

    private StarType type;
    private int ageYears;
    private int massTons;

    public Star(StarType startType, int startAge, int startMass) {
        this.type = startType;
        this.ageYears = startAge;
        this.massTons = startMass;
    }

    public void timePasses() {
        ageYears *= 2;
        massTons *= 8;
        switch (type) {
            case RED_GIANT:
                type = StarType.WHITE_DWARF;
                break;
            case SUN:
                type = StarType.RED_GIANT;
                break;
            case SUPERNOVA:
                type = StarType.DEAD;
                break;
            case WHITE_DWARF:
                type = StarType.SUPERNOVA;
                break;
            case DEAD:
                ageYears *= 2;
                massTons = 0;
                break;
            default:
                break;
        }
    }

    StarMemento getMemento() {
        final StarMementoInternal state = new StarMementoInternal();
        state.setAgeYears(ageYears);
        state.setMassTons(massTons);
        state.setType(type);
        return state;
    }

    void setMemento(StarMemento memento) {
        final StarMementoInternal state = (StarMementoInternal) memento;
        this.type = state.getType();
        this.ageYears = state.getAgeYears();
        this.massTons = state.getMassTons();
    }

    @Override
    public String toString() {
        return String.format("%s age: %d years mass: %d tons", type.toString(), ageYears, massTons);
    }

    private static class StarMementoInternal implements StarMemento {

        private StarType type;
        private int ageYears;
        private int massTons;

        public StarType getType() {
            return type;
        }

        public void setType(final StarType type) {
            this.type = type;
        }

        public int getAgeYears() {
            return ageYears;
        }

        public void setAgeYears(final int ageYears) {
            this.ageYears = ageYears;
        }

        public int getMassTons() {
            return massTons;
        }

        public void setMassTons(final int massTons) {
            this.massTons = massTons;
        }
    }
}