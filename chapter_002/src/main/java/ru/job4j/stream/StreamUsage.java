package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static class Task {

        private final String name;
        private final Long spent;


        public Task(String name, Long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", spent='" + spent + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        List<Task> tasks = List.of(
                new Task("Bug #1", 100L),
                new Task("Task #2", 100L),
                new Task("Bug #3", 100L)
        );

        // Фильтрация
        // отфильтровать все задачи, где в имени есть слово Bug и сохранить в коллекцию List
        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);

        // аналог
        List<Task> containerBugs = new ArrayList<>();
        for (Task task : tasks) {
            if ("Bug".equals(task.name)) {
                containerBugs.add(task);
            }
        }

        // Преобразование
        // получить только имена задач - use method map
        List<String> names = tasks.stream().map(
                task -> task.name
        ).collect(Collectors.toList());
        names.forEach(System.out::println);

        // аналог
        List<String> containerNames = new ArrayList<>();
        for (Task task : tasks) {
            containerNames.add(task.name);
        }

        // Упрощение
        // посчитать общую сумму, потраченную на все задачи
        long total = tasks.stream().map(
                task -> task.spent
        ).reduce(0L, Long::sum);
        System.out.println(total);

        // аналог
        total = 0L;
        for (Task task : tasks) {
            total += task.spent;
        }
    }

}
