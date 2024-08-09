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
                    setId(rs.getInt("id"));
                    setName(rs.getString("name"));
                    setAddress(rs.getString("address"));
                    setBirthDay(rs.getString("birthday"));
                    setPhoneNumber(rs.getString("phoneNumber"));
                    setEmail(rs.getString("email"));
                    setPosition(rs.getString("position"));
                    setSalary(rs.getString("salary"));
                    setPassword(rs.getString("password"));
                    setIsAdmin(rs.getInt("isAdmin"));
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
     * @param userId
     * @param dbConnection
     */
    public void SeeInfo(int userId, Connection dbConnection) {
        try (PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    setName(rs.getString("name"));
                    setAddress(rs.getString("address"));
                    setBirthDay(rs.getString("birthday"));
                    setPhoneNumber(rs.getString("phoneNumber"));
                    setEmail(rs.getString("email"));
                    setPosition(rs.getString("position"));
                }
            }
        }
        catch (SQLException e) {
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
        String updateQuery = "UPDATE users SET name = ?, email = ?, phoneNumber = ?, address = ?, birthday = ?, position = ?, salary = ?, password = ? WHERE id = ?";
        try (PreparedStatement pstmt = dbConnection.prepareStatement(updateQuery)){

            pstmt.setString(1, getName());
            pstmt.setString(2, getEmail());
            pstmt.setString(3, getPhoneNumber());
            pstmt.setString(4, getAddress());
            pstmt.setString(5, getBirthDay());
            pstmt.setString(6, getPosition());
            pstmt.setString(7, getSalary());
            pstmt.setString(8, getPassword());
            pstmt.setInt(9, getId());

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