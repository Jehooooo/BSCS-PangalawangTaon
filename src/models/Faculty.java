package models;

public class Faculty extends Member{
    private String position;


    public Faculty(String name, int numberID, String department, String position) {
        super(name, numberID, department);
        this.position = position;

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String getMemberInfo() {
        return "\nName: " + getName() + "\nID: " + getNumberID() + "\nDepartment: " + getDepartment() +
               "\nPosition: " + position;
    }
}
