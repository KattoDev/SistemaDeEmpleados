package Classes;

public class User {

    public int id;
    public String name;
    public String address;
    public String birthDay;
    public String phoneNumber;
    public String email;
    public String position;
    public String salary;
    public String password;
    public String checkinHour;
    public String checkoutHour;

    public User() {
    }

    public User(int id, String name, String address, String birthDay, String phoneNumber, String email, String position, String salary, String password, String checkinHour, String checkoutHour) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;
        this.salary = salary;
        this.password = password;
        this.checkinHour = checkinHour;
        this.checkoutHour = checkoutHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckinHour() {
        return checkinHour;
    }

    public void setCheckinHour(String checkinHour) {
        this.checkinHour = checkinHour;
    }

    public String getCheckoutHour() {
        return checkoutHour;
    }

    public void setCheckoutHour(String checkoutHour) {
        this.checkoutHour = checkoutHour;
    }

    public void SeeInfo() {
    }

    public void UpdateInfo() {
    }

    public void RequestPermission() {
    }

    public void ReportAbsence() {
    }

    public void Authenticate() {
    }
}
