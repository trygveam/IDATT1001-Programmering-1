import java.util.ArrayList;

public class Menu {

    private String name;
    ArrayList<Dish> dishes = new ArrayList<>();

    public Menu(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void addDishToMenu(Dish dish) {
        if (!dishes.contains(dish)) {
            dishes.add(dish);
        } else {
            throw new IllegalArgumentException("Dish already in menu");
        }
    }

    public void removeDishFromMenu(Dish dish) {
        if (dishes.contains(dish)) {
            dishes.remove(dish);
        } else {
            throw new IllegalArgumentException("Dish not in menu");
        }
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public int calculatePrice() {
        return dishes.stream().mapToInt(a -> a.getPrice()).sum();
    }


}
