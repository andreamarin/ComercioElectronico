public class GenDeltaT {
	
	public static void main(String[] args){
		System.out.println("Hello World");
		double lambda = 5.0;
		double sdt = 0.0,dt = 0.0;
		int n = 10000;

		for(int i = 0; i < n; i++){
			dt = -1/lambda * (Math.log(Math.random()));
			sdt+=dt;
			System.out.println(i+" deltaT = "+dt);
		}
		
		double prom_dt = sdt/n;
		
		System.out.println("Promedio: "+prom_dt);
	}
	
}