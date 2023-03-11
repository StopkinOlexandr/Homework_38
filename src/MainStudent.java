import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Задача 2* (не обязательно)
//Добавить в базу данных студентов чтение данных из файла.
//
//Задача 3** (не обязательно)
//Добавить в базу данных студентов хранение в отдельных списках для каждой группы.
//
//Придумать общую структуру для хранения всех групп и переработать вывод данных в формате,
//аналогичном вводу.
public class MainStudent {  // написать базу данных студентов
  // студенты могут находиться в группах

  // красиво вывести состав групп на экран
  public static void main(String[] args) throws IOException {
    File filePath = new File("res/students.txt");
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader fr = new BufferedReader(new FileReader(filePath));
    List<Student> students = new ArrayList<>();
    // прочитать количество групп
//    int groups = Integer.parseInt(br.readLine());
    int groups = Integer.parseInt(fr.readLine());
    for (int groupId = 0; groupId < groups; ++groupId) {
      // для каждой группы:
      readGroup(fr, students);
    }
    for (Student student : students) {
      System.out.printf("%15s (%s) в группе %s%n", student.getName(), student.getEMail(),
          student.getGroup());
    }
  }

  // - прочитать название группы
  // - прочитать количество студентов
  // - прочитать информацию о студентах - "имя" или "имя,e-mail" для каждого в отдельной строке
  private static void readGroup(BufferedReader fr, List<Student> students) throws IOException {
    String groupName = fr.readLine();
    int studentsNumber = Integer.parseInt(fr.readLine());
    for (int i = 0; i < studentsNumber; ++i) {
      String line = fr.readLine();
      Student student = Student.parseStudent(groupName, line);
      students.add(student);
    }
  }
}
