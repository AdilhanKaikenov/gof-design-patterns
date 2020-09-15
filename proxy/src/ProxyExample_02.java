/**
 * Provide a surrogate or placeholder for another object to control access to it.
 *
 * Wikipedia says
 *
 * A proxy, in its most general form, is a class functioning as an interface to something else.
 * A proxy is a wrapper or agent object that is being called by the client to access the real
 * serving object behind the scenes. Use of the proxy can simply be forwarding to the real object,
 * or can provide additional logic. In the proxy extra functionality can be provided, for example
 * caching when operations on the real object are resource intensive, or checking preconditions
 * before operations on the real object are invoked.
 */
public class ProxyExample_02 {
    public static void main(String[] args) {
        WizardTowerProxy proxy = new WizardTowerProxy(new IvoryTower());
        proxy.enter(new Wizard("Red wizard"));
        proxy.enter(new Wizard("White wizard"));
        proxy.enter(new Wizard("Black wizard"));
        proxy.enter(new Wizard("Green wizard"));
        proxy.enter(new Wizard("Brown wizard"));
    }
}

interface WizardTower {
    void enter(Wizard wizard);
}

class IvoryTower implements WizardTower {

    public void enter(Wizard wizard) {
        System.out.println((wizard + " enters the tower."));
    }
}

class Wizard {

    private final String name;

    public Wizard(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class WizardTowerProxy implements WizardTower {

    private static final int NUM_WIZARDS_ALLOWED = 3;

    private int numWizards;

    private final WizardTower tower;

    public WizardTowerProxy(WizardTower tower) {
        this.tower = tower;
    }

    @Override
    public void enter(Wizard wizard) {
        if (this.numWizards < NUM_WIZARDS_ALLOWED) {
            this.tower.enter(wizard);
            this.numWizards++;
        } else {
            System.out.println((wizard + " is not allowed to enter!"));
        }
    }
}