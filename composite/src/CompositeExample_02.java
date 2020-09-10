import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The pattern is a tree structure. An example is a folder hierarchy or html page.
 */
public class CompositeExample_02 {
    public static void main(String[] args) {

        Folder composite = new Folder("composite");
        Folder src = new Folder("src");
        Folder etc = new Folder("etc");

        Folder root = new Folder("gof-design-patterns");
        root.addFolder(composite, src, etc);

        Folder temp01 = new Folder("temp-01");
        Folder temp02 = new Folder("temp-02");
        Folder temp03 = new Folder("temp-03");

        composite.addFolder(temp01, temp02);
        src.addFolder(temp03);

        root.printFolders();
    }
}

class Folder {

    private String name;
    private List<Folder> folders = new ArrayList<>();


    public Folder(final String name) {
        this.name = name;
    }

    public void addFolder(Folder folder) {
        this.folders.add(folder);
    }

    public void addFolder(Folder... folders) {
        this.folders.addAll(Arrays.asList(folders));
    }

    public void printFolders() {
        for (Folder folder : this.folders) {
            System.out.println("Folder name: " + folder.name);
            folder.printFolders();
        }
    }
}
