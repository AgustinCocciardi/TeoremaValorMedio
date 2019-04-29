package paquete;

public class Polinomio {

	public static double evaluarPolinomio(double x){
		return -Math.pow(x, 4) -Math.pow(x, 3) + 1;
	}
	
	public static double calcularValorMedio(double a, double b, double error){
		if((evaluarPolinomio(a)*evaluarPolinomio(b)) >= 0){
			System.out.println("No hay punto medio entre " + a + " y " + b);
			System.exit(0);
		}
		double puntoMedio= (a+b)/2;
		double puntoAnterior= a;
		while( Math.abs(puntoAnterior-puntoMedio) > error ){
			if( (evaluarPolinomio(a) * evaluarPolinomio(puntoMedio)) > 0 ){
				a=puntoMedio;
			}
			else{
				b=puntoMedio;
			}
			puntoAnterior = puntoMedio;
			puntoMedio = (a+b)/2;
		}
		return puntoMedio;
	}
	
	public static void main(String[] args) {
		double a =0, b=23, cotaError=1/100;
		System.out.println("F(" + a + ") = " + evaluarPolinomio(a));
		System.out.println("F(" + b + ") = " + evaluarPolinomio(b));
		double puntoMedio = calcularValorMedio(a,b,cotaError);
		System.out.println("El punto medio de " + a + " y " + b + " es: " + puntoMedio);
		System.out.println("F(" + puntoMedio + ") = " + evaluarPolinomio(puntoMedio));
	}

}
