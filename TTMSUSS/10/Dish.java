public class Dish {

    private String name;
    private String type;
    private int price;
    private String recipe;

    public Dish(String name, String type, int price, String recipe) {
        this.name = name;
        this.type = type;
        this.recipe = recipe;
        if (!(price > 0)) {
            throw new IllegalArgumentException("Price must be positive");
        }
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", recipe='" + recipe + '\'' +
                '}';
    }
}
