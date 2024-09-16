package com.example.demo.dao;

import com.example.demo.entity.Phone;
import com.example.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        Phone phone1 = new Phone("1234567","1","57");
        Phone phone2 = new Phone("1234567","1","57");
        Phone phone3 = new Phone("33333","3","88");
        List<Phone> telephones = new ArrayList<Phone>();
        telephones.add(phone1);
        telephones.add(phone2);
        telephones.add(phone3);


        User user = new User(telephones, "John Doe", "john.doe@example.com");
        userDAO.saveUser(user);
    }
}
