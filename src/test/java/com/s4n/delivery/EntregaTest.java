package com.s4n.delivery;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.s4n.delivery.exception.DeliveryException;


public class EntregaTest {
	
	private Dron dron;
	
	@Before
	public void constructor(){
		dron = new Dron(10,3);
	}
		
	@After
	public void destroy(){}

	@Test
	public void moverTest1(){
		try {
			dron.mover("AAAAIAAD", 1);
			assertEquals("(-2, 4) dirección Norte", dron.getPosicionActual().toString());
		} catch (DeliveryException e) {
			fail("No se esperaba DeliveryException");
		}catch(Exception e){
			fail("No se esperaba excepción");
		}
	}
	
	@Test
	public void moverTest2(){
		try {
			dron.setPosicionActual(new Posicion(-2,4,Sentido.NORTE));
			dron.mover("DDAIAD", 1);
			assertEquals("(-1, 3) dirección Sur", dron.getPosicionActual().toString());
		} catch (DeliveryException e) {
			fail("No se esperaba DeliveryException");
		}catch(Exception e){
			fail("No se esperaba excepción");
		}
	}
	
	@Test
	public void moverTest3(){
		try {
			dron.setPosicionActual(new Posicion(-1,3,Sentido.SUR));
			dron.mover("AAIADAD", 1);
			assertEquals("(0, 0) dirección Occidente", dron.getPosicionActual().toString());
		} catch (DeliveryException e) {
			fail("No se esperaba DeliveryException");
		}catch(Exception e){
			fail("No se esperaba excepción");
		}
	}
	
	@Test
	public void moverTest4(){
		try {
			dron.setPosicionActual(new Posicion(0,0,Sentido.NORTE));
			dron.mover("AADAAAAADAAAADAAI", 1);
			assertEquals("(3, -2) dirección Sur", dron.getPosicionActual().toString());
		} catch (DeliveryException e) {
			fail("No se esperaba DeliveryException");
		}catch(Exception e){
			fail("No se esperaba excepción");
		}
	}

}
