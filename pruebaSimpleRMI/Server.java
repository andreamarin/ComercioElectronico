package example.hello;
        
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
        
public class Server implements Hola {
    long cuantos = 0;    
    String strHostname = System.getenv("COMPUTERNAME");
    public Server() {}

    public String sayHello(){
		
		// Delay con distribucion exponencial
		double lambda = 2.0;
		double delay = -(1/lambda)*Math.log(Math.random());
		
		long milis = (long) Math.floor(delay);
		int nanos = (int) Math.floor((delay-milis)*1e6);
		
        cuantos++;
		
		try{
          Thread.currentThread().sleep(milis,nanos);
		  System.out.println("Proporcionando el servicio no. " + cuantos);
		}catch(Exception e){
			
		}
		
        return "Servicio no. " + cuantos + " proporcionado desde " + strHostname+ " con un delay de "+delay+" nanosegundos.";
    }
	
	public String suma(double a, double b){
        double resp = 0.0;

        try{
            Thread.currentThread().sleep(50);
            resp = a+b;
        }catch(Exception e){

        }
 
		return "La suma de "+a+" + "+b+" es "+resp+" .";
	}
        
    public static void main(String args[]) {
        
        try {
            Server obj = new Server();
            Hola stub = (Hola) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Hola", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}