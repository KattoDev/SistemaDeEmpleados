package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Administrator extends User {

    public void EmployeeRegistration(Connection dbConnection, User newEmployee) {

        try {
            String updateQuery = "INSERT INTO users (name, address, birthday, phoneNumber, email, position, salary, password) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = dbConnection.prepareStatement(updateQuery);

            pstmt.setString(1, newEmployee.getName());
            pstmt.setString(2, newEmployee.getAddress());
            pstmt.setString(3, newEmployee.getBirthDay());
            pstmt.setString(4, newEmployee.getPhoneNumber());
            pstmt.setString(5, newEmployee.getEmail());
            pstmt.setString(6, newEmployee.getPosition());
            pstmt.setString(7, newEmployee.getSalary());
            pstmt.setString(8, newEmployee.getPassword());

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha registrado el nuevo empleado", "Atención",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "No se se puede registrar el empleado", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            System.err.println("ERROR: " + sqle);
        }

    }

}
