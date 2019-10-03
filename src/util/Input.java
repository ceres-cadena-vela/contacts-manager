package util;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    private static String userMessage;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Main
     */


    public static void main(String[] args) {


    }

    private String getString() {

        return this.scanner.nextLine();
    }

    public String getString(String prompt) {
        if (prompt.isEmpty()) {
            System.out.println("Please enter a sentence");
        } else {
            System.out.println(prompt);
        }
        return getString();
    }

    private boolean yesNo() {
        /**
         * The yesNo method should return true if the user enters y, yes, or variants thereof, and false otherwise.
         */
//        System.out.println("Please answer Y/N?");
        String answer = this.scanner.nextLine();
        return (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"));

    }

    public boolean yesNo(String message) {
        /**
         * The yesNo method should return true if the user enters y, yes, or variants thereof, and false otherwise.
         */
        if (message.trim().length() > 0) {
            System.out.println(message);
        } else {
            System.out.println("Please answer Y/N?");
        }

        return yesNo();

    }


    public int getInt(int min, int max) {
        /**
         *
         * The getInt(int min, int max) method should keep prompting the user for input until they give an integer within the min and max.
         */
        //System.out.format("please enter a number between %d and %d \n", min, max);

        int userInput = getInt();

        //* If the input is invalid, prompt the user again.
        if (userInput >= min && userInput <= max) {
            return userInput;
        } else {
            System.out.format("The number %d is not between %d and %d \n", userInput, min, max);
            return getInt(min, max);
        }
    }

    public int getInt(String prompt, int min, int max) {
        /**
         *
         * The getInt(int min, int max) method should keep prompting the user for input until they give an integer within the min and max.
         */

        if (prompt.isEmpty()) {
            System.out.format("please enter a number between %d and %d \n", min, max);
        } else {
            System.out.println(prompt);
        }
        //

        return getInt(min, max);

    }

    private int getInt() {
        /**
         * The getInt() method should keep prompting the user for input until they give an integer
         */
        //System.out.println("please enter a number ");
        // return Integer.parseInt(this.scanner.nextLine());


        String intNumber = "";

        try {
            intNumber = this.scanner.nextLine();
            return Integer.valueOf(intNumber);

        } catch (NumberFormatException e) {
            System.err.println("Unable to format. " + e);
            System.out.println("Please enter a number ");
            //e.printStackTrace();
            return getInt();
        }
    }

    public int binaryToInteger() {
        //String binary = this.scanner.nextLine();
        int number = getInt("Please enter a number to change to binary");
        String binary = Integer.toString(number);
        return Integer.valueOf(binary, 2);
    }

    public int hexadecimalToInteger() {
        int number = getInt("Please enter a number to change to hexadecimal");
        String hexadecimal = Integer.toString(number);
        return Integer.valueOf(hexadecimal, 16);
    }


    public int getInt(String prompt) {
        /**
         * The getInt() method should keep prompting the user for input until they give an integer
         */
        if (!prompt.isEmpty()) {
            System.out.println(prompt);
        } else {
            System.out.println("Please enter a number");
        }

        return getInt();
    }

    private double getDouble(double min, double max) {
        /**
         *
         * The getDouble(int min, int max) method should keep prompting the user for input until they give an integer within the min and max.
         */
        double userInput = getDouble();

        //* If the input is invalid, prompt the user again.
        if (userInput >= min && userInput <= max) {
            return userInput;
        } else {
            System.out.format("The number %.2f is not between %.2f and %.2f \n", userInput, min, max);
            return getDouble(min, max);
        }
    }

    public double getDouble(String prompt, double min, double max) {
        /**
         *
         * The getDouble(int min, int max) method should keep prompting the user for input until they give an integer within the min and max.
         */

        if (prompt.isEmpty()) {
            System.out.format("please enter a number between %.2f and %.2f \n", min, max);
        } else {
            System.out.println(prompt);
        }
        return getDouble(min, max);
    }

    private double getDouble() {
        /**
         * The getDouble() method should keep prompting the user for input until they give an double
         */

        String dblNumber = "";

        try {
            dblNumber = this.scanner.nextLine();
            return Double.valueOf(dblNumber);

        } catch (NumberFormatException e) {
            System.err.println("Unable to format. " + e);
            System.out.println("\nPlease enter a decimal number");
            return getDouble();
        }
    }

    public double getDouble(String prompt) {
        /**
         * The getDouble() method should keep prompting the user for input until they give an double
         */
        // System.out.println("please enter a decimal number ");
        if (!prompt.isEmpty()) {
            System.out.println(prompt);
        } else {
            System.out.println("Please enter a decimal number");
        }

        return getDouble();


    }

}

