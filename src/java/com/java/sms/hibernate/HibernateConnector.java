/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.sms.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author harmeet.singh
 */
public class HibernateConnector {
    
    
    private static HibernateConnector instance;
    private SessionFactory sessionFactory;
    private final ThreadLocal<Session> session = new ThreadLocal<Session>();    
    private HibernateConnector(){
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
    }
    
    public static HibernateConnector getInstance(){
        
        if(null == instance)
            instance = new HibernateConnector();
        return instance;
    }
    
    public Session getCurrentSession(){
        
        Session currentSession = session.get();
        if(currentSession==null){
            
            currentSession = sessionFactory.openSession();
            session.set(currentSession);
        }
        return currentSession;
    }
    
    public void closeSession() throws HibernateException {
        Session currentSession = (Session) session.get();
        session.set(null);
        if (currentSession != null) {
            currentSession.flush();
            currentSession.clear();
            currentSession.close();
            
        }
    }
    
}
