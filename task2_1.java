// 1) Дана строка sql-запроса "select * from students where ". 
// Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации:
// Input:
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.nio.file.Files;
import java.nio.file.Paths;

public class task2_1 {
    public static final String request = "SELECT * FROM students WHERE ";

    public static String readFile(String fileName) throws Exception // Загрука данных из файла
    {
        String data = "";
        data = new String(
            Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception{
        String data = readFile("workers.txt");
        String dataNew = data.replace('{', ' ')
        .replace('\\', ' ')
        .replace('}', ' ');
        String[] params = dataNew.split(",");
        StringBuilder stringBuilder = new StringBuilder(request);
        for (int i = 0; i < params.length; i++) {
            String[] elements = params[i].replace('"', ' ').split(":");
            if (!"null".equals(elements[1].trim())) {
                stringBuilder.append(elements[0].trim()).append("=")
                .append("'")
                .append(elements[1].trim())
                .append("'");
                if (i < params.length - 2)
                    stringBuilder.append(" AND ");
            }
        }
        System.out.println(stringBuilder);
    }
}
