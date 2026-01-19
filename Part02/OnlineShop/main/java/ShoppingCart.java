import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void add(String product, int price) {
        if (this.items.containsKey(product)) {
            Item itemExistente = this.items.get(product);
            itemExistente.increaseQuantity();
        } else {
            Item nuevoItem = new Item(product, 1, price);
            this.items.put(product, nuevoItem);
        }
    }

    public int price() {
        int totalPrice = 0;
        for (Item item : this.items.values()) {
            totalPrice += item.price();
        }

        return totalPrice;
    }

    public void print() {
        for (Item item : this.items.values()) {
            System.out.println(item);
        }
    }

    
}
