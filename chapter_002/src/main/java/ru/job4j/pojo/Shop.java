package ru.job4j.pojo;

public class Shop {

    public static void main(String[] args) {
        Product products[] = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. тк у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();
        System.out.println("Удаляем значение из ячейки с индексом 1");
        //удаляем значение из ячейки с индексом 1
        products[1] = null;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. тк у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();
        System.out.println("Записываем  в ячейку с индексом 1 значение ячейки с индексом 2 и удаляем значение из ячейки с индексом 2");
        //записываем в ячейку с индексом 1 значение ячейки с индексом 2.
        products[1] = products[2];
        //удаляем значение из ячейки с индексом 2.
        products[2] = null;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. так как  у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();
        products[2] = new Product("Bread", 2);
        products[3] = new Product("Bread", 3);
        products[4] = new Product("Bread", 4);
        for (Product product: products) {
            if (product != null) {
                System.out.println(product.getName() + ", count: " + product.getCount());
            } else {
                System.out.println("null");
            }
        };

        System.out.println("\nDelete method: ");
        delete(products, 1);
        delete(products, 2);
        for (Product product: products) {
            if (product != null) {
                System.out.println(product.getName() + ", count: " + product.getCount());
            } else {
                System.out.println("null");
            }
        };
    }

    public static Product[] delete(Product[] products, int index){
        for (int i = index; i < products.length - 1; i++){
            Product temp = products[i + 1];
            products[i] = temp;
        }
        products[products.length - 1] = null;
        return products;
    };

}
