import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HandlerAction {

  public boolean validateUserName(String userName) {
    if (userName.equals("User Name") || userName.length() <= 5) {
      System.out.println("El campo nombre no puede estar vacío o ser menor a 5 caracteres");
      return false;
    }

    return true;
  }

  public boolean validateIdNumber(String idNumber) {
    if (idNumber.equals("User ID") || idNumber.length() < 10 || Integer.parseInt(idNumber) < 0) {
      System.out.println("El campo número de identificación no puede estar vacío o ser menor a 5 caracteres");
      return false;
    }

    return true;
  }

  public boolean validateEge(String ege) {
    if (Integer.parseInt(ege) < 0) {
      System.out.println("El campo edad no puede estar vacío o ser menor a 5 caracteres");
      return false;
    }

    return true;
  }

  public boolean validateAffiliationCategory(String affiliationCategory) {
    if (affiliationCategory.equals("Affiliation Category") || affiliationCategory.length() <= 0) {
      System.out.println("El campo categoría de afiliación no puede estar vacío");
      return false;
    }

    return true;
  }

  public UserStructureData validationData (String userName, String idNumber, String ege, String affiliationCategory) {
    final String validatedUserName = validateUserName(userName) ? userName : "";
    final String validatedIdNumber = validateIdNumber(idNumber) ? idNumber : "";
    final int validatedEge = validateEge(ege) ? Integer.parseInt(ege) : 0;
    final String validatedAffiliationCategory = validateAffiliationCategory(affiliationCategory) ? affiliationCategory : "";

    return new UserStructureData(validatedUserName, validatedIdNumber, validatedEge, validatedAffiliationCategory);
  }

  public void uploadDataToTable(DbManager dbManager, String[] columns, JTable ShowResults) {
    final Object[][] data = dbManager.readUsersFromFile();
    DefaultTableModel model = new DefaultTableModel(data, columns);
    ShowResults.setModel(model);
  }

}
