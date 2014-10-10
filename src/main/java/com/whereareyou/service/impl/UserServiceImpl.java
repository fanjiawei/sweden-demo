package com.whereareyou.service.impl;

import com.google.inject.Provider;
import com.whereareyou.model.User;
import com.whereareyou.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by 家玮 on 2014/7/26.
 */
public class UserServiceImpl implements UserService{
    final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final EntityManager em;

    @Inject
    public UserServiceImpl(Provider<EntityManager> entityManagerProvider){
        this.em = entityManagerProvider.get();
    }

    public User getByUsername(String username){
        String queryString = "SELECT u FROM User u WHERE u.username = :username";
        Query query = em.createQuery(queryString);

        query.setParameter("username", username);
        try {
            return (User) query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public User getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        log.debug(subject.getPrincipal().toString());
        return getByUsername(subject.getPrincipal().toString());
    }

    @Override
    public User getByUserId(String userId) {
        String queryString = "SELECT u FROM User u WHERE u.id=:userId";
        Query query = em.createQuery(queryString);
        query.setParameter("userId",userId);
        try {
            return (User) query.getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }
}
