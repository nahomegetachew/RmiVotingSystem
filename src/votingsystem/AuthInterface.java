package votingsystem;

import java.rmi.*;

public interface AuthInterface extends Remote{
    
    public boolean login(String username, String password) throws RemoteException;
    public void logout() throws RemoteException;
    public void sinup(String email, int age, String username, String password) throws RemoteException;

}
