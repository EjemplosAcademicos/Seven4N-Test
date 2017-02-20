package com.s4n.delivery;

import com.s4n.delivery.exception.DeliveryException;
import com.s4n.delivery.exception.FormatException;


/**
 * La clase Dron implementa las operaciones necesarias para realizar las entregas
 * correspondientes 
 * @author sebas.monsalve@gmail.com
 *
 */
public class Dron extends Entrega{
	
	public Dron(){
		super();
	}
	
	public Dron(int distanciaMaxima, int entregasMaximas){
		super(distanciaMaxima, entregasMaximas);
	}
	
	/**
	 * implmentación del metodo call el cual ejecuta las instrucciones en un hilo.
	 */
	public String call() throws DeliveryException, InterruptedException   {
		String reporte = "";
		reporte = entregarDomicilio();
		super.volverPosicionInicial();
		return reporte;
	}
	
	@Override
	public String entregarDomicilio() throws DeliveryException {
		String reporte = "== Reporte de entregas =="+"\n";
		String entrega = "";
		for(int i =0; i<super.getRuta().getEntregas().size() && i<super.getEntregasMaximas(); i++){
			entrega = super.getRuta().getEntregas().get(i);
			if(!"".equals(entrega))
				reporte += (mover(entrega,i+1)).toString()+"\n";
		}
		return reporte;
	}
		
	/**
	 * Método que realiza el desplazamiento de una entrega determinada por el plano, 
	 * validando que no se salga de los limites de su domicilio
	 * @param entrega es la ruta para un domicilio
	 * @param numEntrega es el numero que identifica la entrega
	 * @return la posicion de la entrega del domicilio
	 * @throws DeliveryException lanza una excepcion si la entrega tiene algun movimiendo incorrecto o se pasa del limite posible de entrega de domicilios
	 */
	public Posicion mover(String entrega, int numEntrega) throws DeliveryException {
		Posicion posicionFinal = getPosicionActual();
		FormatException excepFormatFile;
		if(entrega !=null || !entrega.isEmpty()){
			
			for(int pos=0; pos<entrega.length(); pos++){
				switch(entrega.charAt(pos)){
					case 'A': //movimiento hacia adelante.
						//validamos si el movimiento no se sale de los limites de la entrega.
						puedoMoverme(posicionFinal);
						posicionFinal.moverAdelante();
						break;
					case 'I': //giro de 90 grados del dron a la izquierda
						posicionFinal.girarIzquierda();
						break;
					case 'D': //giro de 90 grados del dron a la derecha
						posicionFinal.girarDerecha();
						break;
					default:
						excepFormatFile = new FormatException();
						excepFormatFile.setId("Formato "+FormatException.ERROR);
						excepFormatFile.setMsnUser("Formato de la entrega invalido. "+entrega+" . Diposiitivo: "+super.getIdDron()+" Entrega: "+numEntrega);
						throw excepFormatFile;
				}
			}
		}
		setPosicionActual(posicionFinal);
		return posicionFinal;
	}

	/**
	 * Método que permite validar si el dispositivo puede realizar el movimiento, sin salirse de los limites de sus entregas
	 * @param posicionFinal posición en la que se encuentra antes de realizar el movimiento
	 * @throws DeliveryException lanza una excepcion si no puede realizar el movimiento ya que sobrepasa sus limites.
	 */
	public void puedoMoverme(Posicion posicionFinal) throws DeliveryException {
		
		DeliveryException deliveryException = new DeliveryException();
		deliveryException.setId("Entrega "+DeliveryException.ERROR);
		deliveryException.setMsnUser("La entrega supera los limites de los domicilios. Limite: "+super.getDistanciaMaxima()+" cuadras a la redonda. Dipositivo: "+super.getIdDron());
		
		switch(posicionFinal.getSentido()){
			case NORTE :
				if(posicionFinal.getY()+1>super.getDistanciaMaxima())
					throw deliveryException;
				break;
			case SUR :
				if(posicionFinal.getY()-1<-super.getDistanciaMaxima())
					throw deliveryException;
				break;
			case ORIENTE :
				if(posicionFinal.getX()+1>super.getDistanciaMaxima())
					throw deliveryException;
				break;
			case OCCIDENTE :
				if(posicionFinal.getX()-1<-super.getDistanciaMaxima())
					throw deliveryException;
				break;
		}
	}
	
}
