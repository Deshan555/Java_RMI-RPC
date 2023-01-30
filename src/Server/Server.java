package Server;

// that library validate clients request and protocols
import java.net.MalformedURLException;

// that import responsible for store references os the remote objects (Save in RemoteObject Registry)
import java.rmi.Naming;

// that library handle all security aspects related to the RPC
import java.rmi.RMISecurityManager;

import java.rmi.AlreadyBoundException;

// that lib help to locate related data registry
import java.rmi.registry.LocateRegistry;

// that lib helps to export remote object
import java.rmi.server.UnicastRemoteObject;

import java.rmi.registry.*;

import java.rmi.RemoteException;

public class Server extends UnicastRemoteObject implements Service
{
    public Server() throws RemoteException{
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {

        System.out.println("Adding Two Of Numbers");

        return a+b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {

        System.out.println("Adding Two Of Numbers");

        return a+b;
    }

    @Override
    public int divide(int a, int b) throws RemoteException {

        System.out.println("Adding Two Of Numbers");

        return a+b;
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {

        System.out.println("Adding Two Of Numbers");

        return a+b;
    }

    public int testing() throws RemoteException {

        System.out.println("Adding Two Of Numbers");

        return 0;
    }

    public static void main()
    {
        if(System.getSecurityManager() == null)
        {
            System.setSecurityManager(new RMISecurityManager());

            try{
                Server server = new Server();

                Registry registry = LocateRegistry.getRegistry();

                registry.bind("Cal_Service", server);

                System.out.println("Service Started");

            }catch (RemoteException e)
            {
                throw new RuntimeException(e);
            }
            catch (AlreadyBoundException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
