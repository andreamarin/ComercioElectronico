package example.hello;

    import java.rmi.registry.LocateRegistry;
    import java.rmi.registry.Registry;

    public class Client {

        private Client() {}

        public static void main(String[] args) {
            long i;
			double sum = 0.0;
			double sum2 = 0.0;
			double dt = 0.0;
			double avg = 0.0;
			double std = 0.0;
			int n = 1000;
			long t0,t1;
			
            String response;
            String host = (args.length < 1) ? null : args[0];
			
            try{
                Registry registry = LocateRegistry.getRegistry(host);
                Hola stub = (Hola) registry.lookup("Hola");
				
                for(i=0;i<n;i++){
					
					t0 = System.nanoTime();
					response = stub.sayHello();
					t1 = System.nanoTime();
					
					dt += (double)(t1-t0);
					sum += dt;
					sum2 += dt*dt;
					
					System.out.println("response: " + response);
                } 

				avg = sum/n;
				std = Math.sqrt((sum2-n*avg*avg)/(n-1));
				
				avg *= 1e-9;
				
				System.out.println("=============================================");
				System.out.println("Para "+n+" solicitudes de ejecucion.");
				System.out.println("Promedio: "+avg+" segundos.");
				System.out.println("Desviacion estandar: "+std+" nanosegundos.");
				System.out.println("=============================================");
				
            } 
            catch (Exception e) 
            {
                System.err.println("Client exception: " + e.toString());
                e.printStackTrace();
            }
        }
    }

