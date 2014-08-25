package am.training.dao;

import am.training.dao.entity.Address;
import am.training.dao.entity.Company;
import am.training.dao.entity.User;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by nadya on 8/16/14.
 */

@Service
public class GeneralDaoImpl implements GeneralDao {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public boolean insert(Object obj) {
        Object o = sessionFactory.getCurrentSession().save(obj);
        return (o != null) ? true : false;
    }

    @Override
    public List<User> selectUserList(Company company) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("companies", company));
        List<User> users = criteria.list();
        if (!users.isEmpty())
            return users;
        return null;
    }

    @Override
    public List<Company> selectCompanyList() {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);

        List<Company> companyList = criteria.list();
        if (!companyList.isEmpty())
            return companyList;
        return null;

    }

    @Override
    public List<Address> selectAddressList() {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);

        List<Address> addressList = criteria.list();
        if (!addressList.isEmpty())
            return addressList;
        return null;
    }

    @Override
    public User selectUser(String userName, String password) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("userName", userName));
        criteria.add(Restrictions.eq("passwd", password));

        List<User> users = criteria.list();
        if (!users.isEmpty())
            return users.get(0);
        return null;
    }
}
