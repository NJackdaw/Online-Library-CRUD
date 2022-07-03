package PasswordPack;

public class Password {
    private String password;
    private int passwordID;

    public Password(String password, int passwordID) {
        this.password = password;
        this.passwordID = passwordID;
    }

    public Password() {
    }

    public int getPasswordID() {
        return passwordID;
    }

    public void setPasswordID(int passwordID) {
        this.passwordID = passwordID;
    }

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
