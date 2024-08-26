package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Department {

  private String name;
  private int id;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  /**
   * Creates a new department with a list of employees
   *
   * @param dbConnection The connection with the db
   * @param employeeList The List of the employees to add
   */
  public void Create(Connection dbConnection, ArrayList<String> employeeList) {
    String addDepartmentQuery = "INSERT INTO departments (dept_name) VALUES (?)";
    String getDeptidQuery = "SELECT dept_id FROM departments WHERE dept_name = ?";

    try (PreparedStatement pstmt = dbConnection.prepareStatement(addDepartmentQuery)) {
      pstmt.setString(1, getName());

      pstmt.executeUpdate();

      try (PreparedStatement iddeptpstmt = dbConnection.prepareStatement(getDeptidQuery)) {
        iddeptpstmt.setString(1, getName());

        try (ResultSet rs = iddeptpstmt.executeQuery()) {
          if (rs.next()) {
            setId(rs.getInt("dept_id"));
          }
        } 
      }
      
      AssignEmployee(dbConnection, employeeList);
      JOptionPane.showMessageDialog(
          null, "Se ha añadido el departamento.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException sqle) {
      JOptionPane.showMessageDialog(
          null,
          "No se se puede añadir el departamento.\nDebido a: " + sqle,
          "ERROR",
          JOptionPane.ERROR_MESSAGE);
      sqle.printStackTrace();
    }
  }

  /**
   * @param dbConnection
   * @param employeeList
   */
  public void AssignEmployee(Connection dbConnection, ArrayList<String> employeeList) {
    String locateEmployeeQuery = "SELECT usr_id FROM users WHERE usr_name = ?";
    String modifyEmployeeQuery = "UPDATE users SET usr_assignedDepartment = ? WHERE usr_id = ?";

    try (PreparedStatement le_pstmt = dbConnection.prepareStatement(locateEmployeeQuery);
        PreparedStatement me_pstmt = dbConnection.prepareStatement(modifyEmployeeQuery)) {

      for (String employee : employeeList) {

        le_pstmt.setString(1, employee);

        try (ResultSet le_rs = le_pstmt.executeQuery()) {
          if (le_rs.next()) {
            int employeeid = le_rs.getInt("usr_id");
            me_pstmt.setInt(1, getId());
            me_pstmt.setInt(2, employeeid);
            me_pstmt.executeUpdate();
          }
        }
      }
    } catch (SQLException sqleu) {
      JOptionPane.showMessageDialog(
          null,
          "No se se puede añadir el empleado al departamento.\nDebido a: " + sqleu,
          "ERROR",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  /**
   * Gets the dept info
   *
   * @param dbConnection the connection with database
   * @param deptName the dept name to get the info
   * @return Arraylist of employees within the department
   */
  @SuppressWarnings("rawtypes")
  public ArrayList GetDepartmentInfo(Connection dbConnection, String deptName) {
    String deptInfoQuery = "SELECT * FROM departments WHERE dept_name = ?";
    String userNameQuery = "SELECT usr_name FROM users WHERE usr_assignedDepartment = ?";

    ArrayList<String> employeeList = new ArrayList<>();

    try (PreparedStatement pstmt = dbConnection.prepareStatement(deptInfoQuery)) {
      pstmt.setString(1, deptName);
      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          setId(rs.getInt("dept_id"));
          setName(rs.getString("dept_name"));
        }
      }
      try (PreparedStatement upstmt = dbConnection.prepareStatement(userNameQuery)) {
        upstmt.setInt(1, getId());
        try (ResultSet urs = upstmt.executeQuery()) {

          while (urs.next()) {
            employeeList.add(urs.getString("usr_name"));
          }
        }
      } catch (SQLException sqle) {
        System.err.println(
            "ERROR, No se puede obtener la información de los usuarios debido a: " + sqle);
      }
    } catch (SQLException sqle) {
      System.err.println("ERROR, No se puede obtener la información debido a: " + sqle);
    }
    return employeeList;
  }
}
