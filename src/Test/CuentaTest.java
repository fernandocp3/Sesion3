package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Cuenta;
import pkg.Movimiento;

class CuentaTest {
	
	public static Cuenta cuenta;
	public static Movimiento movimiento;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cuenta = new Cuenta("12345", "Juan Pérez", 0.0);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cuenta = new Cuenta("12345", "Juan Pérez", 0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testReintegro() {
	    cuenta.ingreso(500.0);
	    cuenta.reintegro(200.0);
	    assertEquals(300.0, cuenta.getSaldo());
	    assertEquals(2, cuenta.getMovimientos().size());
	    assertEquals(Movimiento.Signo.D, cuenta.getMovimientos().get(1).getSigno());
	}

	@Test
	void testNoPermiteReintegroMayorQueSaldo() {
	    cuenta.ingreso(100.0);
	    cuenta.reintegro(200.0);
	    assertEquals(100.0, cuenta.getSaldo()); // no se permite
	}

	@Test
	void testMovimientoIngreso() {
	    cuenta.ingreso(150.0);
	    Movimiento m = cuenta.getMovimientos().get(0);
	    assertEquals(150.0, m.getImporte());
	    assertEquals(Movimiento.Signo.H, m.getSigno());
	    assertEquals("Ingreso en cuenta", m.getDetalle());
	}

}
