package com.s4n.delivery.ruta;

import java.util.ArrayList;
import java.util.List;

import com.s4n.delivery.exception.DeliveryException;

/**
 * La clase abstracta Ruta provee la estructura y las operaciones para
 * representar la ruta y las entregas que se deben realizar.
 * @author sebas.monsalve@gmail.com
 *
 */
public abstract class Ruta {
	
	private List<String> entregas;
	
	Ruta(){
		this.entregas = new ArrayList<String>();
	}
	

	public List<String> getEntregas() {
		return entregas;
	}

	public void setEntregas(List<String> entregas) {
		this.entregas = entregas;
	}
	
	/**
	 * Metodo encargado de obtener las instrucciones para cada una de las entregas y 
	 * guardarlas en el lista de entregas
	 * @throws DeliveryException lanza una excepcion si falla en obtener las rutas. 
	 */
	public abstract void obtenerRutas() throws DeliveryException;
	
}
