package TEST;

import ComponentMaintainer.DatabaseConection;

public class testDBC {

  public static void main(String[] args) {
    DatabaseConection dbc = new DatabaseConection();

    final String urlRoot = dbc.getUrlRoot();
    final String urlPort = dbc.getUrlPort();
    final String dbUser = dbc.getDbUser();
    final String dbPassword = dbc.getDbPassword();
    final String dbRoot = dbc.getDbRoot();
    System.out.println("---------------------------------------------------");
    System.out.println("| URL: " + "jdbc:mysql://" + urlRoot + ":" + urlPort + "/" + dbRoot + " |");
    System.out.println("| DBUSER: " + dbUser + " |");
    System.out.println("| DBPASSWORD: " + dbPassword + " |");
    System.out.println("---------------------------------------------------");

    dbc.connectDatabase();

    try {
      dbc.statement = dbc.connection.createStatement();
      dbc.resultSet = dbc.statement.executeQuery("select * from users");
      System.out.println("QUERY FROM [" + dbRoot + "] COMMAND {select * from users}");

      while (dbc.resultSet.next()) {

        System.out.println(
            "ID: "
                + dbc.resultSet.getString("id")
                + "\n"
                + "NAME: "
                + dbc.resultSet.getString("name")
                + "\n"
                + "ADDRESS: "
                + dbc.resultSet.getString("address")
                + "\n"
                + "BIRTHDAY: "
                + dbc.resultSet.getString("birthday")
                + "\n"
                + "PHONE NUMBER: "
                + dbc.resultSet.getString("phoneNumber")
                + "\n"
                + "EMAIL: "
                + dbc.resultSet.getString("email")
                + "\n"
                + "POSITION: "
                + dbc.resultSet.getString("position")
                + "\n"
                + "SALARY: "
                + dbc.resultSet.getString("salary")
                + "\n"
                + "USER PASSWORD: "
                + dbc.resultSet.getString("password")
                + "\n"
                + "IS ADMIN: "
                + dbc.resultSet.getString("isAdmin")
                + "\n");
      }
      dbc.CloseConnection();
    } catch (Exception e) {
      System.err.println("ERROR " + e);
    }
  }
}
