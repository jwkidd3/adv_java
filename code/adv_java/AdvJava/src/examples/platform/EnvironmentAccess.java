package examples.platform;

import java.util.Map;
import static java.lang.System.*;

/**
 * Copyright DevelopIntelligence 2007. All rights reserved.
 *
 * User: developintelligence llc
 * Date: Mar 4, 2010
 * Time: 10:57:59 AM
 *
 * EnvironmentAccess provides a simplistic example of accessing
 * operating system environment variables using the getenv method
 * introduced as part of the System class in Java 5.
 *
 * EnvironmentAccess takes a command line argument that represents
 * the oS system variable name that will be retrieved and display
 * as part of the program execution.
 */
public class EnvironmentAccess {

    /** EnvironmentAccess takes a command line argument that represents
    * the oS system variable name that will be retrieved and display
    * as part of the program execution.
    */
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Unable to access specific env var, retrieving all env vars");
            Map<String, String> envValues = getenv();
            for(String s : envValues.keySet()) {
                System.out.println(s + "=" + envValues.get(s));
            }

        } else {

            String envValue = System.getenv(args[0]);
            System.out.println(args[0] + "=" + envValue);
        }
    }
}
