package utils;

import java.util.regex.Pattern;

public class ValidationUtils {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^\\S+@\\S+\\.\\S+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");
    private static final Pattern DOB_PATTERN = Pattern.compile("^\\d{2}_\\d{2}_\\d{4}$");

    public static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidPhone(String phone) {
        return PHONE_PATTERN.matcher(phone).matches();
    }

    public static boolean isValidDOB(String dob) {
        return DOB_PATTERN.matcher(dob).matches();
    }

    public static boolean isValidAge(int age) {
        return age >= 18 && age <= 60;
    }

    public static boolean isValidGender(String gender) {
        return gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Other");
    }

    public static boolean isValidDepartment(String department) {
        String dep = department.trim();
        return dep.equalsIgnoreCase("QA") ||
                dep.equalsIgnoreCase("Developer") ||
                dep.equalsIgnoreCase("Devops") ||
                dep.equalsIgnoreCase("BI and Reporting");
    }

//    public static boolean isValidDepartment(String department) {
//        return department.equalsIgnoreCase("QA") || department.equalsIgnoreCase("Developer") || department.equalsIgnoreCase("Devops")|| department.equalsIgnoreCase("BI and Reporting");
//    }
}
