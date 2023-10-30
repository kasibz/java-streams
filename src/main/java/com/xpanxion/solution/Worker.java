package com.xpanxion.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.TreeMap;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;

public class Worker {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String ssn;

    public Worker() {
    }

    public Worker(int id, String firstName, String lastName, int age, String ssn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ssn = ssn;
    }

    public void ex1() {
        var newProductsList = DataAccess.getProducts().stream()
                .map(item -> {
                    if (item.getDepartmentId() == 1) {
                        item.setDepartmentName("Electronics");
                        return item;
                    } else if (item.getDepartmentId() == 2) {
                        item.setDepartmentName("Food");
                        return item;
                    }
                    return item;
                })
                .collect(Collectors.toList());

        System.out.println(newProductsList);

    }

    public void ex2() {
        var newProductsList = DataAccess.getProducts().stream()
                .map(item -> {
                    item.setDepartmentName("N/A");
                    return item;
                })
                .collect(Collectors.toList());

        System.out.println(newProductsList);
    }

    public void ex3() {
        var newProductsList = DataAccess.getProducts().stream()
                .filter(item -> item.getDepartmentId() == 1 && item.getPrice() >= 10.0)
                .collect(Collectors.toList());

        System.out.println(newProductsList);
    }

    public void ex4() {
        // needs to be an array to be final??
        float[] sum = { 0.0F };
        DataAccess.getProducts().stream()
                .forEach(item -> {
                    if (item.getDepartmentId() == 2) {
                        sum[0] += item.getPrice();
                    }
                });

        System.out.printf("$%.2f", sum[0]);
    }

    public void ex5() {
        var newPeopleList = DataAccess.getPeople().stream()
                .filter(person -> person.getId() <= 3)
                .map(person -> {
                    person.setSsn(person.getSsn().substring(7));
                    return person;

                })
                .collect(Collectors.toList());

        System.out.println(newPeopleList);
    }

    public void ex6() {
        var newCatList = DataAccess.getCats();
        newCatList.sort(Comparator.comparing(cat -> cat.getName()));
        System.out.println(newCatList);
    }

    public void ex7() {
        // need to split sentence to array then set to stream and check for keys
        HashMap<String, Integer> wordCount = new HashMap<>();
        Stream<String> words = Arrays.stream(DataAccess.getWords().split(" "));

        words.forEach(word -> {
            if (wordCount.containsKey(word)) {
                int temp = wordCount.get(word);
                temp++;
                wordCount.put(word, temp);
            } else {
                wordCount.put(word, 1);
            }
        });

        Map<String, Integer> sortedWordCount = new TreeMap<>(wordCount);

        // print them out
        sortedWordCount.forEach((key, value) -> {
            System.out.printf("%s = %d\n", key, value);

        });

    }
}
