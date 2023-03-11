//Задача 1
//  Создать класс Pet (домашнее животное). В классе должны быть:
//
//  enum Kind для вида животного (DOG, CAT, OTHER);
//  поля:
//  "вид животного" (тип Kind),
//  "кличка" (тип String),
//  "дата рождения" (тип String),
//  вес (тип double);
//  конструктор, сеттеры, геттеры;
//  статический метод для создания животного при прочтении данных из строки "dog,кличка",
//  "cat,кличка,вес", "turtle,кличка,вес,дата рождения".
//  Создать класс Main, в котором данные будут считываться с консоли и красиво выводиться на экран.
//
//  Формат входных данных: количество строк с записями о домашних животных,
//  затем сами записи в описанном формате.
public class Pet {
  private Kind kind;
  private String name;
  private String birthday;
  private Double weight;

  public Kind getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public String getBirthday() {
    return birthday;
  }

  public Double getWeight() {
    return weight;
  }

  public void setKind(Kind kind) {
    this.kind = kind;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Pet(Kind kind, String name){
    this.kind = kind;
    this.name = name;
  }

  public Pet(Kind kind, String name, Double weight){
    this.kind = kind;
    this.name = name;
    this.weight = weight;
  }

  public Pet(Kind kind, String name, Double weight, String birthday){
    this.kind = kind;
    this.name = name;
    this.weight = weight;
    this.birthday = birthday;
  }
}
