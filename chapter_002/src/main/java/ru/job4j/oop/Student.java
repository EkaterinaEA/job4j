package ru.job4j.oop;

public class Student {

    public void music(String lyrics) {
        System.out.println("I can sign a song : " + lyrics);
    }

    public void song() {
        System.out.println("I believe I can fly");
    }

    public void playAccordion() {
        System.out.println("Accordion Music");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        String song = "I believe, I can fly";
        petya.music(song);
        Jukebox jukebox = new Jukebox();
        jukebox.music(1);
        jukebox.music(2);
        jukebox.music(8745);
    }

}
