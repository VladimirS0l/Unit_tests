package seminars.first.hw;

import java.util.*;

public class Shop implements Iterable<Product>{
    private List<Product> products;

    public Shop() {
        products = new ArrayList<>();
    }

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        products.sort(new ComporatorShopForCost());
        return products;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        products.sort(new ComporatorShopForCost());
        return products.get(0);
    }

    public void addBox(Product p1){
        products.add(p1);
    }

    @Override
    public Iterator iterator() {
        return products.iterator();
    }
}