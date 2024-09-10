import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Formatter;


public class EmployeeOperations {

    public List<Employee> employeeList = new ArrayList<Employee>();

    /**
     * Create employee.
     * gets input from user and assigns value to employee object variables
     * @return the employee
     */
    public static Employee createEmployee()

    {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();

        //employee.setId(getValidInt(scanner, "Enter ID: "));

        employee.setName(getValidString(scanner, "Enter Name: "));

        employee.setDateOfBirth(getValidDate(scanner, "Enter Date of Birth (yyyy-mm-dd): "));

        System.out.println("Enter Current Address:");
        employee.setCurrent_address(readAddress(scanner));

        System.out.println("Enter Permanent Address:");
        employee.setPermanent_address(readAddress(scanner));

        employee.setEmail(getValidString(scanner, "Enter Email: "));

        employee.setDept(getValidEnum(scanner, Department.class, "Enter Department (HR, IT, SALES, MARKETING, FINANCE, ADMINISTRATION): "));

        employee.setDesignation(getValidEnum(scanner, Designation.class, "Enter DesignationBand (INTERN, JUNIOR, SENIOR, MANAGER, DIRECTOR): "));

        employee.setPAN_number(getValidString(scanner, "Enter PAN Number: "));

        employee.setBank_AccNo((getValidLong(scanner, "Enter Bank Account Number: ")));

        employee.setGender(getValidString(scanner, "Enter Gender: "));

        employee.setMaritalStatus(getValidEnum(scanner, MaritalStatus.class, "Enter Marital Status (SINGLE, MARRIED, DIVORCED, WIDOW): "));

        employee.setFatherName(getValidString(scanner, "Enter Father's Name: "));

        if(employee.getMaritalStatus().equals("SINGLE") || employee.getMaritalStatus().equals("DIVORCED")) {
            employee.setSpouseName(null);
        }
        else{
            employee.setSpouseName(getValidString(scanner, "Enter Spouse's Name: "));
        }

        employee.setObject_status(1);

        return employee;
    }

    /**
     * Add employee to list.
     * uses createEmployee() method to create employee object.
     * checks if the created object is already present in the list by comparing email-id and PAN number
     * sets the visibility status of object as 1
     * adds object to the list
     */
    public void addEmployeeToList(){
        Employee employee = new Employee();
        employee = createEmployee();
        int flag=0;

        //Check for duplicate
        for(Employee e : employeeList){
            if(employee.getEmail().equals(e.getEmail()) || employee.getPAN_number().equals(e.getPAN_number())){
                flag=1;
                System.out.println("Employee already exists. Please enter a Employee that isn't already in the list.");
                break;
            }
        }
        if(flag == 0){
            int id = 0;
            if(!employeeList.isEmpty()){
                id = employeeList.get(employeeList.size()-1).getId();
            }
            employee.setId(id + 1);
            employeeList.add(employee);
            System.out.println(employee + "has been added successfully \n\n");
        }
    }

    private static Address readAddress(Scanner scanner) {
        Address address = new Address();

        address.setHouseName(getValidString(scanner, "House Name: "));
        address.setStreetName(getValidString(scanner, "Street Name: "));
        address.setLandmark(getValidString(scanner, "Landmark: "));
        address.setPincode(getValidString(scanner, "Pincode: "));

        return address;
    }

    private static String getValidString(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }

    private static int getValidInt(Scanner scanner, String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return input;
    }

