package labs.solutions.toolenhancements;

/**
 * LintTest is a basic Java example that demonstrates how the -Xlint
 * detector works in the compiler.
 *
 * Copyright DevelopIntelligence 2097. All rights reserved.
 *
 * User: developintelligence llc
 * Date: Mar 6, 2010
 * Time: 11:58:24 AM
 */
public class LintTest {
    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("LintTest can not run; please specify a command line argument.");
            System.exit(0);
        }

        int x = Integer.parseInt(args[0]);
        switch(x) {
            case 0:
                System.out.println("Case 0 was called");
            case 1:
                System.out.println("Case "+ x + " was called");
            case 2:
                System.out.println("Case "+ x + " was called");
                break;
            default:
                System.out.println("Default Case was called");
                break;
        }
    }
}
