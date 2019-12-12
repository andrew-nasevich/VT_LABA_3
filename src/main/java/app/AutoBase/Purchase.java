package app.AutoBase;


/**
 * The type Purchase.
 */
public class Purchase implements java.io.Serializable{

    private User customer;
    private Vehicle vehicle;

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
     * Gets vehicle.
     *
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Sets vehicle.
     *
     * @param vehicle the vehicle
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return  "\n Vehicle:" + vehicle.toString() +
                "\n Customer: " + customer.getName();
    }

}
