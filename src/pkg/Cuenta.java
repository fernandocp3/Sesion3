package pkg;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	
	private String numero;
	private Double saldo;
	private String titular;
	private List<Movimiento> movimientos;
	
    public Cuenta(String numero, String titular, Double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.movimientos = new ArrayList<>();
    }

    public void ingreso(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            movimientos.add(new Movimiento(cantidad, Movimiento.Signo.H, "Ingreso en cuenta"));
        }
    }

    public void reintegro(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            movimientos.add(new Movimiento(cantidad, Movimiento.Signo.D, "Reintegro de cuenta"));
        }
    }

    public Double getSaldo() {
        return saldo;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }
}