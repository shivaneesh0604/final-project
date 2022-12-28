package RESTAURENTMANAGEMENT.MenuList;

public class Item {

    private final String foodName;
    private int price;
    private final Dietery dietery;
    private final Course course;
    private Timing timing;

    public Item(String foodName, int price,Dietery dietery,Course course,Timing timing) {
        this.foodName = foodName;
        this.price = price;
        this.dietery=dietery;
        this.course=course;
        this.timing = timing;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Dietery getDietery() {
        return dietery;
    }

    public Course getCourse() {
        return course;
    }

    public Timing getTiming() {
        return timing;
    }

    public void setTiming(Timing timing) {
        this.timing = timing;
    }

}
