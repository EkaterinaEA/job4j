package ru.job4j.oop;

public class Student {

    public void music() {
        System.out.println("Tra tra tra");
    }

    public void song() {
        System.out.println("I believe I can fly");
    }

    public void playAccordion() {
        System.out.println("Accordion Music");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.playAccordion();
        petya.playAccordion();
        petya.playAccordion();
        petya.song();
        petya.song();
        petya.song();
    }

}
