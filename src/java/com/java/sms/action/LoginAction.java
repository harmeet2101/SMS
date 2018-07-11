/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.sms.action;

import com.java.sms.bean.LoginBean;
import com.java.sms.bean.RegisterBean;
import com.java.sms.hibernate.HibernateDaoUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author harmeet.singh
 */
public class LoginAction extends ActionSupport implements ModelDriven<LoginBean>,SessionAware{

   private LoginBean loginBean;
   private SessionMap<String,Object> sessionMap;
   
   public LoginBean getModel(){
       
       loginBean = new LoginBean();
       return loginBean;
   }

    public LoginAction() {
        
    }
    
    
    
    @Action(value = "/loginAction",results = {@Result(name = "success",location = "/homePage.jsp")
    ,@Result(name = "input",location = "/errorPage.jsp")
    })
    public String execute() {
	
        RegisterBean rb = HibernateDaoUtil.authenticateUser(loginBean.getEmail(), loginBean.getPassword());
        if(rb!=null){
        
            sessionMap.put("username", rb.getFirstName());
            sessionMap.put("isLoggedIn", true);
            
            return SUCCESS;
        }
        else
            return INPUT;
    
    }    

    @Override
    public void setSession(Map<String, Object> map) {

        this.sessionMap = (SessionMap)map;
    }
}
