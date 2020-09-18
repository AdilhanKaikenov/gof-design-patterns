public class TemplateExample_02 {
    public static void main(String[] args) {

        WebsiteTemplate welcomePage = new WelcomePage();
        WebsiteTemplate newsPage = new NewsPage();

        welcomePage.showPage();

        System.out.println("\n===========================================\n");

        newsPage.showPage();

    }
}

abstract class WebsiteTemplate {
    public void showPage() {
        System.out.println("Header");
        this.showPageContent();
        System.out.println("Footer");
    }

    public abstract void showPageContent();
}

class WelcomePage extends WebsiteTemplate {

    @Override
    public void showPageContent() {
        System.out.println("Welcome");
    }
}

class NewsPage extends WebsiteTemplate {

    @Override
    public void showPageContent() {
        System.out.println("News");
    }
}
