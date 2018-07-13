/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.sms.action;

import com.java.sms.bean.StudentBean;
import com.java.sms.hibernate.HibernateDaoUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author harmeet.singh
 */
public class StudentAction extends ActionSupport implements ModelDriven<StudentBean>{
    
    
    private StudentBean sb;
    
    @Override
    public StudentBean getModel(){
        sb = new StudentBean();
        return sb;
    }
    
    
    @Action(value = "/addStudent",results = {@Result(name = "success",location = "/homePage.jsp"),
            @Result(name = "error",location = "/addStudent.jsp")
    })
    @Override
    public String execute(){
        
        int res =HibernateDaoUtil.saveOrUpdate(sb);
        if(res>0)
        return SUCCESS;
        else{
            addActionError("Error in adding student");
            return ERROR;
        }      
    }    
    
    
    @Action(value = "/allStudents",results = {@Result(name = "success",location = "/allStudent.jsp")
    ,@Result(name = "error",location = "/errorPage.jsp")
    })
    public String getAllStudents(){
     
       sbl = HibernateDaoUtil.getAllStudents();
        if(sb!=null)
        return SUCCESS;
        else
            return ERROR;
    }
    
    List<StudentBean> sbl;

    public List<StudentBean> getSbl() {
        return sbl;
    }

    public void setSbl(List<StudentBean> sbl) {
        this.sbl = sbl;
    }
    
}
