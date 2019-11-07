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
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Manideep
 */
@ManagedBean
@SessionScoped
public class viewhr {
  public int counter=0 ;
  
    /**
     * Creates a new instance of viewhr
     */
    public String jobID;
    public String newappID;
    public String tempjobID="";
    public String tempjobPos ="";
    public int foo=0;
    public String acctid;
    public String decision;
       public String applid;
    Login lo = new Login();
     public String newjobID = "J1";
    public ArrayList<GetData> listhr= new ArrayList<GetData>();
    public ArrayList<String> dd= new ArrayList<String>();
    public ArrayList <GetData> dec = new ArrayList<GetData> ();
    public ArrayList<viewhr> hrconfirm = new ArrayList<viewhr>();
    
    public String d;
    public String a;
    
    public viewhr()
    {
        
    }

    public ArrayList<viewhr> getHrconfirm() {
        return hrconfirm;
    }

    public void setHrconfirm(ArrayList<viewhr> hrconfirm) {
        this.hrconfirm = hrconfirm;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
    
    
    public viewhr(String d, String a)
    {
        this.d=d;
        this.a=a;
    }

    public String getAcctid() {
        return acctid;
    }

    public void setAcctid(String acctid) {
        this.acctid = acctid;
    }
    

    public String getApplid() {
        return applid;
    }

    public void setApplid(String applid) {
        this.applid = applid;
    }
 

    public ArrayList<GetData> getDec() {
        return dec;
    }

    public void setDec(ArrayList<GetData> dec) {
        this.dec = dec;
    }
    

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }
    
   public void dropdown()
   {
       dd.clear();
       dd.add("Select");
       dd.add("Reject");
   }

    public ArrayList<String> getDd() {
        return dd;
    }

    public void setDd(ArrayList<String> dd) {
        this.dd = dd;
    }

    public ArrayList<GetData> getListhr() {
        return listhr;
    }

    public void setListhr(ArrayList<GetData> listhr) {
        this.listhr = listhr;
    }
    
    public void sr()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //return to internalError.xhtml
           
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
            
            
             
             
             
        
        }
        catch (SQLException e)
        {
            //go to internalError.xhtml
            e.printStackTrace();
           
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
    
    public String sendresults()
    {
     
         sr();
         
         for(int i=0;i<hrconfirm.size();i++)
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

                int r = statement.executeUpdate("Update application set "
                        + "status = '" +  hrconfirm.get(i).d + "' where appID= '" + hrconfirm.get(i).a + "'");
                 
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
         
        hrconfirm.clear();
        
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
            
            int r1 = statement.executeUpdate("Update application set "
                        + "status = '" +  "Reject" + "' where status= '" + "pending" + "'");
        
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
   
        return "resultsConfirmation";
      
     }
    
     
    public String viewjobdisplay()
    {
        dec.clear();
        dd.clear();

       lo.list1.clear();
        
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
                lo.list1.add(new GetData(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4))); 
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
    
    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
        
    }
    
    public String goForm(String id)
    {
        setJobID(id);
        listhr.clear();
        dd.clear();
        viewapplicationhr();
        return "applyFormhr";
    }
    public void go(String aid)
    {
        setApplid(aid);
       
        listhr.clear();
        dd.clear();
 
          
    }
    
 
    
    public String confirm()
     {
       try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            //error message
            return ("Internal Error! ");
        }
         
         
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        
        try
        {
            final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/nagraja5860";
            
            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "nagraja5860", "1321506");   
            statement = connection.createStatement();
            //to search an onlineaccount based on id or ssn
            
            resultSet = statement.executeQuery("Select * from application "
                    + "where appID = '" + 
                    applid  + "'" );
            //either the id is used or the ssn is used
 
             while(resultSet.next())
            {
                 if(resultSet.getString(9).equals("withdraw"))
            {
               return "notWithdraw"; 
            }
                 else
                 {
               tempjobID = resultSet.getString(3);
            }
            }
            
            resultSet = statement.executeQuery("Select * from job "
                    + "where jobID = '" + 
                    tempjobID  + "'" );
            
           while(resultSet.next())
            {
               tempjobPos = resultSet.getString(4);
               foo = Integer.parseInt(tempjobPos);
               
            }
           
           if(decision.equals("Select") && counter == 0)
           {
               counter ++;
               hrconfirm.add(new viewhr(decision,applid));
               //int r = statement.executeUpdate("Update application set "
               //         + "status = '" +  decision + "' where appID= '" + applid + "'");
                return("decisionconfirmation");
           }
           else if(decision.equals("Select") && counter<foo)
           {
               counter ++;
               hrconfirm.add(new viewhr(decision,applid));
               //int r = statement.executeUpdate("Update application set "
               //         + "status = '" +  decision + "' where appID= '" + applid + "'");
                return("decisionconfirmation");
           }
           else if(decision.equals("Select") && counter==foo)
           {
               //counter ++;
               
                return("DecisionNotConfirmed");
           }
           else if(decision.equals("Select") && counter>=foo)
           {
               //counter++;
               
                return("DecisionNotConfirmed");
           }
           else if(decision.equals("Reject") && counter == 0)
           {
               
               hrconfirm.add(new viewhr(decision,applid));
               //int r = statement.executeUpdate("Update application set "
               //         + "status = '" +  decision + "' where appID= '" + applid + "'");
                return("decisionconfirmation");
           }
           else if(decision.equals("Reject") && counter <=foo)
           {
               counter--;
               hrconfirm.add(new viewhr(decision,applid));
              // int r = statement.executeUpdate("Update application set "
              //          + "status = '" +  decision + "' where appID= '" + applid + "'");
                return("decisionconfirmation");
           }
           else if(decision.equals("Reject") && counter>=foo)
           {
               counter--;
               hrconfirm.add(new viewhr(decision,applid));
              // int r = statement.executeUpdate("Update application set "
              //          + "status = '" +  decision + "' where appID= '" + applid + "'");
                return("decisionconfirmation");
           }
           else
           {
               return("DecisionNotConfirmed");
           }
           
            
       
            //either the id is used or the ssn is used
 
        
        }
        catch (SQLException e)
        {
            //error message
            e.printStackTrace();
            return ("Internal Error! Please try again later.");
             
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
    
    
    
    public String viewapplicationhr()
    {
        listhr.clear();
        dd.clear();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            //error message
            return ("Internal Error! Please try again later.");
        }
         
         
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        
        try
        {
            final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/nagraja5860";
            
            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "nagraja5860", "1321506");   
            statement = connection.createStatement();
            //to search an onlineaccount based on id or ssn
            resultSet = statement.executeQuery("Select * from application "
                    + "where jobID = '" + 
                    jobID  + "'" );
            //either the id is used or the ssn is used
            
             while(resultSet.next())
            {
               // List.add(new GetData(resultSet.getString(1)));
                //newappID = resultSet.getString(1);
                listhr.add(new GetData(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9))); 
            }
            return "applyFormhr";
        
            
        }
        catch (SQLException e)
        {
            //error message
            e.printStackTrace();
            return ("Internal Error! Please try again later.");
             
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