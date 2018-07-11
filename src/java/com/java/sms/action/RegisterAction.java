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
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author harmeet.singh
 */
public class RegisterAction extends ActionSupport implements ModelDriven<RegisterBean>{
    
    private RegisterBean registerBean;
    
    @Override
    public RegisterBean getModel(){
        registerBean =new RegisterBean();
        return registerBean;
    }
    
    @Action(value = "/registerAction",results = {
        @Result(name = "success",location = "/homePage.jsp")
    })
    @Override
    public String execute(){
    
        HibernateDaoUtil.saveOrUpdate(registerBean);
        return SUCCESS;
    }
}
