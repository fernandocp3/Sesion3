package pkg;

public class Cuenta {
	
	private String numero;
	private Double saldo;
	private String titular;
	
	public Cuenta(Double sal) {
		this.saldo = sal;
	}

	public void ingresar(double cantidad) {
        if (cantidad > 0)
            this.saldo += cantidad;
		
	}

	public Double getSaldo() {
		return saldo;
	}

	public void retirar(double cantidad) {
      if (cantidad > 0 && cantidad <= this.saldo)
            this.saldo -= cantidad;
	}

	public void setSaldo(double d) {
		this.saldo = d;
		
	}

}
