package models;

public class Member {
    private String name;
    private int numberID;
    private String department;

    public Member(String name, int numberID, String department) {
        this.name = name;
        this.numberID = numberID;
        this.department = department;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumberID() {
        return numberID;
    }
    public void setNumberID(int numberID) {
        this.numberID = numberID;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMemberInfo() {
        return "Name: " + name + ", ID: " + numberID + ", Department: " + department;
    }

}

