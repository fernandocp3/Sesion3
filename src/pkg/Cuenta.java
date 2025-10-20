package pkg;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {

    private String numero;
    private String titular;
    private Double saldo;
    private List<Movimiento> movimientos;
    private List<String> errores;
    private static final double LIMITE_DESCUBIERTO = -500.0;

    public Cuenta(String numero, String titular, Double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.movimientos = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public void ingreso(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            movimientos.add(new Movimiento(cantidad, Movimiento.Signo.H, "Ingreso en cuenta"));
        }
    }

    public void reintegro(double cantidad) {
        if (cantidad <= 0) return;

        // Calcular saldo provisional tras el reintegro
        double saldoTrasOperacion = saldo - cantidad;

        // Si supera el límite permitido, registrar error
        if (saldoTrasOperacion < LIMITE_DESCUBIERTO) {
            String error = String.format(
                "Fondos insuficientes (saldo %.2f) en la cuenta %s para el reintegro de %.2f€",
                saldo, numero, cantidad
            );
            errores.add(error);
            System.out.println(error);
            return;
        }

        // Si no supera el límite, aplicar reintegro
        saldo = saldoTrasOperacion;
        movimientos.add(new Movimiento(cantidad, Movimiento.Signo.D, "Reintegro de cuenta"));
    }


    public Double getSaldo() {
        return saldo;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public List<String> getErrores() {
        return errores;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }
}
