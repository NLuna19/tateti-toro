package logica;

public class Tablero {
// Aca se guardan todas las jugada con key = coordenadas y valor = numero de jugador
	private int[][] tablero; 	// 0 vacio // 1 jugador 1 // 2 jugador 2
	private int dimensiones;
	
	public Tablero(int dimensiones) {
		tablero  = new int[dimensiones][dimensiones];
		this.dimensiones=dimensiones;
		for (int fila = 0 ; fila < dimensiones ; fila++) {
			for (int columna = 0 ; columna < dimensiones ; columna++) {
				tablero[fila][columna]=0;
			}
		}
	}
	
	public boolean ingresar(int jugador, int fila, int columna) {
    	if (fila < 0 || fila > dimensiones || columna < 0 || columna > dimensiones) {
			throw new IllegalArgumentException("Jugada fuera de rango ("+fila+","+columna+")");
		}else {
			if(tablero[fila][columna]==0) {
				tablero[fila][columna]=jugador;
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public void quitar(int fila, int columna) {
		if (tablero[fila][columna]!=0) {
			tablero[fila][columna]=0;
		}	
	}
	
	public int obtener(int fila, int columna) {
		return tablero[fila][columna];
	}
	
	public void limpiarTablero() {
		for (int fila = 0 ; fila < dimensiones ; fila++) {
			for (int columna = 0 ; columna < dimensiones ; columna++)
				quitar(fila, columna);	
		}
	}
	
	public int getDimensiones() {
		return dimensiones;
	}

}
