package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Order> history =new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        // Створення категорій
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");
        // Створення об'єктів класу Product з вказівкою категорії
        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном…", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);
        Cart cart = new Cart();
        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Переглянути кошик");
            System.out.println("4 - Зробити замовлення");
            System.out.println("5 - Видалити товар з кошика");
            System.out.println("6 - Пошук");
            System.out.println("7 - Історія замовлень");
            System.out.println("0 - Вийти");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();
                    // Проста логіка додавання, для прикладу використаємо ID для вибору
                    if (id == 1) cart.addProduct(product1);
                    else if (id == 2) cart.addProduct(product2);
                    else if (id == 3) cart.addProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 3:
                    System.out.println(cart);
                    break;
                case 4:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        history.add(order);
                        cart.clear(); // Метод для очищення кошика, який потрібно реалізувати в класі Cart
                    }
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Введіть ID видалення до кошика:");
                    id = scanner.nextInt();
                    if (id == 1) cart.removeProduct(product1);
                    else if (id == 2) cart.removeProduct(product2);
                    else if (id == 3) cart.removeProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 6:
                    scanner.nextLine();
                    System.out.println("Введіть назву або категорію товару:");
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase(product1.getName())||input.equalsIgnoreCase(product1.getCategory().getName())) System.out.println(product1) ;
                    else if (input.equalsIgnoreCase(product2.getName())||input.equalsIgnoreCase(product2.getCategory().getName())) System.out.println(product2) ;
                    else if (input.equalsIgnoreCase(product3.getName())||input.equalsIgnoreCase(product3.getCategory().getName())) System.out.println(product3) ;
                    else System.out.println("Товар з такою назвою чи категорією не знайдено");
                    break;
                case 7:
                    System.out.println("Історія замовлень:");
                    System.out.println(history);
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;


            }
        }

    }
}
