/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Manideep
 */
@ManagedBean
@SessionScoped
public class GetData implements Serializable{

    /**
     * Creates a new instance of GetData
     */
    
    private String jobid;
    private String jobtitle;
    private String jobdesc;
    private String jobpos;
    
    private String darray;
    private String aarray;
    


   
    
    public String getDarray() {
        return darray;
    }

    public void setDarray(String darray) {
        this.darray = darray;
    }

    public String getAarray() {
        return aarray;
    }

    public void setAarray(String aarray) {
        this.aarray = aarray;
    }

    

    public GetData(String appid, String acctid, String jobid, String fullname, String qualification, String yexp, String fexp, String contact, String status) {
        this.jobid = jobid;
        this.appid = appid;
        this.acctid = acctid;
        this.fullname = fullname;
        this.qualification = qualification;
        this.yexp = yexp;
        this.fexp = fexp;
        this.contact = contact;
        this.status = status;
    }
    


    private String appid;
    private String acctid;
    private String fullname;
    private String qualification;
    private String yexp;
    private String fexp;
    private String contact;
    private String status;
    private String jID;

    public String getjID() {
        return jID;
    }

    public void setjID(String jID) {
        this.jID = jID;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAcctid() {
        return acctid;
    }

    public void setAcctid(String acctid) {
        this.acctid = acctid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getYexp() {
        return yexp;
    }

    public void setYexp(String yexp) {
        this.yexp = yexp;
    }

    public String getFexp() {
        return fexp;
    }

    public void setFexp(String fexp) {
        this.fexp = fexp;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    public GetData(String jobid, String jobtitle, String jobdesc, String jobpos) {
        this.jobid = jobid;
        this.jobtitle = jobtitle;
        this.jobdesc = jobdesc;
        this.jobpos = jobpos;
    }
    
public GetData(String darray, String aarray) {
        this.darray = darray;
        this.aarray = aarray;
    }
    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getJobdesc() {
        return jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        this.jobdesc = jobdesc;
    }

    public String getJobpos() {
        return jobpos;
    }

    public void setJobpos(String jobpos) {
        this.jobpos = jobpos;
    }
    
 
    
}
