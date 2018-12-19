import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {

    public Connection connect() throws SQLException{
        return null;
    }
    
    public void close(Connection conn) throws SQLException{
    }

    public boolean isValid(String username, String password) throws SQLException{   
        return false;
    }

    public void insertElection(String name, String type, String detail, boolean status, int result) throws SQLException{
        //status == true > open else closed
        
    }
    public boolean readStatus(){
        return false;

    }
    public int readResult(){
        return 0;

    }
    public void updateStatus(){

    }
    public void updateResult(){

    }


    public void insertCompetitor(String name, String type, String detail, int count) throws SQLException{
    }
    public int readCount(){
        return 0;

    }
    public void updateCount(){
        
    }
    public void insertUser(String email, int age, String username, String password) throws SQLException{
    }


}