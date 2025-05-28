//package model;

//public class Admin {
//    private String employeeId;
//    private String name;
//    private String email;
//    private String password;
//
//    public Admin(String employeeId, String name, String email, String password) {
//        this.employeeId = employeeId;
//        this.name = name;
//        this.email = email;
//        this.password = password;
//    }
//
//    public String getEmployeeId() {
//        return employeeId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//}

package model;

public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
}