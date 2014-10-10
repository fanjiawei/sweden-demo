package com.whereareyou.provider;

import com.google.inject.Provider;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by 家玮 on 2014/7/27.
 */
public class EntityManagerProvider implements Provider<EntityManager> {
    @Override
    public EntityManager get() {
        return Persistence.createEntityManagerFactory("database").createEntityManager();
    }
}
