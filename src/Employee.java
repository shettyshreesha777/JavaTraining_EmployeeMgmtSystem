import java.time.LocalDate;
import java.time.Period;

/*
Employee attributes:  id, name, age (calculate base on DOB),
full address (current and parmanent), emailId, department (use enum),
designation, salary band (use enum for salasy band s1, s2, s3, s4) , PAN,
bank account number, gender,
father or husband name, married status (use enum for various status), status
 */
public class Employee {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private int age;
    private Address Current_address;
    private Address Permanent_address;
    private String email;
    private Department dept;
    private Designation designation;
    private float salary;
    private String PAN_number;
    private long Bank_AccNo;
    private String gender;
    private MaritalStatus maritalStatus;
    private String fatherName;
    private String spouseName;
    private int object_status;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCurrent_address() {
        return Current_address.toString();
    }

    public String getPermanent_address() {
        return Permanent_address.toString();
    }

    public String getEmail() {
        return email;
    }

    public String getDept() {
        return dept.name();
    }

    public String getDesignation() {
        return designation.name();
    }

    public float getSalaryBand() {
        return salary;
    }

    public String getPAN_number() {
        return PAN_number;
    }

    public long getBank_AccNo() {
        return Bank_AccNo;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus.name();
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public int getObject_status() {
        return object_status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        LocalDate currentDate = LocalDate.now();
        age=Period.between(dateOfBirth, currentDate).getYears();
    }

    public void setCurrent_address(Address current_address) {
        Current_address = current_address;
    }

    public void setPermanent_address(Address permanent_address) {
        Permanent_address = permanent_address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public void setDesignation(Designation designation) {

        this.designation = designation;
        salary = this.designation.getSalary();
    }

    public void setPAN_number(String PAN_number) {
        this.PAN_number = PAN_number;
    }

    public void setBank_AccNo(long bank_AccNo) {
        Bank_AccNo = bank_AccNo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public void setObject_status(int object_status) {
        this.object_status = object_status;
    }

    public int getAge() {
        return age;
    }

}
