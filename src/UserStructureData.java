public class UserStructureData {
    final private int ticketValue = 30000;
    private String userName;
    private String idNumber;
    private int ege;
    private String affiliationCategory;

    public UserStructureData(String userName, String idNumber, int ege, String affiliationCategory) {
        this.userName = userName;
        this.idNumber = idNumber;
        this.ege = ege;
        this.affiliationCategory = affiliationCategory;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getEge() {
        return ege;
    }

    public void setEge(int ege) {
        this.ege = ege;
    }

    public String getAffiliationCategory() {
        return affiliationCategory;
    }

    public void setAffiliationCategory(String affiliationCategory) {
        this.affiliationCategory = affiliationCategory;
    }

    public double getTotalPrice () {
      String category = affiliationCategory.toUpperCase();
      System.out.println(category);

      if("A".equals(category)) {
        return ticketValue - (ticketValue * 0.15);
      }
      if ("B".equals(category)) {
        return ticketValue - (ticketValue * 0.3);
      }
      if ("C".equals(category)) {
        return ticketValue * 0.5;
      }
      return ticketValue;
    }

    public double getDiscount () {
      String category = affiliationCategory.toUpperCase();

      if("A".equals(category)) {
        return (ticketValue * 0.15);
      }
      if ("B".equals(category)) {
        return ticketValue * 0.3;
      }
      if ("C".equals(category)) {
        return ticketValue * 0.5;
      }
      return 0;
    }
}
