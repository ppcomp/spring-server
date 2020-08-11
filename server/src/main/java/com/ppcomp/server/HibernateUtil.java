package com.ppcomp.server;

import com.ppcomp.server.entity.Notice;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static String configFile = "hibernate.cfg.xml";

    static {
        try {
            Configuration cfg = new Configuration().configure(configFile);
//            cfg.addAnnotatedClass(Notice.class);
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();
            sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
        } catch (Throwable th) {
            System.err.println("Enitial SessionFactory creation failed" + th);
            throw new ExceptionInInitializerError(th);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void shutdown() {
        sessionFactory.close();
    }
}