/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.sms.hibernate;

import com.java.sms.bean.RegisterBean;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author harmeet.singh
 */
public class HibernateDaoUtil {
    
    
    
    public static void saveOrUpdate(Object obj){
        
        Session session = null;
        Transaction transaction = null;
        
        try{
            
            session = HibernateConnector.getInstance().getCurrentSession();
            session.clear();
            transaction = session.beginTransaction();
            session.saveOrUpdate(obj);
            transaction.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    
    public static RegisterBean authenticateUser(String email,String password){
        
        RegisterBean registerBean=null;
        Session session = null;
        Transaction transaction = null;
        String qry ="";
        Query query=null;
        try{
            
            qry = "from RegisterBean r where r.email=:emailId and r.password=:pass";
            query = HibernateConnector.getInstance().getCurrentSession().createQuery(qry);
            query.setParameter("emailId", email);
            query.setParameter("pass", password);
            registerBean = (RegisterBean)query.uniqueResult();
        }catch(HibernateException he){
            
            he.printStackTrace();
        }
        return  registerBean;
    }
    
}
