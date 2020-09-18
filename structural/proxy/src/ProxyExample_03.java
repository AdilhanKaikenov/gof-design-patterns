/**
 * We need a proxy here, for example, we want to load objects not when creating a project, but only at startup. LAZY
 */
public class ProxyExample_03 {
    public static void main(String[] args) {
        Project project = new ProxyProject("https://github.com/AdilhanKaikenov/realproject");

//        project.run();
    }
}

interface Project {
    void run();
}

class RealProject implements Project {

    private String url;

    public RealProject(final String url) {
        this.url = url;
        this.load();
    }

    public void load() {
        System.out.println("Loading project from " + this.url + "...");
    }

    @Override
    public void run() {
        System.out.println("Running project " + this.url + "...");
    }
}

class ProxyProject implements Project {
    private String url;

    private RealProject realProject;

    public ProxyProject(final String url) {
        this.url = url;
    }

    @Override
    public void run() {
        if (this.realProject == null) {
            this.realProject = new RealProject(this.url);
        }
        this.realProject.run();
    }
}