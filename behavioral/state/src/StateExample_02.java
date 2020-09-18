public class StateExample_02 {
    public static void main(String[] args) {
        Activity activity = new Sleeping();
        Developer developer = new Developer();

        developer.setActivity(activity);

        for (int i = 0; i < 10; i++) {
            developer.justDoIt();
            developer.changeActivity();
        }
    }
}

interface Activity {
    void justDoIt();
}

class Coding implements Activity {

    @Override
    public void justDoIt() {
        System.out.println("Writing code...");
    }
}

class Reading implements Activity {

    @Override
    public void justDoIt() {
        System.out.println("Reading book...");
    }
}

class Sleeping implements Activity {

    @Override
    public void justDoIt() {
        System.out.println("Sleeping...");
    }
}

class Training implements Activity {

    @Override
    public void justDoIt() {
        System.out.println("Training...");
    }
}

class Developer {
    private Activity activity;

    public Activity getActivity() {
        return this.activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void changeActivity() {
        if (this.activity instanceof Sleeping) {
            this.setActivity(new Training());
        } else if (this.activity instanceof Training) {
            this.setActivity(new Coding());
        } else if (this.activity instanceof Coding) {
            this.setActivity(new Reading());
        } else if (this.activity instanceof Reading) {
            this.setActivity(new Sleeping());
        }
    }

    public void justDoIt() {
        this.activity.justDoIt();
    }
}