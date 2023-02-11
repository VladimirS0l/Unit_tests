package seminars.first.hw;

import seminars.first.model.Calculator;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {

    /*
     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    */

    public static void main(String[] args) {
        Product milk = new Product(60, "Молоко");
        Product meat = new Product(700, "Мясо");
        Product fish = new Product(800, "Рыба");
        Product bread = new Product(10, "Хлеб");
        Product water = new Product(35, "Вода");

        Shop box1 = new Shop();
        box1.addBox(milk);
        box1.addBox(meat);
        box1.addBox(fish);
        box1.addBox(bread);

        System.out.println("Неотсортированный список");
        for (Product p1: box1) {
            if (box1.equals(p1)){
                System.out.println(p1);
            }else {
                assert false: "Товара " + p1 + "не существует";
            }
        }

        System.out.println("Отсортированный список");
        box1.getSortedListProducts();
        for (Product p1: box1) {
            if (box1.equals(p1)){
                System.out.println(p1);
            }else {
                assert false: "Товара " + p1 + "не существует";
            }
        }

        System.out.println("Самый дорогой продукт");
        System.out.println(box1.getMostExpensiveProduct());

        assertThat(box1).containsSequence(milk);
        assertThat(box1).containsSequence(meat);
        assertThat(box1).containsSequence(fish);
        assertThat(box1).containsSequence(bread);
        //Для примера с ошибкой
        //assertThat(box1).containsSequence(water);

        //Все продукты не стал перебирать
        assertThat(water.getTitle()).contains("Вода");
        assertThat(water.getCost()).isEqualTo(35);

        assertThat(fish.getTitle())
                .isNotEmpty()
                .contains("Рыба")
                .hasSize(4);

        assertThat(box1.getProducts())
                .contains(milk, meat, bread, fish)
                .isNotEmpty()
                .hasSize(4);
    }
}




