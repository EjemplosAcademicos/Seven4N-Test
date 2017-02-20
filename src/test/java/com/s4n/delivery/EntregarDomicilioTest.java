package com.s4n.delivery;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.s4n.delivery.exception.AccessFileException;
import com.s4n.delivery.exception.DeliveryException;
import com.s4n.delivery.ruta.Ruta;
import com.s4n.delivery.ruta.RutaXArchivo;

@RunWith(Parameterized.class)
public class EntregarDomicilioTest {
	
	private Entrega dispositivo;
	private String idDron;
	private Ruta ruta;
	
	public EntregarDomicilioTest(String idDron, Ruta ruta){
		this.idDron = idDron;
		this.ruta = ruta;
	}
	
	@Before
	public void constructor(){
		this.dispositivo = new Dron(10,2);
	}
	
	@After
	public void destroy(){}
	
	@Parameters
	public static Collection<Object[]> nums() throws AccessFileException{
		Object[][] nums = new Object[][]{
			{"1", new RutaXArchivo("src/test/resources/test_file/wrong/in.txt")},
			{"1", new RutaXArchivo("src/test/resources/test_file/wrong/in01.txt")},
			{"2", new RutaXArchivo("src/test/resources/test_file/wrong/in02.txt")},
			{"3", new RutaXArchivo("src/test/resources/test_file/wrong/in03.txt")},
			{"4", new RutaXArchivo("src/test/resources/test_file/wrong/in04.txt")},
			{"5", new RutaXArchivo("src/test/resources/test_file/wrong/in05.txt")},
		};
		return Arrays.asList(nums);
	}

	@Test
	public void entregarDomicilioTest() {
		String reporte;
		dispositivo.setIdDron(idDron);
		dispositivo.setRuta(ruta);
		try{
			reporte = dispositivo.entregarDomicilio();
			fail("Se esperaba que lanzara una excepcion");
		} catch (DeliveryException e) {
			assertTrue(true);
		} catch (Exception e) {
			fail("No se esperaba una Exception "+e.getMessage());
		}
	}

}
