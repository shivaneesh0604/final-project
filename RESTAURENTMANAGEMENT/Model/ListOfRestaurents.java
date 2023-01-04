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

    void addRestaurent(Restaurent restaurent) {
        restaurents.add(restaurent);
    }

    public void showRestaurents() {
        for (Restaurent restaurent : restaurents) {
            System.out.println(restaurent.getRestaurentName());
        }
    }

    public Restaurent getRestaurents(int restaurentID) {
        for (Restaurent restaurent : restaurents) {
            if (restaurent.getRestaurentID() == restaurentID) {
                return restaurent;
            }
        }
        return null;
    }
}
