package ComponentMaintainer;

import GUI.MainModules.Dashboard;
import GUI.MainModules.Login;

import GUI.DialogModules.EditDepartment;
import GUI.DialogModules.NewDepartment;
import GUI.DialogModules.NewProject;
import GUI.DialogModules.EditProject;
import GUI.DialogModules.NewTask;
import GUI.DialogModules.TasksList;
import GUI.DialogModules.EditTask;

import GUI.Modules.Departments;
import GUI.Modules.FindEmployee;
import GUI.Modules.EmployeeRegister;
import GUI.Modules.EmployeeProfile;
import GUI.Modules.Projects;
import GUI.Modules.GeneralReports;

/**
 * @author Kris
 */
public class CM_Views {

  public static GUI.MainModules.Login LoginWindow() {
    return new Login();
  }

  public static GUI.MainModules.Dashboard DashboardWindow() {
    return new Dashboard();
  }

  public class EmployeesModule {

    public static GUI.Modules.EmployeeRegister EmployeeRegister() {
      return new EmployeeRegister();
    }

    public static GUI.Modules.FindEmployee FindEmployee() {
      return new FindEmployee();
    }
  }

  public class DepartmentsModule {

    public static GUI.Modules.Departments Departaments() {
      return new Departments();
    }

    public static GUI.DialogModules.NewDepartment NewDepartment() {
      return new NewDepartment();
    }

    public static GUI.DialogModules.EditDepartment EditDepartment() {
      return new EditDepartment();
    }
  }

  public class EmployeeProfileModule {

    public static GUI.Modules.EmployeeProfile EmployeeProfile() {
      return new EmployeeProfile();
    }
  }

  public class ProjectsModule {

    public static GUI.Modules.Projects Projects() {
      return new Projects();
    }

    public static GUI.DialogModules.NewProject NewProject() {
      return new NewProject();
    }

    public static GUI.DialogModules.EditProject EditProject() {
      return new EditProject();
    }

    public static GUI.DialogModules.NewTask NewTask() {
      return new NewTask();
    }

    public static GUI.DialogModules.EditTask EditTask() {
      return new EditTask();
    }

    public static GUI.DialogModules.TasksList TaskList() {
      return new TasksList();
    }
  }

  public class ReportModule {
    public static GUI.Modules.GeneralReports GeneralReports() {
      return new GeneralReports();
    }
  }
}
