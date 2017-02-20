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
import com.s4n.delivery.ruta.Ruta;
import com.s4n.delivery.ruta.RutaXArchivo;

@RunWith(Parameterized.class)
public class ArchivoTest {

	private String filePath;
	private Ruta ruta;
	private String entregas;
	
	public ArchivoTest(String entregas, String filePath){
		this.filePath = filePath;
		this.entregas = entregas;
	}
	
	@Before
	public void constructor(){	}
		
	@After
	public void destroy(){}
	
	@Parameters
	public static Collection<Object[]> nums(){
		Object[][] nums = new Object[][]{
			{"[AADDA, AAAII, DDAA, IIAA]","src/test/resources/test_file/in01.txt"},
			{"[AAAIAAAIAAA, AAADAAADAAA]","src/test/resources/test_file/in02.txt"},
			{"[]","src/test/resources/test_file/in03.txt"},
			{"[AAAAAAA, AAA]","src/test/resources/test_file/in04.txt"},
			{"[AAIDAD, DDAIA, IADAA]","src/test/resources/test_file/in05.txt"}
		};
		return Arrays.asList(nums);
	}
	@Test
	public void rutasXArxhivoTest() {
		try {
			ruta = new RutaXArchivo(filePath);
			assertEquals(entregas, ruta.getEntregas().toString());
		} catch (AccessFileException e) {
			fail("No se esperaba esta excepcion AccessFileException");
		}
		
	}

}
