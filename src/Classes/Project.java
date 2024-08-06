package Classes;

public class Project {

    private String assignedDept;
    private String name;
    private String Status;
    private String dueDate;
    private int completedTasks;
    private int totalTasks;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(int completedTasks) {
        this.completedTasks = completedTasks;
    }

    public void assignProject() {
    }

    public String getAssignedDept() {
        return assignedDept;
    }

    public void setAssignedDept(String assignedDept) {
        this.assignedDept = assignedDept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(int totalTasks) {
        this.totalTasks = totalTasks;
    }
    

}
