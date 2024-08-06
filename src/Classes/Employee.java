package Classes;

public class Employee extends User {

    public String assignedProject;
    public String assignedDepartment;

    public Employee() {
    }

    public Employee(String assignedProject, String assignedDepartment, int id, String name, String address, String birthDay, String phoneNumber, String email, String position, String salary, String password, String checkinHour, String checkoutHour, String department, int isAdmin) {
        super(id, name, address, birthDay, phoneNumber, email, position, salary, password, checkinHour, checkoutHour, department, isAdmin);
        this.assignedProject = assignedProject;
        this.assignedDepartment = assignedDepartment;
    }

    public String getAssignedProject() {
        return assignedProject;
    }

    public void setAssignedProject(String assignedProject) {
        this.assignedProject = assignedProject;
    }

    public String getAssignedDepartment() {
        return assignedDepartment;
    }

    public void setAssignedDepartment(String assignedDepartment) {
        this.assignedDepartment = assignedDepartment;
    }

}
