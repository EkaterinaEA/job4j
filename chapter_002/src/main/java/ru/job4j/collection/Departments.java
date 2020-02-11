package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Departments {

    private String[] parsedDepartments;

    /**
     * Method descendingSort - sorting an array in hierarchical descending order
     *
     * @param departments String[] without null elements
     * @return sorted String[]
     */
    public String[] descendingSort(String[] departments) {
        this.validate(departments);
        Arrays.sort(this.parsedDepartments, this.descendingDeptComparator);
        return this.parsedDepartments;
    }

    /**
     * Method ascendingSort - sorting an String array in hierarchical ascending order
     *
     * @param departments String[] without null elements
     * @return sorted String[]
     */
    public String[] ascendingSort(String[] departments) {
        this.validate(departments);
        return this.parsedDepartments;
    }

    private Comparator<String> descendingDeptComparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int compared = o2.compareTo(o1);
            if (o1.indexOf(o2) == 0) {
                compared = 1;
            }
            if (o2.indexOf(o1) == 0) {
                compared = -1;
            }
            return compared;
        }
    };

    /**
     * Method validate - tests input String array for null-reference and doubling
     *
     * @param arr String[] array to be sorted
     * @throws IllegalArgumentException if String[] reference is null
     */
    private void validate(String[] arr) throws IllegalArgumentException {
        if (arr == null) {
            throw new IllegalArgumentException("Null-reference of the String[]");
        }
        if (this.parsedDepartments == null || !Arrays.equals(this.parsedDepartments, arr)) {
            this.parse(arr);
        }
    }

    /**
     * Method parse - String[] departments parsing
     * construct a new String array with hierarchy recovering
     *
     * @param departments String[] departments to be parsed
     */
    private void parse(String[] departments) {
        Set<String> deptSet = new TreeSet<>();
        char delimiter = '\\';
        for (String dept : departments) {
            deptSet.add(dept);
            for (int i = 0; i < dept.length(); i++) {
                if (dept.charAt(i) == delimiter) {
                    deptSet.add(dept.substring(0, i));
                }
            }
            this.parsedDepartments = deptSet.toArray(new String[0]);
        }
    }

    /**
     * getDeptIndexes
     *
     * @param departments String[] to extract indexes array
     * @return String[] filled with department indexes only
     */
    private String[] getDeptIndexes(String[] departments) {
        String[] result = new String[departments.length];
        int counter = 0;
        for (String dept : departments) {
            result[counter++] = dept.replaceAll("[0-9]", "");
        }
        return result;
    }

}
