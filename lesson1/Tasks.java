package lesson1;

import java.util.Arrays;
import java.util.Random;
public class Tasks {
    public static void main(String[] args) {
        // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i

        Random random = new Random();
        int i = random.nextInt(2000);
        System.out.println(i);

        // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа

        int n = 0;
        while (i != 1) {
            i >>= 1;
            n++;
        }
        System.out.println(n);

        // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1

        int count1 = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                count1 += 1;
            }
        }
        int [] m1 = new int[count1];
        int k = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                m1[k] = j;
                k++;
            }
        }
        System.out.println(Arrays.toString(m1));

        // 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

        int count2 = 0;
        for (int j = i; j > Short.MIN_VALUE; j--) {
            if (j % n != 0) {
                count2 += 1;
            }
        }
        int [] m2 = new int[count2];
        int q = 0;
        for (int j = i; j > Short.MIN_VALUE; j--) {
            if (j % n != 0) {
                m2[q] = j;
                q++;
            }
        }
        System.out.println(Arrays.toString(m2));
    }
}
