package prj.cardealershipnew.salesman;

public class Employee {


    private String empID ;
    private String empName;
    private int empPhone;
    private String empAddress;
    private String empEmail ;
    private String DOB ;


    public Employee(String empID, String empName, int empPhone, String empAddress, String empEmail, String DOB) {
        this.empID = empID;
        this.empName = empName;
        this.empPhone = empPhone;
        this.empAddress = empAddress;
        this.empEmail = empEmail;
        this.DOB = DOB;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(int empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID='" + empID + '\'' +
                ", empName='" + empName + '\'' +
                ", empPhone=" + empPhone +
                ", empAddress='" + empAddress + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", DOB='" + DOB + '\'' +
                '}';
    }



}
