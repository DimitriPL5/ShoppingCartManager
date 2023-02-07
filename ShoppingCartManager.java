package controller;
import domain.ItemToPurchase;
import domain.ShoppingCart;
import java.util.Scanner;
/**
 * Description: Creates an ArrayList containing shopping cart variables, and allows user to add, remove, or modify items in their cart.
 */

public class ShoppingCartManager {

    /**
     * Description: Asks user for their information and allows user to go through menu options.
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String customerName;
        String todaysDate;
        char menuChoice = ' ';

        System.out.println("Enter Customer's Name:");
        customerName = scnr.nextLine();

        System.out.println("Enter Today's Date:");
        todaysDate = scnr.nextLine();

        System.out.println("\nCustomer Name: " + customerName);
        System.out.println("Today's Date: " + todaysDate);
        System.out.println("");

        ShoppingCart myCart = new ShoppingCart(customerName, todaysDate);

        printMenu();

        while(menuChoice != 'q') {
            System.out.println("Choose an option:");
            menuChoice = scnr.next().charAt(0);
            executeMenu(menuChoice, myCart, scnr);
            printMenu();
        }
        System.out.println("Thanks for shopping with us.  Please come again.");
    }

    /**
     * Description: Prints out all the menu options that the user can select.
     * Precondition: The user has started the program.
     * Postcondition: The menu options are displayed to the user.
     */
    public static void printMenu() {
        System.out.println("MENU");
        System.out.println("a - Add item to cart");
        System.out.println("d - Remove item from cart");
        System.out.println("c - Change item quantity");
        System.out.println("i - Output items' descriptions");
        System.out.println("o - Output shopping cart");
        System.out.println( "q - Quit");
        System.out.println("");
    }

    /**
     * Description: Uses the user's menu option choice in order to add,remove,or modify the shopping cart. Can also print item descriptions or display the entire cart.
     * Precondition: The user has started the program and selected a menu option.
     * Postcondition: The shopping cart is changed the way the user wants, or item description/cart description has been displayed.
     */
    public static void executeMenu(char option, ShoppingCart theCart, Scanner scnr) {
        String productName;
        String productDescription;
        double productPrice = 0;
        int productQuantity = 0;

        switch (option) {
            case 'a':
                scnr.nextLine();
                System.out.println("ADD ITEM TO CART");
                System.out.println("Enter the item name:");
                productName = scnr.nextLine();

                System.out.println("Enter the item description:");
                productDescription = scnr.nextLine();

                System.out.println("Enter the item price:");
                productPrice= scnr.nextDouble();

                System.out.println("Enter the item quantity:");
                productQuantity = scnr.nextInt();

                ItemToPurchase newItem = new ItemToPurchase(productName, productPrice, productQuantity, productDescription);
                theCart.addItem(newItem);

                System.out.println("");
                break;

            case 'd':
                scnr.nextLine();

                System.out.println("REMOVE ITEM FROM CART");
                System.out.println("Enter name of item to remove:");
                productName = scnr.nextLine();

                theCart.removeItem(productName);
                System.out.println("");
                break;

            case 'c':
                scnr.nextLine();

                System.out.println("CHANGE ITEM QUANTITY");
                System.out.println("Enter the item name:");
                productName = scnr.nextLine();

                System.out.println("Enter the new quantity:");
                productQuantity = scnr.nextInt();

                ItemToPurchase modItem = new ItemToPurchase();
                modItem.setItemName(productName);
                modItem.setItemQuantity(productQuantity);

                theCart.modifyItem(modItem);
                System.out.println("");
                break;

            case 'i':
                System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
                theCart.printDescriptions();
                System.out.println("");
                break;

            case 'o':
                System.out.println("OUTPUT SHOPPING CART");
                theCart.printTotal();
                System.out.println("");
                break;
        }

    }



}
