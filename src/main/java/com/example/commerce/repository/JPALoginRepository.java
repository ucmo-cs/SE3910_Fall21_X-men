package com.example.commerce.repository;

import com.example.commerce.domain.UserTable;
import org.hibernate.UnknownEntityTypeException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JPALoginRepository implements UserRepository
{
    private EntityManager em;

    public JPALoginRepository(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public int setOffline(UserTable user)
    {
        user.setOnline(0);
        return 0;
    }

    @Override
    public int setOnline(UserTable user)
    {
        user.setOnline(1);
        return 0;
    }

    @Override
    public UserTable searchUser(String username, String password)
    {
        List<UserTable> users = em.createQuery("select u from UserTable u where u.name = :name and u.password = :password", UserTable.class)
                .setParameter("name", username)
                .setParameter("password", password)
                .getResultList();

        if (users.get(0) == null)
            return null;
        else
        {
            setOnline(users.get(0));
            return users.get(0);
        }
    }

    @Override
    public UserTable setOfflineIfOnline()
    {
        List<UserTable> users = em.createQuery("select u from UserTable u where u.online=1", UserTable.class)
                .getResultList();
        for (UserTable user : users)
        {
            setOffline(user);
        }
        return null;
    }
}
