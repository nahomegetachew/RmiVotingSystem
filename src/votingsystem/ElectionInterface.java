package votingsystem;

import java.rmi.*;

public interface ElectionInterface extends Remote{
    
    public void createElection(String name, String type, String detail) throws RemoteException;
    public int getStatus() throws RemoteException;
    public String getResult() throws RemoteException;
    public void setStatus(int status) throws RemoteException;
    public void setResult(String result) throws RemoteException;
    
    
}
