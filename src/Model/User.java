package Model;

import java.io.Serializable;

public class User implements Serializable {
    private int userID;
    private String Name;
    private String userPhoneNumber;
    private String userEmail;
    private String userName;
    private String passWord;
    private Role.RoleName roleName;

    public User() {
    }

    public User(int userID, String name) {
        this.userID = userID;
        this.Name = name;
    }

    public User(int userID, String name, String userPhoneNumber, String userEmail, String userName, String passWord, Role.RoleName roleName) {
        this.userID = userID;
        this.Name = name;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userName = userName;
        this.passWord = passWord;
        this.roleName = roleName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    public Role.RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(Role.RoleName roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", Name='" + Name + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", roleName=" + roleName +
                '}' + "\n";
    }

    public String toStringReceiptUser() {
        return "User{" +
                "userID=" + userID +
                ", Name='" + Name + '\'' +
                '}' + "\n";
    }
}
