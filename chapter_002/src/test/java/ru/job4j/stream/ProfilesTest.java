package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static ru.job4j.stream.Profiles.collectDistinctSortedByCity;

class ProfilesTest {

    @Test
    void collectDistinctSortedByCityTest() {

        Address address1 = new Address("New-York", "First Street", 10, 48);
        Address address2 = new Address("Boston", "Second Street", 106, 48);

        List<Profile> profiles = List.of(
                new Profile(address2),
                new Profile(address1),
                new Profile(address2),
                new Profile(address1)
        );

        List<Address> addressesDistinctSortedByCity = collectDistinctSortedByCity(profiles);

        assertEquals(addressesDistinctSortedByCity.get(0), address2);
        assertEquals(addressesDistinctSortedByCity.get(1), address1);

    }
}