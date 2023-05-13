package prj.cardealershipnew.LoginAuthentication;

import prj.cardealershipnew.salesman.Salesman;

public class RegisteredEmployee {


    private String username ;
    private String password ;
    private Salesman salesman ;


    public RegisteredEmployee(String username, String password, Salesman salesman) {
        this.username = username;
        this.password = password;
        this.salesman = salesman;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }
}
