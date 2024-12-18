package models.bo;

import models.bean.CompanyAddress;
import models.dao.CompanyAddressDAO;

import java.util.ArrayList;
import java.util.List;

public class CompanyAddressBO {
    CompanyAddressDAO companyAddressDAO = new CompanyAddressDAO();

    public int handleCreateCompanyAddress(CompanyAddress companyAddress) {
        return companyAddressDAO.handleCreateCompanyAddress(companyAddress);
    }

    public int handleEditCompanyAddress(CompanyAddress companyAddress) {
        return companyAddressDAO.handleEditCompanyAddress(companyAddress);
    }

    public int handleDeleteCompanyAddress(int companyAddressId) {
        return companyAddressDAO.handleDeleteCompanyAddress(companyAddressId);
    }

    public ArrayList<CompanyAddress> getCompanyAddress(int companyId) {
        return companyAddressDAO.getCompanyAddress(companyId);
    }

    public CompanyAddress mockAdress() {
        return new CompanyAddress(1, 1, "769 Nguyen Dinh Chieu, Da Kao, District 1, Ho Chi Minh", "Dong Nhan Building");
    }

    public List<CompanyAddress> mockAdresses() {
        return new ArrayList<CompanyAddress>() {
            {
                add(new CompanyAddress(1, 1, "769 Nguyen Dinh Chieu, Da Kao, District 1, Ho Chi Minh", "Dong Nhan Building"));
                add(new CompanyAddress(2, 1, "12 Trung Kinh, Yen Hoa, Hanoi", "Center Point"));
                add(new CompanyAddress(3, 1, "260 Lý Thái Tông, Hòa Minh, Liên Chiểu, Đà Nẵng", ""));
            }
        };
    }
}
