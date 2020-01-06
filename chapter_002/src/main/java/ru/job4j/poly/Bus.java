package ru.job4j.poly;

public class Bus implements Transport {

    private int passengers = 0;
    private int station = 0;

    @Override
    public void ride() {
        station++;
    }

    @Override
    public void passengers(int passengers) {
        this.passengers += passengers;
    }

    @Override
    public double refuel(int gasoline) {
        return gasoline * 50;
    }
}
