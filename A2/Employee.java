// Part 1: Employee class (inherits Person)
public class Employee extends Person {
    private String employeeId; // Unique employee ID
    private String department; // Department (e.g., Ride Operations)

    // Default Constructor
    public Employee() {
        super();
        this.employeeId = "";
        this.department = "";
    }

    // Parameterized Constructor
    public Employee(String name, int age, String email, String employeeId, String department) {
        super(name, age, email);
        this.employeeId = employeeId;
        this.department = department;
    }

    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

}