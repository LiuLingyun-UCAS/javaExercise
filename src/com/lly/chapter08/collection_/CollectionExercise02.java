package com.lly.chapter08.collection_;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class CollectionExercise02{
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);

        m.put("jack", 2600);
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            entry.setValue(entry.getValue() + 100);
        }
        System.out.println(m);

    }
}
