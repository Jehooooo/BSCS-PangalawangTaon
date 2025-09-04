
import java.util.Scanner;

public class UniversityManagementSystem {

    static abstract class UniversityMember {

        protected String name;
        protected int id;
        protected String department;

        public UniversityMember(String name, int id, String department) {
            this.name = name;
            this.id = id;
            this.department = department;
        }

        public void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Department: " + department);
        }
    }

    static abstract class Faculty extends UniversityMember {

        protected double baseSalary; // monthly
        protected String subject;

        public Faculty(String name, int id, String department, double baseSalary, String subject) {
            super(name, id, department);
            this.name = name;
            this.id = id;
            this.department = department;
            this.baseSalary = baseSalary;
            this.subject = subject;
        }

        public double calculateAnnualSalary() {
            return baseSalary * 12; // annual salary
        }

        @Override
        public void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Department: " + department);
            System.out.println("Base Salary (Monthly): " + baseSalary);
            System.out.println("Subject: " + subject);
        }
    }

    static class RegularFaculty extends Faculty {

        private double clothingAllowance;
        private double sportsAllowance;

        public RegularFaculty(String name, int id, String department, double baseSalary, String subject, double clothingAllowance, double sportsAllowance) {
            super(name, id, department, baseSalary, subject);

            this.clothingAllowance = clothingAllowance;
            this.sportsAllowance = sportsAllowance;
        }

        public double calculateAnnualBenefits() {
            return (clothingAllowance + sportsAllowance) * 12; // annual benefits
        }

        @Override
        public void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Department: " + department);
            System.out.println("Base Salary (Monthly): " + baseSalary);
            System.out.println("Subject: " + subject);
            System.out.println("Faculty Type: Regular");
            System.out.println("Clothing Allowance: " + clothingAllowance);
            System.out.println("Sports Allowance: " + sportsAllowance);
            System.out.println("Annual Benefits: " + calculateAnnualBenefits());
        }

    }

    public static void MainFunction() {
        Scanner sc = new Scanner(System.in);
        String choice;
        // Main Menu
        System.out.println("=== UNIVERSITY MANAGEMENT SYSTEM ===");
        System.out.println("1. Faculty");
        System.out.println("2. Staff");
        System.out.println("3. Student");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
        int mainOption = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (mainOption) {
            case 1:
                // Faculty Menu
                System.out.println("--- FACULTY MENU ---");
                System.out.println("1. Regular Faculty");
                System.out.println("2. Contractual Faculty");
                System.out.print("Choose faculty type: ");
                int facultyOption = sc.nextInt();
                sc.nextLine();

                if (facultyOption == 1) {
                    System.out.println("--- ADD REGULAR FACULTY ---");
                    if (facultyOption == 1) {
                        System.out.println("--- ADD REGULAR FACULTY ---");
                        System.out.println("Name: ");
                        String name = sc.nextLine();

                        System.out.println("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // consume newline

                        System.out.println("Department: ");
                        String dept = sc.nextLine();

                        System.out.println("Base Salary (monthly): ");
                        double salary = sc.nextDouble();
                        sc.nextLine(); // consume newline

                        System.out.println("Subject: ");
                        String subject = sc.nextLine();

                        System.out.println("Clothing Allowance: ");
                        double clothing = sc.nextDouble();
                        sc.nextLine(); // consume newline

                        System.out.println("Sports Allowance: ");
                        double sports = sc.nextDouble();
                        sc.nextLine(); // consume newline
                        System.out.println("--- REGULAR FACULTY DETAILS ---");
                        RegularFaculty regularFaculty = new RegularFaculty(name, id, dept, salary, subject, clothing, sports);
                        regularFaculty.displayDetails();

                    } else if (facultyOption == 2) {
                        System.out.println("--- ADD CONTRACTUAL FACULTY ---");
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("ID: ");
                        String id = sc.nextLine();
                        System.out.print("Department: ");
                        String dept = sc.nextLine();
                        System.out.print("Base Salary (monthly): ");
                        String salary = sc.nextLine();
                        System.out.print("Subject: ");
                        String subject = sc.nextLine();
                        System.out.print("Contract Duration (Months): ");
                        String duration = sc.nextLine();

                        System.out.println("--- CONTRACTUAL FACULTY DETAILS ---");
                        System.out.println("Name: " + name);
                        System.out.println("ID: " + id);
                        System.out.println("Department: " + dept);
                        System.out.println("Base Salary (Monthly): " + salary);
                        System.out.println("Subject: " + subject);
                        System.out.println("Faculty Type: Contractual");
                        System.out.println("Contract Duration: " + duration + " months");
                        System.out.println("Total Contract Benefits: [to be calculated]");
                    }
                    break;
                }
            case 2:
                // Staff
                System.out.println("--- ADD STAFF ---");
                System.out.print("Name: ");
                String sName = sc.nextLine();
                System.out.print("ID: ");
                String sId = sc.nextLine();
                System.out.print("Department: ");
                String sDept = sc.nextLine();
                System.out.print("Base Salary (monthly): ");
                String sSalary = sc.nextLine();
                System.out.print("Position: ");
                String sPos = sc.nextLine();
                System.out.print("Overtime Hours: ");
                String sHours = sc.nextLine();
                System.out.print("Overtime Rate: ");
                String sRate = sc.nextLine();

                System.out.println("--- STAFF DETAILS ---");
                System.out.println("Name: " + sName);
                System.out.println("ID: " + sId);
                System.out.println("Department: " + sDept);
                System.out.println("Base Salary (Monthly): " + sSalary);
                System.out.println("Position: " + sPos);
                System.out.println("Overtime Hours: " + sHours);
                System.out.println("Overtime Rate: " + sRate);
                System.out.println("Annual Benefits: [to be calculated]");
                break;

            case 3:
                // Student
                System.out.println("--- ADD STUDENT ---");
                System.out.print("Name: ");
                String stName = sc.nextLine();
                System.out.print("ID: ");
                String stId = sc.nextLine();
                System.out.print("Department: ");
                String stDept = sc.nextLine();
                System.out.print("Course: ");
                String stCourse = sc.nextLine();
                System.out.print("GPA: ");
                String stGPA = sc.nextLine();

                System.out.println("--- STUDENT DETAILS ---");
                System.out.println("Name: " + stName);
                System.out.println("ID: " + stId);
                System.out.println("Department: " + stDept);
                System.out.println("Course: " + stCourse);
                System.out.println("GPA: " + stGPA);
                break;

            case 4:
                System.out.println("Exiting...");
                return;

            default:
                System.out.println("Invalid option. Try again.");
        }

        System.out.print("Enter another details? Y/N: ");
        choice = sc.nextLine();

        sc.close();
    }

    public static void main(String[] args) {
        MainFunction();

    }
}
