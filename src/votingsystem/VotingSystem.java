package votingsystem;

import java.rmi.server.*;
import java.rmi.RemoteException;

public class VotingSystem extends UnicastRemoteObject implements AuthInterface,
                                    ElectionInterface, CompetitorsInterface{
    Db db;
    
    public VotingSystem() throws RemoteException{
        super();
        db = new Db();
    }

    @Override
    public boolean login(String username, String password) throws RemoteException {
        if(db.isValid())
            return true;
        return false;
        
    }

    @Override
    public void logout() throws RemoteException {
        
    }

    @Override
    public void sinup(String email, int age, String username, String password) throws RemoteException {
        db.insertUser(email,age,username,password);
    }

    @Override
    public void createElection(String name, String type, String detail) throws RemoteException {
       
    }

    @Override
    public String getStatus() throws RemoteException {
        return null;
       
    }

    @Override
    public String getResult() throws RemoteException {
        return null;
        
    }

    @Override
    public void setStatus() throws RemoteException {
        
    }

    @Override
    public void setResult() throws RemoteException {
        
    }

    @Override
    public void createCompetitor(String name, int age, String job, String detail) throws RemoteException {
        
    }

    @Override
    public void IncCount() throws RemoteException {
       
    }

    @Override
    public int getCount() throws RemoteException {
        return 0;
        
    }

    

}