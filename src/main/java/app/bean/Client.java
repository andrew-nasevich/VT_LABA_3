package app.bean;

public class Client {

    private int id;
    private String name;
    private String birthday;
    private String medicalHistory;

    public Client(){}

    public Client(int id, String name, String birthday, String medicalHistory)
    {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.medicalHistory = medicalHistory;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Client that = (Client) o;

        return that.birthday == birthday && that.name == name;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * birthday.hashCode() * 11;
    }

    //Переопределенный метод toString()
    @Override
    public String toString() {
        return "Human{" +
                "name = '" + name + ", " +
                "birthday = " + birthday + '}';
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
