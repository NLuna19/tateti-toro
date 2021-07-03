package logica;

public class Jugador {
	private String nombre, marca;
	
	public Jugador(String nombre, String marca) {
		this.marca = marca;	
		if (nombre == "" || nombre == null) {
			this.nombre = "Jugador "+ (marca=="X"? "1":"2");	
		}else {
			this.nombre = nombre;	
		}
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getMarca() {
		return marca;
	}
}
