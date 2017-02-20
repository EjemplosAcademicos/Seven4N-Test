package com.s4n.corrientazo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.s4n.delivery.Dron;
import com.s4n.delivery.Entrega;
import com.s4n.delivery.exception.DeliveryException;
import com.s4n.delivery.ruta.Ruta;
import com.s4n.delivery.ruta.RutaXArchivo;
import com.s4n.util.Utilidades;



/**
 * La Clase App es la encargada de solicitar el recorrido que debe realizar el dispositivo
 * y lanzar el hilo que ejecuta la entraga 
 * @author sebas.monsalve@gmail.com
 *
 */
public class App {
	
	private CorrientazoDomicilio corrientazoDomi;
	private  BufferedReader br;
	private ExecutorService servicio;
	private Utilidades utilidades;
	
	public App(){
		this.utilidades = new Utilidades();
		this.servicio = Executors.newFixedThreadPool(1);
        this.corrientazoDomi = new CorrientazoDomicilio(cargarDispositivos());
        
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingerese la ruta del directorio donde se encuentran las entregas (C:/xxx/xxx/folder/): ");
        
        try{
        	
        	String pathFile = br.readLine();
        	
        	File folder = new File(pathFile);
        	if(folder!=null && folder.listFiles()!=null){
		    	for (final File fileEntry : folder.listFiles()) {
		    		if (fileEntry.isFile()) {
		   	            
		    			String path = fileEntry.getPath().replaceAll("\\\\", "/");
		   	            
		    			try{
		    				//Obtengo las rutas de las entregas
			   				Ruta ruta = new RutaXArchivo(path);
			   				
			   				int idDron = utilidades.getDispositivoTest(path);
			   				   				
			   				Entrega dispositivo = corrientazoDomi.obtenerDispositivo(idDron);
			   				
			   				if(!ruta.getEntregas().isEmpty() && dispositivo!=null){
			   					dispositivo.setIdDron(idDron+"");
			   					dispositivo.setRuta(ruta);
			   										 
			   		            Future<String> resultado= servicio.submit(dispositivo);
			   		            utilidades.exportarReporte( resultado.get(),path,idDron);
			   		            System.out.println("Entregas Finalizadas dispositivo "+idDron+"!!. El reporte de las entregas se encuentra en el mismo "
			   		    	        		+ "directorio del las entregas");
			   		
			   				}else{
			   					DeliveryException deliveryException = new DeliveryException();
			   					deliveryException.setId("Entrega "+DeliveryException.ERROR);
			   					deliveryException.setMsnUser("No hay rutas dentro del archivo o tienen el formato incorrecto. Dipositivo: "+idDron);
			   					throw deliveryException;
			   				}   
		    			} catch(DeliveryException e){
		    	        	e.showUserMessage();
		    	        } catch (ExecutionException e) {
		    	        	try{
		    		        	DeliveryException newEx = (DeliveryException)e.getCause();
		    		        	newEx.showUserMessage();
		    	        	}catch(Exception ex){
		    	            	e.printStackTrace();
		    	            }
		    			} catch (InterruptedException e) {
		    				// TODO Auto-generated catch block
		    				System.out.println("Entrega interrumpida");
		    			}
		   	        	
		   	        }
	      	    }
        	}else{
        		DeliveryException deliveryException = new DeliveryException();
				deliveryException.setId("DIRECTORIO "+DeliveryException.ERROR);
				deliveryException.setMsnUser("No se encuentran archivos dentro del directorio o la ruta esta incorrecta");
				throw deliveryException;
        	}    
        	
        } catch(DeliveryException e){
        	e.showUserMessage();
        } catch(IOException e){
        	e.printStackTrace();
        } catch(Exception e){
        	e.printStackTrace();
        } finally{
        	servicio.shutdown();
        }
	}

	public List<Entrega> cargarDispositivos(){
		List<Entrega> listaDrones = new ArrayList<Entrega>();
		for(int i=0; i<20; i++){
			listaDrones.add(new Dron(10,10));
		}
		return listaDrones;
	}
	
    public static void main( String[] args )
    {
    	App app = new App();
    }
}
