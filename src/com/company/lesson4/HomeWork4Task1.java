package com.company.lesson4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author Sveta
 */
public class HomeWork4Task1 {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C", "A", "A", "D", "B");
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> stringHashSet = new HashSet<>(list);

        for (String item : list) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        System.out.println(list);
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(stringHashSet);
    }
}
