/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

/**
 *
 * @author Mucharla
 */
@ManagedBean
@SessionScoped
public class userDetails {

    /**
     * Creates a new instance of userDetails
     */
    Login lo = new Login();
    private String fname;
    private String qualification;
    private String yExp;
    private String fExp;
    private String contact;
    public String aID ;
    public String jID ;
    public String selectedjID;
    
    private String aaid;
    private String ajoID;
    private String afname;
    private String adecStatus;
    
    public userDetails()
    {
        
    }

    public String getAaid() {
        return aaid;
    }

    public void setAaid(String aaid) {
        this.aaid = aaid;
    }

    public String getAjoID() {
        return ajoID;
    }

    public void setAjoID(String ajoID) {
        this.ajoID = ajoID;
    }

    public String getAfname() {
        return afname;
    }

    public void setAfname(String afname) {
        this.afname = afname;
    }

    public String getAdecStatus() {
        return adecStatus;
    }

    public void setAdecStatus(String adecStatus) {
        this.adecStatus = adecStatus;
    }

    public userDetails(String aaid, String ajoID, String afname, String adecStatus) {
        this.aaid = aaid;
        this.ajoID = ajoID;
        this.afname = afname;
        this.adecStatus = adecStatus;
    }
    
 
    public String getSelectedjID() {
        return selectedjID;
    }

    public void setSelectedjID(String selectedjID) {
        this.selectedjID = selectedjID;
    }
    

    public String getaID() {
        return aID;
    }

    public void setaID(String aID) {
        this.aID = aID;
    }

    public String getjID() {
        return jID;
    }

    public void setjID(String jID) {
        this.jID = jID;
    }
    
    
    
    public ArrayList<GetData> getList1() {
        return list1;
    }

    public void setList1(ArrayList<GetData> list1) {
        this.list1 = list1;
    }
    
    public ArrayList<GetData> list1 = new ArrayList<GetData>();
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getyExp() {
        return yExp;
    }

    public void setyExp(String yExp) {
        this.yExp = yExp;
    }

    public String getfExp() {
        return fExp;
    }

    public void setfExp(String fExp) {
        this.fExp = fExp;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet resultSet1 = null;
        ResultSet resultSet2 = null;
        
        public void goUser(String jid, String id)
        {
            setaID(id);
            setjID(jid);
        }
        
        
        public String withdraw(String sjid)
                
        {
            
            setSelectedjID(sjid);
           
           String w="withdraw";
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
            
            int r = statement.executeUpdate("Update application set "
                        + "status = '" +  w + "' where appID= '" + selectedjID + "'");
                
            return "withdrawJob";
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
   
    public String submit(String userID, String jobID)
    {
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            //error message
            return "internal";
        }
         
         try
        {
             final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/nagraja5860";
        
            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "nagraja5860", "1321506"); 
            statement = connection.createStatement();
         
        }
        catch (SQLException e)
        {
            //error message
            e.printStackTrace();
            return "internalError";
             
        }
        finally
        {
            try
            {
                resultSet1.close();
                resultSet2.close();
                statement.close();
                connection.close();
                
            }
            catch (Exception e)
            {
                 
                e.printStackTrace();
            }
        }
        
        
        try
        {
            final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/nagraja5860";
            
            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "nagraja5860", "1321506"); 
            
            statement = connection.createStatement();
            
            System.out.println("account id" + aID);
            System.out.println("job id" + jID);
            
            resultSet = statement.executeQuery("Select * from application "
                    + "where acctID = '" + aID + "' and jobID = '" + jID + "'" );
          
            if(resultSet.next())
            {
                 return"submitNotOk";
            }
            else
            {
                int r = statement.executeUpdate("insert into application (acctID, jobID, fullName, qualification, yExp, fExp, contact, status) "
                        + "values ('" + userID + "', '" + jobID + "', '" + fname + "', '" + qualification 
                        + "', '" + yExp + "', '" + fExp + "', '" + contact +"', '" + "pending" + "')");
                
                return "submitOk";
                 
            }   
        }
        catch (SQLException e)
        {
            //error message
            e.printStackTrace();
            return "internalError";
             
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
    

    
}   
        

    
    
