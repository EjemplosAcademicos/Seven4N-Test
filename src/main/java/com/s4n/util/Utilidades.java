package com.s4n.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.s4n.delivery.exception.AccessFileException;
import com.s4n.delivery.exception.FormatException;

public class Utilidades {
	
	/**
	 * Método encargado obtener el id del dispositivo al que le corresponde determinada entrega, segun el nombre del archivo
	 * que contiene las entregas
	 * @param filePath ruta del archivo que contiene las entregas
	 * @return id del dispositivo, si el Id es 0, es que no identifacarlo de nombre del archivo
	 * @throws FormatException lanza si el path del archivo no esta en el formato correcto
	 */
	public int getDispositivoTest(String filePath) throws FormatException {
		int dronID = 0;
		String file = filePath.substring(filePath.lastIndexOf('/')+1, filePath.length());
		if ("in.txt".equals(file)){
			return 1;
		}else{
			try{
				String id = file.substring(2,4);
				dronID = Integer.parseInt(id);
			}catch(Exception e){
				FormatException excepFormatFile = new FormatException();
				excepFormatFile.setId("Formato "+FormatException.ERROR);
				excepFormatFile.setMsnUser("Formato del nombre del archivo invalido. "+file+". (.../inXX.txt)");
				throw excepFormatFile;
			}
		}
		return dronID;
	}
	
	/**
	 * Metodo que permite exportar el reporte de las entregas en un archivo de texto
	 * @param reporte a exportar
	 * @param filePath ruta donde se va a guardar el reporte
	 * @param idDron identificacion del dispositivo que realizo la entrega
	 * @throws AccessFileException si existe algun problema creando el archivo
	 */
	public void exportarReporte(String reporte, String filePath, int idDron) throws AccessFileException{
		RandomAccessFile raf;
		try{
			String fileName = "";
			
			fileName = filePath.substring(0,filePath.lastIndexOf('/'))+"/out"+idDron+".txt";
			
			File file = new File(fileName);
			file.delete();
			raf = new RandomAccessFile(fileName, "rw");
	        raf.seek(raf.length());
	        raf.write(reporte.getBytes());
	        raf.close();
		}catch (IOException e) {
			AccessFileException excepAccessFile = new AccessFileException();
			excepAccessFile.setExceptionSource(e);
			excepAccessFile.setId("FILE "+AccessFileException.ERROR);
			excepAccessFile.setMsnTechnical("Error class DrawingTool,  method newGraphic");
			excepAccessFile.setMsnUser("Error saving the graphic in the output file. (Check the permissions of your directory)");
			throw excepAccessFile;
		}
		
	}

}
