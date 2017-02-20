package com.s4n.delivery;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.s4n.corrientazo.CorrientazoDomicilio;
import com.s4n.delivery.exception.AccessFileException;
import com.s4n.delivery.exception.DeliveryException;

@RunWith(Parameterized.class)
public class ObtenerDispositvoTest {
	
	private CorrientazoDomicilio corrientazo;
	private List<Entrega> listaEntregas;
	private int idDron;
	
	public ObtenerDispositvoTest(int idDron){
		this.idDron = idDron;
	}
	
	@Before
	public void constructor(){
		listaEntregas = new ArrayList<Entrega>();
		listaEntregas.add(new Dron(10,4));
		listaEntregas.add(new Dron(10,4));
		listaEntregas.add(new Dron(10,4));
		listaEntregas.add(new Dron(10,4));
		corrientazo = new CorrientazoDomicilio(listaEntregas);
	}
		
	@After
	public void destroy(){}
	
	@Parameters
	public static Collection<Object[]> nums(){
		Object[][] nums = new Object[][]{
			{0},
			{6},
			{5},
			{-1},
		};
		return Arrays.asList(nums);
	}

	@Test
	public void cargarRutaTest() {
		try {
			corrientazo.obtenerDispositivo(idDron);
			fail("Se esperaba una DeliveryException");
		} catch (AccessFileException e){
			fail("No se esperaba este tipo de AccessFileException");
		} catch (DeliveryException e) {
			assertTrue(true);
		} catch(Exception e) {
			fail("No se esperaba este tipo de excepcion");
		}
	}

}
