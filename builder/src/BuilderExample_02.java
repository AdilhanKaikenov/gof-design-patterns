/**
 * Example from https://github.com/AdilhanKaikenov/java-design-patterns/tree/master/builder
 */
public class BuilderExample_02 {
    public static void main(String[] args) {
        final Hero hero = new Hero.Builder(Profession.MAGE, "Riobard").withHairColor(HairColor.BLACK).withWeapon(Weapon.DAGGER).build();
        System.out.println(hero);
    }
}

class Hero {
    private final Profession profession;
    private final String name;
    private final HairType hairType;
    private final HairColor hairColor;
    private final Armor armor;
    private final Weapon weapon;

    private Hero(Builder builder) {
        this.profession = builder.profession;
        this.name = builder.name;
        this.hairColor = builder.hairColor;
        this.hairType = builder.hairType;
        this.weapon = builder.weapon;
        this.armor = builder.armor;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "profession=" + this.profession +
                ", name='" + this.name + '\'' +
                ", hairType=" + this.hairType +
                ", hairColor=" + this.hairColor +
                ", armor=" + this.armor +
                ", weapon=" + this.weapon +
                '}';
    }

    static class Builder {
        private final Profession profession;
        private final String name;
        private HairType hairType;
        private HairColor hairColor;
        private Armor armor;
        private Weapon weapon;

        public Builder(Profession profession, String name) {
            if (profession == null || name == null) {
                throw new IllegalArgumentException("profession and name can not be null");
            }
            this.profession = profession;
            this.name = name;
        }

        public Builder withHairType(HairType hairType) {
            this.hairType = hairType;
            return this;
        }

        public Builder withHairColor(HairColor hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Builder withArmor(Armor armor) {
            this.armor = armor;
            return this;
        }

        public Builder withWeapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public Hero build() {
            return new Hero(this);
        }
    }
}

enum Profession {MAGE}
enum Armor {}
enum Weapon {DAGGER}
enum  HairType {}
enum  HairColor {BLACK}
