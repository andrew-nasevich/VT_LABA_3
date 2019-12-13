package app.Hotel;


/**
 * The type Room.
 */
public class Room implements java.io.Serializable{

    private String name;
    private String surname;
    private double price;
    private double sale;
    private int number;
    private int countOfRoom;
    private ViewType viewType;
    private User manager;

    /**
     * Gets manager.
     *
     * @return the manager
     */
    public User getManager() {
        return manager;
    }

    /**
     * Sets manager.
     *
     * @param manager the manager
     */
    public void setManager(User manager) {
        this.manager = manager;
    }

    /**
     * Instantiates a new Room.
     *
     * @param _name            the name
     * @param _surname           the surname
     * @param _price           the price
     * @param _sale the fuel consumption
     * @param _number           the number
     * @param _countOfRoom            the countOfRoom
     * @param _viewType        the fuel type
     */
    public Room(String _name, String _surname, double _price, double _sale,
                int _number, int _countOfRoom, ViewType _viewType){
        name = _name;
        surname = _surname;
        price = _price;
        sale =_sale;
        number = _number;
        countOfRoom = _countOfRoom;
        viewType = _viewType;
    }

    /**
     * Instantiates a new Room.
     */
    public Room() {
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets surname.
     *
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets surname.
     *
     * @param surname the surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets fuel consumption.
     *
     * @return the fuel consumption
     */
    public double getSale() {
        return sale;
    }

    /**
     * Sets fuel consumption.
     *
     * @param sale the fuel consumption
     */
    public void setSale(double sale) {
        this.sale = sale;
    }

    /**
     * Gets number.
     *
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets number.
     *
     * @param number the number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Gets countOfRoom.
     *
     * @return the countOfRoom
     */
    public int getCountOfRoom() {
        return countOfRoom;
    }

    /**
     * Sets countOfRoom.
     *
     * @param countOfRoom the countOfRoom
     */
    public void setCountOfRoom(int countOfRoom) {
        this.countOfRoom = countOfRoom;
    }

    /**
     * Gets fuel type.
     *
     * @return the fuel type
     */
    public ViewType getViewType() {
        return viewType;
    }

    /**
     * Sets fuel type.
     *
     * @param viewType the fuel type
     */
    public void setViewType(ViewType viewType) {
        this.viewType = viewType;
    }

    @Override
    public String toString() {
        return  "\n  Name: " + name +
                "\n  Surname: " + surname +
                "\n  Price: "+ price +
                "\n  Sale: "+ sale +
                "\n  Number: "+ number +
                "\n  CountOfRoom: "+ countOfRoom +
                "\n  Feul Type: "+ viewType.toString();
    }
}