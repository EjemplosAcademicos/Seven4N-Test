package com.s4n.corrientazo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.s4n.delivery.Entrega;
import com.s4n.delivery.exception.DeliveryException;
import com.s4n.delivery.exception.FormatException;

/**
 * La Clase CorrientazoDomicilio contiene los dispositivos que posee el corrientazo para 
 * realizar sus domicilios
 * @author sebas.monsalve@gmial.com
 *
 */
public class CorrientazoDomicilio {
	
	private List<Entrega> listaEntregas;
	
	public CorrientazoDomicilio(){
		this.listaEntregas = new ArrayList<Entrega>();
	}
	
	public CorrientazoDomicilio(List<Entrega> listaEntregas){
		this.listaEntregas = listaEntregas;
	}
		
	/**
	 * Metodo encargado de retornar el dispositivo correspondiente al id que le corresponde
	 * validando que si exista
	 * @param dronID id del dispositivo que se desea buscar
	 * @return retorna el reporte de las entregas realizadas
	 * @throws DeliveryException lanza una excepcion si el formato del archivo no cumple las especificaciones
	 * @throws ExecutionException lanza una excepcion si ocurre un problema ejecutando el hilo que entrega el domicilio
	 * @throws InterruptedException lanza una excepcion si el proceso del hilo es interrumpido
	 */
	public Entrega obtenerDispositivo(int dronID) throws DeliveryException, InterruptedException, ExecutionException  {
		
		//declarar hilo por drone.
		Entrega dispositivo;
		
		if(dronID > 0){
			
			if(dronID<=listaEntregas.size()){
				
				dispositivo = listaEntregas.get(dronID-1);
				
			}else{
				DeliveryException deliveryException = new DeliveryException();
				deliveryException.setId("Entrega "+DeliveryException.ERROR);
				deliveryException.setMsnUser("El nombre del archivo sobrepasa el numero de dispositivos que tenemos para las entregas. Dipositivo: "+dronID);
				throw deliveryException;
			}
			
		}else{
			FormatException excepFormatFile = new FormatException();
			excepFormatFile.setId("Formato "+FormatException.ERROR);
			excepFormatFile.setMsnUser("Formato del nombre del archivo invalido. (.../inXX.txt)");
			throw excepFormatFile;
		}
		return dispositivo;
		
	}	

	

}
