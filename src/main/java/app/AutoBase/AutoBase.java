package app.AutoBase;

import java.util.ArrayList;

/**
 * The type Auto base.
 */
public class AutoBase implements java.io.Serializable{

    private static User currentUser;
    private static ArrayList<Vehicle> carList;
    private static ArrayList<User> users;
    private static ArrayList<Purchase> purchases;

    /**
     * Gets purchases.
     *
     * @return the purchases
     */
    public static ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    /**
     * Sets purchases.
     *
     * @param purchases the purchases
     */
    public static void setPurchases(ArrayList<Purchase> purchases) {
        AutoBase.purchases = purchases;
    }


    /**
     * Gets current user.
     *
     * @return the current user
     */
    public static User getCurrentUser() {
        return currentUser;
    }


    /**
     * Gets car list.
     *
     * @return the car list
     */
    public static ArrayList<Vehicle> getCarList() {
        return carList;
    }

    /**
     * Sets car list.
     *
     * @param carList the car list
     */
    public static void setCarList(ArrayList<Vehicle> carList) {
        AutoBase.carList = carList;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public static ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public static void setUsers(ArrayList<User> users) {
        AutoBase.users = users;
    }

    /**
     * Instantiates a new Auto base.
     */
    public AutoBase() {
    }
}
