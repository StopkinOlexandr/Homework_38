import java.io.*;
import java.security.KeyStore;
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
    List<List<Student>> students = new ArrayList<>();
    // прочитать количество групп
//    int groups = Integer.parseInt(br.readLine());
    int groups = Integer.parseInt(fr.readLine());
    for (int groupId = 0; groupId < groups; ++groupId) {
      // для каждой группы:
      students.add(readGroup(fr));
    }
    for (List groupList : students) {
//      System.out.println(groupList);
      List<Student> group = groupList;
      System.out.println(group.get(0).getGroup());
      for (Student student : group) {
        System.out.printf("%15s (%s) в группе %s%n", student.getName(), student.getEMail(),
            student.getGroup());
      }
    }
    outputAsInput(students);
  }

  public static void outputAsInput(List<List<Student>> students) {
    //для того что бы потом быстро пробежаться и записать в файл или еще что - то
    List<String> output = new ArrayList<>();
    int groupsQuantity = students.size();
    output.add("" + groupsQuantity);
    System.out.println(groupsQuantity);
    for (List groupList : students) {
      List<Student> group = groupList;
      String groupName = group.get(0).getGroup();
      output.add(groupName);
      System.out.println(groupName);
      int groupSize = group.size();
      output.add("" + groupSize);
      System.out.println(groupSize);
      for (Student student : group) {
        String studForOutput = student.getName() + "," + student.getEMail();
        System.out.println(studForOutput);
        output.add(studForOutput);
      }
    }
  }

  // - прочитать название группы
  // - прочитать количество студентов
  // - прочитать информацию о студентах - "имя" или "имя,e-mail" для каждого в отдельной строке
  private static List<Student> readGroup(BufferedReader fr) throws IOException {
    List<Student> studentsInGroup = new ArrayList<>();
    String groupName = fr.readLine();
    int studentsNumber = Integer.parseInt(fr.readLine());
    for (int i = 0; i < studentsNumber; ++i) {
      String line = fr.readLine();
      Student student = Student.parseStudent(groupName, line);
      studentsInGroup.add(student);
    }
    return studentsInGroup;
  }
}
