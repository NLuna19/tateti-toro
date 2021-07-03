package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logica.Tateti;

public class tatetiTest {
	Tateti tateti = new Tateti(3,"1","2");
	int turnoFijo=tateti.getTurno();
	
	@Test
	public void JugadaPermitida_test() {
		assertTrue(tateti.jugar(tateti.getTurno(), 2, 2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void JugadorInexistente_test() {
		tateti.ganador(3);
	}
	
	@Test
	public void cambioturno_test(){
		int actual=tateti.getTurno();
		tateti.cambiarTurno();
		int siguiente=tateti.getTurno();
		assertNotEquals(actual, siguiente);
	}
	
	@Test
	public void cantidadDeJugadasTotales_test() {
		tateti.jugar(turnoFijo, 0, 0);
		tateti.jugar(turnoFijo, 0, 1);
		assertEquals(2, tateti.getJugadas());
	}
		
	@Test
	public void sinSuficientesMarcas_test() {
		tateti.jugar(tateti.getTurno(), 0, 0);
		tateti.cambiarTurno();
		tateti.jugar(tateti.getTurno(), 2, 2);
		tateti.cambiarTurno();
		tateti.jugar(tateti.getTurno(), 0, 2);
		tateti.cambiarTurno();
		tateti.jugar(tateti.getTurno(), 1, 1);
		assertFalse(tateti.ganador(tateti.getTurno()));
	}
	
}
