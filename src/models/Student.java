package models;

public class Student extends Member {
    private String year;
    private String major;

    public Student(String name, int numberID, String department, String year, String major) {
        super(name, numberID, department);
        this.year = year;
        this.major = major;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    @Override
    public String getMemberInfo() {
        return "\nName: " + getName() + "\nID: " + getNumberID() + "\nDepartment: " + getDepartment() +
               "\nYear: " + getYear() + "\nCourse: " + getMajor();
    }
}
