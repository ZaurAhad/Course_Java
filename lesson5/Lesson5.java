package Lesson5;

import java.util.*;

public class Lesson5 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        addTel(map, "Maria", "111");
        addTel(map, "Maria", "112");
        addTel(map, "Maria", "121");
        addTel(map, "Petr", "222");
        addTel(map, "Petr", "223");

        ArrayList<String> list = new ArrayList<>();
        for (String s: map.keySet()) {
            list.add(s);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).size() - map.get(o2).size();
            }
        });

        System.out.println(list);
    }
    public static void addTel(HashMap<String, ArrayList<String>> map, String name, String phone) {
        map.putIfAbsent(name, new ArrayList<>());
        map.get(name).add(phone);

    }

}
