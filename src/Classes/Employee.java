package Classes;

public class Employee extends User {

    public String assignedProject;
    public String assignedDepartment;

    public Employee() {
    }

    public Employee(
            int id, String name, String address, String birthDay, String phoneNumber, String email,
            String position, String salary, String password, String checkinHour, String checkoutHour,
            String assignedProject, String assignedDepartment) {
        super(id, name, address, birthDay, phoneNumber, email, position, salary, password, checkinHour, checkoutHour);
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
