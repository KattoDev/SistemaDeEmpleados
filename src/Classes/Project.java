package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Project {

  private int id;
  private String assignedDept;
  private String name;
  private String status;
  private String dueDate;
  private int completedTasks;
  private int totalTasks;

  public int getId() {
    return id;
  }

  public String getAssignedDept() {
    return assignedDept;
  }

  public String getName() {
    return name;
  }

  public String getStatus() {
    return status;
  }

  public String getDueDate() {
    return dueDate;
  }

  public int getCompletedTasks() {
    return completedTasks;
  }

  public int getTotalTasks() {
    return totalTasks;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setAssignedDept(String assignedDept) {
    this.assignedDept = assignedDept;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  public void setCompletedTasks(int completedTasks) {
    this.completedTasks = completedTasks;
  }

  public void setTotalTasks(int totalTasks) {
    this.totalTasks = totalTasks;
  }

  public void create(Connection dbConnection) {

    String createProjectQuery =
        "INSERT INTO projects (proj_name, proj_status, proj_deadline, proj_assignedDepartment)"
            + "values (?, ?, ?, ?)";
    String searchDepartmentQuery = "SELECT dept_id FROM departments WHERE dept_name = ?";

    try (PreparedStatement proj_pstmt = dbConnection.prepareStatement(createProjectQuery)) {
      try (PreparedStatement dept_pstmt = dbConnection.prepareStatement(searchDepartmentQuery)) {

        dept_pstmt.setString(1, getAssignedDept());

        try (ResultSet dept_rs = dept_pstmt.executeQuery()) {
          if (dept_rs.next()) {
            setAssignedDept(dept_rs.getString("dept_id"));
          }
        }
      }

      int dept = Integer.parseInt(getAssignedDept());

      proj_pstmt.setString(1, getName());
      proj_pstmt.setString(2, getStatus());
      proj_pstmt.setString(3, getDueDate());
      proj_pstmt.setInt(4, dept);

      proj_pstmt.executeUpdate();
      JOptionPane.showMessageDialog(
          null, "Se ha creado el proyecto", "Atención", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException sqle) {
      JOptionPane.showMessageDialog(
          null, "No se puede crear el proyecto", "ERROR", JOptionPane.ERROR_MESSAGE);
      System.err.println("ERROR: " + sqle);
    }
  }

  public void assignProject() {}
}
