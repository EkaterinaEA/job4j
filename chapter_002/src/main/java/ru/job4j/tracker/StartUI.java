package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAll(Tracker tracker) {
        System.out.println("=== Show all Items ====");
        Item[] resultList = tracker.findAll();
        if (resultList.length == 0) {
            System.out.println("Not found");
        } else {
            for (Item show : resultList) {
                System.out.println("Item ID: " + show.getId() + ", Item name: " + show.getName());
            }
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String id = input.askStr("Enter ID: ");
        String editName = input.askStr("Enter new name: ");
        Item editItem = new Item(editName);
        boolean edit = tracker.replace(id, editItem);
        if (edit) {
            System.out.println("Item modified");
        } else {
            System.out.println("ID not found");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String deleteId = input.askStr("Enter ID: ");
        boolean delete = tracker.delete(deleteId);
        if (delete) {
            System.out.println("Item deleted");
        } else {
            System.out.println("ID not found");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        String findId = input.askStr("Enter ID: ");
        Item foundById = tracker.findById(findId);
        if (foundById != null) {
            System.out.println("Item ID: " + foundById.getId() + ", Item name: " + foundById.getName());
        } else {
            System.out.println("Not found");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String findName = input.askStr("Enter name: ");
        Item[] foundByName = tracker.findByName(findName);
        if (foundByName != null) {
            for (Item found : foundByName) {
                System.out.println("Item ID: " + found.getId() + ", Item name: " + found.getName());
            }
        } else {
            System.out.println("Not found");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            switch (select) {
                case (0):
                    StartUI.createItem(input, tracker);
                    break;
                case (1):
                    StartUI.showAll(tracker);
                    break;
                case (2):
                    StartUI.replaceItem(input, tracker);
                    break;
                case (3):
                    StartUI.deleteItem(input, tracker);
                    break;
                case (4):
                    StartUI.findById(input, tracker);
                    break;
                case (5):
                    StartUI.findByName(input, tracker);
                    break;
                case (6):
                    System.out.println("=== Exit Program ====");
                    run = false;
                    break;
                default:
                    run = false;
                    break;
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

}
