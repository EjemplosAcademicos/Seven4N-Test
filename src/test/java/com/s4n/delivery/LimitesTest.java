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

import com.s4n.delivery.exception.DeliveryException;

@RunWith(Parameterized.class)
public class LimitesTest {
	
	private Dron dron;
	private Posicion posicion;
	
	public LimitesTest(Posicion posicion){
		this.posicion = posicion;
	}
	
	@Before
	public void constructor(){
		dron = new Dron(5,3);
	}
		
	@After
	public void destroy(){}
	
	@Parameters
	public static Collection<Object[]> nums(){
		Object[][] nums = new Object[][]{
			{new Posicion(0,5,Sentido.NORTE)},
			{new Posicion(0,-5,Sentido.SUR)},
			{new Posicion(5,0,Sentido.ORIENTE)},
			{new Posicion(-5,0,Sentido.OCCIDENTE)},
		};
		return Arrays.asList(nums);
	}

	@Test
	public void puedoMovermeTest() {
		try {
			dron.puedoMoverme(posicion);
			fail("Se esperaba excepcion a entrega supera los limites");
		} catch (DeliveryException e) {
			assertTrue(e.getMsnUser(),true);
		} catch(Exception e){
			fail("No se esperaba esta excepcion");
		}
	}

}
