package ru.job4j.addresses;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProfilesTest {
    @Test

    public void sortingByAllParametersIncreasingOrder() {
        List<Profile> profiles = new LinkedList<>();
        profiles.add(new Profile(new Address(
                "Moscow",
                "Polyanka",
                18,
                25)));
        profiles.add(new Profile(new Address(
                "Moscow",
                "Dmitrieva",
                1,
                20)));
        profiles.add(new Profile(new Address(
                "Moscow",
                "Polyanka",
                8,
                1)));
        profiles.add(new Profile(new Address(
                "Moscow",
                "Polyanka",
                8,
                5)));
        profiles.add(new Profile(new Address(
                "Moscow",
                "Polyanka",
                8,
                5)));
        profiles.add(new Profile(new Address(
                "Izhevsk",
                "Lenina",
                100,
                15)));
        profiles.add(new Profile(new Address(
                "Izhevsk",
                "Lenina",
                100,
                15)));

        List<Address> result = new Profiles().collect(profiles);
        List<Address> expect = new LinkedList<>();
        expect.add(new Address(
                "Izhevsk",
                "Lenina",
                100,
                15));
        expect.add(new Address(
                "Moscow",
                "Dmitrieva",
                1,
                20));
        expect.add(new Address(
                "Moscow",
                "Polyanka",
                8,
                1));
        expect.add(new Address(
                "Moscow",
                "Polyanka",
                8,
                5));
        expect.add(new Address(
                "Moscow",
                "Polyanka",
                18,
                25));

        assertThat(result, is(expect));
    }

    @Test
    public void sortingByAllParametersIncreasingOrderAndIgnoreSameAddress() {
        List<Profile> profiles = new LinkedList<>();
        profiles.add(new Profile(new Address(
                "Moscow",
                "Polyanka",
                18,
                25)));
        profiles.add(new Profile(new Address(
                "Moscow",
                "Dmitrieva",
                1,
                20)));
        profiles.add(new Profile(new Address(
                "Moscow",
                "Polyanka",
                8,
                1)));
        profiles.add(new Profile(new Address(
                "Moscow",
                "Polyanka",
                8,
                5)));
        profiles.add(new Profile(new Address(
                "Moscow",
                "Polyanka",
                8,
                5)));
        profiles.add(new Profile(new Address(
                "Izhevsk",
                "Lenina",
                100,
                15)));
        profiles.add(new Profile(new Address(
                "Izhevsk",
                "Lenina",
                100,
                15)));

        List<Address> result = new Profiles().collect(profiles);
        List<Address> expect = new LinkedList<>();
        expect.add(new Address(
                "Izhevsk",
                "Lenina",
                100,
                15));
        expect.add(new Address(
                "Moscow",
                "Dmitrieva",
                1,
                20));
        expect.add(new Address(
                "Moscow",
                "Polyanka",
                8,
                1));
        expect.add(new Address(
                "Moscow",
                "Polyanka",
                8,
                5));
        expect.add(new Address(
                "Moscow",
                "Polyanka",
                18,
                25));

        assertThat(result, is(expect));
    }
}
