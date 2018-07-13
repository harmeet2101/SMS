/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.sms.hibernate;

import com.java.sms.bean.RegisterBean;
import com.java.sms.bean.StudentBean;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author harmeet.singh
 */
public class HibernateDaoUtil {
    
    
    
    public static int saveOrUpdate(Object obj){
        
        Session session = null;
        Transaction transaction = null;
        int count=0;
        try{
            
            session = HibernateConnector.getInstance().getCurrentSession();
            session.clear();
            transaction = session.beginTransaction();
            session.saveOrUpdate(obj);
            transaction.commit();
            session.close();
            count++;
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        
        return count;
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
    
    
    public static int updateProfile(int id,RegisterBean rb){
        
        int count =0;
        
        Session session = HibernateConnector.getInstance().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String qry="";
        Query q=null;
        
        qry = "update RegisterBean set first_name=:fn ,last_name=:ln , "
                + "email_id=:email, user_type=:ut where reg_id=:id";
        q = session.createQuery(qry);
        q.setString("fn",rb.getFirstName());
        q.setString("ln",rb.getLastName());
        q.setString("email", rb.getEmail());
        q.setString("ut", rb.getRegisterationType());
        q.setInteger("id", id);
        q.executeUpdate();
        transaction.commit();
        session.close();
        count++;
        return count;
    }
    
    
    public static List<StudentBean> getAllStudents(){
        
        Session session = HibernateConnector.getInstance().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String qry="from StudentBean";
        Query q=session.createQuery(qry);
        List<StudentBean> list =  q.list();
        
        return list;
    }
}
