package example_01.website;

import example_01.Tester;

public class ManualTester implements Tester {
    @Override
    public void testCode() {
        System.out.println("Manual Tester tests website...");
    }
}
