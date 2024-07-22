package ComponentMaintainer;

import GUI.DialogModules.EditDepartment;
import GUI.DialogModules.NewDepartment;
import GUI.Modules.Departments;
import GUI.Modules.FindEmployee;
import GUI.Modules.EmployeeRegister;
import GUI.Modules.EmployeeProfile;

/**
 * @author Kris
 */
public class CM_Views {
    
    public class EmployeesModule {

        public static GUI.Modules.EmployeeRegister EmployeeRegister(){
            return new EmployeeRegister();
        }

        public static GUI.Modules.FindEmployee FindEmployee(){
            return new FindEmployee();
        }

    }
    
    public class DepartmentsModule{

        public static GUI.Modules.Departments Departaments(){
            return new Departments();
        }

        public static GUI.DialogModules.NewDepartment NewDepartment(){
            return new NewDepartment();
        }
        
        public static GUI.DialogModules.EditDepartment EditDepartment(){
            return new EditDepartment();
        }
    }

    public class EmployeeProfileModule{

        public static GUI.Modules.EmployeeProfile EmployeeProfile(){
            return new EmployeeProfile();
        }
    }


}
