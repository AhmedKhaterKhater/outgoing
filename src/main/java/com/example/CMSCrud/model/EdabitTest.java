package com.example.CMSCrud.model;

import java.util.ArrayList;
import java.util.List;

public class EdabitTest {
    int [] items = new int[10];
    int count;
    void add(int item) {
        items[count++] = item;
    }
    int getItem(int index) {
        return items[index];
    }

    public static void main(String[] args) {

        EdabitTest l = new EdabitTest();
        l.add(1);
        l.add(2);
        l.add(4);
        int res = l.getItem(1);
        System.out.println(res);
    }
}
