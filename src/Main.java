import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    List<Pet> pets = readPet();
    for (Pet pet : pets) {
      printPet(pet);
    }
  }

  public static void printPet(Pet pet) {
    Kind kind = pet.getKind();
    String name = pet.getName();
    Double weight = pet.getWeight();
    String birthday = pet.getBirthday();
    System.out.printf("Kind :%10s Name: %20s Weight: %10f Birthday: %10s%n",
        kind, name, weight, birthday);
  }

  public static List<Pet> readPet() throws IOException {
    List<Pet> pets = new ArrayList<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      int number = Integer.parseInt(br.readLine());
      for (int i = 0; i < number; ++i) {
        String line = br.readLine();
        Pet parsedPet = Pet.parsePet(line);
        pets.add(parsedPet);
      }
    } catch (NumberFormatException e) {
      System.err.println("Incorrect number format!" + e.getMessage());
    } catch (NullPointerException e) {
      System.err.println("Argument is NULL" + e.getMessage());
    } catch (IllegalArgumentException e) {
      System.err.println("Argument is incorrect" + e.getMessage());
    }
    return pets;
  }
}
