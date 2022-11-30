import java.util.ArrayList;
import java.util.Scanner;
public class Main
{
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        final String menu = "A - add D - delete P - print Q - quit";
        boolean done = false;
        boolean aDone = false;
        boolean dDone = false;
        boolean quit = false;

        int deleteItem = 0;
        int addnum = 0;

        String cmd = "";
        String item = "";

        do {
            //display the menu
            //display the menu options
            //get a menu choice
            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            //execute the choice
            switch (cmd)
            {
                case "A":
                    do
                    {
                        aDone = false;
                        dispalayList();
                        item = SafeInput.getNonZeroLenString(in, "What item would you like to input? ");
                        if (list.size() > 0)
                        {
                            addnum = SafeInput.getRangedInt(in, "Where would you like to in put it?", 1, (list.size() + 1));
                            addnum--;
                            list.add(addnum, item);
                        }
                        else
                            list.add(item);
                        aDone = SafeInput.getYNConfirm(in, "Are you done with adding?");
                    }while (!aDone);
                    break;
                case "D":
                    do
                    {
                        dDone = false;
                        dispalayList();
                        deleteItem = SafeInput.getRangedInt(in, "What is the number of the item you would like to delete ", 1, list.size());
                        deleteItem --;
                        list.remove(deleteItem);
                        dDone = SafeInput.getYNConfirm(in, "Are you done with deleting?");
                    }while (!dDone);
                    break;
                case "P":
                    dispalayList();
                    break;
                case "Q":
                    quit = false;
                    quit = SafeInput.getYNConfirm(in, "Are you sure that you want to quit?");
                    if (quit == true)
                    {
                        System.exit(0);
                    }
                    break;
            }
        }while(!done);
    }

    private static void dispalayList()
    {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        if (list.size() !=0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d%35s", i + 1, list.get(i));
                System.out.println();
            }
        }
        else System.out.println("+++                LIST IS EMPTY!                +++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}