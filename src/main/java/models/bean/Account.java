package models.bean;

public class Account {
    private int id;
    private int adminId;
    private String email;
    private byte[] password;
    private int roleId;
    private int isLocked;

    public Account() {}

    public Account(int id, int adminId, String email, byte[] password, int roleId, int isLocked) {
        this.id = id;
        this.adminId = adminId;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.isLocked = isLocked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getEmail() { return email;}

    public void setEmail(String email) { this.email = email;}

    public byte[] getPassword() { return password;}

    public void setPassword(byte[] password) { this.password = password;}

    public int getRoleId() {return roleId;}

    public void setRoleId(int roleId) { this.roleId = roleId;}

    public int getIsLooked() {return isLocked;}

    public void getIsLocked(int isLocked) { this.isLocked = isLocked;}
}
