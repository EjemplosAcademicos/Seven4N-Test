package com.s4n.delivery;

/**
 * La Clase Posicion permite representar una posicion en el plano cartesiano y su dirección
 * ademas de la implementacion de los metodos que le permiten moverse a traves del plano
 *  * @author sebas.monsalve@gmail
 *
 */
public class Posicion {
	
	private int x;
	private int y;
	private Sentido sentido;
	
	public Posicion() {
		this.x = 0;
		this.y = 0;
		this.sentido = Sentido.NORTE;
	}

	public Posicion(int x, int y, Sentido sentido) {
		this.x = x;
		this.y = y;
		this.sentido = sentido;
	}
	
	public void moverAdelante() {
		switch(sentido){
			case NORTE :
				this.y++;
				break;
			case SUR :
				this.y--;
				break;
			case ORIENTE :
				this.x++;
				break;
			case OCCIDENTE :
				this.x--;
				break;
		}
	}

	public void girarIzquierda() {
		switch(sentido){
			case NORTE :
				this.setSentido(Sentido.OCCIDENTE);
				break;
			case SUR :
				this.setSentido(Sentido.ORIENTE);
				break;
			case ORIENTE :
				this.setSentido(Sentido.NORTE);
				break;
			case OCCIDENTE :
				this.setSentido(Sentido.SUR);
				break;
		}
	}

	public void girarDerecha() {
		switch(sentido){
			case NORTE :
				this.setSentido(Sentido.ORIENTE);
				break;
			case SUR :
				this.setSentido(Sentido.OCCIDENTE);
				break;
			case ORIENTE :
				this.setSentido(Sentido.SUR);
				break;
			case OCCIDENTE :
				this.setSentido(Sentido.NORTE);
				break;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Sentido getSentido() {
		return sentido;
	}

	public void setSentido(Sentido sentido) {
		this.sentido = sentido;
	}
	
	/**
	 * Método encargado de transformar una posicion actual en su representación en caracteres. 
	 * Por Ejemplo (0, 0, Norte) -- (0, 0) dirección Norte 
	 * @return retorna la representacion en caracteres de la poscion dado
	 */
	@Override
	public String toString() {
		return "("+x+", "+y+") dirección "+sentido.getSentido();
	}
	
}
