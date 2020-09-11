package example_01;

import example_01.website.WebsiteTeamFactory;

public class AuctionSiteProject {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new WebsiteTeamFactory();
        final Developer developer = projectTeamFactory.getDeveloper();
        final Tester tester = projectTeamFactory.getTester();
        final ProjectManager projectManager = projectTeamFactory.getProjectManager();

        System.out.println("Creating auction website...");
        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
