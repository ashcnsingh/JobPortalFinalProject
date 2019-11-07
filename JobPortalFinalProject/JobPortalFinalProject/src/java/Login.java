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
import java.util.ArrayList;
import java.util.Scanner;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Manideep
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable{

    public ArrayList<userDetails> getApp() {
        return app;
    }

    public void setApp(ArrayList<userDetails> app) {
        this.app = app;
    }

    private String id;
    private String password;
    private JobAccount theLoginAccount;
    private String type;
    public String jobID;
    public String lname;
    private String jobTitle;
    private String jobDesc;

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    private int currentitem = 0;
    
    public ArrayList<GetData> list1= new ArrayList<>();
    public ArrayList<userDetails> app= new ArrayList<>();

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }
    
    
    

    public ArrayList<GetData> getList1() {
        return list1;
    }

    public void setList1(ArrayList<GetData> list1) {
        this.list1 = list1;
    }

    public int getCurrentitem() {
        return currentitem;
    }

    public void setCurrentitem(int currentitem) {
        this.currentitem = currentitem;
    }
    
    

    public JobAccount getTheLoginAccount() {
        return theLoginAccount;
    }

    public void setTheLoginAccount(JobAccount theLoginAccount) {
        this.theLoginAccount = theLoginAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public String goFormuser(String id)
    {
        setJobID(id);
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
        
        final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/nagraja5860";
        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
        ResultSet resultSet = null;   //set of results
        
        
        try
        {      
            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "nagraja5860", "1321506");   
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery("Select * from job where jobID = '" + jobID + "'");
            
            if(resultSet.next())
            {
               jobTitle = resultSet.getString(2);
               jobDesc = resultSet.getString(3);
            }
            else
            {
                jobTitle = "";
                jobDesc = "";
                
                return "internalError";
                 
            }
            
        }
        catch (SQLException e)
        {
            //go to internalError.xhtml
            e.printStackTrace();
            return ("internalError");
        }
        finally
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
                 
            }
            catch (Exception e)
            {
                e.printStackTrace();    
            }
        }
        return "applyFormuser";
    }
    
    
    
    public String login() {
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
        
        final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/nagraja5860";
        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
        ResultSet resultSet = null;   //set of results
        
        
        try
        {      
            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "nagraja5860", "1321506");   
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery("Select * from account "
                    + "where acctID = '" + 
                    id + "'" );
            
            if(resultSet.next())
            {
                //id is found
                if(password.equals(resultSet.getString(3)))
                {
                    //password is good 
                    //display welcome.xhtml
                    //create an OnlineAccount object
                    theLoginAccount = new JobAccount(resultSet.getString(1),id, 
                             password);
                    //go to welcome.xhtml
                    if(resultSet.getString(4).equals("user"))
                    {
                     lname = resultSet.getString(1);   
                    return "welcome";
                    }
                    else
                    {
                        return "welcomehr";
                    }
                     
                }
                else
                {
                    id = "";
                    password = "";
                    //display loginNotOK.xhtml
                    return "loginNotOK";    
                }
            }
            else
            {
                id = "";
                password = "";
                //id is not found, display loginNotOK.xhtml
                return "loginNotOK";
                 
            }
            
        }
        catch (SQLException e)
        {
            //go to internalError.xhtml
            e.printStackTrace();
            return ("internalError");
        }
        finally
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
                 
            }
            catch (Exception e)
            {
                e.printStackTrace();    
            }
        }
    }
    
    public String viewjobdisplayuser()
    {
        list1.clear();
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
        
        final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/nagraja5860";
        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
        ResultSet resultSet = null;   //set of results
        
        try
        {
          
            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "nagraja5860", "1321506");   
            statement = connection.createStatement();
            //to search an onlineaccount based on id or ssn
            resultSet = statement.executeQuery("Select * from job " );
            //either the id is used or the ssn is used
            while(resultSet.next())
            {
               // List.add(new GetData(resultSet.getString(1)));
                list1.add(new GetData(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4))); 
            }
            return "viewjobuser";
        }
        catch (SQLException e)
        {
            //go to internalError.xhtml
            e.printStackTrace();
            return ("internalError");
        }
        finally
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
                 
            }
            catch (Exception e)
            {
                e.printStackTrace();    
            }
        }
        
    }
   
    
    public String viewappjobs()
    {
        app.clear();
     try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //return to internalError.xhtml
            return ("interna");
        }
        
        final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/nagraja5860";
        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
        ResultSet resultSet = null;   //set of results
        
        try
        {
          
            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "nagraja5860", "1321506");   
            statement = connection.createStatement();
            //to search an onlineaccount based on id or ssn
            
            resultSet = statement.executeQuery("Select * from application "
                    + "where acctID = '" + 
                    id + "'" );
            //either the id is used or the ssn is used
            while(resultSet.next())
            {
               // List.add(new GetData(resultSet.getString(1)));
                app.add(new userDetails(resultSet.getString(1),resultSet.getString(3),resultSet.getString(4),resultSet.getString(9)));
                
                //list1.add(new GetData(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4))); 
            }
            return "appliedJobs";
        }
        catch (SQLException e)
        {
            //go to internalError.xhtml
            e.printStackTrace();
            return ("internalError");
        }
        finally
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
                 
            }
            catch (Exception e)
            {
                e.printStackTrace();    
            }
        }
           
    }
    public String viewjobdisplay()
    {
        list1.clear();
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
        
        final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/nagraja5860";
        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
        ResultSet resultSet = null;   //set of results
        
        try
        {
          
            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "nagraja5860", "1321506");   
            statement = connection.createStatement();
            //to search an onlineaccount based on id or ssn
            resultSet = statement.executeQuery("Select * from job " );
            //either the id is used or the ssn is used
            while(resultSet.next())
            {
               // List.add(new GetData(resultSet.getString(1)));
                list1.add(new GetData(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4))); 
            }
            return "viewjob";
        }
        catch (SQLException e)
        {
            //go to internalError.xhtml
            e.printStackTrace();
            return ("internalError");
        }
        finally
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
                 
            }
            catch (Exception e)
            {
                e.printStackTrace();    
            }
        }
        
    }
    
    public String getJobid() {
        return list1.get(currentitem).getJobid();
    }

  

    public String getJobtitle() {
         return list1.get(currentitem).getJobtitle();
    }

  

    public String getJobdesc() {
         return list1.get(currentitem).getJobdesc();
    }


    public String getJobpos() {
         return list1.get(currentitem).getJobpos();
    }
    
    

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }
    }

    

