package models.dao;

import config.Database;
import models.bean.CompanyAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecruitmentAddressDAO {
    public ArrayList<CompanyAddress> getCompanyAddress(int recruitmentId){
        String query = """
                        SELECT * FROM CompanyAddress JOIN RecruitmentAddress ON CompanyAddress.Id = RecruitmentAddress.AddressId
                        WHERE RecruitmentId = ?
                """;
        ArrayList<CompanyAddress> result = new ArrayList<>();
        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(query)){

            stmt.setInt(1, recruitmentId);
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    CompanyAddress companyAddress = new CompanyAddress();
                    companyAddress.setId(rs.getInt("Id"));
                    companyAddress.setAddress(rs.getString("Address"));
                    companyAddress.setCompanyId(rs.getInt("CompanyId"));
                    companyAddress.setDetail(rs.getString("Detail"));
                    result.add(companyAddress);
                }
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return result;
    }

}
