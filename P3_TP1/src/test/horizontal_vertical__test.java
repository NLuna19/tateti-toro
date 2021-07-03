package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logica.Tateti;

public class horizontal_vertical__test {
	Tateti tateti = new Tateti(3,"1","2");
	int turnoFijo=tateti.getTurno(); 
	//se guarda un turnoActual para evitar problemas con el turno aleatorio
	
	@Test
	public void ganoHoizontal_test() {
		tateti.jugar(turnoFijo, 1, 1);
		tateti.jugar(turnoFijo, 1, 0);
		tateti.jugar(turnoFijo, 1, 2);
		assertTrue(tateti.ganoHorizontal(turnoFijo));
	}
	@Test
	public void NOganoHoizontal_test() {
		tateti.jugar(turnoFijo, 0, 1);
		tateti.jugar(turnoFijo, 0, 0);
		tateti.jugar(turnoFijo, 1, 2);
		assertFalse(tateti.ganoHorizontal(turnoFijo));
	}
	@Test
	public void ganoVertical_test() {
		tateti.jugar(turnoFijo, 0, 2);
		tateti.jugar(turnoFijo, 1, 2);
		tateti.jugar(turnoFijo, 2, 2);
		assertTrue(tateti.ganoVertical(turnoFijo));
	}
	@Test
	public void NOganoVertical_test() {
		tateti.jugar(turnoFijo, 0, 2);
		tateti.jugar(turnoFijo, 1, 2);
		tateti.jugar(turnoFijo, 2, 1);
		assertFalse(tateti.ganoVertical(turnoFijo));
	}
	

}
