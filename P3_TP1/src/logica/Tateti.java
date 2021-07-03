package logica;

public class Tateti {
	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	int turno; int numeroJugadasTotales;
	
	public Tateti(int dimenciones, String nombre1, String nombre2) {
		Tablero tablero = new Tablero(dimenciones);
		int valor = (int) (Math.random() * 2)+1;
		jugador1 = new Jugador (nombre1, valor==1?"O":"X");
		jugador2 = new Jugador (nombre2, valor==1?"X":"O");
		this.tablero = tablero;
		this.turno = setTurno();
		this.numeroJugadasTotales = 0;
	}
	private int setTurno() { // genera un turno inicial random (1 o 2) para que no siempre arranque el mismo jugador;
		int valor = (int) (Math.random() * 2)+1;
		return valor;
	}
	private boolean verificarTurno(int jugador) {
		return (jugador == turno)? true:false;
	}
	
	public void cambiarTurno() {
		turno = (turno == 1)?  2 :  1;
	}
	
	public boolean jugar(int jugador, int fila, int columna) {
		if(verificarTurno(jugador)) {
			tablero.ingresar(jugador, fila, columna);
			numeroJugadasTotales++;
			return true;
			}
		return false;
	}
	
	public boolean ganoHorizontal(Integer jugador) {
		boolean gano = false;
		int fila=0; int dim = getDimensiones();
		while(fila < dim && !gano) {
			int columnaAux=0;
			int contador=0;
			while (columnaAux < dim && !gano) {
				if (tablero.obtener(fila,columnaAux)==jugador) {
					contador++;
				}
				columnaAux++;
			}
			gano = (contador==dim ? true : false);
			fila++;
		}
		return gano;
	}
	
	public boolean ganoVertical(Integer jugador) {// revisa si un jugador tiene 3 coord con la misma X pero distinta Y
		boolean gano = false;
		int columna=0; int dim = getDimensiones();
		while(columna < dim && !gano) {
			int filaAux=0;
			int contador=0;
			while (filaAux < dim && !gano) {
				if (tablero.obtener(filaAux,columna)==jugador) {
					contador++;
				}
				filaAux++;
			}
			gano = (contador==dim ? true : false);
			columna++;
		}
		return gano;
	}
	
	public boolean ganoToroidal(int jugador) {
		int columna=0;
		int fila=0;
		boolean acumB=false;
		while (columna<getDimensiones() && !acumB) {
			acumB = acumB || ganoToroidal(jugador, fila, columna, new boolean[getDimensiones()]);		
			columna++;
		}
		return acumB;
	}
	
	private boolean ganoToroidal(int jugador, int fila, int columna, boolean[] bloqueadas) {
		if(fila == getDimensiones()-1) {
			return tablero.obtener(fila, columna) == jugador;
		}
		if (fila < getDimensiones()-1) {
			if (columna < getDimensiones()-1 && tablero.obtener(fila, columna) != jugador ) {
				return false;
			}else {
				if (tablero.obtener(fila, columna) == jugador && bloqueadas[columna]==false ) {
					bloqueadas[columna]=true;
					boolean rama=false;
					if (columna == getDimensiones()-1) {
						if (!bloqueadas[0]) 
							rama= rama || ganoToroidal(jugador, fila+1, 0, bloqueadas);
						if (!bloqueadas[columna-1]) 
							rama= rama || ganoToroidal(jugador, fila+1, columna-1, bloqueadas);
					}	
					if (columna == 0) {
						if (!bloqueadas[getDimensiones()-1]) 
							rama= rama || ganoToroidal(jugador, fila+1, getDimensiones()-1, bloqueadas);
						if (!bloqueadas[columna+1]) 
							rama= rama || ganoToroidal(jugador, fila+1, columna+1, bloqueadas);
					}	
					if (columna != getDimensiones()-1 && columna != 0) {
						if (!bloqueadas[columna-1])
							rama= rama || ganoToroidal(jugador, fila+1, columna-1, bloqueadas);
						if (!bloqueadas[columna+1])
							rama= rama || ganoToroidal(jugador, fila+1, columna+1, bloqueadas);
					}
					return rama;
				}
			}	
		}
		return false;
	}
	
	public boolean ganador(Integer jugador) {
		if (jugador == 2 || jugador == 1) {
			if (numeroJugadasTotales < (getDimensiones()*2)-1) // en 3x3 ( <5 ) // en 4x4 (<7) // en 5x5 (<9)
				return false;
			return ganoVertical(jugador) || ganoHorizontal(jugador) || ganoToroidal(jugador);
		}	
		throw new IllegalArgumentException("Jugador solicitado fuera de rango "+jugador);
	}
	
	public boolean empate() {
		return (numeroJugadasTotales == getDimensiones()*getDimensiones())? true:false;
	}
	
	public String getNombreJugador1() {
		return jugador1.getNombre();
	}

	public String getNombreJugador2() {
		return jugador2.getNombre();
	}
	public String getMarcaJugador1() {
		return jugador1.getMarca();
	}

	public String getMarcaJugador2() {
		return jugador2.getMarca();
	}
	
	public Jugador getJugador1() {
		return jugador1;
	}
	public Jugador getJugador2() {
		return jugador2;
	}
	
	public int getDimensiones() {
		return tablero.getDimensiones();
	}
	public String getJugadorActual() {		
		return (turno == 1)? jugador1.getNombre():jugador2.getNombre();
	}
	
	public String getMarcaActual() {
		return (turno == 1)? jugador1.getMarca():jugador2.getMarca();
	}
	
	public int getTurno() {
		return turno;
	}
	
	public int getJugadas() {
		return numeroJugadasTotales;
	}
	

}
