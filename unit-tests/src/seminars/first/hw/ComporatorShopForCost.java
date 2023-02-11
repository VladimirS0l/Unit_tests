package seminars.first.hw;

import java.util.Comparator;

public class ComporatorShopForCost implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o2.getCost(), o1.getCost());
    }
}
