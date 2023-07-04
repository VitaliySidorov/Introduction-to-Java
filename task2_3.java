// 3) Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
// Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

import java.nio.file.Files;
import java.nio.file.Paths;

public class task2_3 {

    public static String readFile(String fileName) throws Exception // Загрука данных из файла
    {
        String data = "";
        data = new String(
            Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        String data = readFile("json.txt");
        String newData = data.replaceAll("\\{", "") // удаление символов из строк
                .replaceAll("\\}", "")
                .replaceAll("\"", "")
                .replaceAll("\\\\", "")
                .replace('[', ' ')
                .replace(']', ' ');
        String[] parts = newData.split(",");
        for (String part : parts) {
            String[] params = part.split(":");
            if ("фамилия".equals(params[0].trim())) {
                sb = new StringBuilder("Студент ").append(params[1]); // парсинг строк и сборка строки вывода
            } 
            else if ("оценка".equals(params[0].trim())){
                sb.append(" получил ").append(params[1]);
            }
            else if ("предмет".equals(params[0].trim())) {
                sb.append(" по предмету ").append(params[1].trim()).append('.');
            
            System.out.println(sb);
            }
        }
    }
}