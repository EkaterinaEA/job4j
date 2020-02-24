package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    private static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(u -> u.getAddress()).collect(Collectors.toList());
    }

    public static List<Address> collectDistinctSortedByCity(List<Profile> profiles) {
        return collect(profiles).stream().sorted(new AddressAscendingByCity()).distinct().collect(Collectors.toList());
    }

}
