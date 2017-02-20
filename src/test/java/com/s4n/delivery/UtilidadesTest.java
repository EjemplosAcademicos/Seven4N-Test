package com.s4n.delivery;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.s4n.delivery.exception.FormatException;
import com.s4n.util.Utilidades;

public class UtilidadesTest {

	Utilidades util;
	
	@Before
	public void constructor(){
		util = new Utilidades();
	}
		
	@After
	public void destroy(){}
	
	
	@Test
	public void getDispositivoTest1() {
		int dronID;
		try {
			dronID = util.getDispositivoTest("D:/S4N/wk_neon_s4n/in.txt");
			assertEquals(1, dronID);
		} catch (FormatException e) {
			fail("No se esperaba una FormatException");
		}
	}
	
	@Test
	public void getDispositivoTest2() {
		int dronID;
		try {
			dronID = util.getDispositivoTest("D:/S4N/wk_neon_s4n/in01.txt");
			assertEquals(1, dronID);
		} catch (FormatException e) {
			fail("No se esperaba una FormatException");
		}
	}
	
	@Test
	public void getDispositivoTest3() {
		int dronID;
		try {
			dronID = util.getDispositivoTest("D:/S4N/wk_neon_s4n/in11.txt");
			assertEquals(11, dronID);
		} catch (FormatException e) {
			fail("No se esperaba una FormatException");
		}
	}
	
	@Test
	public void getDispositivoTest4() {
		int dronID;
		try {
			dronID = util.getDispositivoTest("D:/S4N/wk_neon_s4n/in30.txt");
			assertEquals(30, dronID);
		} catch (FormatException e) {
			fail("No se esperaba una FormatException");
		}
	}
	
	@Test
	public void getDispositivoTest5() {
		int dronID;
		try {
			dronID = util.getDispositivoTest("D:/S4N/wk_neon_s4n/asdf.txt");
			fail("se esperaba Exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void getDispositivoTest6() {
		int dronID;
		try {
			dronID = util.getDispositivoTest("D:/S4N/wk_neon_s4n/");
			fail("se esperaba Exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void getDispositivoTest7() {
		int dronID;
		try {
			dronID = util.getDispositivoTest("");
			fail("se esperaba Exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void getDispositivoTest8() {
		int dronID;
		try {
			dronID = util.getDispositivoTest(null);
			fail("se esperaba Exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

}
