package Classes;

public class Employee extends User {

  private String assignedProject;
  private String assignedDepartment;
  private int completedTasks;

  public Employee() {
  }

  public Employee(int id, String name, String address, String birthDay, long phoneNumber, String email, String position,
      long salary, String password, String checkinHour, String checkoutHour, String department, int isAdmin,
      String assignedProject, String assignedDepartment, int completedTasks) {
    super(id, name, address, birthDay, phoneNumber, email, position, salary, password, checkinHour, checkoutHour,
        department, isAdmin);
    this.assignedProject = assignedProject;
    this.assignedDepartment = assignedDepartment;
    this.completedTasks = completedTasks;
  }

  public String getAssignedProject() {
    return assignedProject;
  }

  public String getAssignedDepartment() {
    return assignedDepartment;
  }

  public int getCompletedTasks() {
    return completedTasks;
  }

  public void setAssignedProject(String assignedProject) {
    this.assignedProject = assignedProject;
  }

  public void setAssignedDepartment(String assignedDepartment) {
    this.assignedDepartment = assignedDepartment;
  }

  public void setCompletedTasks(int completedTasks) {
    this.completedTasks = completedTasks;
  }
}
