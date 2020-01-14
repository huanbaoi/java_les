package com.zeroten.javaless.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortUtils {
    private static void bubbleSort(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size - i-1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j+1, tmp);
                }
            }
        }
    }

    public static void insertionSort(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int num = list.get(i);
            int j = i - 1;

        }
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
    }

    private static void fillRandom(List<Integer> list, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt());
        }
    }
}
