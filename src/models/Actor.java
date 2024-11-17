package models;

public class Actor {
    private String fullName;
    private String role;

    public Actor(){}
    public Actor(String role, String fullName) {
        this.role = role;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return  "\n\t\t_________________________"+
                "\n\t\tfullName: " + fullName +
                "\n\t\trole    : " + role ;
    }
}
