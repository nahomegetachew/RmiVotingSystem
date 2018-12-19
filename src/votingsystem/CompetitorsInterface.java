package votingsystem;

import java.rmi.*;

public interface CompetitorsInterface extends Remote{
    
    public void createCompetitor(String name, int age, String job, String detail, int election_id) throws RemoteException;
    public void IncCount(int competitor_id, int count) throws RemoteException; //vote
    public int getCount(int competitor_id) throws RemoteException;
    
}
