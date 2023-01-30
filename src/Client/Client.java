package Client;

import Server.Service;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class Client{

    public static void main(String[] args)
    {
        if(System.getSecurityManager() == null)
        {
            System.setSecurityManager(new RMISecurityManager());
        }

        Service service = null;

        try{
            service = (Service)Naming.lookup("//localhost/Cal_Service");

            System.out.println("Add : "+ service.add(2, 2));
        }
        catch (MalformedURLException e)
        {
            throw new RuntimeException(e);
        }
        catch (NotBoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        }
    }
}
