package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logica.Tateti;

public class toroidal_test {
	Tateti tateti = new Tateti(3,"1","2");
	int turnoFijo=tateti.getTurno(); 
	//se guarda un turnoActual para evitar problemas con el turno aleatorio
	@Test
	public void ganoToroidal_test() {
		tateti.jugar(turnoFijo, 0, 1);
		tateti.jugar(turnoFijo, 1, 0);
		tateti.jugar(turnoFijo, 2, 2);
		assertTrue(tateti.ganoToroidal(turnoFijo));
	}
	
	@Test
	public void casogana_toroidalTest() {
		tateti.jugar(turnoFijo, 0, 1); //*
		tateti.jugar(turnoFijo, 1, 0); //*
		tateti.jugar(turnoFijo, 2, 1);
		tateti.jugar(turnoFijo, 2, 2); //*
		assertTrue(tateti.ganoToroidal(turnoFijo));
	}
	
	@Test
	public void casogana2_toroidalTest() {
		tateti.jugar(turnoFijo, 0, 0); 
		tateti.jugar(turnoFijo, 0, 2); //*
		tateti.jugar(turnoFijo, 1, 0); //*
		tateti.jugar(turnoFijo, 2, 1); //*
		assertTrue(tateti.ganoToroidal(turnoFijo));
	}
	
	@Test
	public void diagonal_test() {
		tateti.jugar(turnoFijo, 1, 1);
		tateti.jugar(turnoFijo, 0, 0);
		tateti.jugar(turnoFijo, 2, 2);
		assertTrue(tateti.ganoToroidal(turnoFijo));
	}
	
	@Test
	public void casoNOgana_test() {
		tateti.jugar(turnoFijo, 0, 0);
		tateti.jugar(turnoFijo, 0, 1);
		tateti.jugar(turnoFijo, 1, 2);
		tateti.jugar(turnoFijo, 2, 2);
		assertFalse(tateti.ganoToroidal(turnoFijo));
	}
	@Test
	public void NOgana2_toroidalTest() {
		tateti.jugar(turnoFijo, 1, 1);
		tateti.jugar(turnoFijo, 1, 0);
		tateti.jugar(turnoFijo, 2, 1);
		assertFalse(tateti.ganoToroidal(turnoFijo));
	}
	
	@Test
	public void gana4X4_toroidalTest() {
		Tateti tateti4 = new Tateti(4,"1","2");
		int turno = tateti4.getTurno();
		tateti4.jugar(turno, 0, 0);
		tateti4.jugar(turno, 1, 1);
		tateti4.jugar(turno, 2, 2);
		tateti4.jugar(turno, 3, 3);
		assertTrue(tateti4.ganoToroidal(turno));
	}
	@Test
	public void NOgana4X4_toroidalTest() {
		Tateti tateti4 = new Tateti(4,"1","2");
		int turno = tateti4.getTurno();
		tateti4.jugar(turno, 0, 0);
		tateti4.jugar(turno, 1, 2);
		tateti4.jugar(turno, 2, 1);
		tateti4.jugar(turno, 3, 3);
		assertFalse(tateti4.ganoToroidal(turno));
	}
	
	/* empates
	 *  O O X O
	 * 	X X X O  
	 * 	O X X X
	 * 	O X O O
	 * 
	 * 	O X O X
	 * 	O X O X
	 * 	O X O X
	 *  X O X O
	 *  
	 */
	

	 // 	O O O .
	 // 	X X X O
	 // 	O O O X  // a revisar
	 // 	X X X(O)
	@Test
	public void NOgana4X4_2_toroidalTest() {
		Tateti tateti4 = new Tateti(4,"1","2");
		tateti4.jugar(tateti4.getTurno(), 0, 0); tateti4.cambiarTurno(); 
			tateti4.jugar(tateti4.getTurno(), 1, 0); tateti4.cambiarTurno(); 
		tateti4.jugar(tateti4.getTurno(), 0, 1); tateti4.cambiarTurno(); 
			tateti4.jugar(tateti4.getTurno(), 1, 1); tateti4.cambiarTurno(); 
		tateti4.jugar(tateti4.getTurno(), 0, 2); tateti4.cambiarTurno(); 
			tateti4.jugar(tateti4.getTurno(), 1, 2); tateti4.cambiarTurno(); 
		tateti4.jugar(tateti4.getTurno(), 1, 3); tateti4.cambiarTurno(); 
			tateti4.jugar(tateti4.getTurno(), 2, 3); tateti4.cambiarTurno(); 
		tateti4.jugar(tateti4.getTurno(), 2, 0); tateti4.cambiarTurno(); 
			tateti4.jugar(tateti4.getTurno(), 3, 0); tateti4.cambiarTurno(); 
		tateti4.jugar(tateti4.getTurno(), 2, 1); tateti4.cambiarTurno(); 
			tateti4.jugar(tateti4.getTurno(), 3, 1); tateti4.cambiarTurno(); 
		tateti4.jugar(tateti4.getTurno(), 2, 2); tateti4.cambiarTurno(); 
			tateti4.jugar(tateti4.getTurno(), 3, 2); tateti4.cambiarTurno(); 
		tateti4.jugar(tateti4.getTurno(), 3, 3); /* SE PUDRIO TODO*/
		assertFalse(tateti4.ganoToroidal(tateti4.getTurno()));
	}
	
	@Test
	public void gana5x5_toroidalTest() {
		Tateti tateti5 = new Tateti(5,"1","2");
		int turno = tateti5.getTurno();
		tateti5.jugar(turno, 0, 1); // . X . . .
		tateti5.jugar(turno, 1, 2); // . . X . .
		tateti5.jugar(turno, 2, 3); // . . . X .
		tateti5.jugar(turno, 3, 4); // . . . . X
		tateti5.jugar(turno, 4, 0); // X . . . .
		assertTrue(tateti5.ganoToroidal(turno));
	}
	@Test
	public void NOgana5x5_toroidalTest() {
		Tateti tateti5 = new Tateti(5,"1","2");
		int turno = tateti5.getTurno();
		tateti5.jugar(turno, 0, 0); // X . . . .
		tateti5.jugar(turno, 1, 1); // . X . . .
		tateti5.jugar(turno, 2, 2); // . . X . . 
		tateti5.jugar(turno, 3, 4); // . . . . X 
		tateti5.jugar(turno, 4, 3); // . . . X .
		assertFalse(tateti5.ganoToroidal(turno));
	}
	
	
	

}
