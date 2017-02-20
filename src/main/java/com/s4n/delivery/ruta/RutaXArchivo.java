package com.s4n.delivery.ruta;

import java.io.IOException;
import java.io.RandomAccessFile;

import com.s4n.delivery.exception.AccessFileException;

/**
 * La clase RutaXArchivo implementa la oprecion para obtener las ruta de las entregas 
 * por medio de un archivo.
 * @author sebas.monsalve@gmail.com
 *
 */
public class RutaXArchivo extends Ruta{

	private RandomAccessFile raf;
	private String filePath;
	
	public RutaXArchivo(String filePath) throws AccessFileException {
		super();
		this.filePath = filePath;	
		this.obtenerRutas();
	}

	@Override
	public void obtenerRutas() throws AccessFileException {
		try{
			raf = new RandomAccessFile(filePath, "r");
		    String line;
		    while((line = raf.readLine()) != null) {
		    	super.getEntregas().add(line);
		    }
		    raf.close();
		} catch (IOException e) {
			AccessFileException excepAccessFile = new AccessFileException();
			excepAccessFile.setExceptionSource(e);
			excepAccessFile.setId("ARCHIVO "+AccessFileException.ERROR);
			excepAccessFile.setMsnTechnical("Error class RutaXArchivo,  metodo obtenerRutas");
			excepAccessFile.setMsnUser("Error leyendo el archivo de entrada. Por favor, revisar el archivo o la ruta donde se encuentra");
			throw excepAccessFile;
		}
	}

}
