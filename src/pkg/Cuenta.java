package pkg;

public class Cuenta {
	
	public String numero;
	public Double saldo;
	public String titular;
	
	public Cuenta(Double sal) {
		this.saldo = sal;
	}

	public void ingresar(double d) {
		// TODO Auto-generated method stub
		this.saldo = 500.0;
		
	}

	public Double getSaldo() {
		return saldo;
	}

	public void retirar(double i) {
		// TODO Auto-generated method stub
		this.saldo = -500.0;
	}

}
