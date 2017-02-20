package com.s4n.delivery;

import java.util.concurrent.Callable;

import com.s4n.delivery.exception.DeliveryException;
import com.s4n.delivery.ruta.Ruta;

/**
 * La clase abstracta Entrega provee la estructura para representar cualquier dispositivo
 * de entrega
 * @author sebas.monsalve@gmailcom
 */
public abstract class Entrega implements Callable<String>{
	
	private int distanciaMaxima;
	private int entregasMaximas;
	private String idDron;
	private Posicion posicionActual;
	private String reporte;
	private Ruta ruta;
	
	Entrega(){
		this.distanciaMaxima = 10;
		this.entregasMaximas = 3;
		this.idDron = "1";
		this.posicionActual = new Posicion(0,0,Sentido.NORTE);
		this.reporte = "== Reporte de entregas ==";
	}
	
	Entrega(int distanciaMaxima, int entregasMaximas){
		this.distanciaMaxima = distanciaMaxima;
		this.entregasMaximas = entregasMaximas;
		this.posicionActual = new Posicion(0,0,Sentido.NORTE);
		this.reporte = "== Reporte de entregas ==";
	}
		
	public int getDistanciaMaxima() {
		return distanciaMaxima;
	}

	public void setDistanciaMaxima(int distanciaMaxima) {
		this.distanciaMaxima = distanciaMaxima;
	}

	public int getEntregasMaximas() {
		return entregasMaximas;
	}

	public void setEntregasMaximas(int entregasMaximas) {
		this.entregasMaximas = entregasMaximas;
	}
	
	public Posicion getPosicionActual() {
		return posicionActual;
	}

	public void setPosicionActual(Posicion posicionActual) {
		this.posicionActual = posicionActual;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	

	public String getIdDron() {
		return idDron;
	}

	public void setIdDron(String idDron) {
		this.idDron = idDron;
	}

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}
	
	public void volverPosicionInicial(){
		this.posicionActual = new Posicion(0,0,Sentido.NORTE);
	}

	/**
	 * Método encargado de realizar los diferentes recorridos segun las entregas pautadas
	 * @return Reporte de las posiciones donde se realizaron las diferentes entregas
	 * @throws DeliveryException si se presenta una excepcion entregando el domicilio
	 */
	public abstract String entregarDomicilio() throws DeliveryException;	

}
