package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            switch (select) {
                case (0):
                    System.out.println("=== Create a new Item ====");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item item = new Item(name);
                    tracker.add(item);
                    System.out.println("Item created");
                    break;
                case (1):
                    System.out.println("=== Show all Items ====");
                    Item[] resultList = tracker.findAll();
                    if (resultList.length == 0) {
                        System.out.println("Not found");
                    } else {
                        for (Item show : resultList) {
                            System.out.println("Item ID: " + show.getId() + ", Item name: " + show.getName());
                        }
                    }
                    break;
                case (2):
                    System.out.println("=== Edit item ====");
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String editName = scanner.nextLine();
                    Item editItem = new Item(editName);
                    boolean edit = tracker.replace(id, editItem);
                    if (edit) {
                        System.out.println("Item modified");
                    } else {
                        System.out.println("ID not found");
                    }
                    break;
                case (3):
                    System.out.println("=== Delete item ====");
                    System.out.print("Enter ID: ");
                    String deleteId = scanner.nextLine();
                    boolean delete = tracker.delete(deleteId);
                    if (delete) {
                        System.out.println("Item deleted");
                    } else {
                        System.out.println("ID not found");
                    }
                    break;
                case (4):
                    System.out.println("=== Find item by Id ====");
                    System.out.print("Enter ID: ");
                    String findId = scanner.nextLine();
                    Item foundById = tracker.findById(findId);
                    if (foundById != null) {
                        System.out.println("Item ID: " + foundById.getId() + ", Item name: " + foundById.getName());
                    } else System.out.println("Not found");
                    break;
                case (5):
                    System.out.println("=== Find items by name ====");
                    System.out.print("Enter name: ");
                    String findName = scanner.nextLine();
                    Item[] foundByName = tracker.findByName(findName);
                    if (foundByName != null) {
                        for (Item found : foundByName) {
                            System.out.println("Item ID: " + found.getId() + ", Item name: " + found.getName());
                        }
                    } else System.out.println("Not found");
                    break;
                case (6):
                    System.out.println("=== Exit Program ====");
                    run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.\n");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

}
