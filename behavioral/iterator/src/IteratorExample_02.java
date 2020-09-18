public class IteratorExample_02 {
    public static void main(String[] args) {
        String[] skills = {"Java", "Spring", "Hibernate", "MySQL"};

        final JavaDeveloper javaDeveloper = new JavaDeveloper("Adilkhan", skills);

        final Iterator iterator = javaDeveloper.getIterator();
        System.out.println("Java developer name: " + javaDeveloper.getName());
        System.out.println("Skills: ");

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Collection {
    Iterator getIterator();
}

class JavaDeveloper implements Collection {

    private String name;
    private String[] skills;

    public JavaDeveloper(final String name, final String[] skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String[] getSkills() {
        return this.skills;
    }

    public void setSkills(final String[] skills) {
        this.skills = skills;
    }

    @Override
    public Iterator getIterator() {
        return new SkillIterator();
    }

    private class SkillIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < skills.length) {
                return true;
            }

            return false;
        }

        @Override
        public Object next() {
            return skills[index++];
        }
    }
}