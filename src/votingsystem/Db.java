package votingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Db {
    String location;
    String pass;

    public Db() {
        this.location = "jdbc:mysql://localhost:3306/voting";
    }
    

    public Connection connect() throws SQLException{
        try{
              Connection con = DriverManager.getConnection(location, "root", "");
              return con;
              
        }catch(SQLException ex){
            System.out.println("ecxeption" +ex);
        }  
        
        return null;
    }
    
    public void close(Connection conn) throws SQLException{
        conn.close();
    }

    public boolean isValid(String username, String password) throws SQLException{   
        try{
            Connection con=this.connect();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT password from Users where username='"+username+"';");
            while(rs.next()){           
                   pass = rs.getString("password");
                   System.out.println(pass);
                   
                return pass.equals(password);     
            }
            
        }catch(SQLException ex){
            System.out.println("ecxeption" +ex);  
        }  
        return false;
    }

    public void insertElection(String name, String type, String detail, int status, String result) throws SQLException{
        try{
            Connection con=this.connect();
            Statement stmt = con.createStatement();
            ResultSet rs;
            PreparedStatement ps = con.prepareStatement("insert into Elections (name,type,detail,status,result) VALUES (?,?,?,?,?);");
            System.out.println("after alll********");
            
            ps.setString(1,name);
            ps.setString(2,type);
            ps.setString(3,detail);
            ps.setInt(4,status);
            ps.setString(5, result);
            ps.executeUpdate();
            
            
               
         }catch(SQLException ex){
            System.out.println("ecxeption" +ex);
            
         } 
        
    }
    public int readStatus(){
        return 0;

    }
    public String readResult(){
        return null;

    }
    public void updateStatus(int status){

    }
    public void updateResult(String result){

    }


    public void insertCompetitor(String name, int age, String job, String detail, int count, int election_id) throws SQLException{
        try{
            Connection con=this.connect();
            Statement stmt = con.createStatement();
            ResultSet rs;
            PreparedStatement ps = con.prepareStatement("insert into Competitors (name,age,job,detail,count,election_id) VALUES (?,?,?,?,?,?);");
            System.out.println("after alll********");
            
            ps.setString(1,name);
            ps.setInt(2,age);
            ps.setString(3,job);
            ps.setString(4,detail);
            ps.setInt(5, count);
            ps.setInt(6, election_id);
            ps.executeUpdate();
            
            
               
         }catch(SQLException ex){
            System.out.println("ecxeption" +ex);
            
         } 
    }
    public int readCount(int competitor_id){
        try{
            Connection con=this.connect();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT count from Competitors where competitor_id='"+competitor_id+"';");
            while(rs.next()){           
                int count = rs.getInt("count");
                System.out.println(count);
                   
                return count;     
            }
            
        }catch(SQLException ex){
            System.out.println("ecxeption" +ex);  
        }  
        return 0;

    }
    public void updateCount(int competitor_id, int count){
        try {
            Connection con=this.connect();
            String query = "update Competitors set count = ? where competitor_id= ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, count);
            ps.setInt(2, competitor_id);
            
            // execute the java preparedstatement
            ps.executeUpdate();
            
            this.close(con);
        } catch (SQLException ex) {
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void insertUser(String email, int age, String username, String password) throws SQLException{
        
        try{
            Connection con=this.connect();
            Statement stmt = con.createStatement();
            ResultSet rs;
            PreparedStatement ps = con.prepareStatement("insert into Users (email,age,username,password) VALUES (?,?,?,?);");
            System.out.println("after alll********");
            
            ps.setString(1,email);
            ps.setInt(2,age);
            ps.setString(3,username);
            ps.setString(4,password);
            ps.executeUpdate();
            
            
               
        }catch(SQLException ex){
            System.out.println("ecxeption" +ex);
            
         } 
    }


}