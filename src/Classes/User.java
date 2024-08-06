package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ComponentMaintainer.DatabaseConection;
import javax.swing.JOptionPane;

public class User {

    DatabaseConection dbc = new DatabaseConection();

    private int id;
    private String name;
    private String address;
    private String birthDay;
    private String phoneNumber;
    private String email;
    private String position;
    private String salary;
    private String password;
    private String checkinHour;
    private String checkoutHour;
    private String department;
    private int isAdmin;


    // Constructors
    public User() {
    }
    
    
    public User(int id, String name, String address, String birthDay, String phoneNumber, String email, String position, String salary, String password, String checkinHour, String checkoutHour, String department, int isAdmin) {
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
        this.department = department;
        this.isAdmin = isAdmin;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public String getSalary() {
        return salary;
    }

    public String getPassword() {
        return password;
    }

    public String getCheckinHour() {
        return checkinHour;
    }

    public String getCheckoutHour() {
        return checkoutHour;
    }

    public String getDepartment() {
        return department;
    }

    public int getIsAdmin() {
        return isAdmin;
    }
    
    

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCheckinHour(String checkinHour) {
        this.checkinHour = checkinHour;
    }

    public void setCheckoutHour(String checkoutHour) {
        this.checkoutHour = checkoutHour;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    

    
    // Methods

    /**
     * Method for User Auth
     * 
     * @param email    The email registered in the system
     * @param password The password registered in the system
     * @return the Auth status
     */
    public boolean Authenticate(String email, String password, Connection dbConnection) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (PreparedStatement stmt = dbConnection.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    this.id = rs.getInt("id");
                    this.name = rs.getString("name");
                    this.address = rs.getString("address");
                    this.birthDay = rs.getString("birthday");
                    this.phoneNumber = rs.getString("phoneNumber");
                    this.email = rs.getString("email");
                    this.position = rs.getString("position");
                    this.salary = rs.getString("salary");
                    this.password = rs.getString("password");
                    this.isAdmin = rs.getInt("isAdmin");
                    return true;
                }
                else {
                    return false;
                }
            }
            catch (SQLException sqle) {
                sqle.printStackTrace();
                return false;
            }
        }
        catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    /**
     * <ul>
     * <li>Fetch the user profile in the system, overriding the info fetched in
     * Login().</li>
     * </ul>
     */
    public void SeeInfo(int userId, Connection dbConnection) {
        try {
            PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM users WHERE id = ?");
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                this.name = rs.getString("name");
                this.address = rs.getString("address");
                this.birthDay = rs.getString("birthday");
                this.phoneNumber = rs.getString("phoneNumber");
                this.email = rs.getString("email");
                this.position = rs.getString("position");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for user confirmation with System info changes.
     * 
     * @param editedInformation boolean for tracking if the user has make changes in
     *                          the System info
     * @param dbConnection      the connection with the DB
     */
    public void confirmInfoUpdate(boolean editedInformation, Connection dbConnection) {

        int userOption = 1;

        if (editedInformation) {
            userOption = JOptionPane.showConfirmDialog(null, "Hay información sin guardar, ¿desea guardar?", "Atención",
                    JOptionPane.YES_NO_OPTION);
        }

        if (userOption == 0) {
            UpdateInfo(dbConnection);
        }

    }

    public void UpdateInfo(Connection dbConnection) {
        try {
            String updateQuery = "UPDATE users SET name = ?, email = ?, phoneNumber = ?, address = ?, birthday = ?, position = ?, salary = ? WHERE id = ?";
            PreparedStatement pstmt = dbConnection.prepareStatement(updateQuery);

            pstmt.setString(1, this.name);
            pstmt.setString(2, this.email);
            pstmt.setString(3, this.phoneNumber);
            pstmt.setString(4, this.address);
            pstmt.setString(5, this.birthDay);
            pstmt.setString(6, this.position);
            pstmt.setString(7, this.salary);
            pstmt.setInt(8, this.id);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "se ha actualizado la información", "Atención",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "No se puede actualizar la información", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            System.err.println("ERROR: " + sqle);
        }

    }

    public void RequestPermission() {
        // TODO make this method
    }

    public void ReportAbsence() {
        // TODO make this method
    }
}