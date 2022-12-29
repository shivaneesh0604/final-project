package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;

public class ListOfRestaurents {
    private final ArrayList<Restaurent> restaurents = new ArrayList<>();

    private ListOfRestaurents() {

    }

    private static ListOfRestaurents listOfRestaurents = null;

    public static ListOfRestaurents getInstance() {
        if (listOfRestaurents == null) {
            listOfRestaurents = new ListOfRestaurents();
        }
        return listOfRestaurents;
    }

    public void addRestaurent(Restaurent restaurent) {
        restaurents.add(restaurent);
    }

    public ArrayList<Restaurent> getRestaurents() {
        return restaurents;
    }
}
