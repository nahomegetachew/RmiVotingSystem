package votingsystem;

import java.rmi.server.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VotingSystem extends UnicastRemoteObject implements VotingInterface{
    Db db;
    
    
    
    
    public VotingSystem() throws RemoteException{
        super();
        db = new Db();
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
            db.insertElection(name,type,detail,1, null);
        } catch (SQLException ex) {
            Logger.getLogger(VotingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public int getStatus() throws RemoteException {
        return db.readStatus();
       
    }

    @Override
    public String getResult() throws RemoteException {
        return db.readResult();
        
    }

    @Override
    public void setStatus(int status) throws RemoteException {
        db.updateStatus(status);
        
        
        
    }

    @Override
    public void setResult(String result) throws RemoteException {
        db.updateResult(result);
        
    }

    @Override
    public void createCompetitor(String name, int age, String job, String detail, int election_id) throws RemoteException {
        try {
            db.insertCompetitor(name, age,job, detail, 0, election_id);
        } catch (SQLException ex) {
            Logger.getLogger(VotingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void IncCount(int competitor_id, int count) throws RemoteException {
        int c = count + 1; // increament count by 1
        db.updateCount(competitor_id, c);
       
    }

    @Override
    public int getCount(int competitor_id) throws RemoteException {
        return db.readCount(competitor_id);
        
    }

    

}