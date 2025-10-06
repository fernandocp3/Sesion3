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
		this.saldo += d;
		
	}

	public Double getSaldo() {
		return saldo;
	}

	public void retirar(double i) {
		// TODO Auto-generated method stub
		this.saldo -= i;
	}

	public void setSaldo(double d) {
		this.saldo = d;
		
	}

}
