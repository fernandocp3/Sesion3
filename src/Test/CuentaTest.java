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
	void testPermiteReintegroHastaLimiteDescubierto() {
	    cuenta.ingreso(100.0);
	    cuenta.reintegro(200.0);
	    assertEquals(-100.0, cuenta.getSaldo());
	}


	@Test
	void testMovimientoIngreso() {
	    cuenta.ingreso(150.0);
	    Movimiento m = cuenta.getMovimientos().get(0);
	    assertEquals(150.0, m.getImporte());
	    assertEquals(Movimiento.Signo.H, m.getSigno());
	    assertEquals("Ingreso en cuenta", m.getDetalle());
	}
	
	@Test
	void test0014() {
	    // Inicialización
	    Cuenta c1 = new Cuenta("12345", "Juan", 50.0);
	    Cuenta c2 = new Cuenta("67890", "María", 0.0);

	    c1.reintegro(200.0);   // (1)
	    c2.reintegro(350.0);   // (2)
	    c1.ingreso(100.0);     // (3)
	    c2.reintegro(200.0);   // (4)
	    c2.reintegro(150.0);   // (5)
	    c1.reintegro(200.0);   // (6)
	    c2.ingreso(50.0);      // (7)
	    c2.reintegro(100.0);   // (8)

	    assertEquals(-250.0, c1.getSaldo(), "Saldo final incorrecto en cuenta 12345");
	    assertEquals(-450.0, c2.getSaldo(), "Saldo final incorrecto en cuenta 67890");

	    // Verificar errores registrados (pasos 4 y 8)
	    assertEquals(2, c2.getErrores().size(), "Deben registrarse dos errores en la cuenta 67890");
	    assertTrue(c2.getErrores().get(0).contains("Fondos insuficientes"));
	    assertTrue(c2.getErrores().get(1).contains("Fondos insuficientes"));
	}


}
