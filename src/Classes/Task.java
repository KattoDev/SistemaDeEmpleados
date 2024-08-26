package Classes;

public class Task {

  public String name;
  public String status;
  public String deadline;
  public int assignedEmployee;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDeadline() {
    return deadline;
  }

  public void setDeadline(String deadline) {
    this.deadline = deadline;
  }

  public int getAssignedEmployee() {
    return assignedEmployee;
  }

  public void setAssignedEmployee(int assignedEmployee) {
    this.assignedEmployee = assignedEmployee;
  }

  public void AssignProject() {}

  public void UpdateStatus() {}

  public void FinishProject() {}
}
