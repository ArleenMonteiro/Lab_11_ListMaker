import java.util.Scanner;
public class SafeInput
{



    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero in lenth
     */

    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {

        String retString = "";
        String trash = "";
        boolean done = false;

        do {
            System.out.println("\n"+ prompt + ": ");
            retString = pipe.nextLine();
            if (retString.length()>0)
            {done=true;}
            else
            {System.out.println("You must have atleast one character");}


        } while (!done);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.println(prompt + ": ");
            if(pipe.hasNextInt()){
                retVal = pipe.nextInt();
                pipe.nextLine();
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Must enter valid int: " + "trash");
            }

        } while (!done);
        return retVal;


    }

    /**
     * Get an integer value within a specified range of low to high
     *
     * @param pipe Scanner to use for console input
     * @param prompt String that tells the user what to input
     * @param low Low value for a range low - high
     * @param high hihg value for a range low - high
     * @return return an int value within a low to high range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = low - 1;
        String trash = "";
        boolean done = false;

        do {
            System.out.println(prompt + " [" + low + " - " + high + "]:");
            if(pipe.hasNextInt()){
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    //  System.out.println("You said your fav num is: " + retVal);
                    done = true;
                } else {
                    System.out.println("You said your fav num is: " + retVal + " but that is out of range [" + low + " - " + high + "]");
                }
            } else
            {
                trash = pipe.nextLine();
                System.out.println("Must enter valid int: " + "trash");
            }

        } while (!done);
        return retVal;

    }

    /**
     * Use scanner to get a double from the console with no constraints
     *
     * @param pipe Scanner to use for console input
     * @param prompt String that tells the user what to input
     * @return return a Doublr
     **/
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.println(prompt + ": ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Must enter a valid double: " + "trash");
            }

        } while (!done);
        return retVal;


    }


    /**
     * Get an integer value within a specified range of low to high
     *
     * @param pipe Scanner to use for console input
     * @param prompt String that tells the user what to input
     * @param low Low value for a range low - high
     * @param high hihg value for a range low - high
     * @return return an int value within a low to high range
     **/
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = low-1;
        String trash = "";
        boolean done = false;

        do {
            System.out.println(prompt + " [" + low + " - " + high + "]:");
            if(pipe.hasNextDouble()){
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    //  System.out.println("You said your num is: " + retVal);
                    done = true;
                } else {
                    System.out.println("You said your fav num is: " + retVal + " but that is out of range [" + low + " - " + high + "]");
                }
            } else
            {
                trash = pipe.nextLine();
                System.out.println("Must enter valid double" + "trash");
            }

        } while (!done);
        return retVal;
    }


    /**
     * gets a Y or an N and returns a true or a false respectively
     * @param pipe Scanner to use to get the input
     * @param prompt String prompt for the user to get the yes or no question
     * @return
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String confirmation = "";
        boolean done = false;
        boolean retVal = true;
        do {
            System.out.print(prompt + "[Y/N]: ");
            confirmation = pipe.nextLine();
            if (confirmation.equalsIgnoreCase("Y")) {
                done = true;
                retVal = true;
            } else if (confirmation.equalsIgnoreCase("N")) {
                done = true;
                retVal = false;
            } else {
                System.out.print(confirmation + " is not a valid answer you must enter [Y/N]");
            }
        } while (!done);
        return retVal;

    }

    /**
     * gets a string that matches a Regular Expression pattern like ###-##-#### \d{3}-\d{2}=\d{4}
     * @param pipe String prompt to tell user what to input
     * @param prompt A regEx pattern to use for the test
     * @param pattern a String that matches the regEx pattern
     * @return
     */

    public static String getRegExString(Scanner pipe, String prompt, String pattern)
    {
        // figure this one out by asking other people
        String retVal = "";
        boolean done = false;

        do
        {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();

            if (retVal.matches(pattern))
            {
                done = true;
            }
            else
            {
                System.out.println("You did not match the pattern");
            }
        }while (!done);
        return retVal;
    }
}
