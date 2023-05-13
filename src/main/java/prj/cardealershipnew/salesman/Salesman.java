package prj.cardealershipnew.salesman;

public class Salesman extends Employee{


    private String salesmanID ;
    private double salary ;
    public Salesman(String empID, String empName, int empPhone, String empAddress, String empEmail, double salary, String DOB) {
        super(empID, empName, empPhone, empAddress, empEmail, DOB);
        this.salesmanID = empID ;
        this.salary = salary;
    }


    public String getSalesmanID() {
        return salesmanID;
    }

    public void setSalesmanID(String salesmanID) {
        this.salesmanID = salesmanID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "salesmanID='" + salesmanID + '\'' +
                ", salary=" + salary +
                '}';
    }
}
