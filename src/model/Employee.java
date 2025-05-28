//    package model;
//
//    public class Employee {
//        private String employeeId;
//        private String name;
//        private String email;
//        private String password;
//
//        public Employee(String employeeId, String name, String email, String password) {
//            this.employeeId = employeeId;
//            this.name = name;
//            this.email = email;
//            this.password = password;
//        }
//
//        public String getEmployeeId() {
//            return employeeId;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//    }

package model;

public class Employee {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private int age;
    private String dob;
    private String department;
    private String designation;
    private String username;
    private String password;

    public Employee(String id, String name, String email, String phone, String gender,
                    int age, String dob, String department, String designation,
                    String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
        this.dob = dob;
        this.department = department;
        this.designation = designation;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
    public String getDob() {
        return dob;
    }
    public String getDepartment() {
        return department;
    }
    public String getDesignation() {
        return designation;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public boolean isManager() {
        return designation != null && designation.equalsIgnoreCase("Manager");
    }
}






//package model;
//
//public class Employee {
//    private String empId;
//    private String name;
//    private String email;
//    private String phone;
//    private String gender;
//    private int age;
//    private String dob;
//    private String department;
//    private String designation;
//    private String username;
//    private String password;
//
//    public Employee(String empId, String name, String email, String phone, String gender,
//                    int age, String dob, String department, String designation,
//                    String username, String password) {
//        this.empId = empId;
//        this.name = name;
//        this.email = email;
//        this.phone = phone;
//        this.gender = gender;
//        this.age = age;
//        this.dob = dob;
//        this.department = department;
//        this.designation = designation;
//        this.username = username;
//        this.password = password;
//    }
//
//    // Getters
//    public String getEmpId() { return empId; }
//    public String getName() { return name; }
//    public String getEmail() { return email; }
//    public String getPhone() { return phone; }
//    public String getGender() { return gender; }
//    public int getAge() { return age; }
//    public String getDob() { return dob; }
//    public String getDepartment() { return department; }
//    public String getDesignation() { return designation; }
//    public String getUsername() { return username; }
//    public String getPassword() { return password; }
//}
