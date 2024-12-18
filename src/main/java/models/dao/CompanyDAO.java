package models.dao;

import config.Database;
import models.bean.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyDAO {
    public int handleCreateCompany(Company company) throws SQLException{
        String query = """
                        INSERT INTO Company (Name, Introduce, Country, Industry, WorkingDays, Size, Detail, Email, Logo, AccountId) 
                        VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        int result;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, company.getName());
            stmt.setString(2, company.getIntroduce());
            stmt.setString(3, company.getCountry());
            stmt.setString(4, company.getIndustry());
            stmt.setString(5, company.getWorkingDays());
            stmt.setString(6, company.getSize());
            stmt.setString(7, company.getDetail());
            stmt.setString(8, company.getEmail());
            stmt.setString(9, company.getLogo());
            stmt.setInt(10, company.getAccountId());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int handleEditCompany(Company company) throws SQLException{
        String query = """
                   UPDATE Company SET Name = ?, Introduce = ?, Country = ?, Industry = ?, WorkingDays = ?, Size = ?, Detail = ?, Email = ?, Logo = ?
                   WHERE Id = ?
                """;
        int result;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, company.getName());
            stmt.setString(2, company.getIntroduce());
            stmt.setString(3, company.getCountry());
            stmt.setString(4, company.getIndustry());
            stmt.setString(5, company.getWorkingDays());
            stmt.setString(6, company.getSize());
            stmt.setString(7, company.getDetail());
            stmt.setString(8, company.getEmail());
            stmt.setString(9, company.getLogo());
            stmt.setInt(10, company.getId());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int handleDeleteCompany(int companyId) throws SQLException{
        String query = "DELETE FROM Company WHERE Id = ?";
        int result;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, companyId);

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Company getCompanyById(int companyId) {
        String query = "SELECT * FROM Company WHERE Id = ?";
        Company result = new Company();
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, companyId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    result = resultSetToCompany(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Company getCompanyByAccountId(int accountId) {
        String query = "SELECT * FROM Company WHERE AccountId = ?";
        Company result = new Company();
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, accountId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    result = resultSetToCompany(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public ArrayList<Company> getCompanyList() throws SQLException{
        String query = "SELECT * FROM Company ORDER BY Size DESC LIMIT 12";
        ArrayList<Company> result = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Company company = resultSetToCompany(rs);
                    result.add(company);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public ArrayList<Company> searchCompany(String city, String searchInput) throws SQLException{
        ArrayList<Company> result = new ArrayList<>();
        String query;
        if (city.equals("All Cities")) {
            query = "SELECT Name FROM Company WHERE Company.Name LIKE ?";
            try (Connection conn = Database.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, "%" + searchInput + "%");
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        result.add(resultSetToCompany(rs));
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            query = """
                    SELECT Name FROM Company JOIN CompanyAddress ON Company.Id = CompanyAddress.CompanyId 
                    WHERE CompanyAddress.Address = ? AND Company.Name LIKE ?
            """;
            try (Connection conn = Database.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, city);
                stmt.setString(2, "%" + searchInput + "%");
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        result.add(resultSetToCompany(rs));
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public Company resultSetToCompany(ResultSet rs) throws SQLException{
        Company company = new Company();
        try {
            company.setId(rs.getInt("Id"));
            company.setAccountId(rs.getInt("AccountId"));
            company.setSize(rs.getString("Size"));
            company.setName(rs.getString("Name"));
            company.setIntroduce(rs.getString("Introduce"));
            company.setCountry(rs.getString("Country"));
            company.setIndustry(rs.getString("Industry"));
            company.setWorkingDays(rs.getString("WorkingDays"));
            company.setDetail(rs.getString("Detail"));
            company.setEmail(rs.getString("Email"));
            company.setLogo(rs.getString("Logo"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return company;
    }
}
