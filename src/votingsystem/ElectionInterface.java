package votingsystem;

import java.rmi.*;

public interface ElectionInterface extends Remote{
    
    public void createElection(String name, String type, String detail) throws RemoteException;
    public boolean getStatus() throws RemoteException;
    public String getResult() throws RemoteException;
    public void setStatus(boolean status) throws RemoteException;
    public void setResult(String result) throws RemoteException;
    
    
}
