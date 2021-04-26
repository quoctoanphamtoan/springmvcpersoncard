package com.springmvchibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class hibernateConfig {
	private final static SessionFactory FACTORY;
	static {
		try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                            .configure("hibernate.cfg.xml").build();
            Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            FACTORY = metaData.getSessionFactoryBuilder().build();
    } catch (Throwable th) {
            throw new ExceptionInInitializerError(th);
    }
	}
	public static SessionFactory getFactory() {
		return FACTORY;
	}
	 
	
}
