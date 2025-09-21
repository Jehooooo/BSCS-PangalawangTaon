//LAGYAN NG 'STATIC' BEFORE OR AFTER THE 'ABSTRACT' YUNG CLASS NA 'TO IF NEEDED
    abstract class UniversityMember {

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
//LAGYAN NG 'STATIC' BEFORE OR AFTER THE 'ABSTRACT' YUNG CLASS NA 'TO IF NEEDED
    abstract class Faculty extends UniversityMember {

        protected double baseSalary; // monthly
        protected String subject;

        public Faculty(String name, int id, String department, double baseSalary, String subject) {
            super(name, id, department);
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
//LAGYAN NG 'STATIC' BEFORE OR AFTER THE 'ABSTRACT' YUNG CLASS NA 'TO IF NEEDED
    abstract class RegularFaculty extends Faculty {

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