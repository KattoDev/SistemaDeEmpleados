package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Department {

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void Create(Connection dbConnection, ArrayList<String> employeeList) {

        String locateDeptQuery = "SELECT id FROM departments WHERE name = ?";
        String addDepartmentQuery = "INSERT INTO departments (name) values (?)";

        try {
            // Añade el departamento a la DB
            PreparedStatement ad_pstmt = dbConnection.prepareStatement(addDepartmentQuery);
            ad_pstmt.setString(1, getName());
            ad_pstmt.executeUpdate();

            // Actualiza el ID del departamento
            PreparedStatement ld_pstmt = dbConnection.prepareStatement(locateDeptQuery);
            ld_pstmt.setString(1, getName());
            ResultSet ld_rs = ld_pstmt.executeQuery();
            if (ld_rs.next()) {
                this.setId(ld_rs.getInt("id"));
            }

            AssignEmployee(dbConnection, employeeList);

            JOptionPane.showMessageDialog(null, "Se ha añadido el departamento.", "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "No se se puede añadir el departamento.\nDebido a: " + sqle, "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }
    }

    public void AssignEmployee(Connection dbConnection, ArrayList<String> employeeList) {
        String locateEmployeeQuery = "SELECT id FROM users WHERE name = ?";
        String modifyEmployeeQuery = "UPDATE users SET assignedDepartment = ? WHERE id = ?";

        try {
            for (String employee : employeeList) {
                int employeeid = 0;

                // Search the employee by name and gets the ID
                PreparedStatement le_pstmt = dbConnection.prepareStatement(locateEmployeeQuery);
                le_pstmt.setString(1, employee);
                ResultSet le_rs = le_pstmt.executeQuery();
                if (le_rs.next()) {
                    employeeid = le_rs.getInt("id");
                }

                // Sets the department ID to the user
                PreparedStatement me_pstmt = dbConnection.prepareStatement(modifyEmployeeQuery);
                me_pstmt.setInt(1, getId());
                me_pstmt.setInt(2, employeeid);
                me_pstmt.executeUpdate();
            }
        }
        catch (SQLException sqleu) {
            JOptionPane.showMessageDialog(null,
                    "No se se puede añadir el empleado al departamento.\nDebido a: " + sqleu, "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("rawtypes")
    public ArrayList GetDepartmentInfo(Connection dbConnection, String deptName) {
        String deptInfoQuery = "SELECT * FROM departments WHERE name = ?";
        String userNameQuery = "SELECT name FROM users WHERE assignedDepartment = ?";
        
        ArrayList<String> employeeList = new ArrayList<>();

        try {
            PreparedStatement pstmt = dbConnection.prepareStatement(deptInfoQuery);
            pstmt.setString(1, deptName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                setId(rs.getInt("id"));
                setName(rs.getString("name"));
            }

            try {
                PreparedStatement upstmt = dbConnection.prepareStatement(userNameQuery);
                upstmt.setInt(1, getId());
                ResultSet urs = upstmt.executeQuery();

                while (urs.next()) {
                    employeeList.add(urs.getString("name"));
                }
            }
            catch (SQLException sqle) {
                System.err.println("ERROR, No se puede obtener la información de los usuarios debido a: " + sqle);
            }
        }
        catch (SQLException sqle) {
            System.err.println("ERROR, No se puede obtener la información debido a: " + sqle);
        }
        return employeeList;
    }
}
