package app.Hotel;

import java.util.ArrayList;

public class Hotel implements java.io.Serializable{

    private static User currentUser;
    private static ArrayList<Room> list;
    private static ArrayList<User> users;
    private static ArrayList<Purchase> purchases;


    public static ArrayList<Purchase> getPurchases() {
        return purchases;
    }


    public static void setPurchases(ArrayList<Purchase> purchases) {
        Hotel.purchases = purchases;
    }


    public static User getCurrentUser() {
        return currentUser;
    }


    public static ArrayList<Room> getList() {
        return list;
    }

    public static void setList(ArrayList<Room> carList) {
        Hotel.list = list;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        Hotel.users = users;
    }

    public Hotel() {
    }
}
