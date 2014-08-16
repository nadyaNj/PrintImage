package am.training.dao;

import am.training.dao.entity.Address;
import am.training.dao.entity.Company;
import am.training.dao.entity.User;

import java.util.List;

/**
 * Created by nadya on 8/16/14.
 */
public interface GeneralDao {
    public boolean insert(Object obj);
    public List<User> selectUserList(Company company);
    public List<Company> selectCompanyList();
    public List<Address> selectAddressList();
    public User selectUser(String userName, String password);
}
