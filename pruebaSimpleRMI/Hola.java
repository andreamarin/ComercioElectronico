package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hola extends Remote {
    String sayHello() throws RemoteException;

    String suma(double x, double y) throws RemoteException;
}