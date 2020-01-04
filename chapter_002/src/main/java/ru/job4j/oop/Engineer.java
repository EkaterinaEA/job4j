package ru.job4j.oop;

public class Engineer extends Profession {

    private String specialization;

    public Project work(Task task) {
        return task.projectLogic();
    }

}