    private static long getValidLong(Scanner scanner, String prompt) {
        long input;
        while (true) {
            System.out.print(prompt);
            try {
                input = Long.parseLong(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid long integer.");
            }
        }
        return input;
    }

    private static LocalDate getValidDate(Scanner scanner, String prompt) {
        LocalDate date;
        while (true) {
            System.out.print(prompt);
            try {
                date = LocalDate.parse(scanner.nextLine().trim());
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
            }
        }
        return date;
    }

    private static <T extends Enum<T>> T getValidEnum(Scanner scanner, Class<T> enumClass, String prompt) {
        T enumValue;
        while (true) {
            System.out.print(prompt);
            try {
                enumValue = Enum.valueOf(enumClass, scanner.nextLine().trim().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter one of the following values: " + String.join(", ", getEnumValues(enumClass)));
            }
        }
        return enumValue;
    }

    private static <T extends Enum<T>> String[] getEnumValues(Class<T> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

    /**
     * Update employee by id.
     * asks user to enter the id of the employee to be updated.
     * user can select wh
     */
    public void updateEmployeeById() {
        int Emp_id, employee_present=0;
        Scanner scanner = new Scanner(System.in);
        Emp_id=getValidInt(scanner, "Enter the ID of the Employee to be updated: ");

        //check if ID present in arrayList
        for(Employee z : employeeList){
            if(z.getId() == Emp_id && z.getObject_status() == 1){
                int option;
                employee_present=1;
                System.out.println("Employee with ID is present!");
                System.out.println("Select the attribute of Employee you would like to update: ");
                System.out.println("1. Name \n 2. Current Address \n "
                        + "3.Permanent Address \n 4. Department \n 5. Designation \n "
                        + "6. Salary Band \n 7. Bank Account Number \n "
                        + "8. Marital Status \n 9. Spouse Name");
                option=scanner.nextInt();
                switch(option){
                    case 1 : z.setName(getValidString(scanner, "Enter Name: "));
                             System.out.println("Name has been updated");
                             break;
                    case 2 : z.setCurrent_address(readAddress(scanner));
                             System.out.println("Current Address has been updated");
                             break;
                    case 3 : z.setPermanent_address(readAddress(scanner));
                             System.out.println("Permanent Address has been updated");
                             break;
                    case 4 : z.setDept(getValidEnum(scanner, Department.class, "Enter Department (HR, IT, SALES, MARKETING, FINANCE, ADMINISTRATION): "));
                             System.out.println("Department has been updated");
                             break;
                    case 5 : z.setDesignation(getValidEnum(scanner, Designation.class, "Enter Designation (INTERN, JUNIOR, SENIOR, MANAGER, DIRECTOR): "));
                             System.out.println("Designation has been updated");
                             break;
                    case 6 : z.setBank_AccNo((getValidLong(scanner, "Enter Bank Account Number: ")));
                             System.out.println("Bank Account has been updated");
                             break;
                    case 7 : z.setMaritalStatus(getValidEnum(scanner, MaritalStatus.class, "Enter Marital Status (SINGLE, MARRIED, DIVORCED, WIDOW): "));
                             System.out.println("Marital Status has been updated");
                             break;
                    case 8 : z.setSpouseName(getValidString(scanner, "Enter Spouse's Name: "));
                             System.out.println("Spouse Name has been updated");
                             break;
                    default :
                        System.out.println("Entered the Wrong Option");

                }
                break;
            }
        }
        if(employee_present == 0)
        {
            System.out.println("Employee with ID: "+Emp_id+" is not present.");
        }

    }

    public void deleteEmployeeFromList(){
        int Emp_id, employee_present=0;
        Scanner scanner = new Scanner(System.in);
        Emp_id=getValidInt(scanner, "Enter the ID of the Employee to be Deleted: ");

        for(Employee z : employeeList) {
            if (z.getId() == Emp_id) {
                employee_present=1;
                z.setObject_status(0);
            }
            System.out.println("Employee ID: "+Emp_id+" has been Deleted.");
        }
        if(employee_present == 0)
        {
            System.out.println("Employee with ID: "+Emp_id+" is not present.");
        }

    }

    public void displayAllEmployees(){
        Formatter fmt = new Formatter();
        System.out.println("EMPLOYEE DETAILS");
        fmt.format("%15s %15s %15s %15s %15s %15s\n", "ID", "NAME", "AGE",
                "DEPARTMENT", "DESIGNATION", "GENDER");
        System.out.println(fmt);
        for(Employee z : employeeList){
            if(z.getObject_status() == 1) {
                fmt.format("%15s %15s %15s %15s %15s %15s\n", z.getId(), z.getName(),
                        z.getAge(), z.getDept(), z.getDesignation(), z.getGender());
                System.out.println(fmt);
            }
        }
    }

    public void displayEmployeeById(){
        Scanner scanner = new Scanner(System.in);
        int eid=getValidInt(scanner, "Enter the ID of the Employee: ");

        for(Employee e : employeeList){
            if(e.getId() == eid && e.getObject_status() == 1){
                Formatter fmt = new Formatter();
                System.out.println("EMPLOYEE DETAILS");
                System.out.println("ID : "+e.getId() + "\nNAME : "+e.getName() +
                        "\nAGE : "+e.getAge() + "\nDATE OF BIRTH : "+e.getDateOfBirth() +
                        "\nCURRENT ADDRESS : "+e.getCurrent_address() + "\nPERMANENT ADDRESS : "+e.getPermanent_address() +
                        "\nEMAIL : "+e.getEmail() + "\nDEPARTMENT : "+e.getDept() + "\nDESIGNATION : "+e.getDesignation() +
                        "\nSALARY BAND : "+e.getSalaryBand() + "\nPAN NUMBER : "+e.getPAN_number() +
                        "\nGENDER : "+e.getGender() + "\nMARITAL STATUS : "+e.getMaritalStatus() +
                        "\nFATHER NAME : "+e.getFatherName() + "\nSPOUSE NAME : "+e.getSpouseName());
            }

        }
    }

    public void displayEmployeeByName(){
        Scanner scanner = new Scanner(System.in);
        String EmployeeName = getValidString(scanner, "Enter the Name of the Employee: ");

        for(Employee e : employeeList){
            if(e.getName().equals(EmployeeName) && e.getObject_status() == 1){
                Formatter fmt = new Formatter();
                System.out.println("EMPLOYEE DETAILS");
                System.out.println("ID : "+e.getId() + "\nNAME : "+e.getName() +
                        "\nAGE : "+e.getAge() + "\nDATE OF BIRTH : "+e.getDateOfBirth() +
                        "\nCURRENT ADDRESS : "+e.getCurrent_address() + "\nPERMANENT ADDRESS : "+e.getPermanent_address() +
                        "\nEMAIL : "+e.getEmail() + "\nDEPARTMENT : "+e.getDept() + "\nDESIGNATION : "+e.getDesignation() +
                        "\nSALARY BAND : "+e.getSalaryBand() + "\nPAN NUMBER : "+e.getPAN_number() +
                        "\nGENDER : "+e.getGender() + "\nMARITAL STATUS : "+e.getMaritalStatus() +
                        "\nFATHER NAME : "+e.getFatherName() + "\nSPOUSE NAME : "+e.getSpouseName());
            }

        }
    }

    public void EmployeeDepartmentCount() {
        int HR_count = (int) employeeList.stream().filter(employee -> employee.getDept().equals("HR")).count();
        int IT_count = (int) employeeList.stream().filter(employee -> employee.getDept().equals("IT")).count();
        int SALES_count = (int) employeeList.stream().filter(employee -> employee.getDept().equals("SALES")).count();
        int MARKETING_count = (int) employeeList.stream().filter(employee -> employee.getDept().equals("MARKETING")).count();
        int FINANCE_count = (int) employeeList.stream().filter(employee -> employee.getDept().equals("FINANCE")).count();
        int ADMINISTRATION_count = (int) employeeList.stream().filter(employee -> employee.getDept().equals("ADMINISTRATION")).count();

        System.out.println("Employee Count in each Department");
        System.out.println("HR : "+HR_count);
        System.out.println("IT : "+IT_count);
        System.out.println("SALES : "+SALES_count);
        System.out.println("MARKETING : "+MARKETING_count);
        System.out.println("FINANCE : "+FINANCE_count);
        System.out.println("ADMINISTRATION : "+ADMINISTRATION_count);

    }
}
