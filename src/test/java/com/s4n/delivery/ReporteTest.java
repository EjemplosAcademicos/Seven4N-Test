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
public class ReporteTest {

	private Entrega dispositivo;
	private Ruta ruta;
	private String reporte;
	
	public ReporteTest(String reporte, Ruta ruta){
		this.reporte = reporte;
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
			{	"== Reporte de entregas =="+"\n"+
				"(1, 3) dirección Norte"+"\n"+
				"(2, 6) dirección Norte"+"\n",			 new RutaXArchivo("src/test/resources/test_file/in.txt")},
			{	"== Reporte de entregas =="+"\n"+
				"(0, 1) dirección Sur"+"\n"+
				"(0, -2) dirección Norte"+"\n", 		new RutaXArchivo("src/test/resources/test_file/in01.txt")},
			{	"== Reporte de entregas =="+"\n"+
				"(-3, 0) dirección Sur"+"\n"+
				"(-6, 0) dirección Norte"+"\n", 		new RutaXArchivo("src/test/resources/test_file/in02.txt")},
			{	"== Reporte de entregas =="+"\n", 		new RutaXArchivo("src/test/resources/test_file/in03.txt")},
			{	"== Reporte de entregas =="+"\n"+
				"(0, 7) dirección Norte"+"\n"+
				"(0, 10) dirección Norte"+"\n", 		new RutaXArchivo("src/test/resources/test_file/in04.txt")},
			{	"== Reporte de entregas =="+"\n"+
				"(0, 3) dirección Oriente"+"\n"+
				"(-1, 2) dirección Sur"+"\n", new RutaXArchivo("src/test/resources/test_file/in05.txt")},
		};
		return Arrays.asList(nums);
	}

	@Test
	public void entregarDomicilioTest() {
		String reporte;
		dispositivo.setRuta(ruta);
		try{
			reporte = dispositivo.entregarDomicilio();
			assertEquals(this.reporte, reporte);
		} catch (DeliveryException e) {
			fail("No se esperaba una DeliveryException "+e.getMessage());
		} catch (Exception e) {
			fail("No se esperaba una Exception "+e.getMessage());
		}
	}


}
