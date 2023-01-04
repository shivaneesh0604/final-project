package RESTAURENTMANAGEMENT.Model;

public abstract class User {
    private final String name;
    private final int ID;

    public User(String name, int iD) {
        this.name = name;
        this.ID = iD;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

}
