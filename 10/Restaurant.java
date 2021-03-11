import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Restaurant{
    ArrayList<Dish> dishes = new ArrayList<>();
    ArrayList<Menu> menus = new ArrayList<>();

    public void addDish(Dish dish) {
        if (!(dishes.contains(dish))) {

            dishes.add(dish);
        } else {
            throw new IllegalArgumentException("Already in");
        }
    }
    public void removeDish(Dish dish){
        if(dishes.contains(dish)){
            dishes.remove(dish);
        }
        else{
            throw new IllegalArgumentException("Not in dishes");
        }
    }

    public void addMenu(Menu menu) {
        if (!(menus.contains(menu))) {
            menus.add(menu);
        } else {
            throw new IllegalArgumentException("Already in");
        }
    }
    public void removeMenu(Menu menu){
        if(menus.contains(menu)){
            menus.remove(menu);
        }
        else{
            throw new IllegalArgumentException("Not in menus");
        }
    }

    public Menu findMenuWithName(String name){
        for(Menu m: menus){
            if(m.getName().equals(name)) {
                return m;
            }
        }return null;
    }

    public Dish findDishWithName(String name) {
        return dishes.stream().filter(a -> a.getName().equals(name)).findAny().orElse(null);
    }

    public ArrayList<Dish> findAllType(String type) {
        return dishes.stream().filter(a -> a.getType().equals(type)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Menu> findMenusInPriceRange(int lowerLimit, int upperLimit) {
        return menus.stream().filter(a -> a.calculatePrice() >= lowerLimit && a.calculatePrice() <= upperLimit).collect(Collectors.toCollection(ArrayList::new));
    }

    public void sortDishesPrice(){
        dishes.sort(new SortingDishPrice());
    }


    // Test Code
    public static void main(String[] args) {
        Restaurant r1 = new Restaurant();
        Dish d1 = new Dish("cod", "starter", 120, "");
        Dish d2 = new Dish("meat", "main", 109, "");
        Dish d3 = new Dish("ice-cream", "dessert", 100, "");
        Dish d4 = new Dish("fruit", "dessert", 115, "");
        r1.addDish(d1);
        r1.addDish(d2);
        r1.addDish(d3);
        r1.addDish(d4);
        Menu m1 = new Menu("Kids-menu");
        m1.addDishToMenu(d1);
        m1.addDishToMenu(d2);
        m1.addDishToMenu(d3);
        r1.addMenu(m1);
        System.out.println(r1.findDishWithName("cod"));
        System.out.println(r1.findAllType("dessert"));
        System.out.println(r1.findMenusInPriceRange(100,500));
        r1.sortDishesPrice();
        System.out.println(r1.dishes);

    }
}
