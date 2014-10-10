package com.whereareyou;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 家玮 on 2014/7/26.
 */
public class Util {
    public static EntityManager ENTITY_MANAGER = Persistence.createEntityManagerFactory("database").createEntityManager();
    public static Object save(Lamb lamb){
        ENTITY_MANAGER.getTransaction().begin();
        Object object = lamb.run();
        ENTITY_MANAGER.persist(object);
        ENTITY_MANAGER.getTransaction().commit();
        return object;
    }

    public static Object save(Object object){
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.persist(object);
        ENTITY_MANAGER.getTransaction().commit();
        return object;
    }

    public static List<Object> save(Object... objects){
        List result = new ArrayList<Object>();
        for(int i=0;i<objects.length;i++){
            result.add(Util.save(objects[i]));
        }
        return result;
    }
}
