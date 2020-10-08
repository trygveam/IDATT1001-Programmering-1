import java.util.ArrayList;

public class Menu {
    ArrayList<Dish> dishes = new ArrayList<>();

    public void addDishToMenu(Dish dish) {
        if (!dishes.contains(dish)) {
            dishes.add(dish);
        } else {
            throw new IllegalArgumentException("Dish already in menu");
        }
    }

    public void removeDishToMenu(Dish dish) {
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
