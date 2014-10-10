package com.whereareyou;

import com.google.inject.AbstractModule;
import com.whereareyou.provider.EntityManagerProvider;
import com.whereareyou.service.UserService;
import com.whereareyou.service.impl.UserServiceImpl;

import javax.persistence.EntityManager;

/**
 * Created by 家玮 on 2014/7/27.
 */
public class Modules extends AbstractModule{

    @Override
    public void configure() {
        bind(EntityManager.class).toProvider(EntityManagerProvider.class);
        bind(UserService.class).to(UserServiceImpl.class);
//        bind(CreditCardProcessor.class)
//                .annotatedWith(Names.named("Checkout"))
//                .to(CheckoutCreditCardProcessor.class);
    }
}
