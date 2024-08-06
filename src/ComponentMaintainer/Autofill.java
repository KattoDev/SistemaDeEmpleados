package ComponentMaintainer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JTextField;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

/**
 * @author Kris
 */
public class Autofill {

    private ArrayList<String> employees = new ArrayList<String>();
    private ArrayList<String> departments = new ArrayList<String>();
    private ArrayList<String> projects = new ArrayList<String>();

    /**
     * Adds the function to autocomplete the Employee field
     * 
     * @param dbConnection The connection with the database.
     * @param field        The target txtField to add the functionality
     */
    public void LoadEmployeeList(Connection dbConnection, JTextField field) {
        try {
            PreparedStatement stmt = dbConnection.prepareStatement("SELECT name FROM users");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employees.add(rs.getString("name"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        @SuppressWarnings({
                "unchecked", "rawtypes" })
        JList employeeslist = new JList(employees.toArray());

        AutoCompleteDecorator.decorate(employeeslist, field, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
    }

    /**
     * Adds the function to autocomplete the project field
     * 
     * @param dbConnection The connection with the database.
     * @param field        The target txtField to add the functionality
     */
    public void LoadProjectList(Connection dbConnection, JTextField field) {
        try {
            PreparedStatement stmt = dbConnection.prepareStatement("SELECT name FROM projects");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                projects.add(rs.getString("name"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        @SuppressWarnings({
                "unchecked", "rawtypes" })
        JList projectsList = new JList(projects.toArray());

        AutoCompleteDecorator.decorate(projectsList, field, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
    }

    /**
     * Adds the function to autocomplete the department field
     * 
     * @param dbConnection The connection with the database.
     * @param field        The target txtField to add the functionality
     */
    public void LoadDepartmentList(Connection dbConnection, JTextField field) {
        try {
            PreparedStatement stmt = dbConnection.prepareStatement("SELECT name FROM departments");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                departments.add(rs.getString("name"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        @SuppressWarnings({
                "unchecked", "rawtypes" })
        JList departmentList = new JList(departments.toArray());

        AutoCompleteDecorator.decorate(departmentList, field, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
    }

    public void LoadCustomList(String[] list, JTextField field) {
        @SuppressWarnings({
                "unchecked", "rawtypes" })
        JList itemList = new JList(list);

        AutoCompleteDecorator.decorate(itemList, field, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
    }

}
