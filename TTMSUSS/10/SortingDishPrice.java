import java.util.Comparator;

public class SortingDishPrice implements Comparator<Dish> {
    @Override
    public int compare(Dish o1, Dish o2) {
        return o1.getPrice()-o2.getPrice();
    }
}
