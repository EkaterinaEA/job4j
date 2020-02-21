package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {

    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(u -> u.address).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Profile> profiles = List.of(
                new Profile(new Address("New-York", "First Street", 10, 48)),
                new Profile(new Address("Boston", "Second Street", 106, 48))
        );

        List<Address> addresses = collect(profiles);
        addresses.stream().forEach(System.out::println);

    }

}