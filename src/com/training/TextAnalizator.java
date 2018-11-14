package com.training;

import java.util.*;

import static com.training.File.*;

public class TextAnalizator {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        String text = readFile("THE PURSUIT OF HAPPINESS.txt");
        for (String word : text.split("\\W")) {
            Integer count = words.get(word);
            words.put(word, count == null ? 1 : count + 1);
        }
        words.remove("");
        Map<String, Integer> sortedByValue = new LinkedHashMap<>();
        sortedByValue = sortByValue(words);
        writeFile("", "result.txt", false);
        for (Map.Entry<String, Integer> pair : sortedByValue.entrySet()) {
            String line = pair.getKey() + " = " + pair.getValue() + System.getProperty("line.separator");
            writeFile(line, "result.txt", true);
        }
    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue().compareTo(o1.getValue()));
            }
        });
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
        /*Code above can be replaced with lambda expression
    {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o2.getValue().compareTo(o1.getValue())));
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }*/
    }
}
