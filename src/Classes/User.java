package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ComponentMaintainer.DatabaseConection;
import javax.swing.JOptionPane;


public class User {

    DatabaseConection dbc = new DatabaseConection();

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

    // Constructors
    public User() {
    }

    public User(int id, String name, String address, String birthDay, String phoneNumber, String email, String position,
            String salary, String password, String checkinHour, String checkoutHour) {
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

    // Methods

    /**
     * Method for User Auth
     * @param email The email registered in the system
     * @param password The password registered in the system
     * @return the Auth status
     */
    public boolean Authenticate(String email, String password) {
        dbc.connectDatabase();
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (PreparedStatement stmt = dbc.connection.prepareStatement(query)) {

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
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                return false;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    /**
     * <ul>
     * <li>Fetch the user profile in the system, overriding the info fetched in Login().</li>
     * <li>Connects to the DB</li>
     * <li>Disconects the DB after fetch</li>
     * </ul>
     */
    public void SeeInfo() {
        dbc.connectDatabase();
        try {
            PreparedStatement stmt = dbc.connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                this.name = rs.getString("name");
                this.address = rs.getString("address");
                this.birthDay = rs.getString("birthday");
                this.phoneNumber = rs.getString("phoneNumber");
                this.email = rs.getString("email");
                this.position = rs.getString("position");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbc.CloseConnection();
    }

    public void UpdateInfo() {
        dbc.connectDatabase();
        try {
            String updateQuery = "UPDATE users SET name = ?, email = ?, phoneNumber = ?, address = ?, birthday = ?, position = ?, salary = ?";
            PreparedStatement pstmt = dbc.connection.prepareStatement(updateQuery);

            pstmt.setString(1, this.name);
            pstmt.setString(2, this.email);
            pstmt.setString(4, this.phoneNumber);
            pstmt.setString(5, this.address);
            pstmt.setString(6, this.birthDay);
            pstmt.setString(7, this.position);
            pstmt.setString(8, this.salary);
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "No se puede actualizar la información", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            System.err.println("ERROR: " + sqle);
        }
        dbc.CloseConnection();
    }

    public void RequestPermission() {
    }

    public void ReportAbsence() {
    }
}