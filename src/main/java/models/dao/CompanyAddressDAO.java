package models.dao;

import config.Database;
import models.bean.CompanyAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyAddressDAO {
    public int handleCreateCompanyAddress(CompanyAddress companyAddress){
        String query = "INSERT INTO CompanyAddress (CompanyId, Address, Detail) VALUES (?, ?, ?)";
        int result;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, companyAddress.getCompanyId());
            stmt.setString(2, companyAddress.getAddress());
            stmt.setString(3, companyAddress.getDetail());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int handleEditCompanyAddress(CompanyAddress companyAddress){
        String query = "UPDATE CompanyAddress SET Address = ?, Detail = ?";
        int result;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, companyAddress.getAddress());
            stmt.setString(2, companyAddress.getDetail());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int handleDeleteCompanyAddress(int companyAddressId){
        String query = "DELETE FROM CompanyAddress WHERE Id = ?";
        int result;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, companyAddressId);

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public ArrayList<CompanyAddress> getCompanyAddress(int companyId){
        String query = "SELECT * FROM CompanyAddress WHERE CompanyId = ?";
        ArrayList<CompanyAddress> result = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, companyId);

            try(ResultSet rs = stmt.executeQuery()) {
                while(rs.next()){
                    CompanyAddress companyAddress = new CompanyAddress();
                    companyAddress.setId(rs.getInt("Id"));
                    companyAddress.setCompanyId(rs.getInt("CompanyId"));
                    companyAddress.setAddress(rs.getString("Address"));
                    companyAddress.setDetail(rs.getString("Detail"));

                    result.add(companyAddress);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
