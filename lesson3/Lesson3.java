package Lesson3;

import java.util.ArrayList;
import java.util.Comparator;

//Пусть дан произвольный список целых чисел.
//1) Нужно удалить из него чётные числа
//2) Найти минимальное значение
//3) Найти максимальное значение
//4) Найти среднее значение

//
public class Lesson3 {
    public static void main(String[] args) {
        int rand = (int) (Math.random() * 20);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < rand; i++) {
            list1.add((int)(Math.random() * 100));
        }
        list2.addAll(list1);

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) % 2 == 0) {
                list2.remove(list1.get(i));
            }
        }

        list2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int min = list2.get(0);
        int max = list2.get(list2.size() - 1);
        int sum = 0;
        for (int i = 0; i < list2.size(); i++) {
            sum += list2.get(i);
        }
        int average = sum / list2.size();
        System.out.println("Список чисел " + list1);
        System.out.println("Список нечетных чисел " + list2);
        System.out.println("Минимальное значение " + list2.get(0));
        System.out.println("Максимальное значение " + list2.get(list2.size() - 1));
        System.out.println("Cреднее значение " + sum / list2.size());


    }
}
