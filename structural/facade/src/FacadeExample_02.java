public class FacadeExample_02 { // Sprint Runner
    public static void main(String[] args) {
//        Job job = new Job();
//        job.doJob();
//        BugTracker bugTracker = new BugTracker();
//        bugTracker.startSprint();
//        Developer developer = new Developer();
//        developer.doJobBeforeDeadline(bugTracker);
//
//        bugTracker.finishSprint();
//        developer.doJobBeforeDeadline(bugTracker);

        Workflow workflow = new Workflow();

        workflow.solveProblems();
    }
}

class Job {
    public void doJob() {
        System.out.println("Job in progress...");
    }
}

class BugTracker {
    private boolean activeSprint;

    public boolean isActiveSprint() {
        return this.activeSprint;
    }

    public void startSprint() {
        System.out.println("Sprint is active");
        this.activeSprint = true;
    }

    public void finishSprint() {
        System.out.println("Sprint is not active");
        this.activeSprint = false;
    }
}

class Developer {
    public void doJobBeforeDeadline(BugTracker bugTracker) {
        if (bugTracker.isActiveSprint()) {
            System.out.println("Developer is solving the problems...");
        } else {
            System.out.println("Developer is reading articles on HabraHabr");
        }
    }
}

// Facade
class Workflow {

    private Job job = new Job();
    private BugTracker bugTracker = new BugTracker();
    private Developer developer = new Developer();

    public void solveProblems() {
        this.job.doJob();
        this.bugTracker.startSprint();
        this.developer.doJobBeforeDeadline(this.bugTracker);
    }


}