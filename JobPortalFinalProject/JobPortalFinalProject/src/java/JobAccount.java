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
import javax.faces.context.FacesContext;

/**
 *
 * @author Manideep
 */
@ManagedBean
@SessionScoped
public class JobAccount {
private String id;   //account ID
    private String password; 
    private String name;
    //used for reset password
    private String oldPsw;  
    private String newPsw1;
    private String newPsw2;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOldPsw() {
        return oldPsw;
    }

    public void setOldPsw(String oldPsw) {
        this.oldPsw = oldPsw;
    }

    public String getNewPsw1() {
        return newPsw1;
    }

    public void setNewPsw1(String newPsw1) {
        this.newPsw1 = newPsw1;
    }

    public String getNewPsw2() {
        return newPsw2;
    }

    public void setNewPsw2(String newPsw2) {
        this.newPsw2 = newPsw2;
    }
    
    
    /**
     * Creates a new instance of JobAccount
     */
    public JobAccount(String n, String i, String p ) {
        id=i;
        name=n;
        password=p;
    }
    
    
    public String resetPassword()
    {
         
        boolean newPswOK = false; 
        boolean matchOldPsw = false;
        
        
        
        if(newPsw1.equals(newPsw2))
        {
            newPswOK = true;
        }
        
        if(oldPsw.equals(password))
        {
            matchOldPsw = true;
        }
        
        if(!newPswOK)
        {
            return ("confirmationResetWrong.xhtml");
        }
        else if(!matchOldPsw)
        {
             
            return ("confirmationResetWrong.xhtml");
            
        }
        else
        {
             
               
            final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/nagraja5860";
            
            Connection connection = null;  //a connection to the database
            Statement statement = null;    //execution of a statement
            ResultSet resultSet = null;   //set of results
            
            try 
            {
                password = newPsw1;
                //connect to the database
                connection = DriverManager.getConnection(DATABASE_URL, 
                        "nagraja5860", "1321506");
                
                //create a statement
                statement = connection.createStatement();
                
                int r = statement.executeUpdate("Update account set "
                        + "password = '" +  password + "' where acctID= '" + id + "'");
                return("confirmationResetOK");
                
            }
            catch (SQLException e)
            {
                      
                e.printStackTrace();
                return("internalError");
             }
             finally
             {
                try
                {
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
    public String signOut()
    {
        FacesContext.getCurrentInstance().
                getExternalContext().invalidateSession();
        return "index.xhtml";

        
    }

}
