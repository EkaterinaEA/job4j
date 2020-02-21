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

    public static List<Address> collectDistinctSortedByCity(List<Profile> profiles) {
        return collect(profiles).stream().sorted(new AddressAscendingByCity()).distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {

        Address address1 = new Address("New-York", "First Street", 10, 48);
        Address address2 = new Address("Boston", "Second Street", 106, 48);


        List<Profile> profiles = List.of(
                new Profile(address2),
                new Profile(address1),
                new Profile(address2),
                new Profile(address1)
        );

        List<Address> addresses = collect(profiles);
        addresses.stream().forEach(System.out::println);

        List<Address> addressesDistinctSortedByCity = collectDistinctSortedByCity(profiles);
        addressesDistinctSortedByCity.stream().forEach(System.out::println);
    }

}