public enum Designation {
    INTERN(30000),
    JUNIOR(50000),
    SENIOR(80000),
    MANAGER(120000),
    DIRECTOR(150000);

    private final int salary;

    Designation(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}