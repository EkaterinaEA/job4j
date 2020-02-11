package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class DepartmentsTest {

    @Test
    public void parsingAndHierarchyRecoveringTest() {
        String[] departments = {
                "K1\\SK2",
                "K1\\SK1",
                "K2\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
        };
        String[] expected = {
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        Departments departmentSorter = new Departments();
        String[] result = departmentSorter.ascendingSort(departments);
        assertThat(result, is(expected));
    }

    @Test
    public void ascendingSortTest() {
        String[] departments = {
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K2\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1",
                "K2"
        };
        String[] expected = {
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        Departments departmentSorter = new Departments();
        String[] result = departmentSorter.ascendingSort(departments);
        assertThat(result, is(expected));
    }

    @Test
    public void descendingSortTest() {
        String[] departments = {
                "K2\\SK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K1",
                "K2\\SK1\\SSK2",
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1"
        };
        String[] expected = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        Departments departmentSorter = new Departments();
        String[] result = departmentSorter.descendingSort(departments);
        assertThat(result, is(expected));
    }

    @Test
    public void whenParsingNullArrayThenIAException() {
        String[] departments = null;
        String[] expected = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        String[] result = null;
        String errMsg = "";
        String exp = "Parameter is empty or null-reference";
        Departments departmentSorter = new Departments();
        try {
            result = departmentSorter.descendingSort(departments);
        } catch (IllegalArgumentException e) {
            errMsg = e.getMessage();
        } finally {
            assertThat(Arrays.equals(expected, result)
                            & errMsg.equals(exp),
                    is(false)
            );
        }
    }
}