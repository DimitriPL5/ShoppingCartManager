package domain;
/**
 * Contains all variables and setter/getter functions for the ItemsToPurchase class.
 * Constructor initialized variables based on user input.
 */
public class ItemToPurchase {
    private String itemName;
    private double itemPrice;
    private int itemQuantity;
    private String itemDescription;

    public ItemToPurchase(String itemName, double itemPrice, int itemQuantity, String itemDescription) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemDescription = itemDescription;
    }

    public ItemToPurchase()
    {
        this.itemName = "none";
        this.itemPrice = 0.00;
        this.itemQuantity = 0;
        this.itemDescription = "none";
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public double getItemPrice(){
        return itemPrice;
    }

    public void setItemPrice(double itemPrice){
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity(){
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity){
        this.itemQuantity = itemQuantity;
    }

    public String getItemDescription(){
        return itemDescription;
    }

    public void setItemDescription(String itemDescription){
        this.itemDescription = itemDescription;
    }

    /**
     * Description:  Prints the cost of an item.
     * Precondition: The user has begun to modify their shopping cart.
     * Postcondition: The name and cost of an item is displayed.
     */
    public void printItemCosts(){
        System.out.printf(itemName + " " + itemQuantity + " $%.2f = $%.2f \n", itemPrice, (itemPrice * itemQuantity));
    }

    /**
     * Description: Prints out the description of a shopping cart item.
     * Precondition: The user has started the program and selected the menu option to view descriptions.
     * Postcondition: Item description is displayed to the user.
     */
    public void printItemDescription(){
        System.out.println(itemName + ": " + itemDescription);
    }

}

