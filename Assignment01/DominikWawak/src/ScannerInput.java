
import java.util.Scanner;

/**
 * ScannerInput class
 * Removes the Scanner bug by creating a seperate scanner object
 * each time a read method is called.
 *
 * @author Dominik Wawak
 * @version 1.0.0 (9.Mar.2020)
 */

public class ScannerInput {

    /**
     * readNextInt
     * Creates a new scanner object , reads users input and parses it as a int,
     * if it isn't an int it catches a error.
     *
     * @param prompt a Stying that outputs a message to the user
     * @return a int that the user has entered to the console.
     */
    public static int readNextInt(String prompt) {
        do {
            var scanner = new Scanner(System.in);
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.err.println("\tEnter a number please.");
            }
        } while (true);
    }

    public static double readNextDouble(String prompt) {
        do {
            var scanner = new Scanner(System.in);
            try{
                System.out.print(prompt);
                return Double.parseDouble(scanner.next());
            }
            catch (NumberFormatException e) {
                System.err.println("\tEnter a number please.");
            }
        }  while (true);
    }

    /**
     * readNextString
     * Creates a new scanner object , reads users input ,
     *
     * @param prompt a Stying that outputs a message to the user
     * @return a String that the user has entered to the console.
     */



    public static String  readNextString(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        return input.nextLine();
    }

    public static char readNextChar(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        return input.next().charAt(0);
    }


}
