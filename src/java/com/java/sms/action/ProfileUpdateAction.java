/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.sms.action;

import com.java.sms.bean.RegisterBean;
import com.java.sms.hibernate.HibernateDaoUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author harmeet.singh
 */
public class ProfileUpdateAction extends ActionSupport implements ModelDriven<RegisterBean>,SessionAware{
    
    private RegisterBean rb ;
    private SessionMap<String ,Object> sm;
    
    @Override
    public RegisterBean getModel(){
        rb = new RegisterBean();
        return rb;
    }
    
    @Action(value = "/updateAction",results = {
    
        @Result(name = "success",type = "redirect" ,location = "/index.jsp"),
        @Result(name = "error",location = "/errorPage.jsp")
    })
    @Override
    public String execute(){
        
        RegisterBean bean= (RegisterBean)sm.get("user");
        int regId = bean.getRegId();
        
        int res =HibernateDaoUtil.updateProfile(regId, rb);
        if(res>0){
        sm.invalidate();
        return SUCCESS;
        }
        else
            return ERROR;
    }

    @Override
    public void setSession(Map<String, Object> map) {

        sm = (SessionMap<String, Object>)map;
    }
}
