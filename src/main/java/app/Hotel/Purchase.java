package app.Hotel;


/**
 * The type Purchase.
 */
public class Purchase implements java.io.Serializable{

    private User customer;
    private Room room;

    /**
     * Instantiates a new Purchase.
     */
    public Purchase() {
    }

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public User getCustomer() {
        return customer;
    }

    /**
     * Sets customer.
     *
     * @param customer the customer
     */
    public void setCustomer(User customer) {
        this.customer = customer;
    }

    /**
     * Gets room.
     *
     * @return the room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Sets room.
     *
     * @param room the room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return  "\n Room:" + room.toString() +
                "\n Customer: " + customer.getName();
    }

}
