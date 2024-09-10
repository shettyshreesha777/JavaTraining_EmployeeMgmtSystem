import java.util.Scanner;

public class UserMenu {
    EmployeeOperations employeeOperations = new EmployeeOperations();

    public void Menu(){
        int option;
        Scanner scanner = new Scanner(System.in);
        EmployeeOperations employeeOperations = new EmployeeOperations();

        do {
            System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("1. Add employee to List");
            System.out.println("2. Delete employee from List");
            System.out.println("3. Update existing employee in List");
            System.out.println("4. Display All Employees in List");
            System.out.println("5. Display Employee by ID");
            System.out.println("6. Display Employee by Name");
            System.out.println("7. Employee count in each Department");
            System.out.println("8. Exit");
            System.out.println("Enter your option: ");
            option= scanner.nextInt();

            switch(option){
                case 1: employeeOperations.addEmployeeToList();
                        break;
                case 2: employeeOperations.deleteEmployeeFromList();
                        break;
                case 3: employeeOperations.updateEmployeeById();
                        break;
                case 4: employeeOperations.displayAllEmployees();
                        break;
                case 5: employeeOperations.displayEmployeeById();
                        break;
                case 6: employeeOperations.displayEmployeeByName();
                        break;
                case 7: employeeOperations.EmployeeDepartmentCount();
                        break;
                case 8: break;
                default:
                    System.out.println("Please select a option from the provided menu.");
            }
        }while(option!=8);
    }
}
