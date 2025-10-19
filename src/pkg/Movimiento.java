package pkg;

public class Movimiento {
	public enum Signo {D, H};
	
    private Double importe;
    private Signo signo;
    private String detalle;

    public Movimiento(Double importe, Signo signo, String detalle) {
        this.importe = importe;
        this.signo = signo;
        this.detalle = detalle;
    }

    public Double getImporte() {
        return importe;
    }

    public Signo getSigno() {
        return signo;
    }

    public String getDetalle() {
        return detalle;
    }

    @Override
    public String toString() {
        return signo + " " + importe + "€ - " + detalle;
    }
}
