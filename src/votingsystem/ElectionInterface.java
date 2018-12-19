package votingsystem;

import java.rmi.*;

public interface ElectionInterface extends Remote{
    
    public void createElection(String name, String type, String detail) throws RemoteException;
    public String getStatus() throws RemoteException;
    public String getResult() throws RemoteException;
    public void setStatus() throws RemoteException;
    public void setResult() throws RemoteException;
    
    
}
