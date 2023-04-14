package examples.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * CsvScanner is a basic example illustrating how to use
 * the Scanner API introduced in Java 1.5.
 * <p/>
 * The CsvScanner reads lines in a text file which
 * uses a comma as a delimiter.
 * <p/>
 * <p/>
 * User: developintelligence llc
 * Date: Mar 6, 2010
 * Time: 1:17:20 PM
 */
public class CsvScanner {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("CsvScanner needs a csv file name as a argument.");
            System.exit(0);
        }

        try {
            Scanner fileScanner = new Scanner(new File(args[0]));
            fileScanner.useDelimiter(",\\s*");
            while (fileScanner.hasNext()) {
                String field = fileScanner.next();
                System.out.print(field + " ");
            }
            System.out.flush();
            System.out.println("\nCsvScanner processing next row..");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
