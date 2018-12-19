package votingsystem;

import java.rmi.server.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VotingSystem extends UnicastRemoteObject implements AuthInterface,
                                    ElectionInterface, CompetitorsInterface{
    Db db;
    boolean status; // for creating new election (open)
    String result;  // for creating new election (null)
    int count; //intial count for compittiors
    
    
    
    public VotingSystem() throws RemoteException{
        super();
        db = new Db();
        status = true;
        result = null;
        count = 0;
        
        
    }

    @Override
    public boolean login(String username, String password) throws RemoteException {
        try {
            if(db.isValid(username, password))
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(VotingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }

    @Override
    public void logout() throws RemoteException {
        
    }

    @Override
    public void sinup(String email, int age, String username, String password) throws RemoteException {
        try {
            db.insertUser(email,age,username,password);
        } catch (SQLException ex) {
            Logger.getLogger(VotingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void createElection(String name, String type, String detail) throws RemoteException {
        try {
            db.insertElection(name,type,detail,status, result);
        } catch (SQLException ex) {
            Logger.getLogger(VotingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public boolean getStatus() throws RemoteException {
        return db.readStatus();
       
    }

    @Override
    public String getResult() throws RemoteException {
        return db.readResult();
        
    }

    @Override
    public void setStatus(boolean status) throws RemoteException {
        db.updateStatus(status);
        
        
        
    }

    @Override
    public void setResult(String result) throws RemoteException {
        db.updateResult(result);
        
    }

    @Override
    public void createCompetitor(String name, int age, String job, String detail) throws RemoteException {
        try {
            db.insertCompetitor(name, age,job, detail, count);
        } catch (SQLException ex) {
            Logger.getLogger(VotingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void IncCount() throws RemoteException {
        db.updateCount();
       
    }

    @Override
    public int getCount() throws RemoteException {
        return db.readCount();
        
    }

    

}