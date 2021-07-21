package ua.training;

import java.util.*;
import java.util.stream.Collectors;

public class ListDuplicateCounter {
    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7);
        countNumberOfOccurrences(arrayList).forEach((key, value) -> System.out.println(key + " - " + value));
    }

    public static TreeMap<Integer, Long> countNumberOfOccurrences(List<Integer> arrayList) {
        return new TreeMap<>(arrayList.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting())));
    }
}
