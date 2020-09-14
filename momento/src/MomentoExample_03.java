import java.util.Date;

public class MomentoExample_03 {
    public static void main(String[] args) {
        final Project project = new Project();
        final GitHubRepo gitHub = new GitHubRepo();

        System.out.println("Creating new project. Version 1.0");
        project.setVersionAndDate("Version 1.0");

        System.out.println(project);

        System.out.println("Saving current project to gutHub...");
        gitHub.setSave(project.save());

        System.out.println("Updating project to Version 1.1");

        System.out.println("Writing poor code...");
        project.setVersionAndDate("Version 1.1");

        System.out.println(project);

        System.out.println("Something went wrong...");

        System.out.println("Rolling back to Version 1.0");
        project.load(gitHub.getSave());

        System.out.println("Project after rollback:");
        System.out.println(project);
    }
}

class Project {
    private String version;
    private Date date;

    public void setVersionAndDate(String version) {
        this.version = version;
        this.date = new Date();
    }

    public Save save() {
        return new Save(this.version);
    }

    public void load(Save save) {
        this.version = save.getVersion();
        this.date = save.getDate();
    }

    @Override
    public String toString() {
        return "Project{" +
                "version='" + this.version + '\'' +
                ", date=" + this.date +
                '}';
    }
}

class Save {
    private final String version;
    private final Date date;

    public Save(final String version) {
        this.version = version;
        this.date = new Date();
    }

    public String getVersion() {
        return this.version;
    }

    public Date getDate() {
        return this.date;
    }
}

class GitHubRepo {
    private Save save;

    public Save getSave() {
        return this.save;
    }

    public void setSave(final Save save) {
        this.save = save;
    }
}