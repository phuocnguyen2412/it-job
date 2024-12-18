package models.bean;

import java.util.Arrays;

public class Account {
    private int id;
    private int adminId;
    private String email;
    private byte[] password;
    private int roleId;
    private String roleName;
    private int isLocked;

    public Account() {
    }

    public Account(int id, int adminId, String email, byte[] password, int roleId, String roleName, int isLocked) {
        this.id = id;
        this.adminId = adminId;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.roleName = roleName;
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


    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getIsLocked() {
        return isLocked;
    }

    public void getIsLocked(int isLocked) {
        this.isLocked = isLocked;
    }

    public void setIsLocked(int isLocked) { this.isLocked = isLocked;}

    @Override
    public String toString() {
        // Trả về chuỗi mô tả đối tượng
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password=" + new String(password) +  // Mảng byte sẽ được chuyển thành chuỗi
                ", roleId=" + roleId +
                ", isLocked=" + isLocked +
                '}';
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
