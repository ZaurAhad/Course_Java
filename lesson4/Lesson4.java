package Lesson4;
//Организовать ввод и хранение данных пользователей. ФИО возраст и пол
//вывод в формате Фамилия И.О. возраст пол
//добавить возможность выхода или вывода списка отсортированного по возрасту!)
//*реализовать сортировку по возрасту с использованием индексов
//*реализовать сортировку по возрасту и полу с использованием индексов
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Lesson4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList <Integer> id = new ArrayList<>();
        ArrayList<String> allInfo = new ArrayList<>();
        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> parentName = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> sex = new ArrayList<>();
        int count;
        while (scanner.hasNextLine()) {
            allInfo.add(scanner.nextLine());

        }

        for (int i = 0; i < allInfo.size(); i++) {
            if (allInfo.get(i).equals("муж") || allInfo.get(i).equals("жен")) {
                id.add(i % 4 + 1);
                age.add(Integer.parseInt(allInfo.get(i - 1)));
                parentName.add(allInfo.get(i - 2));
                name.add(allInfo.get(i - 3));
                lastName.add(allInfo.get(i - 4));
                sex.add(allInfo.get(i));
            }
        }
        for (int i = 0; i < name.size(); i++) {
            System.out.println(id.get(i) + ". "+ lastName.get(i) + " " + name.get(i) + " " + parentName.get(i) + " " + age.get(i) + " " + sex.get(i));
        }
        System.out.println();
        System.out.println("Введите '+' чтобы получить отсортированный список по возрасту");
        System.out.println("Введите 'male' или 'female' чтобы получить отсортированный список по возрасту полу");
        System.out.println();
        if (allInfo.get(allInfo.size() - 1).equals("+") || allInfo.get(allInfo.size() - 1).equals("male") || allInfo.get(allInfo.size() - 1).equals("female")) {
            ArrayList<Integer> sortAge = new ArrayList<>();
            ArrayList<Integer> sortSex = new ArrayList<>();
            sortAge.addAll(age);
            sortAge.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            if (allInfo.get(allInfo.size() - 1).equals("+")) {
                count = 0;
                for (int i = 0; i < sortAge.size(); i++) {
                    for (int j = 0; j < age.size(); j++) {
                        if (sortAge.get(i).equals(age.get(j))) {
                            count++;
                            System.out.println(count + ". " + lastName.get(j) + " " + name.get(j) + " " + parentName.get(j) + " " + age.get(j) + " " + sex.get(j));
                        }
                    }
                }
            } else if (allInfo.get(allInfo.size() - 1).equals("male")) {
                count = 0;
                for (int i = 0; i < sortAge.size(); i++) {
                    for (int j = 0; j < age.size(); j++) {
                        if (sortAge.get(i).equals(age.get(j)) && (sex.get(j).equals("муж"))) {
                            count++;
                            System.out.println(count + ". " + lastName.get(j) + " " + name.get(j) + " " + parentName.get(j) + " " + age.get(j) + " " + sex.get(j));

                        }
                    }
                }
            } else if (allInfo.get(allInfo.size() - 1).equals("female")) {
                count = 0;
                for (int i = 0; i < sortAge.size(); i++) {
                    for (int j = 0; j < age.size(); j++) {
                        if (sortAge.get(i).equals(age.get(j)) && (sex.get(j).equals("жен"))) {
                            count++;
                            System.out.println(count + ". " + lastName.get(j) + " " + name.get(j) + " " + parentName.get(j) + " " + age.get(j) + " " + sex.get(j));
                        }
                    }
                }
            }

        }

    }
}