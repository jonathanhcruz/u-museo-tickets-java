import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {

  private JPanel UserRegister;
  private JTextField UserName;
  private JTextField UserID;
  private JTextField Age;
  private JTextField AffiliationCategory;
  private JPanel MainPanel;
  private JButton SetValues;
  private JTable ShowResults;

  public Main() {
      setContentPane(MainPanel);
      setTitle("Museum U Compensar");
      setSize(1200, 800);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      DbManager dbManager = new DbManager();
      HandlerAction handlerAction = new HandlerAction();

      final String[] columns = {"UserName", "IdNumber", "Age", "AffiliationCategory", "Discount", "Total Price"};

      handlerAction.uploadDataToTable(dbManager, columns, ShowResults);

      SetValues.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          DbManager dbManager = new DbManager();
          UserStructureData newUser = handlerAction.validationData(UserName.getText(), UserID.getText(), Age.getText(), AffiliationCategory.getText());


          if (newUser.getUserName().equals("") || newUser.getIdNumber().equals("") || newUser.getEge() == 0 || newUser.getAffiliationCategory().equals("")) {
            System.out.println("No se pudo guardar el usuario");
            return;
          }

          // Save User
          dbManager.saveUserToFile(newUser);

          // Update Table
          handlerAction.uploadDataToTable(dbManager, columns, ShowResults);
        }
      });
  }

  public static void main(String[] args) {
      new Main();
  }
}
