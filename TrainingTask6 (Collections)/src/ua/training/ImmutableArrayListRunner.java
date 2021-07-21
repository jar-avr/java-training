package ua.training;

import java.util.Arrays;

public class ImmutableArrayListRunner {
    public static void main(String[] args) {
        ImmutableArrayList<Integer> immutableArrayList = new ImmutableArrayList<>(Arrays.asList(12, 14, 56));
        System.out.println("Contents of the immutable ArrayList: ");
        immutableArrayList.forEach(System.out::println);

        System.out.println("Trying to remove 12: ");
        try {
            immutableArrayList.remove(12);
        } catch(UnsupportedOperationException e) {
            System.err.println("UnsupportedOperationException caught!");
        }

        System.out.println("Trying to clear the list: ");
        try {
            immutableArrayList.clear();
        } catch(UnsupportedOperationException e) {
            System.err.println("UnsupportedOperationException caught!");
        }
    }
}
