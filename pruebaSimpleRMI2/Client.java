package example.hello;

    import java.rmi.registry.LocateRegistry;
    import java.rmi.registry.Registry;

    public class Client {

        private Client() {}

        public static void main(String[] args) {
			long sum = 0;
			long sum2 = 0;
			long tiempoResp = 0;
			double avg = 0.0;
			double std = 0.0;
			double x = 0.0;
			double y = 0.0;
			long i;

			int n = 100;

			long miNum = 0;
			long milisFaltantes;
			long dtMax = 0, dtMin =0;
			
            String response,responseSum;
            String host = (args.length < 1) ? null : args[0];
			
            try{
                Registry registry = LocateRegistry.getRegistry(host);
				
				IServDisparo servDisparo = (IServDisparo) registry.lookup("ServidorDeDisparo");
				miNum = servDisparo.quienSoy();
				milisFaltantes = servDisparo.deltaTEnMilis();

				System.out.println("Cliente " + miNum + " faltan " + milisFaltantes  + " milisegundos");

				Hola stub = (Hola) registry.lookup("Hola");

		Thread.currentThread().sleep(milisFaltantes);
				
                for(i=0;i<n;i++){

					x = Math.round(Math.random()*8000)/100;
					y = Math.round(Math.random()*8000)/100;
					
					tiempoResp = System.nanoTime();
					response = stub.sayHello();
					responseSum = stub.suma(x,y);
					tiempoResp = System.nanoTime() - tiempoResp;
					
					sum += tiempoResp;
					sum2 += Math.pow(tiempoResp,2);

					if(i == 0){
                   		dtMin = tiempoResp;
                   		dtMax = tiempoResp;
               		}else{
                   		if( tiempoResp < dtMin ) dtMin = tiempoResp;
                   		if( tiempoResp > dtMax ) dtMax = tiempoResp;
               		}
					
					System.out.println("response: " + response);
					System.out.println(responseSum);

					System.out.println("Tiempo de espera: "+(tiempoResp*1e-9)+" seg \n");
                } 

		servDisparo.acumula(sum, sum2, n, dtMax, dtMin);

				avg = sum/n;
				std = Math.sqrt((sum2-n*Math.pow(avg,2))/(n-1));
				
				avg *= 1e-9;
				std *= 1e-9;
				
				System.out.println("===================================================");
				System.out.println("Para "+n+" solicitudes de ejecucion.");
				System.out.println("Promedio: "+avg+" seg.");
				System.out.println("Desviacion estandar: "+std+" seg.");
				System.out.println("===================================================");
				
				
            } 
            catch (Exception e) 
            {
                System.err.println("Client exception: " + e.toString());
                e.printStackTrace();
            }
        }
    }

