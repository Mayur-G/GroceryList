import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit)
        {
            System.out.println("Enter your choice :");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
                    break;

            }
        }
    }

    public static void printInstructions()
    {
        System.out.println("\n press");
        System.out.println("\t 0 - to print choice options. ");
        System.out.println("\t 1 - to print the list of Grocery Items ");
        System.out.println("\t 2 - to add an item to the list ");
        System.out.println("\t 3 - to modify an item to the list ");
        System.out.println("\t 4 - to remove an item to the list ");
        System.out.println("\t 5 - to search an item to the list ");
        System.out.println("\t 6 - to process all item from the list ");
        System.out.println("\t 7 - to quit the application ");

    }

    public static void addItem()
    {
        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem()
    {
        System.out.print("Enter item name :");
        String itemNo  = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter new item :");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo,newItem);
    }

    public static void removeItem()
    {
        System.out.print("Enter item name :");
        String itemNo = scanner.nextLine();
        scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }

    public static void searchForItem() {
        System.out.print("item to search for :");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem))
        {
            System.out.println("Found "+searchItem+" in our grocery list");
        }
        else
        {
            System.out.println(searchItem+" is not in the grocery list");
        }
    }

    public static void processArrayList()
    {
        //method 1
        ArrayList<String> newArray = new ArrayList<>();
        newArray.addAll(groceryList.getGroceryList());
        System.out.println(newArray);

        //method 2
        ArrayList<String> nextArray = new ArrayList<>(groceryList.getGroceryList());

        //method 3
        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }
}
