package example_01;

import example_01.banking.BankingTeamFactory;
import example_01.website.WebsiteTeamFactory;

public class SuperBankSystem {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new BankingTeamFactory();
        final Developer developer = projectTeamFactory.getDeveloper();
        final Tester tester = projectTeamFactory.getTester();
        final ProjectManager projectManager = projectTeamFactory.getProjectManager();

        System.out.println("Creating bank system...");
        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
