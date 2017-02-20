package com.s4n.delivery;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PosicionTest {
	
	private Posicion posicion;
	
	@Before
	public void constructor(){
	}
		
	@After
	public void destroy(){}
	
	@Test
	public void toStringTest1() {
		assertEquals("(0, 0) dirección Norte", (new Posicion()).toString());
	}
	
	@Test
	public void toStringTest2() {
		assertEquals("(-2, 4) dirección Sur", (new Posicion(-2,4,Sentido.SUR)).toString());
	}
	
	@Test
	public void toStringTest3() {
		assertEquals("(-10, 5) dirección Oriente",(new Posicion(-10,5,Sentido.ORIENTE)).toString());
	}
	
	@Test
	public void toStringTest4() {
		assertEquals("(1, 5) dirección Occidente",(new Posicion(1,5,Sentido.OCCIDENTE)).toString());
	}
	
	
	@Test
	public void toStringTest5() {
		assertEquals("(-6, -10) dirección Norte", (new Posicion(-6,-10,Sentido.NORTE)).toString());
	}

	@Test
	public void moverAdelanteTest1() {
		posicion = new Posicion(0,0,Sentido.NORTE);
		posicion.moverAdelante();
		assertEquals("(0, 1) dirección Norte", posicion.toString());
	}
	
	@Test
	public void moverAdelanteTest2() {
		posicion = new Posicion(0,0,Sentido.SUR);
		posicion.moverAdelante();
		assertEquals("(0, -1) dirección Sur", posicion.toString());
	}
	
	@Test
	public void moverAdelanteTest3() {
		posicion = new Posicion(0,0,Sentido.ORIENTE);
		posicion.moverAdelante();
		assertEquals("(1, 0) dirección Oriente", posicion.toString());
	}
	
	@Test
	public void moverAdelanteTest4() {
		posicion = new Posicion(0,0,Sentido.OCCIDENTE);
		posicion.moverAdelante();
		assertEquals("(-1, 0) dirección Occidente", posicion.toString());
	}
	
	@Test
	public void girarIzquierda1() {
		posicion = new Posicion(0,0,Sentido.NORTE);
		posicion.girarIzquierda();
		assertEquals("Occidente", posicion.getSentido().getSentido());
	}
	
	@Test
	public void girarIzquierda2() {
		posicion = new Posicion(0,0,Sentido.OCCIDENTE);
		posicion.girarIzquierda();
		assertEquals("Sur", posicion.getSentido().getSentido());
	}
	
	@Test
	public void girarIzquierda3() {
		posicion = new Posicion(0,0,Sentido.SUR);
		posicion.girarIzquierda();
		assertEquals("Oriente", posicion.getSentido().getSentido());
	}
	
	@Test
	public void girarIzquierda4() {
		posicion = new Posicion(0,0,Sentido.ORIENTE);
		posicion.girarIzquierda();
		assertEquals("Norte", posicion.getSentido().getSentido());
	}
	
	@Test
	public void girarDerecha1() {
		posicion = new Posicion(0,0,Sentido.NORTE);
		posicion.girarDerecha();
		assertEquals("Oriente", posicion.getSentido().getSentido());
	}
	
	@Test
	public void girarDerecha2() {
		posicion = new Posicion(0,0,Sentido.OCCIDENTE);
		posicion.girarDerecha();
		assertEquals("Norte", posicion.getSentido().getSentido());
	}
	
	@Test
	public void girarDerecha3() {
		posicion = new Posicion(0,0,Sentido.SUR);
		posicion.girarDerecha();
		assertEquals("Occidente", posicion.getSentido().getSentido());
	}
	
	@Test
	public void girarDerecha4() {
		posicion = new Posicion(0,0,Sentido.ORIENTE);
		posicion.girarDerecha();
		assertEquals("Sur", posicion.getSentido().getSentido());
	}

}
