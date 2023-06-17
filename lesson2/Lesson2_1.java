package Lesson2;
import java.io.*;
import java.util.Scanner;

// Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//В итоге должно получится select * from students where name=Ivanov, country=Russia, city=Moscow, age=null
public class Lesson2_1 {
    public static void main(String[] args) throws Exception {
        String select = "select * from students where ";
        Scanner scanner = new Scanner(new FileInputStream("1.json"));
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }
        scanner.close();
        String jsonString = new String(stringBuilder);
        String[] tmp = jsonString.split(",");
        int flag = -1;
        jsonString = "";
        for (int i = 0; i < tmp.length; i++) {
            flag = tmp[i].indexOf("null");
            if (flag < 0) {
                jsonString += tmp[i];
            }
        }
        jsonString = jsonString.replace("\"", "");
        jsonString = jsonString.replace("{", "");
        jsonString = jsonString.replace("}", "");
        jsonString = jsonString.replace(":", "=");
        jsonString = jsonString.replace(" ", ", ");

        System.out.println(select + jsonString);
    }
}
