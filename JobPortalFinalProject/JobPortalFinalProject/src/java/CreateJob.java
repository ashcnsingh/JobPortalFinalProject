/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author manideepdhumale
 */
@ManagedBean
@SessionScoped
public class CreateJob implements Serializable{

    /**
     * Creates a new instance of CreateJob
     */
    
     private String jobid1;
     private String jobtitle1;
     private String jobdesc1;
     private String jobpos1;

    public String getJobid1() {
        return jobid1;
    }

    public void setJobid1(String jobid1) {
        this.jobid1 = jobid1;
    }

    public String getJobtitle1() {
        return jobtitle1;
    }

    public void setJobtitle1(String jobtitle1) {
        this.jobtitle1 = jobtitle1;
    }

    public String getJobdesc1() {
        return jobdesc1;
    }

    public void setJobdesc1(String jobdesc1) {
        this.jobdesc1 = jobdesc1;
    }

    public String getJobpos1() {
        return jobpos1;
    }

    public void setJobpos1(String jobpos1) {
        this.jobpos1 = jobpos1;
    }


   
public String createjob()
{
     try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //return to internalError.xhtml
            return ("internalError");
        }
        

                         //connect to the database & insert a record
                         final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/nagraja5860";
        
                         Connection connection = null;
                         Statement statement = null;
                         ResultSet resultSet = null;
       
                         try
                         {
                             //connect tothe databse
                             connection = DriverManager.getConnection(DATABASE_URL, 
                               "nagraja5860", "1321506");
                             //create a statement
                             statement = connection.createStatement();
             
                             
                            int r = statement.executeUpdate("insert into job values "
                           + "('" + jobid1 + "', '" + jobtitle1 + "','" + jobdesc1 + "','" + jobpos1 + "')");
  
             
                            return "successfull";
                           
                         }
                         catch(SQLException e)
                         {
                             e.printStackTrace();
                             return "internalError";
                         }
                         finally
                         {
                            //close the database
                             try
                             {
                                 resultSet.close();
                                 statement.close();
                                 connection.close();
                             }
                             catch(Exception e)
                             {
                                 e.printStackTrace();
                             }
                         }
                         
                         

    
}
    
    
}   
    

