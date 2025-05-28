//package service;
//
//import model.Admin;
//import utils.InputUtils;
//
//import java.util.List;
//
//public class SignupService {
//    private static final String SECRET_PASSCODE = "1234"; // hardcoded passcode
//
//    public static void adminSignup(List<Admin> admins) {
//        while (true) {
//            String passcode = InputUtils.getStringInput("Enter 4-digit Passcode: ");
//            if (passcode.equals(SECRET_PASSCODE)) {
//                System.out.println("Passcode Verified. Proceeding with Signup...\n");
//                break;
//            } else {
//                System.out.println("Incorrect Passcode! Try Again or type 'exit' to go back.");
//                String choice = InputUtils.getStringInput("Enter choice: ");
//                if (choice.equalsIgnoreCase("exit")) {
//                    return;
//                }
//            }
//        }
//
//        String name = InputUtils.getStringInput("Enter Admin Name: ");
//        String empId = InputUtils.getStringInput("Enter Employee ID (combination of letters and numbers): ");
//        String email = InputUtils.getStringInput("Enter Email: ");
//        String password = InputUtils.getStringInput("Create Password: ");
//
//        Admin admin = new Admin(empId, name, email, password);
//        admins.add(admin);
//
//        System.out.println("Admin Signup Successful!\n");
//    }
//}
