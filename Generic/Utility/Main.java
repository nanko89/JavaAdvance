package Utility;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integerList = List.of(12,45,9,-10,1100);

        Integer maxInteger = ListUtils.getMax(integerList);

        System.out.println(maxInteger);

        List<String> stringList = List.of("a","b","c");

        String minString = ListUtils.getMin(stringList);
        System.out.println(minString);
    }
}
