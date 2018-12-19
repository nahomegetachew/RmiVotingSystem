package votingsystem;

import java.rmi.*;

public interface CompetitorsInterface extends Remote{
    
    public void createCompetitor(String name, int age, String job, String detail) throws RemoteException;
    public void IncCount() throws RemoteException; //vote
    public int getCount() throws RemoteException;
    
}
