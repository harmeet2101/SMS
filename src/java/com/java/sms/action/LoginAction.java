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
    ,@Result(name = "error",location = "/adminLoginPage.jsp"),@Result(name = "input",location = "/adminLoginPage.jsp")
    })
    public String execute() {
	
         RegisterBean rb= HibernateDaoUtil.authenticateUser(loginBean.getEmail(), loginBean.getPassword());
        if(rb!=null){
        
            sessionMap.put("username", rb.getFirstName());
            sessionMap.put("isLoggedIn", true);
            sessionMap.put("user", rb);
            return SUCCESS;
        }
        else{
            addActionError("Try Again.login Failed");
            return ERROR;
        }
    }    

    @Override
    public void setSession(Map<String, Object> map) {

        this.sessionMap = (SessionMap)map;
    }
    
    @Action(value = "/doLogout",results = {
        @Result(name = "success",type = "redirect" ,location = "/welcomePage.jsp")
    })
    public String doLogout(){
        
        this.sessionMap.put("username", null);
        sessionMap.invalidate();
        return "success";
    }
    
    @Action(value = "/viewProfile",results = {
        @Result(name = "success",location = "/profilePage.jsp")
    })
    public String viewProfile(){
        
        return SUCCESS;
    }

    @Override
    public void validate() {

        try{
        if( loginBean!=null && loginBean.getEmail().length()<1)
            addFieldError("email", "Email required");
        if(loginBean!=null &&loginBean.getPassword().length()<1)
            addFieldError("password", "Password required");
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
}
