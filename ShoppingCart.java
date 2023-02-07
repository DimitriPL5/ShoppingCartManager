package domain;
import java.util.ArrayList;
/**
 * Contains all variables and setter/getter functions for the ShoppingCart class.
 * Constructor initialized variables based on user input.
 */
public class ShoppingCart {

    private String customerName;
    private String currentDate;
    private ArrayList cartItems;

    public ShoppingCart() {
        customerName = "none";
        currentDate = "January 1st, 2022";
        cartItems = new ArrayList<ItemToPurchase>();
    }

    public ShoppingCart(String customerName, String currentDate){
        this.customerName = customerName;
        this.currentDate = currentDate;
        cartItems = new ArrayList<ItemToPurchase>();
    }

    public String getCustomerName(){
        return customerName;
    }

    public String getCurrentDate(){
        return currentDate;
    }

    /**
     * Description: User wants to add an item to the cart.
     * Precondition: The user has started the program and selected the add item menu option.
     * Postcondition: User's item is added to the cartItems ArrayList..
     */
    public void addItem(ItemToPurchase anItem){
        cartItems.add(anItem);
    }

    /**
     * Description: User wants to remove an item to the cart.
     * Precondition: The user has started the program and selected the remove item menu option.
     * Postcondition: User's item is removed from the cartItems ArrayList..
     */
    public void removeItem(String itemName){
        int removed = 0;
        for(int i = 0; i < cartItems.size(); i++){
            ItemToPurchase dummyCart = (ItemToPurchase) cartItems.get(i);
            if(dummyCart.getItemName().equals(itemName)){
                cartItems.remove(i);
                removed = 1;
            }
        }
        if(removed == 0){
            System.out.println("Item not found in cart. Nothing removed.");
        }
    }

    /**
     * Description: User wants to modify an item to the cart.
     * Precondition: The user has started the program and selected the change quantity menu option.
     * Postcondition: User's item quantity is changed in the cartItems ArrayList.
     */
    public void modifyItem(ItemToPurchase anItem){
        int modified = 0;
        for(int i = 0; i < cartItems.size(); i++){
            ItemToPurchase dummyCart = (ItemToPurchase) cartItems.get(i);
            anItem.setItemPrice(dummyCart.getItemPrice());
            anItem.setItemDescription(dummyCart.getItemDescription());
            if(dummyCart.getItemName().equals(anItem.getItemName())){
                cartItems.set(i, anItem);
                modified = 1;
            }
        }
        if(modified == 0){
            System.out.println("Item not found in cart. Nothing modified.");
        }
    }

    /**
     * Description: Returns the amount of items in the shopping cart.
     * Precondition: The user has started the program and has selected the output shopping cart menu option.
     * Postcondition: Number of items in shopping cart is returned.
     */
    public int getNumItemsInCart(){
        int numItems = cartItems.size();

        if(numItems == 0){
            System.out.println("SHOPPING CART IS EMPTY.");
        }
        return numItems;
    }

    /**
     * Description: Figures out the cost of the cart total.
     * Precondition: The user has started the program and selected output shopping cart menu option.
     * Postcondition: Shopping cart cost is returned.
     */
    public double getCostOfCart(){
        double cost = 0;
        for(int i = 0; i < cartItems.size(); i++){
            ItemToPurchase anItem = (ItemToPurchase) cartItems.get(i);
            cost += (anItem.getItemPrice() * anItem.getItemQuantity()) ;
        }
        return cost;
    }

    /**
     * Description: Displays the cost of each item and the cart total.
     * Precondition: The user has started the program and selected output shopping cart menu option.
     * Postcondition: Shopping cart cost is displayed to the user.
     */
    public void printTotal(){
        System.out.println(customerName + "'s Shopping Cart - " + currentDate);
        System.out.println("Number of items: " + getNumItemsInCart());

        for(int i = 0; i < cartItems.size(); i++){
            ItemToPurchase anItem = (ItemToPurchase) cartItems.get(i);
            anItem.printItemCosts();
        }
        System.out.printf("Total: $%.2f \n", getCostOfCart());
    }

    /**
     * Description: Displays user's shopping cart item descriptions.
     * Precondition: The user has started the program and would like to view the item descriptions.
     * Postcondition: Item descriptions are displayed to the user.
     */
    public void printDescriptions(){
        System.out.println(customerName + "'s Shopping Cart - " + currentDate);
        System.out.println("\n Item Descriptions: ");

        for(int i = 0; i < cartItems.size(); i++) {
            ItemToPurchase anItem = (ItemToPurchase) cartItems.get(i);
            anItem.printItemDescription();
        }
    }
}
