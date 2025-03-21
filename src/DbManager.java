import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class DbManager {
  final String directoryPath = "./DB/";
  final String FILE_PATH = directoryPath + "usuarios.txt";

  public void saveUserToFile(UserStructureData user) {
    try {
      File directory = new File(directoryPath);
      if (!directory.exists()) {
        directory.mkdirs();
      }

      File file = new File(FILE_PATH);
      if (file.exists() && file.isDirectory()) {
        System.err.println("ERROR: 'usuarios.txt' es un directorio, no un archivo.");
        return;
      }

      String line = "UserName: " + user.getUserName() +
              ", IdNumber: " + user.getIdNumber() +
              ", Age: " + user.getEge() +
              ", AffiliationCategory: " + user.getAffiliationCategory().toUpperCase() +
              ", Discount: " + user.getDiscount() +
              ", Total Price: " + user.getTotalPrice();


      // Save user to file
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
        writer.write(line);
        writer.newLine();
      }

      System.out.println("Usuario guardado correctamente.");

    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("El usuario no pudo ser guardado.");
    }
  }

  public Object[][] readUsersFromFile() {
    List<Object[]> dataList = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // Dividir por coma
        String[] parts = line.split(", ");
        String name = parts[0].split(": ")[1];
        String id = parts[1].split(": ")[1];
        String age = parts[2].split(": ")[1];
        String category = parts[3].split(": ")[1];
        String discount = parts[4].split(": ")[1];
        String totalPrice = parts[5].split(": ")[1];

        dataList.add(new Object[]{name, id, age, category, discount, totalPrice});
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return dataList.toArray(new Object[0][0]);
  }
}
